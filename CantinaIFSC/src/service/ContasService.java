package service;

import java.util.List;
import model.bo.Contas;
import model.dao.ContasDAO;

public class ContasService {
    public void adicionar(Contas objeto){
        new ContasDAO().create(objeto);
    }

    public static List<Contas> carregar(){
        return new ContasDAO().retrieve();
    }

    public static Contas carregar(int id){
        return new ContasDAO().retrieve(id);
    }

    public static List<Contas> carregar(Contas filtro){
        return new ContasDAO().retrieve(filtro);
    }

    public void atualizar(Contas objeto){
        new ContasDAO().update(objeto);
    }

    public void deletar(Contas objeto){
        new ContasDAO().delete(objeto);
    }
}
