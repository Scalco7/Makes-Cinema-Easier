package model.dao;

import java.util.List;
import model.entities.Usuario;

public interface UsuarioDao {
    
    void insert(Usuario obj);
    void update(Usuario obj);
    Usuario findById(String cpf);
    Usuario findByName(String name);
    List<Usuario> findByAll();
    Usuario findByEmailAndPassword(String email, String senha);
    
}
