package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Cidade;

public class CidadeDAO implements InterfaceDAO<Cidade> {

    @Override
    public void create(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cidade (descricao, uf) VALUES (?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getUf());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Cidade> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, descricao, uf FROM cidade";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String uf = rs.getString("uf");
                Cidade cidade = new Cidade(id, descricao, uf);
                cidades.add(cidade);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return cidades;

    }
    
    
    @Override
    public Cidade retrive(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, descricao, uf FROM cidade WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cidade cidade = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");
                String uf = rs.getString("uf");
                cidade = new Cidade(id, descricao, uf);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return cidade;
    }
    
    @Override
    public List<Cidade> retrive(Cidade filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, descricao, uf FROM cidade WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
                sql += " AND descricao = ?";
                parametros.add(filtro.getDescricao());
            }

            if (filtro.getUf() != null && !filtro.getUf().isEmpty()) {
                sql += " AND uf = ?";
                parametros.add(filtro.getUf());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<>();

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
                String descricao = rs.getString("descricao");
                String uf = rs.getString("uf");
                Cidade cidade = new Cidade(id, descricao, uf);
                cidades.add(cidade);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return cidades;
    }

    @Override
    public void update(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE cidade SET descricao = ?, uf = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getUf());
            pstm.setInt(3, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM cidade WHERE id = ?";

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
