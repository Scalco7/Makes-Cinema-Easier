package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Assento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String status;
    private Sala sala;

    public Assento() {
    }

    public Assento(String codigo, String status, Sala sala) {
        this.codigo = codigo;
        this.status = status;
        this.sala = sala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codigo);
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
        final Assento other = (Assento) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Assento{" + "codigo=" + codigo + ", status=" + status + ", sala=" + sala + '}';
    }
    
}
