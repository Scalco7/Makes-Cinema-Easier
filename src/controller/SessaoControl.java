package controller;

import java.time.LocalDateTime;
import model.entities.Filme;
import model.entities.Sala;
import model.entities.Sessao;

/**
 *
 * @author Scalco
 */
public class SessaoControl {

    public boolean cadastrarSessao(String idioma, LocalDateTime horarioDaSessao, Filme filme, Sala sala) {
        if (idioma != null && idioma.length() > 0 && horarioDaSessao.isAfter(LocalDateTime.now()) && filme != null && sala != null) {

            Sessao sessao = new Sessao(idioma, horarioDaSessao, filme, sala);
            sessao.cadastrarSessao(sessao);

            return true;
        }
        return false;
    }
}
