package model.dao.implementacion;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.entities.Ingresso;
import model.dao.IngressoDao;
import model.entities.Cliente;
import model.entities.Filme;
import model.entities.Sala;
import model.entities.Sessao;

public class IngressoDaoJDBC implements IngressoDao {

    private Connection conn;

    public IngressoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    private Ingresso instantiateIngresso(ResultSet rs, Sessao ses, Cliente cli) throws SQLException {
        Ingresso obj = new Ingresso();
        obj.setId(rs.getInt("Id"));
        obj.setPreco(rs.getDouble("Preco"));
        obj.setSessao(ses);
        obj.setCliente(cli);
        return obj;
    }

    private Cliente instantiateCliente(ResultSet rs) throws SQLException {
        Cliente obj = new Cliente();
        obj.setCpf(rs.getString("Cpf"));
        obj.setNome(rs.getString("Nome"));
        obj.setEmail(rs.getString("Email"));
        obj.setSenha(rs.getString("Senha"));
        obj.setTelefone(rs.getString("Telefone"));
        return obj;
    }

    private Filme instantiateFilme(ResultSet rs) throws SQLException {
        Filme obj = new Filme();
        obj.setId(rs.getInt("Id"));
        obj.setNome(rs.getString("Nome"));
        obj.setDescricao(rs.getString("Descricao"));
        obj.setClassificacao(rs.getString("Classificacao"));
        obj.setMinutosTotais(rs.getInt("MinutosTotais"));
        return obj;
    }

    private Sala instantiateSala(ResultSet rs) throws SQLException {
        Sala obj = new Sala();
        obj.setId(rs.getInt("Id"));
        obj.setNome(rs.getString("Nome"));
        obj.setQtdeAssentos(rs.getInt("QtdeAssentos"));
        return obj;
    }

    private Sessao instantiateSessao(ResultSet rs, Sala sal, Filme film) throws SQLException {
        Sessao obj = new Sessao();
        obj.setId(rs.getInt("Id"));
        obj.setCam(rs.getString("Cam"));
        obj.setHorarioDaSessao(rs.getDate("HorarioDaSessao"));
        obj.setFilme(film);
        obj.setSala(sal);
        return obj;
    }

    @Override
    public void insert(Ingresso obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO ingresso "
                    + "(Preco, SessaoId, ClienteId) "
                    + "VALUES  "
                    + "(?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            st.setDouble(1, obj.getPreco());
            st.setInt(2, obj.getSessao().getId());
            st.setString(3, obj.getCliente().getCpf());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Ingresso obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE ingresso "
                    + "SET Preco = ?, SessaoId = ?, ClienteId = ? "
                    + "WHERE Id = ? ");

            st.setDouble(1, obj.getPreco());
            st.setInt(2, obj.getSessao().getId());
            st.setString(3, obj.getCliente().getCpf());
            st.setInt(4, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Ingresso findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT ingresso.Id AS IngressoId, ingresso.Preco, sessao.Id AS SessaoId, sessao.Cam, sessao.HorarioDaSessao, "
                    + "sala.Id AS SalaId, sala.Nome AS SalaNome, sala.QtdeAssentos, filme.Id AS FilmeId, filme.Nome AS FilmeNome,"
                    + "cliente.Cpf AS ClienteCpf, cliente.Nome AS ClienteNome"
                    + "FROM ingresso INNER JOIN sessao ON ingresso.SessaoId = sessao.Id "
                    + "INNER JOIN sala ON sessao.SalaId = sala.Id "
                    + "INNER JOIN filme ON sessao.FilmeId = filme.Id "
                    + "INNER JOIN cliente ON ingresso.ClienteId = cliente.Cpf "
                    + "ORDER BY ingresso.Id "
                    + "WHERE Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Filme film = instantiateFilme(rs);
                Sala sal = instantiateSala(rs);
                Sessao ses = instantiateSessao(rs, sal, film);
                Cliente cli = instantiateCliente(rs);
                Ingresso ass = instantiateIngresso(rs, ses, cli);
                return ass;
            }

            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Ingresso> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT ingresso.Id AS IngressoId, ingresso.Preco, sessao.Id AS SessaoId, sessao.Cam, sessao.HorarioDaSessao, "
                    + "sala.Id AS SalaId, sala.Nome AS SalaNome, sala.QtdeAssentos, filme.Id AS FilmeId, filme.Nome AS FilmeNome,"
                    + "cliente.Cpf AS ClienteCpf, cliente.Nome AS ClienteNome"
                    + "FROM ingresso INNER JOIN sessao ON ingresso.SessaoId = sessao.Id "
                    + "INNER JOIN sala ON sessao.SalaId = sala.Id "
                    + "INNER JOIN filme ON sessao.FilmeId = filme.Id "
                    + "INNER JOIN cliente ON ingresso.ClienteId = cliente.Cpf "
                    + "ORDER BY ingresso.Id"
            );

            rs = st.executeQuery();

            List<Ingresso> list = new ArrayList<>();
            Map<Integer, Sessao> sessaoMap = new HashMap<>();
            Map<Integer, Sala> salaMap = new HashMap<>();
            Map<Integer, Filme> filmeMap = new HashMap<>();
            Map<String, Cliente> clienteMap = new HashMap<>();

            while (rs.next()) {
                // Recuperar ou instanciar entidades relacionadas
                Sala sala = salaMap.get(rs.getInt("SalaId"));
                if (sala == null) {
                    sala = instantiateSala(rs);
                    sala.setId(rs.getInt("SalaId"));
                    salaMap.put(sala.getId(), sala);
                }

                Filme filme = filmeMap.get(rs.getInt("FilmeId"));
                if (filme == null) {
                    filme = instantiateFilme(rs);
                    filme.setId(rs.getInt("FilmeId"));
                    filmeMap.put(filme.getId(), filme);
                }

                Sessao sessao = sessaoMap.get(rs.getInt("SessaoId"));
                if (sessao == null) {
                    sessao = instantiateSessao(rs, sala, filme);
                    sessao.setId(rs.getInt("SessaoId"));
                    sessaoMap.put(sessao.getId(), sessao);
                }

                Cliente cliente = clienteMap.get(rs.getString("ClienteCpf"));
                if (cliente == null) {
                    cliente = instantiateCliente(rs);
                    cliente.setCpf(rs.getString("ClienteCpf"));
                    clienteMap.put(cliente.getCpf(), cliente);
                }

                // Instanciar ingresso
                Ingresso ingresso = instantiateIngresso(rs, sessao, cliente);
                ingresso.setId(rs.getInt("IngressoId"));

                list.add(ingresso);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}
