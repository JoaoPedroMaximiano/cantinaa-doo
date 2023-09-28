package service;

import java.util.List;
import model.bo.Venda;
import model.dao.VendaDAO;

public class VendaService {
    public void adicionar(Venda objeto){
        new VendaDAO().create(objeto);
    }

    public static List<Venda> carregar(){
        return new VendaDAO().retrive();
    }

    public static Venda carregar(int id){
        return new VendaDAO().retrive(id);
    }

    public static List<Venda> carregar(Venda filtro){
        return new VendaDAO().retrive(filtro);
    }

    public void atualizar(Venda objeto){
        new VendaDAO().update(objeto);
    }

    public void deletar(Venda objeto){
        new VendaDAO().delete(objeto);
    }
}
