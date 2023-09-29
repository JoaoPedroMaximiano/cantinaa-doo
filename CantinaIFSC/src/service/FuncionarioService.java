package service;

import java.util.List;
import model.bo.Funcionario;
import model.dao.FuncionarioDAO;

public class FuncionarioService {
    public void adicionar(Funcionario objeto){
        new FuncionarioDAO().create(objeto);
    }

    public static List<Funcionario> carregar(){
        return new FuncionarioDAO().retrieve();
    }

    public static Funcionario carregar(int id){
        return new FuncionarioDAO().retrieve(id);
    }

    public static List<Funcionario> carregar(Funcionario filtro){
        return new FuncionarioDAO().retrieve(filtro);
    }

    public void atualizar(Funcionario objeto){
        new FuncionarioDAO().update(objeto);
    }

    public void deletar(Funcionario objeto){
        new FuncionarioDAO().delete(objeto);
    }
}
