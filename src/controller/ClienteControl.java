package controller;

import model.entities.Cliente;

public class ClienteControl {

    public boolean cadastrarCliente(String cpf, String nome, String email, String senha, String telefone) {
        if (cpf != null && cpf.length() > 0 && nome != null && nome.length() > 0 && email != null && email.length() > 0 && senha != null && senha.length() > 8 && telefone != null && telefone.length() > 0) {
            
            Cliente cliente = new Cliente(cpf, nome, email, senha, telefone);
            cliente.cadastrarCliente(cliente);
            return true;
        }
        return false;
    }
}
