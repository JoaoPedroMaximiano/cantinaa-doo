package service;

import java.util.List;
import model.bo.Carteirinha;
import model.dao.CarteirinhaDAO;

public class CarteirinhaService {
    public void adicionar(Carteirinha objeto){
        new CarteirinhaDAO().create(objeto);
    }

    public List<Carteirinha> carregar(){
        return new CarteirinhaDAO().retrieve();
    }

    public static Carteirinha carregar(int id){
        return new CarteirinhaDAO().retrieve(id);
    }

    public List<Carteirinha> carregar(Carteirinha filtro){
        return new CarteirinhaDAO().retrieve(filtro);
    }

    public void atualizar(Carteirinha objeto){
        new CarteirinhaDAO().update(objeto);
    }

    public void deletar(Carteirinha objeto){
        new CarteirinhaDAO().delete(objeto);
    }
}
