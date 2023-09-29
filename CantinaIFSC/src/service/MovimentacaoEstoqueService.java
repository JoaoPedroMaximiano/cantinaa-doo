package service;

import java.util.List;
import model.bo.MovimentacaoEstoque;
import model.dao.MovimentacaoEstoqueDAO;

public class MovimentacaoEstoqueService {
    public void adicionar(MovimentacaoEstoque objeto){
        new MovimentacaoEstoqueDAO().create(objeto);
    }

    public static List<MovimentacaoEstoque> carregar(){
        return new MovimentacaoEstoqueDAO().retrieve();
    }

    public static MovimentacaoEstoque carregar(int id){
        return new MovimentacaoEstoqueDAO().retrieve(id);
    }

    public static List<MovimentacaoEstoque> carregar(MovimentacaoEstoque filtro){
        return new MovimentacaoEstoqueDAO().retrieve(filtro);
    }

    public void atualizar(MovimentacaoEstoque objeto){
        new MovimentacaoEstoqueDAO().update(objeto);
    }

    public void deletar(MovimentacaoEstoque objeto){
        new MovimentacaoEstoqueDAO().delete(objeto);
    }
}
