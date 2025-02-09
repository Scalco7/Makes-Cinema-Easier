package model.dao.implementation;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entities.Sala;
import model.dao.SalaDao;

public class SalaDaoJDBC implements SalaDao {

    private Connection conn;

    public SalaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    private Sala instantiateSala(ResultSet rs) throws SQLException {
        Sala obj = new Sala();
        obj.setId(rs.getInt("Id"));
        obj.setNome(rs.getString("Nome"));
        obj.setLargura(rs.getInt("Largura"));
        obj.setProfundidade(rs.getInt("Profundidade"));
        return obj;
    }

    @Override
    public void insert(Sala obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO sala (Nome, Largura, Profundidade) VALUES (?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getLargura());
            st.setInt(3, obj.getProfundidade());

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
    public void update(Sala obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE sala SET Nome = ?, Largura = ?, Profundidade = ? WHERE Id = ? ");

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getLargura());
            st.setInt(3, obj.getProfundidade());
            st.setInt(4, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Sala findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM sala WHERE Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Sala sal = instantiateSala(rs);
                return sal;
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
    public List<Sala> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM sala ORDER BY Nome");

            rs = st.executeQuery();

            List<Sala> list = new ArrayList<>();

            while (rs.next()) {
                Sala sal = instantiateSala(rs);

                list.add(sal);
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
    public List<Sala> findByName(String nome) {
        System.out.println(nome);
        List<Sala> salas = new ArrayList<>();
        nome = "%"+nome+"%";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM sala WHERE Nome LIKE ?");

            st.setString(1, nome);
            rs = st.executeQuery();

            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId(rs.getInt("Id"));
                sala.setNome(rs.getString("Nome"));
                sala.setLargura(rs.getInt("Largura"));
                sala.setProfundidade(rs.getInt("Profundidade"));
                salas.add(sala);
            }

            return salas;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}
