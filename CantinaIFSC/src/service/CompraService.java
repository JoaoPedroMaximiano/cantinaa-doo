package service;

import java.util.List;
import model.bo.Compra;
import model.dao.CompraDAO;

public class CompraService {
    public void adicionar(Compra objeto){
        new CompraDAO().create(objeto);
    }

    public static List<Compra> carregar(){
        return new CompraDAO().retrieve();
    }

    public static Compra carregar(int id){
        return new CompraDAO().retrieve(id);
    }

    public static List<Compra> carregar(Compra filtro){
        return new CompraDAO().retrieve(filtro);
    }

    public void atualizar(Compra objeto){
        new CompraDAO().update(objeto);
    }

    public void deletar(Compra objeto){
        new CompraDAO().delete(objeto);
    }
}
