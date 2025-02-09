package model.entities;

import db.DB;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import model.dao.implementation.SessaoDaoJDBC;

public class Sessao implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String cam;
    private LocalDateTime horarioDaSessao;
    private Filme filme;
    private Sala sala;

    public Sessao() {
    }

    public Sessao(String cam, LocalDateTime horarioDaSessao, Filme filme, Sala sala) {
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

    public LocalDateTime getHorarioDaSessao() {
        return horarioDaSessao;
    }

    public void setHorarioDaSessao(LocalDateTime horarioDaSessao) {
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
    
    public void cadastrarSessao(Sessao obj){
        new SessaoDaoJDBC(DB.getConnection()).insert(obj);
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