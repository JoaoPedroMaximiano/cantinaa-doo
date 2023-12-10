package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;

public class ItemVendaDAO implements InterfaceDAO<ItemVenda> {

    @Override
    public void create(ItemVenda itemVenda) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO itemvenda (venda_id, produto_id, qtdProduto, valorUnitario, status) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, itemVenda.getVenda().getId());
            pstm.setInt(2, itemVenda.getProduto().getId());
            pstm.setDouble(3, itemVenda.getQtdProduto());
            pstm.setDouble(4, itemVenda.getValorUnitario());
            pstm.setString(5, String.valueOf(itemVenda.getStatus()));
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<ItemVenda> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, venda_id, produto_id, qtdProduto, valorUnitario, status FROM itemvenda";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ItemVenda> itensVenda = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int vendaId = rs.getInt("venda_id");
                int produtoId = rs.getInt("produto_id");
                double qtdProduto = rs.getDouble("qtdProduto");
                double valorUnitario = rs.getDouble("valorUnitario");
                char status = rs.getString("status").charAt(0);

                Produto produto = new ProdutoDAO().retrieve(produtoId);
                Venda venda = new VendaDAO().retrieve(vendaId);

                ItemVenda itemVenda = new ItemVenda(id, qtdProduto, valorUnitario, status, produto, venda);
                itensVenda.add(itemVenda);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itensVenda;
    }

    @Override
    public ItemVenda retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT venda_id, produto_id, qtdProduto, valorUnitario, status FROM itemvenda WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        ItemVenda itemVenda = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int vendaId = rs.getInt("venda_id");
                int produtoId = rs.getInt("produto_id");
                double qtdProduto = rs.getDouble("qtdProduto");
                double valorUnitario = rs.getDouble("valorUnitario");
                char status = rs.getString("status").charAt(0);

                Produto produto = new ProdutoDAO().retrieve(produtoId);
                Venda venda = new VendaDAO().retrieve(vendaId);

                itemVenda = new ItemVenda(id, qtdProduto, valorUnitario, status, produto, venda);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itemVenda;
    }

    @Override
    public List<ItemVenda> retrieve(ItemVenda filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT venda_id, produto_id, qtdProduto, valorUnitario, status FROM itemvenda WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getVenda() != null && filtro.getVenda().getId() != 0) {
                sql += " AND venda_id = ?";
                parametros.add(filtro.getVenda().getId());
            }

            if (filtro.getProduto() != null && filtro.getProduto().getId() != 0) {
                sql += " AND produto_id = ?";
                parametros.add(filtro.getProduto().getId());
            }

            if (filtro.getQtdProduto() != 0.0) {
                sql += " AND qtdProduto = ?";
                parametros.add(filtro.getQtdProduto());
            }

            if (filtro.getValorUnitario() != 0.0) {
                sql += " AND valorUnitario = ?";
                parametros.add(filtro.getValorUnitario());
            }

            if (filtro.getStatus() != '\0') {
                sql += " AND status = ?";
                parametros.add(filtro.getStatus());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ItemVenda> itensVenda = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                if (parametro instanceof Integer) {
                    pstm.setInt(i + 1, (Integer) parametro);
                } else if (parametro instanceof String) {
                    pstm.setString(i + 1, (String) parametro);
                } else if (parametro instanceof Double) {
                    pstm.setDouble(i + 1, (Double) parametro);
                } else if (parametro instanceof Character) {
                    pstm.setString(i + 1, String.valueOf(parametro));
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int vendaId = rs.getInt("venda_id");
                int produtoId = rs.getInt("produto_id");
                double qtdProduto = rs.getDouble("qtdProduto");
                double valorUnitario = rs.getDouble("valorUnitario");
                char status = rs.getString("status").charAt(0);

                Produto produto = new ProdutoDAO().retrieve(produtoId);
                Venda venda = new VendaDAO().retrieve(vendaId);

                ItemVenda itemVenda = new ItemVenda(id, qtdProduto, valorUnitario, status, produto, venda);
                itensVenda.add(itemVenda);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itensVenda;
    }

    @Override
    public void update(ItemVenda itemVenda) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE itemvenda SET venda_id = ?, produto_id = ?, qtdProduto = ?, valorUnitario = ?, status = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, itemVenda.getVenda().getId());
            pstm.setInt(2, itemVenda.getProduto().getId());
            pstm.setDouble(3, itemVenda.getQtdProduto());
            pstm.setDouble(4, itemVenda.getValorUnitario());
            pstm.setString(5, String.valueOf(itemVenda.getStatus()));
            pstm.setInt(6, itemVenda.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(ItemVenda itemVenda) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM itemvenda WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, itemVenda.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

}
