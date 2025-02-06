package model.dao;

import db.DB;
import model.dao.implementation.AssentoDaoJDBC;
import model.dao.implementation.UsuarioDaoJDBC;
import model.dao.implementation.FilmeDaoJDBC;
import model.dao.implementation.IngressoDaoJDBC;
import model.dao.implementation.SalaDaoJDBC;
import model.dao.implementation.SessaoDaoJDBC;

//Injecao de dependencia sem insplicitar a implementacao
public class DaoFactory {
    
    public static SalaDao createSalaDao(){
        return new SalaDaoJDBC(DB.getConnection());
    }
    
    public static AssentoDao createAssentoDao(){
        return new AssentoDaoJDBC(DB.getConnection());
    }
    
    public static UsuarioDao createUsuarioDao(){
        return new UsuarioDaoJDBC(DB.getConnection());
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
