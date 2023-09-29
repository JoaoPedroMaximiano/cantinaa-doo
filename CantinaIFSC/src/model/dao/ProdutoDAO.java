package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Produto;

public class ProdutoDAO implements InterfaceDAO<Produto> {

    @Override
    public void create(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO produto (descricao, codigoBarra, status) VALUES (?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, String.valueOf(objeto.getStatus()));
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Produto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, descricao, codigoBarra, status FROM produto";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String codigoBarra = rs.getString("codigoBarra");
                char status = rs.getString("status").charAt(0);

                Produto produto = new Produto(id, descricao, codigoBarra, status);
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return produtos;
    }

    @Override
    public Produto retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT descricao, codigoBarra, status FROM produto WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");
                String codigoBarra = rs.getString("codigoBarra");
                char status = rs.getString("status").charAt(0);

                produto = new Produto(id, descricao, codigoBarra, status);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return produto;
    }

    @Override
    public List<Produto> retrieve(Produto filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder("SELECT id, descricao, codigoBarra, status FROM produto WHERE 1=1");
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql.append(" AND id = ?");
                parametros.add(filtro.getId());
            }

            if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
                sql.append(" AND descricao = ?");
                parametros.add(filtro.getDescricao());
            }

            if (filtro.getCodigoBarra() != null && !filtro.getCodigoBarra().isEmpty()) {
                sql.append(" AND codigoBarra = ?");
                parametros.add(filtro.getCodigoBarra());
            }

            if (filtro.getStatus() != 0) {
                sql.append(" AND status = ?");
                parametros.add(String.valueOf(filtro.getStatus()));
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql.toString());

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
                String codigoBarra = rs.getString("codigoBarra");
                char status = rs.getString("status").charAt(0);

                Produto produto = new Produto(id, descricao, codigoBarra, status);
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return produtos;
    }

    @Override
    public void update(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE produto SET descricao = ?, codigoBarra = ?, status = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, String.valueOf(objeto.getStatus()));
            pstm.setInt(4, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM produto WHERE id = ?";

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
