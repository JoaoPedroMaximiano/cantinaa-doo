package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.bo.Caixa;
import model.bo.Contas;
import model.bo.MovimentoCaixa;

public class MovimentoCaixaDAO {

    public void create(MovimentoCaixa movimentoCaixa) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "INSERT INTO movimentocaixa (caixa_id, contas_id, valorMovimento, observacao, flagTipoMovimento, status, dataHoraMovimento) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sql);

            pstm.setInt(1, movimentoCaixa.getCaixa().getId());
            pstm.setInt(2, movimentoCaixa.getContas().getId());
            pstm.setDouble(3, movimentoCaixa.getValorMovimento());
            pstm.setString(4, movimentoCaixa.getObservacao());
            pstm.setString(5, String.valueOf(movimentoCaixa.getFlagTipoMovimento()));
            pstm.setString(6, String.valueOf(movimentoCaixa.getStatus()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            pstm.setString(7, sdf.format(movimentoCaixa.getDataHoraMovimento()));

            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    public List<MovimentoCaixa> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, caixa_id, contas_id, valorMovimento, observacao, flagTipoMovimento, status, dataHoraMovimento FROM movimentocaixa";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MovimentoCaixa> movimentoCaixas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int caixaId = rs.getInt("caixa_id");
                int contasId = rs.getInt("contas_id");
                double valorMovimento = rs.getDouble("valorMovimento");
                String observacao = rs.getString("observacao");
                char flagTipoMovimento = rs.getString("flagTipoMovimento").charAt(0);
                char status = rs.getString("status").charAt(0);
                String dataHoraMovimentoStr = rs.getString("dataHoraMovimento");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHoraMovimento = sdf.parse(dataHoraMovimentoStr);

                Caixa caixa = new CaixaDAO().retrieve(caixaId);
                Contas contas = new ContasDAO().retrieve(contasId);

                MovimentoCaixa movimentoCaixa = new MovimentoCaixa(id, dataHoraMovimento, valorMovimento, observacao, flagTipoMovimento, status, caixa, contas);
                movimentoCaixas.add(movimentoCaixa);
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return movimentoCaixas;
    }

    public void update(MovimentoCaixa movimentoCaixa) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "UPDATE movimentocaixa SET caixa_id = ?, contas_id = ?, valorMovimento = ?, observacao = ?, flagTipoMovimento = ?, status = ?, dataHoraMovimento = ? WHERE id = ?";
            pstm = conexao.prepareStatement(sql);

            pstm.setInt(1, movimentoCaixa.getCaixa().getId());
            pstm.setInt(2, movimentoCaixa.getContas().getId());
            pstm.setDouble(3, movimentoCaixa.getValorMovimento());
            pstm.setString(4, movimentoCaixa.getObservacao());
            pstm.setString(5, String.valueOf(movimentoCaixa.getFlagTipoMovimento()));
            pstm.setString(6, String.valueOf(movimentoCaixa.getStatus()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            pstm.setString(7, sdf.format(movimentoCaixa.getDataHoraMovimento()));
            pstm.setInt(8, movimentoCaixa.getId());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    public void delete(MovimentoCaixa movimentoCaixa) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "DELETE FROM movimentocaixa WHERE id = ?";
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, movimentoCaixa.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    public List<MovimentoCaixa> retrieve(MovimentoCaixa filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM movimentocaixa WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getCaixa() != null && filtro.getCaixa().getId() != 0) {
                sql += " AND caixa_id = ?";
                parametros.add(filtro.getCaixa().getId());
            }

            if (filtro.getContas() != null && filtro.getContas().getId() != 0) {
                sql += " AND contas_id = ?";
                parametros.add(filtro.getContas().getId());
            }

            if (filtro.getValorMovimento() != 0.0) {
                sql += " AND valorMovimento = ?";
                parametros.add(filtro.getValorMovimento());
            }

            if (filtro.getObservacao() != null && !filtro.getObservacao().isEmpty()) {
                sql += " AND observacao LIKE ?";
                parametros.add("%" + filtro.getObservacao() + "%");
            }

            if (filtro.getFlagTipoMovimento() != '\0') {
                sql += " AND flagTipoMovimento = ?";
                parametros.add(filtro.getFlagTipoMovimento());
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
        List<MovimentoCaixa> movimentoCaixas = new ArrayList<>();

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
                int caixaId = rs.getInt("caixa_id");
                int contasId = rs.getInt("contas_id");
                double valorMovimento = rs.getDouble("valorMovimento");
                String observacao = rs.getString("observacao");
                char flagTipoMovimento = rs.getString("flagTipoMovimento").charAt(0);
                char status = rs.getString("status").charAt(0);
                String dataHoraMovimentoStr = rs.getString("dataHoraMovimento");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHoraMovimento = sdf.parse(dataHoraMovimentoStr);

                Caixa caixa = new CaixaDAO().retrieve(caixaId);
                Contas contas = new ContasDAO().retrieve(contasId);

                MovimentoCaixa movimentoCaixa = new MovimentoCaixa(id, dataHoraMovimento, valorMovimento, observacao, flagTipoMovimento, status, caixa, contas);
                movimentoCaixas.add(movimentoCaixa);
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return movimentoCaixas;
    }

}
