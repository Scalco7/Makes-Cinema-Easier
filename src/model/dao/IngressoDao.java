package model.dao;

import java.util.List;
import model.entities.Ingresso;

public interface IngressoDao {
    
    void insert(List<Ingresso> ingressos);
    void update(Ingresso obj);
    Ingresso findById(Integer id);
    List<Ingresso> findByAll();
    List<Ingresso> findBySection(Integer sectionId);
    
}
