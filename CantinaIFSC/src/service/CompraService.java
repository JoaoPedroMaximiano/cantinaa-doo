package service;

import java.util.List;
import model.bo.Compra;

public class CompraService {
    public void adicionar(Compra objeto){
        new CompraDAO().create(objeto);
    }

    public static List<Compra> carregar(){
        return new CompraDAO().retrive();
    }

    public static Compra carregar(int id){
        return new CompraDAO().retrive(id);
    }

    public static List<Compra> carregar(Compra filtro){
        return new CompraDAO().retrive(filtro);
    }

    public void atualizar(Compra objeto){
        new CompraDAO().update(objeto);
    }

    public void deletar(Compra objeto){
        new CompraDAO().delete(objeto);
    }
}
