package service;

import java.util.List;
import model.bo.ItemVenda;
import model.dao.ItemVendaDAO;

public class ItemVendaService {
    public void adicionar(ItemVenda objeto){
        new ItemVendaDAO().create(objeto);
    }

    public static List<ItemVenda> carregar(){
        return new ItemVendaDAO().retrieve();
    }

    public static ItemVenda carregar(int id){
        return new ItemVendaDAO().retrieve(id);
    }

    public static List<ItemVenda> carregar(ItemVenda filtro){
        return new ItemVendaDAO().retrieve(filtro);
    }

    public void atualizar(ItemVenda objeto){
        new ItemVendaDAO().update(objeto);
    }

    public void deletar(ItemVenda objeto){
        new ItemVendaDAO().delete(objeto);
    }
}
