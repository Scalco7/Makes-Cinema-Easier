package controller;

import model.entities.Filme;

public class FilmeControl {

    public boolean cadastrarFilme(String nome, String descricao, String classificacao, String idioma, Integer minutosTotais, String base64Image) {
        if (nome != null && nome.length() > 0 && descricao != null && descricao.length() > 0 && classificacao != null && classificacao.length() > 0  && idioma != null && idioma.length() > 0 && minutosTotais != null && minutosTotais > 0 && base64Image != null && base64Image.length() > 0) {
            
            Filme film = new Filme(nome, descricao, classificacao, idioma, minutosTotais, base64Image);
            film.cadastrarFilme(film);
            return true;
        }
        return false;
    }
}