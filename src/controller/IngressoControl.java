
package controller;

import model.entities.Ingresso;
import model.entities.Sessao;


public class IngressoControl {
    public boolean cadastrarSessao(Double preco, String assento, String nomeCliente, Sessao sessao) {
        if (preco != null && preco > 0 && sessao != null && assento != null && assento.length() > 0 && nomeCliente != null && nomeCliente.length() > 0) {

            Ingresso ingresso = new Ingresso(preco, assento, sessao, nomeCliente);
            sessao.cadastrarSessao(sessao);

            return true;
        }
        return false;
    }
}
