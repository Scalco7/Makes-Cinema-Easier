package model.dao;

import java.util.List;
import model.entities.Assento;

public interface AssentoDao {
    
    void insert(Assento obj);
    void update(Assento obj);
    Assento findById(String cod);
    List<Assento> findByAll();
    
}
