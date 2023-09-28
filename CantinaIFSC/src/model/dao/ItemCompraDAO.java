package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Compra;
import model.bo.ItemCompra;
import model.bo.Produto;

public class ItemCompraDAO implements InterfaceDAO<ItemCompra> {

    @Override
    public void create(ItemCompra itemCompra) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO itemcompra (compra_id, produto_id, qtdProduto, valorUnitario, status) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, itemCompra.getCompra().getId());
            pstm.setInt(2, itemCompra.getProduto().getId());
            pstm.setDouble(3, itemCompra.getQtdProduto());
            pstm.setDouble(4, itemCompra.getValorUnitario());
            pstm.setString(5, String.valueOf(itemCompra.getStatus()));
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<ItemCompra> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, compra_id, produto_id, qtdProduto, valorUnitario, status FROM itemcompra";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ItemCompra> itensCompra = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int compraId = rs.getInt("compra_id");
                int produtoId = rs.getInt("produto_id");
                double qtdProduto = rs.getDouble("qtdProduto");
                double valorUnitario = rs.getDouble("valorUnitario");
                char status = rs.getString("status").charAt(0);

                Compra compra = new CompraDAO().retrive(compraId);
                Produto produto = new ProdutoDAO().retrive(produtoId);

                ItemCompra itemCompra = new ItemCompra(id, qtdProduto, valorUnitario, status, compra, produto);
                itensCompra.add(itemCompra);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itensCompra;
    }

    @Override
    public ItemCompra retrive(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT compra_id, produto_id, qtdProduto, valorUnitario, status FROM itemcompra WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        ItemCompra itemCompra = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int compraId = rs.getInt("compra_id");
                int produtoId = rs.getInt("produto_id");
                double qtdProduto = rs.getDouble("qtdProduto");
                double valorUnitario = rs.getDouble("valorUnitario");
                char status = rs.getString("status").charAt(0);

                Compra compra = new CompraDAO().retrive(compraId);
                Produto produto = new ProdutoDAO().retrive(produtoId);

                itemCompra = new ItemCompra(id, qtdProduto, valorUnitario, status, compra, produto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itemCompra;
    }
    
    @Override
    public List<ItemCompra> retrive(ItemCompra filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, compra_id, produto_id, qtdProduto, valorUnitario, status FROM itemcompra WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getCompra() != null && filtro.getCompra().getId() != 0) {
                sql += " AND compra_id = ?";
                parametros.add(filtro.getCompra().getId());
            }

            if (filtro.getProduto() != null && filtro.getProduto().getId() != 0) {
                sql += " AND produto_id = ?";
                parametros.add(filtro.getProduto().getId());
            }

            if (filtro.getQtdProduto() != 0) {
                sql += " AND qtdProduto = ?";
                parametros.add(filtro.getQtdProduto());
            }

            if (filtro.getValorUnitario() != 0) {
                sql += " AND valorUnitario = ?";
                parametros.add(filtro.getValorUnitario());
            }

            if (filtro.getStatus() != '\u0000') {
                sql += " AND status = ?";
                parametros.add(String.valueOf(filtro.getStatus()));
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ItemCompra> itensCompra = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                if (parametro instanceof Integer) {
                    pstm.setInt(i + 1, (Integer) parametro);
                } else if (parametro instanceof Double) {
                    pstm.setDouble(i + 1, (Double) parametro);
                } else if (parametro instanceof String) {
                    pstm.setString(i + 1, (String) parametro);
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int compraId = rs.getInt("compra_id");
                int produtoId = rs.getInt("produto_id");
                double qtdProduto = rs.getDouble("qtdProduto");
                double valorUnitario = rs.getDouble("valorUnitario");
                char status = rs.getString("status").charAt(0);

                Compra compra = new CompraDAO().retrive(compraId);
                Produto produto = new ProdutoDAO().retrive(produtoId);

                ItemCompra itemCompra = new ItemCompra(id, qtdProduto, valorUnitario, status, compra, produto);
                itensCompra.add(itemCompra);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itensCompra;
    }

    @Override
    public void update(ItemCompra itemCompra) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE itemcompra SET compra_id = ?, produto_id = ?, qtdProduto = ?, valorUnitario = ?, status = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, itemCompra.getCompra().getId());
            pstm.setInt(2, itemCompra.getProduto().getId());
            pstm.setDouble(3, itemCompra.getQtdProduto());
            pstm.setDouble(4, itemCompra.getValorUnitario());
            pstm.setString(5, String.valueOf(itemCompra.getStatus()));
            pstm.setInt(6, itemCompra.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(ItemCompra itemCompra) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM itemcompra WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, itemCompra.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

}
