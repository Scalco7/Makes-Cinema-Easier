package model.entities;

import db.DB;
import java.io.Serializable;
import java.util.Objects;
import model.dao.implementation.FilmeDaoJDBC;

public class Filme implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String base64Image;
    private String descricao;
    private String classificacao;
    private Integer minutosTotais;

    public Filme() {}

    public Filme(String nome, String descricao, String classificacao, Integer minutosTotais, String base64Image) {
        this.nome = nome;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.minutosTotais = minutosTotais;
        this.base64Image = base64Image;
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
    
    public String getBase64Image(){
        return base64Image;
    }
    
    public void setBase64Image(String base64Image){
        this.base64Image = base64Image;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getMinutosTotais() {
        return minutosTotais;
    }

    public void setMinutosTotais(Integer minutosTotais) {
        this.minutosTotais = minutosTotais;
    }
    
    public void cadastrarFilme(Filme obj){
        new FilmeDaoJDBC(DB.getConnection()).insert(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Filme other = (Filme) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", classificacao=" + classificacao + ", minutosTotais=" + minutosTotais + '}';
    }
    
}
