package service;

import java.util.List;
import model.bo.Cliente;
import model.dao.ClienteDAO;

public class ClienteService {
    public void adicionar(Cliente objeto){
        new ClienteDAO().create(objeto);
    }

    public static List<Cliente> carregar(){
        return new ClienteDAO().retrive();
    }

    public static Cliente carregar(int id){
        return new ClienteDAO().retrive(id);
    }

    public static List<Cliente> carregar(Cliente filtro){
        return new ClienteDAO().retrive(filtro);
    }

    public void atualizar(Cliente objeto){
        new ClienteDAO().update(objeto);
    }

    public void deletar(Cliente objeto){
        new ClienteDAO().delete(objeto);
    }
}
