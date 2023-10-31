package service;

import java.util.List;
import model.bo.Fornecedor;
import model.dao.FornecedorDAO;

public class FornecedorService {
    public void adicionar(Fornecedor objeto){
        new FornecedorDAO().create(objeto);
    }

    public List<Fornecedor> carregar(){
        return new FornecedorDAO().retrieve();
    }

    public Fornecedor carregar(int id){
        return new FornecedorDAO().retrieve(id);
    }

    public List<Fornecedor> carregar(Fornecedor filtro){
        return new FornecedorDAO().retrieve(filtro);
    }

    public void atualizar(Fornecedor objeto){
        new FornecedorDAO().update(objeto);
    }

    public void deletar(Fornecedor objeto){
        new FornecedorDAO().delete(objeto);
    }
}
