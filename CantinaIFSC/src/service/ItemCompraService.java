package service;

import java.util.List;
import model.bo.ItemCompra;

public class ItemCompraService {
    public void adicionar(ItemCompra objeto){
        new ItemCompraDAO().create(objeto);
    }

    public static List<ItemCompra> carregar(){
        return new ItemCompraDAO().retrive();
    }

    public static ItemCompra carregar(int id){
        return new ItemCompraDAO().retrive(id);
    }

    public static List<ItemCompra> carregar(ItemCompra filtro){
        return new ItemCompraDAO().retrive(filtro);
    }

    public void atualizar(ItemCompra objeto){
        new ItemCompraDAO().update(objeto);
    }

    public void deletar(ItemCompra objeto){
        new ItemCompraDAO().delete(objeto);
    }
}
