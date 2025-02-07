package model.entities;

import db.DB;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import model.dao.implementation.IngressoDaoJDBC;

public class Ingresso implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Double preco;
    private String assento;
    private Sessao sessao;
    private String nomeCliente;

    public Ingresso() {
    }

    public Ingresso(Double preco, String assento, Sessao sessao, String nomeCliente) {
        this.preco = preco;
        this.assento = assento;
        this.sessao = sessao;
        this.nomeCliente = nomeCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public void cadastrarIngresso(List<Ingresso> ingressos){
        new IngressoDaoJDBC(DB.getConnection()).insert(ingressos);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Ingresso other = (Ingresso) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Ingresso{" + "id=" + id + ", preco=" + preco + ", sessao=" + sessao + '}';
    }
    
}
