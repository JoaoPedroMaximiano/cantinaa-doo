package service;

import java.util.List;
import model.bo.Carteirinha;
import model.dao.CarteirinhaDAO;

public class CarteirinhaService {
    public void adicionar(Carteirinha objeto){
        new CarteirinhaDAO().create(objeto);
    }

    public static List<Carteirinha> carregar(){
        return new CarteirinhaDAO().retrive();
    }

    public static Carteirinha carregar(int id){
        return new CarteirinhaDAO().retrive(id);
    }

    public static List<Carteirinha> carregar(Carteirinha filtro){
        return new CarteirinhaDAO().retrive(filtro);
    }

    public void atualizar(Carteirinha objeto){
        new CarteirinhaDAO().update(objeto);
    }

    public void deletar(Carteirinha objeto){
        new CarteirinhaDAO().delete(objeto);
}
