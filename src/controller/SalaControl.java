package controller;

import model.entities.Sala;

public class SalaControl {
    public boolean cadastrarSala(String nome, Integer largura, Integer profundidade) {
        if (nome != null && nome.length() > 0 && largura != null && largura > 0 && profundidade != null && profundidade > 0) {
            
            Sala sala = new Sala(nome, largura, profundidade);
            
            sala.cadastrarSala(sala);
            return true;
        }
        return false;
    }
}
