package model.dao.implementation;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.entities.Ingresso;
import model.dao.IngressoDao;
import model.entities.Usuario;
import model.entities.Filme;
import model.entities.Sala;
import model.entities.Sessao;

public class IngressoDaoJDBC implements IngressoDao {

    private Connection conn;

    public IngressoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    private Ingresso instantiateIngresso(ResultSet rs, Sessao ses) throws SQLException {
        Ingresso obj = new Ingresso();
        obj.setId(rs.getInt("Id"));
        obj.setPreco(rs.getDouble("Preco"));
        obj.setNomeCliente(rs.getString("NomeCliente"));
        obj.setAssento(rs.getString("Assento"));
        obj.setSessao(ses);
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
        obj.setLargura(rs.getInt("Largura"));
        obj.setProfundidade(rs.getInt("Profundidade"));
        return obj;
    }

    private Sessao instantiateSessao(ResultSet rs, Sala sal, Filme film) throws SQLException {
        Sessao obj = new Sessao();
        obj.setId(rs.getInt("Id"));
        obj.setCam(rs.getString("Cam"));
        Timestamp timestamp = rs.getTimestamp("HorarioDaSessao");
        if (timestamp != null) {
            obj.setHorarioDaSessao(timestamp.toLocalDateTime());
        }
        obj.setFilme(film);
        obj.setSala(sal);
        return obj;
    }

    @Override
    public void insert(List<Ingresso> ingressos) {
        PreparedStatement st = null;
    
        try {
            String sql = "INSERT INTO ingresso (Preco, Assento, NomeCliente, SessaoId) "
                       + "VALUES (?, ?, ?, ?)";
    
            st = conn.prepareStatement(sql);
    
            // Desativando auto-commit para inserção em batch (melhora performance)
            conn.setAutoCommit(false);
    
            // Loop pelos ingressos na lista e adiciona os parâmetros ao PreparedStatement
            for (Ingresso ingresso : ingressos) {
                st.setDouble(1, ingresso.getPreco());
                st.setString(2, ingresso.getAssento());
                st.setString(3, ingresso.getNomeCliente());
                st.setInt(4, ingresso.getSessao().getId());
    
                // Adiciona a inserção ao batch
                st.addBatch();
            }
    
            // Executa o batch de inserção
            st.executeBatch();
    
            // Confirma as alterações no banco de dados
            conn.commit();
    
        } catch (SQLException e) {
            // Em caso de erro, reverte as alterações
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
            throw new DbException("Erro ao inserir ingressos: " + e.getMessage());
        } finally {
            // Restaura o auto-commit
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

            DB.closeStatement(st);
        }
    }
    

    @Override
    public void update(Ingresso obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE ingresso "
                    + "SET Preco = ?, Assento = ?, SessaoId = ?, NomeCliente = ? "
                    + "WHERE Id = ? ");

            st.setDouble(1, obj.getPreco());
            st.setString(2, obj.getAssento());
            st.setInt(3, obj.getSessao().getId());
            st.setString(4, obj.getNomeCliente());
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
            st = conn.prepareStatement("SELECT ingresso.Id AS IngressoId, ingresso.Preco, ingresso.Assento, ingresso.NomeCliente, sessao.Id AS SessaoId, sessao.Cam, sessao.HorarioDaSessao, "
                    + "sala.Id AS SalaId, sala.Nome AS SalaNome, filme.Id AS FilmeId, filme.Nome AS FilmeNome,"
                    + "FROM ingresso INNER JOIN sessao ON ingresso.SessaoId = sessao.Id "
                    + "INNER JOIN sala ON sessao.SalaId = sala.Id "
                    + "INNER JOIN filme ON sessao.FilmeId = filme.Id "
                    + "ORDER BY ingresso.Id"
                    + "WHERE Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Filme film = instantiateFilme(rs);
                Sala sal = instantiateSala(rs);
                Sessao ses = instantiateSessao(rs, sal, film);
                Ingresso ass = instantiateIngresso(rs, ses);
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
                    "SELECT ingresso.Id AS IngressoId, ingresso.Preco, ingresso.Assento, ingresso.NomeCliente, sessao.Id AS SessaoId, sessao.Cam, sessao.HorarioDaSessao, "
                    + "sala.Id AS SalaId, sala.Nome AS SalaNome, filme.Id AS FilmeId, filme.Nome AS FilmeNome "
                    + "FROM ingresso INNER JOIN sessao ON ingresso.SessaoId = sessao.Id "
                    + "INNER JOIN sala ON sessao.SalaId = sala.Id "
                    + "INNER JOIN filme ON sessao.FilmeId = filme.Id "
                    + "ORDER BY ingresso.Id"
            );

            rs = st.executeQuery();

            List<Ingresso> list = new ArrayList<>();
            Map<Integer, Sessao> sessaoMap = new HashMap<>();
            Map<Integer, Sala> salaMap = new HashMap<>();
            Map<Integer, Filme> filmeMap = new HashMap<>();

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

                // Instanciar ingresso
                Ingresso ingresso = instantiateIngresso(rs, sessao);
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
