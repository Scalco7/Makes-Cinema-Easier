package model.dao.implementation;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.entities.Sessao;
import model.dao.SessaoDao;
import model.entities.Filme;
import model.entities.Sala;

public class SessaoDaoJDBC implements SessaoDao{
    
    private Connection conn;
    
    public SessaoDaoJDBC(Connection conn){
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
        obj.setHorarioDaSessao(rs.getDate("HorarioDaSessao"));
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
            st.setDate(2, new java.sql.Date(obj.getHorarioDaSessao().getTime()));
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
            st.setDate(2, new java.sql.Date(obj.getHorarioDaSessao().getTime()));
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
    public Sessao findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Sessao> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT sessao.HorarioDaSessao, sessao.Cam, sala.Nome as Sala, filme.Nome as Filme "
                   +  "FROM sessao INNER JOIN sala ON sessao.SalaId = sala.Id INNER "
                   + "JOIN filme ON sessao.FilmeId = filme.Id ORDER BY HorarioDaSessao");

            rs = st.executeQuery();

            List<Sessao> list = new ArrayList<>();
            Map<Integer, Sala> map1 = new HashMap<>();
            Map<Integer, Filme> map2 = new HashMap<>();

            while (rs.next()) {
                Sala sal = map1.get(rs.getInt("SalaId"));
                Filme film = map2.get(rs.getInt("FilmeId"));

                if (sal == null) {
                    sal = instantiateSala(rs);
                    map1.put(rs.getInt("SalaId"), sal);
                }
                if (film == null) {
                    film = instantiateFilme(rs);
                    map2.put(rs.getInt("FilmeId"), film);
                }

                Sessao ses = instantiateSessao(rs, sal, film);

                list.add(ses);
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
