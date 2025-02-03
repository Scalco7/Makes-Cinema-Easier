package model.dao;

import java.util.List;
import model.entities.Sessao;

public interface SessaoDao {
    void insert(Sessao obj);
    void update(Sessao obj);
    Sessao findById(Integer id);
    List<Sessao> findByAll();
}
