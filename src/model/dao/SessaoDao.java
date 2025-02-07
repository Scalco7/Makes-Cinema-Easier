package model.dao;

import java.time.LocalDateTime;
import java.util.List;
import model.entities.Sessao;

public interface SessaoDao {
    void insert(Sessao obj);
    void update(Sessao obj);
    List<Sessao> findByDay(LocalDateTime dia);
    List<Sessao> findByAll();
}
