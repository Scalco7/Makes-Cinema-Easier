package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Sessao implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String cam;
    private Date horarioDaSessao;
    private Filme filme;
    private Sala sala;

    public Sessao() {
    }

    public Sessao(Integer id, String cam, Date horarioDaSessao, Filme filme, Sala sala) {
        this.id = id;
        this.cam = cam;
        this.horarioDaSessao = horarioDaSessao;
        this.filme = filme;
        this.sala = sala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCam() {
        return cam;
    }

    public void setCam(String cam) {
        this.cam = cam;
    }

    public Date getHorarioDaSessao() {
        return horarioDaSessao;
    }

    public void setHorarioDaSessao(Date horarioDaSessao) {
        this.horarioDaSessao = horarioDaSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Sessao other = (Sessao) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Sessao{" + "id=" + id + ", cam=" + cam + ", horarioDaSessao=" + horarioDaSessao + ", filme=" + filme + ", sala=" + sala + '}';
    }
    
}