package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Caixa;
import model.bo.Funcionario;

public class CaixaDAO implements InterfaceDAO<Caixa> {

    @Override
    public void create(Caixa caixa) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO caixa (funcionario_id, valorAberto, valorFechamento, observacao, status, dataHoraAbertura, dataHoraFechamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, caixa.getFuncionario().getId());
            pstm.setDouble(2, caixa.getValorAbertura());
            pstm.setDouble(3, caixa.getValorFechamento());
            pstm.setString(4, caixa.getObservacao());
            pstm.setString(5, String.valueOf(caixa.getStatus()));
            pstm.setString(6, caixa.getDataHoraAberto());
            pstm.setString(7, caixa.getDataHoraFechamento());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Caixa> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, funcionario_id, valorAberto, valorFechamento, observacao, status, dataHoraAbertura, dataHoraFechamento FROM caixa";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Caixa> caixas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int funcionarioId = rs.getInt("funcionario_id");
                double valorAbertura = rs.getDouble("valorAberto");
                double valorFechamento = rs.getDouble("valorFechamento");
                String observacao = rs.getString("observacao");
                char status = rs.getString("status").charAt(0);
                String dataHoraAbertura = rs.getString("dataHoraAbertura");
                String dataHoraFechamento = rs.getString("dataHoraFechamento");

                Funcionario funcionario = new FuncionarioDAO().retrive(funcionarioId);

                Caixa caixa = new Caixa(id, dataHoraAbertura, dataHoraFechamento, valorAbertura, valorFechamento, observacao, status, funcionario);
                caixas.add(caixa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return caixas;
    }

    @Override
    public Caixa retrive(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT funcionario_id, valorAberto, valorFechamento, observacao, status, dataHoraAbertura, dataHoraFechamento FROM caixa WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Caixa caixa = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int funcionarioId = rs.getInt("funcionario_id");
                double valorAbertura = rs.getDouble("valorAberto");
                double valorFechamento = rs.getDouble("valorFechamento");
                String observacao = rs.getString("observacao");
                char status = rs.getString("status").charAt(0);
                String dataHoraAbertura = rs.getString("dataHoraAbertura");
                String dataHoraFechamento = rs.getString("dataHoraFechamento");

                Funcionario funcionario = new FuncionarioDAO().retrive(funcionarioId);

                caixa = new Caixa(id, dataHoraAbertura, dataHoraFechamento, valorAbertura, valorFechamento, observacao, status, funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return caixa;
    }
    
    @Override
    public List<Caixa> retrive(Caixa filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, funcionario_id, valorAberto, valorFechamento, observacao, status, dataHoraAbertura, dataHoraFechamento FROM caixa WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getFuncionario() != null && filtro.getFuncionario().getId() != 0) {
                sql += " AND funcionario_id = ?";
                parametros.add(filtro.getFuncionario().getId());
            }

            if (filtro.getValorAbertura() != 0.0) {
                sql += " AND valorAberto = ?";
                parametros.add(filtro.getValorAbertura());
            }

            if (filtro.getValorFechamento() != 0.0) {
                sql += " AND valorFechamento = ?";
                parametros.add(filtro.getValorFechamento());
            }

            if (filtro.getObservacao() != null && !filtro.getObservacao().isEmpty()) {
                sql += " AND observacao = ?";
                parametros.add(filtro.getObservacao());
            }

            if (filtro.getStatus() != 0) {
                sql += " AND status = ?";
                parametros.add(String.valueOf(filtro.getStatus()));
            }

            if (filtro.getDataHoraAberto() != null && !filtro.getDataHoraAberto().isEmpty()) {
                sql += " AND dataHoraAbertura = ?";
                parametros.add(filtro.getDataHoraAberto());
            }

            if (filtro.getDataHoraFechamento() != null && !filtro.getDataHoraFechamento().isEmpty()) {
                sql += " AND dataHoraFechamento = ?";
                parametros.add(filtro.getDataHoraFechamento());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Caixa> caixas = new ArrayList<>();

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
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int funcionarioId = rs.getInt("funcionario_id");
                double valorAbertura = rs.getDouble("valorAberto");
                double valorFechamento = rs.getDouble("valorFechamento");
                String observacao = rs.getString("observacao");
                char status = rs.getString("status").charAt(0);
                String dataHoraAbertura = rs.getString("dataHoraAbertura");
                String dataHoraFechamento = rs.getString("dataHoraFechamento");

                Funcionario funcionario = new FuncionarioDAO().retrive(funcionarioId);

                Caixa caixa = new Caixa(id, dataHoraAbertura, dataHoraFechamento, valorAbertura, valorFechamento, observacao, status, funcionario);
                caixas.add(caixa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return caixas;
    }


    @Override
    public void update(Caixa caixa) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE caixa SET funcionario_id = ?, valorAberto = ?, valorFechamento = ?, observacao = ?, status = ?, dataHoraAbertura = ?, dataHoraFechamento = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, caixa.getFuncionario().getId());
            pstm.setDouble(2, caixa.getValorAbertura());
            pstm.setDouble(3, caixa.getValorFechamento());
            pstm.setString(4, caixa.getObservacao());
            pstm.setString(5, String.valueOf(caixa.getStatus()));
            pstm.setString(6, caixa.getDataHoraAberto());
            pstm.setString(7, caixa.getDataHoraFechamento());
            pstm.setInt(8, caixa.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Caixa caixa) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM caixa WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, caixa.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

}
