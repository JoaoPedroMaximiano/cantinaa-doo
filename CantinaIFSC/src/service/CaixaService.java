package service;

import java.util.List;
import model.bo.Caixa;

public class CaixaService {

    public void adicionar(Caixa objeto){
        new CaixaDAO().create(objeto);
    }

    public static List<Caixa> carregar(){
        return new CaixaDAO().retrive();
    }

    public static Caixa carregar(int id){
        return new CaixaDAO().retrive(id);
    }

    public static List<Caixa> carregar(Caixa filtro){
        return new CaixaDAO().retrive(filtro);
    }
    
    public void atualizar(Caixa objeto){
        new CaixaDAO().update(objeto);
    }
    
    public void deletar(Caixa objeto){
        new CaixaDAO().delete(objeto);
    }    
    
}
