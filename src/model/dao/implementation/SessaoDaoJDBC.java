package model.dao.implementation;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.entities.Sessao;
import model.dao.SessaoDao;
import model.entities.Filme;
import model.entities.Sala;

public class SessaoDaoJDBC implements SessaoDao {

    private Connection conn;

    public SessaoDaoJDBC(Connection conn) {
        this.conn = conn;
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
    public void insert(Sessao obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO sessao "
                    + "(Cam, HorarioDaSessao, FilmeId, SalaId) "
                    + "VALUES  "
                    + "(?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getCam());
            st.setTimestamp(2, Timestamp.valueOf(obj.getHorarioDaSessao()));
            st.setInt(3, obj.getFilme().getId());
            st.setInt(4, obj.getSala().getId());

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
    public void update(Sessao obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE sessao "
                    + "SET Cam = ?, HorarioDaSessao = ?, FilmeId = ?, SalaId = ? "
                    + "WHERE Id = ? ");

            st.setString(1, obj.getCam());
            st.setTimestamp(2, Timestamp.valueOf(obj.getHorarioDaSessao()));
            st.setInt(3, obj.getFilme().getId());
            st.setInt(4, obj.getSala().getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Sessao> findByDay(LocalDateTime dia) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT sessao.Id, sessao.HorarioDaSessao, sessao.Cam, " +
                    "sala.Id AS SalaId, sala.Nome AS SalaNome, sala.Largura, sala.Profundidade, " +
                    "filme.Id AS FilmeId, filme.Nome AS FilmeNome, filme.Descricao, filme.Classificacao, filme.MinutosTotais " +
                    "FROM sessao " +
                    "INNER JOIN sala ON sessao.SalaId = sala.Id " +
                    "INNER JOIN filme ON sessao.FilmeId = filme.Id " +
                    "WHERE HorarioDaSessao = ? " +
                    "ORDER BY HorarioDaSessao");
            
            st.setTimestamp(1, Timestamp.valueOf(dia));
            rs = st.executeQuery();

            List<Sessao> list = new ArrayList<>();
            Map<Integer, Sala> mapSalas = new HashMap<>();
            Map<Integer, Filme> mapFilmes = new HashMap<>();

            while (rs.next()) {
                // Instanciar Sala se ainda não existir no Map
                Sala sala = mapSalas.get(rs.getInt("SalaId"));
                if (sala == null) {
                    sala = new Sala();
                    sala.setId(rs.getInt("SalaId"));
                    sala.setNome(rs.getString("SalaNome"));
                    sala.setLargura(rs.getInt("Largura"));
                    sala.setProfundidade(rs.getInt("Profundidade"));
                    mapSalas.put(rs.getInt("SalaId"), sala);
                }

                // Instanciar Filme se ainda não existir no Map
                Filme filme = mapFilmes.get(rs.getInt("FilmeId"));
                if (filme == null) {
                    filme = new Filme();
                    filme.setId(rs.getInt("FilmeId"));
                    filme.setNome(rs.getString("FilmeNome"));
                    filme.setDescricao(rs.getString("Descricao"));
                    filme.setClassificacao(rs.getString("Classificacao"));
                    filme.setMinutosTotais(rs.getInt("MinutosTotais"));
                    mapFilmes.put(rs.getInt("FilmeId"), filme);
                }

                // Criar a Sessao
                Sessao sessao = new Sessao();
                sessao.setId(rs.getInt("Id"));
                sessao.setCam(rs.getString("Cam"));

                // Converte Timestamp para LocalDateTime
                Timestamp timestamp = rs.getTimestamp("HorarioDaSessao");
                if (timestamp != null) {
                    sessao.setHorarioDaSessao(timestamp.toLocalDateTime());
                }

                sessao.setSala(sala);
                sessao.setFilme(filme);

                list.add(sessao);
            }

            return list;


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Sessao> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT sessao.Id, sessao.HorarioDaSessao, sessao.Cam, " +
                    "sala.Id AS SalaId, sala.Nome AS SalaNome, sala.Largura, sala.Profundidade, " +
                    "filme.Id AS FilmeId, filme.Nome AS FilmeNome, filme.Descricao, filme.Classificacao, filme.MinutosTotais " +
                    "FROM sessao " +
                    "INNER JOIN sala ON sessao.SalaId = sala.Id " +
                    "INNER JOIN filme ON sessao.FilmeId = filme.Id " +
                    "ORDER BY HorarioDaSessao");

            rs = st.executeQuery();

            List<Sessao> list = new ArrayList<>();
            Map<Integer, Sala> mapSalas = new HashMap<>();
            Map<Integer, Filme> mapFilmes = new HashMap<>();

            while (rs.next()) {
                // Instanciar Sala se ainda não existir no Map
                Sala sala = mapSalas.get(rs.getInt("SalaId"));
                if (sala == null) {
                    sala = new Sala();
                    sala.setId(rs.getInt("SalaId"));
                    sala.setNome(rs.getString("SalaNome"));
                    sala.setLargura(rs.getInt("Largura"));
                    sala.setProfundidade(rs.getInt("Profundidade"));
                    mapSalas.put(rs.getInt("SalaId"), sala);
                }

                // Instanciar Filme se ainda não existir no Map
                Filme filme = mapFilmes.get(rs.getInt("FilmeId"));
                if (filme == null) {
                    filme = new Filme();
                    filme.setId(rs.getInt("FilmeId"));
                    filme.setNome(rs.getString("FilmeNome"));
                    filme.setDescricao(rs.getString("Descricao"));
                    filme.setClassificacao(rs.getString("Classificacao"));
                    filme.setMinutosTotais(rs.getInt("MinutosTotais"));
                    mapFilmes.put(rs.getInt("FilmeId"), filme);
                }

                // Criar a Sessao
                Sessao sessao = new Sessao();
                sessao.setId(rs.getInt("Id"));
                sessao.setCam(rs.getString("Cam"));

                // Converte Timestamp para LocalDateTime
                Timestamp timestamp = rs.getTimestamp("HorarioDaSessao");
                if (timestamp != null) {
                    sessao.setHorarioDaSessao(timestamp.toLocalDateTime());
                }

                sessao.setSala(sala);
                sessao.setFilme(filme);

                list.add(sessao);
            }

            return list;


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
    @Override
    public List<Sessao> buscarSessaoDisponivel(Integer idFilme) throws SQLException{
    List<Sessao> sessoes = new ArrayList<>();
    
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
        // Consulta SQL para buscar as sessões de um filme dentro de uma semana
        st = conn.prepareStatement(
                "SELECT sessao.Id, sessao.HorarioDaSessao, sessao.Cam, " +
                "filme.Id AS FilmeId, filme.Nome AS FilmeNome, filme.Descricao, filme.Classificacao, filme.MinutosTotais " +
                "FROM sessao " +
                "INNER JOIN filme ON sessao.FilmeId = filme.Id " +
                "WHERE sessao.FilmeId = ? " +
                "AND sessao.HorarioDaSessao > NOW() " +
                "ORDER BY sessao.HorarioDaSessao ASC");
        
        st.setInt(1, idFilme); // Define o id do filme na consulta
        rs = st.executeQuery();

        while (rs.next()) {
            // Instancia o filme
            Filme filme = new Filme();
            filme.setId(rs.getInt("FilmeId"));
            filme.setNome(rs.getString("FilmeNome"));
            filme.setDescricao(rs.getString("Descricao"));
            filme.setClassificacao(rs.getString("Classificacao"));
            filme.setMinutosTotais(rs.getInt("MinutosTotais"));

            // Cria a sessão e popula os dados
            Sessao sessao = new Sessao();
            sessao.setId(rs.getInt("Id"));
            sessao.setCam(rs.getString("Cam"));
            sessao.setFilme(filme);

            // Converte Timestamp para LocalDateTime
            Timestamp timestamp = rs.getTimestamp("HorarioDaSessao");
            if (timestamp != null) {
                sessao.setHorarioDaSessao(timestamp.toLocalDateTime());
            }

            // Adiciona à lista de sessões
            sessoes.add(sessao);
        }

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closeStatement(st);
        DB.closeResultSet(rs);
    }

    return sessoes;
}


}
