package service;

import java.util.List;
import model.bo.Caixa;
import model.dao.CaixaDAO;

public class CaixaService {

    public void adicionar(Caixa objeto){
        new CaixaDAO().create(objeto);
    }

    public List<Caixa> carregar(){
        return new CaixaDAO().retrieve();
    }

    public static Caixa carregar(int id){
        return new CaixaDAO().retrieve(id);
    }

    public List<Caixa> carregar(Caixa filtro){
        return new CaixaDAO().retrieve(filtro);
    }
    
    public void atualizar(Caixa objeto){
        new CaixaDAO().update(objeto);
    }
    
    public void deletar(Caixa objeto){
        new CaixaDAO().delete(objeto);
    }    
    
}
