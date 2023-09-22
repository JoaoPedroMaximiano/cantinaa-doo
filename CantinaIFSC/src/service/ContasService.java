package service;

import java.util.List;
import model.bo.Contas;

public class ContasService {
    public void adicionar(Contas objeto){
        new ContasDAO().create(objeto);
    }

    public static List<Contas> carregar(){
        return new ContasDAO().retrive();
    }

    public static Contas carregar(int id){
        return new ContasDAO().retrive(id);
    }

    public static List<Contas> carregar(Contas filtro){
        return new ContasDAO().retrive(filtro);
    }

    public void atualizar(Contas objeto){
        new ContasDAO().update(objeto);
    }

    public void deletar(Contas objeto){
        new ContasDAO().delete(objeto);
    }
}
