package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Sala implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private Integer qtdeAssentos;
    private ArrayList<Assento> assentos;

    public Sala() {
    }

    public Sala(Integer id, String nome, Integer qtdeAssentos, ArrayList<Assento> assentos) {
        this.id = id;
        this.nome = nome;
        this.qtdeAssentos = qtdeAssentos;
        this.assentos = assentos;
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

    public Integer getQtdeAssentos() {
        return qtdeAssentos;
    }

    public void setQtdeAssentos(Integer qtdeAssentos) {
        this.qtdeAssentos = qtdeAssentos;
    }

    public ArrayList<Assento> getAssentos() {
        return assentos;
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
        return "Sala{" + "id=" + id + ", nome=" + nome + ", qtdeAssentos=" + qtdeAssentos + ", assentos=" + assentos + '}';
    }
    
}
