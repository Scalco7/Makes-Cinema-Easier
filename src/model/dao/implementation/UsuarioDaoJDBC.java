package model.dao.implementation;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entities.Usuario;
import model.dao.UsuarioDao;

public class UsuarioDaoJDBC implements UsuarioDao{
    
    private Connection conn;
    
    public UsuarioDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    private Usuario instantiateUsuario(ResultSet rs) throws SQLException {
        Usuario obj = new Usuario();
        obj.setCpf(rs.getString("Cpf"));
        obj.setNome(rs.getString("Nome"));
        obj.setEmail(rs.getString("Email"));
        obj.setSenha(rs.getString("Senha"));
        obj.setTelefone(rs.getString("Telefone"));
        return obj;
    }

    @Override
    public void insert(Usuario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO usuario (Cpf, Nome, Email, Senha, Telefone) VALUES (?, ?, ?, ?, ?) ");

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
    public void update(Usuario obj) {
        PreparedStatement st = null;
        try {
            
            st = conn.prepareStatement("UPDATE usuario SET Nome = ?, Email = ?, Senha = ?, Telefone = ? WHERE Cpf = ? ");

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
    public Usuario findById(String cpf) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Cpf, Nome, Email, Telefone FROM usuario WHERE Cpf = ?");

            st.setString(1, cpf);
            rs = st.executeQuery();

            if (rs.next()) {
                Usuario user = instantiateUsuario(rs);
                return user;
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
    public Usuario findByName(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Cpf, Nome, Email, Telefone FROM usuario WHERE Nome = ?");

            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                Usuario user = instantiateUsuario(rs);
                return user;
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
    public List<Usuario> findByAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Cpf, Nome, Email, Telefone FROM usuario ORDER BY Nome");

            rs = st.executeQuery();

            List<Usuario> list = new ArrayList<>();

            while (rs.next()) {
                Usuario user = instantiateUsuario(rs);

                list.add(user);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
    public Usuario findByEmailAndPassword(String email, String senha) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Cpf, Nome, Email, Senha, Telefone FROM usuario WHERE Email = ? AND Senha = ?");

            st.setString(1, email);
            st.setString(2, senha);
            rs = st.executeQuery();
            Usuario usuario = null;

            if (rs.next()) {
                usuario = instantiateUsuario(rs);
                //return usuario;
            }

            return usuario;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
}
