
package model.dao.implementation;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entities.Filme;
import model.dao.FilmeDao;

public class FilmeDaoJDBC implements FilmeDao{
    
    private Connection conn;
    
    public FilmeDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    private Filme instantiateFilme(ResultSet rs) throws SQLException {
        Filme obj = new Filme();
        obj.setId(rs.getInt("Id"));
        obj.setNome(rs.getString("Nome"));
        obj.setBase64Image(rs.getString("Imagem"));
        obj.setDescricao(rs.getString("Descricao"));
        obj.setClassificacao(rs.getString("Classificacao"));
        obj.setMinutosTotais(rs.getInt("MinutosTotais"));
        return obj;
    }

    @Override
    public void insert(Filme obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO filme (Nome, Imagem, Descricao, Classificacao MinutosTotais) VALUES (?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getBase64Image());
            st.setString(3, obj.getDescricao());
            st.setString(4, obj.getClassificacao());
            st.setInt(5, obj.getMinutosTotais());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! Nenhuma linha afetada!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Filme obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE filme SET Nome = ?, Imagem = ?, Descricao = ?, Classificacao = ?, MinutosTotais = ? WHERE Id = ? ");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getBase64Image());
            st.setString(3, obj.getDescricao());
            st.setString(4, obj.getClassificacao());
            st.setInt(5, obj.getMinutosTotais());
            st.setInt(6, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Filme findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM filme WHERE Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Filme film = instantiateFilme(rs);
                return film;
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
    public Filme findByName(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM filme WHERE Nome = ?");

            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                Filme film = instantiateFilme(rs);
                return film;
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
    public List<Filme> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM filme ORDER BY Nome");

            rs = st.executeQuery();

            List<Filme> list = new ArrayList<>();

            while (rs.next()) {
                Filme film = instantiateFilme(rs);

                list.add(film);
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
