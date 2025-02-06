package model.dao.implementacion;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entities.Cliente;
import model.dao.ClienteDao;

public class ClienteDaoJDBC implements ClienteDao{
    
    private Connection conn;
    
    public ClienteDaoJDBC(Connection conn){
        this.conn = conn;
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

    @Override
    public void insert(Cliente obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO cliente (Cpf, Nome, Email, Senha, Telefone) VALUES (?, ?, ?, ?, ?) ");

            st.setString(1, obj.getCpf());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getSenha());
            st.setString(5, obj.getTelefone());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected == 0) {
                throw new DbException("Unexpected error! Nenhuma linha afetada!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Cliente obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE cliente SET Nome = ?, Email = ?, Senha = ?, Telefone = ? WHERE Cpf = ? ");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getSenha());
            st.setString(4, obj.getTelefone());
            st.setString(5, obj.getCpf());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Cliente findById(String cpf) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Cpf, Nome, Email, Telefone FROM cliente WHERE Cpf = ?");

            st.setString(1, cpf);
            rs = st.executeQuery();

            if (rs.next()) {
                Cliente client = instantiateCliente(rs);
                return client;
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
    public Cliente findByName(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Cpf, Nome, Email, Telefone FROM cliente WHERE Nome = ?");

            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                Cliente client = instantiateCliente(rs);
                return client;
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
    public List<Cliente> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Cpf, Nome, Email, Telefone FROM cliente ORDER BY Nome");

            rs = st.executeQuery();

            List<Cliente> list = new ArrayList<>();

            while (rs.next()) {
                Cliente client = instantiateCliente(rs);

                list.add(client);
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
