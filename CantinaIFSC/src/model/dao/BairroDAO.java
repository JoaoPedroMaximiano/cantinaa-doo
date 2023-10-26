package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Bairro;

public class BairroDAO implements InterfaceDAO<Bairro> {

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
    public List<Bairro> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, descricao FROM bairro";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Bairro> bairros = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Bairro bairro = new Bairro(id, descricao);
                bairros.add(bairro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return bairros;
    }

    @Override
    public Bairro retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, descricao FROM bairro WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Bairro bairro = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");
                bairro = new Bairro(id, descricao);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return bairro;
    }

    @Override
    public List<Bairro> retrieve(Bairro filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, descricao FROM bairro WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
                sql += " AND SOUNDEX(descricao) = SOUNDEX(?)";
                parametros.add(filtro.getDescricao());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Bairro> bairros = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                if (parametro instanceof Integer) {
                    pstm.setInt(i + 1, (Integer) parametro);
                } else if (parametro instanceof String) {
                    pstm.setString(i + 1, (String) parametro);
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricaoPstm = rs.getString("descricao");
                Bairro bairro = new Bairro(id, descricaoPstm);
                bairros.add(bairro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return bairros;
    }

    @Override
    public void update(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE bairro SET descricao = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM bairro WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }
}
