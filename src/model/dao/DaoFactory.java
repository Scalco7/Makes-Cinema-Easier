package model.dao;

import db.DB;
import model.dao.implementacion.AssentoDaoJDBC;
import model.dao.implementacion.ClienteDaoJDBC;
import model.dao.implementacion.FilmeDaoJDBC;
import model.dao.implementacion.IngressoDaoJDBC;
import model.dao.implementacion.SalaDaoJDBC;
import model.dao.implementacion.SessaoDaoJDBC;

//Injecao de dependencia sem insplicitar a implementacao
public class DaoFactory {
    
    public static SalaDao createSalaDao(){
        return new SalaDaoJDBC(DB.getConnection());
    }
    
    public static AssentoDao createAssentoDao(){
        return new AssentoDaoJDBC(DB.getConnection());
    }
    
    public static ClienteDao createClienteDao(){
        return new ClienteDaoJDBC(DB.getConnection());
    }
    
    public static FilmeDao createFilmeDao(){
        return new FilmeDaoJDBC(DB.getConnection());
    }
    
    public static IngressoDao createIngressoDao(){
        return new IngressoDaoJDBC(DB.getConnection());
    }
    
    public static SessaoDao createSessaoDao(){
        return new SessaoDaoJDBC(DB.getConnection());
    }
    
}
