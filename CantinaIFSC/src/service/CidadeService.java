package service;

import java.util.List;
import model.bo.Cidade;
import model.dao.CidadeDAO;

public class CidadeService {
    
    public void adicionar(Cidade objeto){
        new CidadeDAO().create(objeto);
    }

    public static List<Cidade> carregar(){
        return new CidadeDAO().retrive();
    }

    public static Cidade carregar(int id){
        return new CidadeDAO().retrive(id);
    }

    public static List<Cidade> carregar(Cidade filtro){
        return new CidadeDAO().retrive(filtro);
    }
    
    public void atualizar(Cidade objeto){
        new CidadeDAO().update(objeto);
    }
    
    public void deletar(Cidade objeto){
        new CidadeDAO().delete(objeto);
    }    
    
}
