package model.entities;

import db.DB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import model.dao.implementation.UsuarioDaoJDBC;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private ArrayList<Ingresso> ingressos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String cpf, String nome, String email, String senha, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void cadastrarUsuario(Usuario obj){
        new UsuarioDaoJDBC(DB.getConnection()).insert(obj);
    }
    
    public void atualizarUsuario(Usuario obj){
        new UsuarioDaoJDBC(DB.getConnection()).update(obj);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone=" + telefone + '}';
    }

}
