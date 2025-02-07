package model.dao;

import java.util.List;
import model.entities.Filme;

public interface FilmeDao {
    
    void insert(Filme obj);
    void update(Filme obj);
    Filme findById(Integer id);
    List<Filme> findByName(String nome);
    List<Filme> findByAll();
    List<Filme> listAvailables();
    
}
