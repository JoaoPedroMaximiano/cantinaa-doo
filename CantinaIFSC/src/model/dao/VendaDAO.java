package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.bo.Carteirinha;
import model.bo.Funcionario;
import model.bo.Venda;

public class VendaDAO implements InterfaceDAO<Venda> {

    @Override
    public void create(Venda venda) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO venda (carteirinha_id, funcionario_id, valorDesconto, flagTipoDesconto, observacao, status, dataHoraVenda) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, venda.getCarteirinha().getId());
            pstm.setInt(2, venda.getFuncionario().getId());
            pstm.setDouble(3, venda.getValorDesconto());
            pstm.setString(4, String.valueOf(venda.getFlagTipoDesconto()));
            pstm.setString(5, venda.getObservacao());
            pstm.setString(6, String.valueOf(venda.getStatus()));
            pstm.setTimestamp(7, new java.sql.Timestamp(venda.getDataHoraVenda().getTime()));
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Venda> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, carteirinha_id, funcionario_id, valorDesconto, flagTipoDesconto, observacao, status, dataHoraVenda FROM venda";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int carteirinhaId = rs.getInt("carteirinha_id");
                int funcionarioId = rs.getInt("funcionario_id");
                double valorDesconto = rs.getDouble("valorDesconto");
                char flagTipoDesconto = rs.getString("flagTipoDesconto").charAt(0);
                String observacao = rs.getString("observacao");
                char status = rs.getString("status").charAt(0);
                Date dataHoraVenda = rs.getTimestamp("dataHoraVenda");

                Carteirinha carteirinha = new CarteirinhaDAO().retrieve(carteirinhaId);
                Funcionario funcionario = new FuncionarioDAO().retrieve(funcionarioId);

                Venda venda = new Venda(id, dataHoraVenda, valorDesconto, observacao, flagTipoDesconto, status, carteirinha, funcionario);
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return vendas;
    }

    @Override
    public Venda retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT carteirinha_id, funcionario_id, valorDesconto, flagTipoDesconto, observacao, status, dataHoraVenda FROM venda WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Venda venda = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int carteirinhaId = rs.getInt("carteirinha_id");
                int funcionarioId = rs.getInt("funcionario_id");
                double valorDesconto = rs.getDouble("valorDesconto");
                char flagTipoDesconto = rs.getString("flagTipoDesconto").charAt(0);
                String observacao = rs.getString("observacao");
                char status = rs.getString("status").charAt(0);
                Date dataHoraVenda = rs.getTimestamp("dataHoraVenda");

                Carteirinha carteirinha = new CarteirinhaDAO().retrieve(carteirinhaId);
                Funcionario funcionario = new FuncionarioDAO().retrieve(funcionarioId);

                venda = new Venda(id, dataHoraVenda, valorDesconto, observacao, flagTipoDesconto, status, carteirinha, funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return venda;
    }

        @Override
    public List<Venda> retrieve(Venda filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, carteirinha_id, funcionario_id, valorDesconto, flagTipoDesconto, observacao, status, dataHoraVenda FROM venda WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getCarteirinha() != null && filtro.getCarteirinha().getId() != 0) {
                sql += " AND carteirinha_id = ?";
                parametros.add(filtro.getCarteirinha().getId());
            }

            if (filtro.getFuncionario() != null && filtro.getFuncionario().getId() != 0) {
                sql += " AND funcionario_id = ?";
                parametros.add(filtro.getFuncionario().getId());
            }

            if (filtro.getValorDesconto() != 0) {
                sql += " AND valorDesconto = ?";
                parametros.add(filtro.getValorDesconto());
            }

            if (filtro.getFlagTipoDesconto() != '\u0000') {
                sql += " AND flagTipoDesconto = ?";
                parametros.add(String.valueOf(filtro.getFlagTipoDesconto()));
            }

            if (filtro.getStatus() != '\u0000') {
                sql += " AND status = ?";
                parametros.add(String.valueOf(filtro.getStatus()));
            }

            if (filtro.getDataHoraVenda() != null) {
                sql += " AND dataHoraVenda = ?";
                parametros.add(new java.sql.Timestamp(filtro.getDataHoraVenda().getTime()));
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();

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
                } else if (parametro instanceof java.sql.Timestamp) {
                    pstm.setTimestamp(i + 1, (java.sql.Timestamp) parametro);
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int carteirinhaId = rs.getInt("carteirinha_id");
                int funcionarioId = rs.getInt("funcionario_id");
                double valorDesconto = rs.getDouble("valorDesconto");
                char flagTipoDesconto = rs.getString("flagTipoDesconto").charAt(0);
                String observacao = rs.getString("observacao");
                char status = rs.getString("status").charAt(0);
                Date dataHoraVenda = rs.getTimestamp("dataHoraVenda");

                Carteirinha carteirinha = new CarteirinhaDAO().retrieve(carteirinhaId);
                Funcionario funcionario = new FuncionarioDAO().retrieve(funcionarioId);

                Venda venda = new Venda(id, dataHoraVenda, valorDesconto, observacao, flagTipoDesconto, status, carteirinha, funcionario);
                vendas.add(venda);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return vendas;
    }

    @Override
    public void update(Venda venda) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE venda SET carteirinha_id = ?, funcionario_id = ?, valorDesconto = ?, flagTipoDesconto = ?, observacao = ?, status = ?, dataHoraVenda = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, venda.getCarteirinha().getId());
            pstm.setInt(2, venda.getFuncionario().getId());
            pstm.setDouble(3, venda.getValorDesconto());
            pstm.setString(4, String.valueOf(venda.getFlagTipoDesconto()));
            pstm.setString(5, venda.getObservacao());
            pstm.setString(6, String.valueOf(venda.getStatus()));
            pstm.setTimestamp(7, new java.sql.Timestamp(venda.getDataHoraVenda().getTime()));
            pstm.setInt(8, venda.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Venda venda) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM venda WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, venda.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }
}
