package model.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.bo.Bairro;

public class BairroDAO implements InterfaceDAO<Bairro>{

    @Override
    public void create(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO bairro (descricao) VALUES (?)";
        
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
        
    }

    @Override
    public List<Bairro> retrive() {
        return null;
    }

    @Override
    public Bairro retrive(int id) {
        return null;
    }

    @Override
    public Bairro retrive(String string) {
        return null;
    }

    @Override
    public void update(Bairro objeto) {
    }

    @Override
    public void delete(Bairro objeto) {
    }


}
