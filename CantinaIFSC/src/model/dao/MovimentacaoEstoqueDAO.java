package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.bo.Funcionario;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.MovimentacaoEstoque;
import model.bo.Produto;

public class MovimentacaoEstoqueDAO implements InterfaceDAO<MovimentacaoEstoque> {

    @Override
    public void create(MovimentacaoEstoque movimentacao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO movimentacaoestoque (itemvenda_id, produto_id, itemcompra_id, funcionario_id, flagTipoMovimento, qtdMovimentada, observacaoMovimento, status, dataHoraMovimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            if (movimentacao.getItemVenda() != null) {
                pstm.setInt(1, movimentacao.getItemVenda().getId());
            } else {
                pstm.setNull(1, java.sql.Types.INTEGER);
            }   
            pstm.setInt(2, movimentacao.getProduto().getId());
            if (movimentacao.getItemCompra() != null) {
                pstm.setInt(3, movimentacao.getItemCompra().getId());
            } else {
                pstm.setNull(3, java.sql.Types.INTEGER);
            }
            pstm.setInt(4, movimentacao.getFuncionario().getId());
            pstm.setString(5, String.valueOf(movimentacao.getFlagTipoMovimento()));
            pstm.setDouble(6, movimentacao.getQtdMovimentada());
            pstm.setString(7, movimentacao.getObservacaoMovimento());
            pstm.setString(8, String.valueOf(movimentacao.getStatus()));
            pstm.setString(9, movimentacao.getDataHoraMovimento());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<MovimentacaoEstoque> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, itemvenda_id, produto_id, itemcompra_id, funcionario_id, flagTipoMovimento, qtdMovimentada, observacaoMovimento, status, dataHoraMovimento FROM movimentacaoestoque";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MovimentacaoEstoque> movimentacoes = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int itemVendaId = rs.getInt("itemvenda_id");
                int produtoId = rs.getInt("produto_id");
                int itemCompraId = rs.getInt("itemcompra_id");
                int funcionarioId = rs.getInt("funcionario_id");
                char flagTipoMovimento = rs.getString("flagTipoMovimento").charAt(0);
                double qtdMovimentada = rs.getDouble("qtdMovimentada");
                String observacaoMovimento = rs.getString("observacaoMovimento");
                char status = rs.getString("status").charAt(0);
                String dataHoraMovimento = rs.getString("dataHoraMovimento");

                Produto produto = new ProdutoDAO().retrieve(produtoId);
                ItemVenda itemVenda = new ItemVendaDAO().retrieve(itemVendaId);
                ItemCompra itemCompra = new ItemCompraDAO().retrieve(itemCompraId);
                Funcionario funcionario = new FuncionarioDAO().retrieve(funcionarioId);

                MovimentacaoEstoque movimentacao = new MovimentacaoEstoque(id, dataHoraMovimento, qtdMovimentada, observacaoMovimento, flagTipoMovimento, status, produto, itemVenda, itemCompra, funcionario);
                movimentacoes.add(movimentacao);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return movimentacoes;
    }

    @Override
    public MovimentacaoEstoque retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, itemvenda_id, produto_id, itemcompra_id, funcionario_id, flagTipoMovimento, qtdMovimentada, observacaoMovimento, status, dataHoraMovimento FROM movimentacaoestoque WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        MovimentacaoEstoque movimentacao = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int itemVendaId = rs.getInt("itemvenda_id");
                int produtoId = rs.getInt("produto_id");
                int itemCompraId = rs.getInt("itemcompra_id");
                int funcionarioId = rs.getInt("funcionario_id");
                char flagTipoMovimento = rs.getString("flagTipoMovimento").charAt(0);
                double qtdMovimentada = rs.getDouble("qtdMovimentada");
                String observacaoMovimento = rs.getString("observacaoMovimento");
                char status = rs.getString("status").charAt(0);
                String dataHoraMovimento = rs.getString("dataHoraMovimento");

                Produto produto = new ProdutoDAO().retrieve(produtoId);
                ItemVenda itemVenda = new ItemVendaDAO().retrieve(itemVendaId);
                ItemCompra itemCompra = new ItemCompraDAO().retrieve(itemCompraId);
                Funcionario funcionario = new FuncionarioDAO().retrieve(funcionarioId);

                movimentacao = new MovimentacaoEstoque(id, dataHoraMovimento, qtdMovimentada, observacaoMovimento, flagTipoMovimento, status, produto, itemVenda, itemCompra, funcionario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return movimentacao;
    }

    @Override
    public List<MovimentacaoEstoque> retrieve(MovimentacaoEstoque filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, itemvenda_id, produto_id, itemcompra_id, funcionario_id, flagTipoMovimento, qtdMovimentada, observacaoMovimento, status, dataHoraMovimento FROM movimentacaoestoque WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getItemVenda() != null && filtro.getItemVenda().getId() != 0) {
                sql += " AND itemvenda_id = ?";
                parametros.add(filtro.getItemVenda().getId());
            }

            if (filtro.getProduto() != null && filtro.getProduto().getId() != 0) {
                sql += " AND produto_id = ?";
                parametros.add(filtro.getProduto().getId());
            }

            if (filtro.getItemCompra() != null && filtro.getItemCompra().getId() != 0) {
                sql += " AND itemcompra_id = ?";
                parametros.add(filtro.getItemCompra().getId());
            }

            if (filtro.getFuncionario() != null && filtro.getFuncionario().getId() != 0) {
                sql += " AND funcionario_id = ?";
                parametros.add(filtro.getFuncionario().getId());
            }

            if (filtro.getFlagTipoMovimento() != '\0') {
                sql += " AND flagTipoMovimento = ?";
                parametros.add(filtro.getFlagTipoMovimento());
            }

            if (filtro.getQtdMovimentada() != 0.0) {
                sql += " AND qtdMovimentada = ?";
                parametros.add(filtro.getQtdMovimentada());
            }

            if (filtro.getObservacaoMovimento() != null && !filtro.getObservacaoMovimento().isEmpty()) {
                sql += " AND observacaoMovimento = ?";
                parametros.add(filtro.getObservacaoMovimento());
            }

            if (filtro.getStatus() != '\0') {
                sql += " AND status = ?";
                parametros.add(filtro.getStatus());
            }

            if (filtro.getDataHoraMovimento() != null) {
                sql += " AND dataHoraMovimento = ?";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                parametros.add(sdf.format(filtro.getDataHoraMovimento()));
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MovimentacaoEstoque> movimentacoes = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                if (parametro instanceof String) {
                    pstm.setString(i + 1, (String) parametro);
                } else if (parametro instanceof Integer) {
                    pstm.setInt(i + 1, (Integer) parametro);
                } else if (parametro instanceof Double) {
                    pstm.setDouble(i + 1, (Double) parametro);
                } else if (parametro instanceof Date) {
                    pstm.setString(i + 1, (String) parametro);
                } else if (parametro instanceof Character) {
                    pstm.setString(i + 1, String.valueOf(parametro));
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int itemVendaId = rs.getInt("itemvenda_id");
                int produtoId = rs.getInt("produto_id");
                int itemCompraId = rs.getInt("itemcompra_id");
                int funcionarioId = rs.getInt("funcionario_id");
                char flagTipoMovimento = rs.getString("flagTipoMovimento").charAt(0);
                double qtdMovimentada = rs.getDouble("qtdMovimentada");
                String observacaoMovimento = rs.getString("observacaoMovimento");
                char status = rs.getString("status").charAt(0);
                String dataHoraMovimento = rs.getString("dataHoraMovimento");

                Produto produto = new ProdutoDAO().retrieve(produtoId);
                ItemVenda itemVenda = new ItemVendaDAO().retrieve(itemVendaId);
                ItemCompra itemCompra = new ItemCompraDAO().retrieve(itemCompraId);
                Funcionario funcionario = new FuncionarioDAO().retrieve(funcionarioId);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHora = sdf.parse(dataHoraMovimento);

                MovimentacaoEstoque movimentacao = new MovimentacaoEstoque(id, dataHoraMovimento, qtdMovimentada, observacaoMovimento, flagTipoMovimento, status, produto, itemVenda, itemCompra, funcionario);
                movimentacoes.add(movimentacao);
            }
        } catch (SQLException | java.text.ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return movimentacoes;
    }

    @Override
    public void update(MovimentacaoEstoque movimentacao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE movimentacaoestoque SET itemvenda_id = ?, produto_id = ?, itemcompra_id = ?, funcionario_id = ?, flagTipoMovimento = ?, qtdMovimentada = ?, observacaoMovimento = ?, status = ?, dataHoraMovimento = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, movimentacao.getItemVenda().getId());
            pstm.setInt(2, movimentacao.getProduto().getId());
            pstm.setInt(3, movimentacao.getItemCompra().getId());
            pstm.setInt(4, movimentacao.getFuncionario().getId());
            pstm.setString(5, String.valueOf(movimentacao.getFlagTipoMovimento()));
            pstm.setDouble(6, movimentacao.getQtdMovimentada());
            pstm.setString(7, movimentacao.getObservacaoMovimento());
            pstm.setString(8, String.valueOf(movimentacao.getStatus()));
            pstm.setString(9, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(movimentacao.getDataHoraMovimento()));
            pstm.setInt(10, movimentacao.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(MovimentacaoEstoque movimentacao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM movimentacaoestoque WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, movimentacao.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

}
