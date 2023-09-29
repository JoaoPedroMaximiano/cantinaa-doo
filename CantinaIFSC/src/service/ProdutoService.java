package service;

import java.util.List;
import model.bo.Produto;
import model.dao.ProdutoDAO;

public class ProdutoService {
    public void adicionar(Produto objeto){
        new ProdutoDAO().create(objeto);
    }

    public static List<Produto> carregar(){
        return new ProdutoDAO().retrieve();
    }

    public static Produto carregar(int id){
        return new ProdutoDAO().retrieve(id);
    }

    public static List<Produto> carregar(Produto filtro){
        return new ProdutoDAO().retrieve(filtro);
    }

    public void atualizar(Produto objeto){
        new ProdutoDAO().update(objeto);
    }

    public void deletar(Produto objeto){
        new ProdutoDAO().delete(objeto);
    }
}
