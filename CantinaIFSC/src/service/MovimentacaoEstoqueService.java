package service;

import java.util.List;
import model.bo.MovimentacaoEstoque;

public class MovimentacaoEstoqueService {
    public void adicionar(MovimentacaoEstoque objeto){
        new MovimentacaoEstoqueDAO().create(objeto);
    }

    public static List<MovimentacaoEstoque> carregar(){
        return new MovimentacaoEstoqueDAO().retrive();
    }

    public static MovimentacaoEstoque carregar(int id){
        return new MovimentacaoEstoqueDAO().retrive(id);
    }

    public static List<MovimentacaoEstoque> carregar(MovimentacaoEstoque filtro){
        return new MovimentacaoEstoqueDAO().retrive(filtro);
    }

    public void atualizar(MovimentacaoEstoque objeto){
        new MovimentacaoEstoqueDAO().update(objeto);
    }

    public void deletar(MovimentacaoEstoque objeto){
        new MovimentacaoEstoqueDAO().delete(objeto);
    }
}
