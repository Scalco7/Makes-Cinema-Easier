package model.entities;

import db.DB;
import java.io.Serializable;
import java.util.Objects;
import model.dao.implementation.SalaDaoJDBC;

public class Sala implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private Integer largura;
    private Integer profundidade;

    public Sala() {
    }

    public Sala(String nome, Integer largura, Integer profundidade) {
        this.nome = nome;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Integer profundidade) {
        this.profundidade = profundidade;
    }
    
    public void cadastrarSala(Sala obj){
        new SalaDaoJDBC(DB.getConnection()).insert(obj);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Sala other = (Sala) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", nome=" + nome + ", largura=" + largura + ", profundidade=" + profundidade + '}';
    }
    
}
