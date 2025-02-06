package model.dao;

import java.util.List;
import model.entities.Sala;

public interface SalaDao {
    
    void insert(Sala obj);
    void update(Sala obj);
    Sala findById(Integer id);
    List<Sala> findByName(String nome);
    List<Sala> findByAll();
   
}
