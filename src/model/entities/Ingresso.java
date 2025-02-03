package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Ingresso implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Double preco;
    private Sessao sessao;
    private Cliente cliente;

    public Ingresso() {
    }

    public Ingresso(Integer id, Double preco, Sessao sessao, Cliente cliente) {
        this.id = id;
        this.preco = preco;
        this.sessao = sessao;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        return "Ingresso{" + "id=" + id + ", preco=" + preco + ", sessao=" + sessao + ", cliente=" + cliente + '}';
    }
    
}
