package service;

import java.util.List;
import model.bo.Endereco;
import model.dao.EnderecoDAO;

public class EnderecoService {
    public void adicionar(Endereco objeto){
        new EnderecoDAO().create(objeto);
    }

    public static List<Endereco> carregar(){
        return new EnderecoDAO().retrieve();
    }

    public static Endereco carregar(int id){
        return new EnderecoDAO().retrieve(id);
    }

    public static List<Endereco> carregar(Endereco filtro){
        return new EnderecoDAO().retrieve(filtro);
    }

    public void atualizar(Endereco objeto){
        new EnderecoDAO().update(objeto);
    }

    public void deletar(Endereco objeto){
        new EnderecoDAO().delete(objeto);
    }
}
