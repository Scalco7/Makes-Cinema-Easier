package controller;

import java.sql.Connection;
import db.DB;
import javax.swing.JOptionPane;
import model.dao.implementation.UsuarioDaoJDBC;
import model.entities.Usuario;

public class UsuarioControl {

    private Connection conn;

    public UsuarioControl() {
        conn = DB.getConnection();
    }

    public boolean cadastrarUsuario(String cpf, String nome, String email, String senha, String telefone) {
        if (cpf != null && cpf.length() > 0 && nome != null && nome.length() > 0 && email != null && email.length() > 0 && senha != null && senha.length() > 8 && telefone != null && telefone.length() > 0) {
            if (validarCPF(cpf)) {
                Usuario user = new Usuario(cpf, nome, email, senha, telefone);
                user.cadastrarUsuario(user);
                return true;
            }
            JOptionPane.showMessageDialog(null, "CPF Inválido!");
        }
        return false;
    }

    public boolean atualizarUsuario(String cpf, String nome, String email, String senha, String telefone) {
        if (cpf != null && cpf.length() > 0 && nome != null && nome.length() > 0 && email != null && email.length() > 0 && senha != null && senha.length() > 8 && telefone != null && telefone.length() > 0) {
            Usuario user = new Usuario(cpf, nome, email, senha, telefone);
            user.atualizarUsuario(user);
            return true;
        }
        return false;
    }

    public Usuario login(String email, String senha) {
        UsuarioDaoJDBC userJDBC = new UsuarioDaoJDBC(conn);
        Usuario user = userJDBC.findByEmailAndPassword(email, senha);
        if (user != null) {
            return user;
        }
        return null;
    }

    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais (ex: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        // Comparar com os dígitos do CPF
        return primeiroDigito == Character.getNumericValue(cpf.charAt(9))
                && segundoDigito == Character.getNumericValue(cpf.charAt(10));
    }
}
