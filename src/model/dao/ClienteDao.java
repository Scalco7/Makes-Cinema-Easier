package model.dao;

import java.util.List;
import model.entities.Cliente;

public interface ClienteDao {
    
    void insert(Cliente obj);
    void update(Cliente obj);
    Cliente findById(String cpf);
    Cliente findByName(String name);
    List<Cliente> findByAll();
    
}
