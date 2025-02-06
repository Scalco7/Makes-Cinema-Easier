package model.dao.implementation;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.entities.Assento;
import model.entities.Sala;
import model.dao.AssentoDao;

public class AssentoDaoJDBC implements AssentoDao {

    private Connection conn;

    public AssentoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    private Assento instantiateAssento(ResultSet rs, Sala sal) throws SQLException {
        Assento obj = new Assento();
        obj.setCodigo(rs.getString("Codigo"));
        obj.setStatus(rs.getString("StatusAssento"));
        obj.setSala(sal);
        return obj;
    }

    private Sala instantiateSala(ResultSet rs) throws SQLException {
        Sala obj = new Sala();
        obj.setId(rs.getInt("Id"));
        obj.setNome(rs.getString("Nome"));
        obj.setQtdeAssentos(rs.getInt("QtdeAssentos"));
        return obj;
    }

    @Override
    public void insert(Assento obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO assento "
                    + "(Codigo, StatusAssento, SalaId) "
                    + "VALUES  "
                    + "(?, ?, ?) ");

            st.setString(1, obj.getCodigo());
            st.setString(2, obj.getStatus());
            st.setInt(3, obj.getSala().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    String cod = rs.getString(1);
                    obj.setCodigo(cod);
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
    public void update(Assento obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE assento "
                    + "SET StatusAssento = ?, SalaId = ? "
                    + "WHERE Codigo = ? ");

            st.setString(1, obj.getStatus());
            st.setInt(2, obj.getSala().getId());
            st.setString(3, obj.getCodigo());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Assento findById(String cod) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM assento WHERE Codigo = ?");

            st.setString(1, cod);
            rs = st.executeQuery();

            if (rs.next()) {
                Sala sal = instantiateSala(rs);
                Assento ass = instantiateAssento(rs, sal);
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
    public List<Assento> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT assento.*,sala.Nome as Sala  "
                    + "FROM assento INNER JOIN sala  "
                    + "ON assento.SalaId = sala.Id "
                    + "ORDER BY Nome");

            rs = st.executeQuery();

            List<Assento> list = new ArrayList<>();
            Map<Integer, Sala> map = new HashMap<>();

            while (rs.next()) {
                Sala sal = map.get(rs.getInt("SalaId"));

                if (sal == null) {
                    sal = instantiateSala(rs);
                    map.put(rs.getInt("SalaId"), sal);
                }

                Assento ass = instantiateAssento(rs, sal);

                list.add(ass);
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
