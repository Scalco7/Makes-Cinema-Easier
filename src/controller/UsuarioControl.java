package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DB;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.dao.implementacion.UsuarioDaoJDBC;
import model.entities.Usuario;

public class UsuarioControl {
    
    private Connection conn;

    public UsuarioControl() {
        conn = DB.getConnection();
    }  

    public boolean cadastrarUsuario(String cpf, String nome, String email, String senha, String telefone) {
        if (cpf != null && cpf.length() > 0 && nome != null && nome.length() > 0 && email != null && email.length() > 0 && senha != null && senha.length() > 8 && telefone != null && telefone.length() > 0) {

            Usuario user = new Usuario(cpf, nome, email, senha, telefone);
            user.cadastrarUsuario(user);
            return true;
        }
        return false;
    }

    public boolean login(String email, String senha) {
        UsuarioDaoJDBC userJDBC = new UsuarioDaoJDBC(conn);
        Usuario user = userJDBC.findByEmailAndPassword(email, senha);
        if (user != null) {
            return true;
        }
        return false;
    }
}
