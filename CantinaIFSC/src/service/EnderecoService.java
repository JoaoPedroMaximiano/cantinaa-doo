package service;

import java.util.List;
import model.bo.Endereco;
import model.dao.EnderecoDAO;

public class EnderecoService {
    public void adicionar(Endereco objeto){
        new EnderecoDAO().create(objeto);
    }

    public static List<Endereco> carregar(){
        return new EnderecoDAO().retrive();
    }

    public static Endereco carregar(int id){
        return new EnderecoDAO().retrive(id);
    }

    public static List<Endereco> carregar(Endereco filtro){
        return new EnderecoDAO().retrive(filtro);
    }

    public void atualizar(Endereco objeto){
        new EnderecoDAO().update(objeto);
    }

    public void deletar(Endereco objeto){
        new EnderecoDAO().delete(objeto);
    }
}
