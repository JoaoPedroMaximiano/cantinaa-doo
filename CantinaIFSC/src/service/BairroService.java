package service;

import java.util.List;
import model.bo.Bairro;
import model.dao.BairroDAO;

public class BairroService {

    public void adicionar(Bairro objeto){
        new BairroDAO().create(objeto);
    }

    public List<Bairro> carregar(){
        return new BairroDAO().retrieve();
    }

    public static Bairro carregar(int id){
        return new BairroDAO().retrieve(id);
    }

    public List<Bairro> carregar(Bairro filtro){
        return new BairroDAO().retrieve(filtro);
    }
    
    public void atualizar(Bairro objeto){
        new BairroDAO().update(objeto);
    }
    
    public void deletar(Bairro objeto){
        new BairroDAO().delete(objeto);
    }
}
