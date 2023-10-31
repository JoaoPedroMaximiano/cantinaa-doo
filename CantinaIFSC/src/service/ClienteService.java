package service;

import java.util.List;
import model.bo.Cliente;
import model.dao.ClienteDAO;

public class ClienteService {
    public void adicionar(Cliente objeto){
        new ClienteDAO().create(objeto);
    }

    public List<Cliente> carregar(){
        return new ClienteDAO().retrieve();
    }

    public Cliente carregar(int id){
        return new ClienteDAO().retrieve(id);
    }

    public List<Cliente> carregar(Cliente filtro){
        return new ClienteDAO().retrieve(filtro);
    }

    public void atualizar(Cliente objeto){
        new ClienteDAO().update(objeto);
    }

    public void deletar(Cliente objeto){
        new ClienteDAO().delete(objeto);
    }
}
