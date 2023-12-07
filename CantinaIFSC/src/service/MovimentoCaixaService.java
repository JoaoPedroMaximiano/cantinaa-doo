package service;

import java.util.List;
import model.bo.MovimentoCaixa;
import model.dao.MovimentoCaixaDAO;

public class MovimentoCaixaService {
    public void adicionar(MovimentoCaixa objeto){
        new MovimentoCaixaDAO().create(objeto);
    }

    public List<MovimentoCaixa> carregar(){
        return new MovimentoCaixaDAO().retrieve();
    }

    public MovimentoCaixa carregar(int id){
        return new MovimentoCaixaDAO().retrieve(id);
    }

    public List<MovimentoCaixa> carregar(MovimentoCaixa filtro){
        return new MovimentoCaixaDAO().retrieve(filtro);
    }

    public void atualizar(MovimentoCaixa objeto){
        new MovimentoCaixaDAO().update(objeto);
    }

    public void deletar(MovimentoCaixa objeto){
        new MovimentoCaixaDAO().delete(objeto);
    }
}
