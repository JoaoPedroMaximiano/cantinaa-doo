package service;

import java.util.List;
import model.bo.Cidade;
import model.dao.CidadeDAO;

public class CidadeService {
    
    public void adicionar(Cidade objeto){
        new CidadeDAO().create(objeto);
    }

    public List<Cidade> carregar(){
        return new CidadeDAO().retrieve();
    }

    public Cidade carregar(int id){
        return new CidadeDAO().retrieve(id);
    }

    public List<Cidade> carregar(Cidade filtro){
        return new CidadeDAO().retrieve(filtro);
    }
    
    public void atualizar(Cidade objeto){
        new CidadeDAO().update(objeto);
    }
    
    public void deletar(Cidade objeto){
        new CidadeDAO().delete(objeto);
    }    
    
}
