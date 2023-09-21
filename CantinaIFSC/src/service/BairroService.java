package service;

import java.util.List;
import model.bo.Bairro;
import model.dao.BairroDAO;

public class BairroService {

    public void adicionar(Bairro objeto){
        new BairroDAO().create(objeto);
    }

    public static List<Bairro> carregar(){
        return new BairroDAO().retrive();
    }

    public static Bairro carregar(int id){
        return new BairroDAO().retrive(id);
    }

    public static List<Bairro> carregar(Bairro filtro){
        return new BairroDAO().retrive(filtro);
    }
    
    public void atualizar(Bairro objeto){
        new BairroDAO().update(objeto);
    }
    
    public void deletar(Bairro objeto){
        new BairroDAO().delete(objeto);
    }
}
