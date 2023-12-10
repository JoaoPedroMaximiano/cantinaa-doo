package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.bo.Compra;
import model.bo.Contas;
import model.bo.Venda;

public class ContasDAO {

    public void create(Contas conta) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "INSERT INTO contas (venda_id, compra_id, valorEmitido, valorDesconto, valorCrescimo, valorQuitado, observacao, flagTipoConta, status, dataHoraEmissao, dataVencimento, dataQuitacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sql);

            if (conta.getVenda() != null) {
                pstm.setInt(1, conta.getVenda().getId());
            } else {
                pstm.setNull(1, java.sql.Types.INTEGER);
            }

            if (conta.getCompra() != null) {
                pstm.setInt(2, conta.getCompra().getId());
            } else {
                pstm.setNull(2, java.sql.Types.INTEGER);
            }
            pstm.setDouble(3, conta.getValorEmitido());
            pstm.setDouble(4, conta.getValorDesconto());
            pstm.setDouble(5, conta.getValorCrescimo());
            pstm.setDouble(6, conta.getValorQuitado());
            pstm.setString(7, conta.getObservacao());
            pstm.setString(8, String.valueOf(conta.getFlagTipoConta()));
            pstm.setString(9, String.valueOf(conta.getStatus()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            pstm.setString(10, sdf.format(conta.getDataHoraEmissora()));
            pstm.setString(11, sdf.format(conta.getDataVencimento()));
            pstm.setString(12, sdf.format(conta.getDataQuitacao()));

            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    public List<Contas> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, venda_id, compra_id, valorEmitido, valorDesconto, valorCrescimo, valorQuitado, observacao, flagTipoConta, status, dataHoraEmissao, dataVencimento, dataQuitacao FROM contas";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Contas> contas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int vendaId = rs.getInt("venda_id");
                int compraId = rs.getInt("compra_id");
                double valorEmitido = rs.getDouble("valorEmitido");
                double valorDesconto = rs.getDouble("valorDesconto");
                double valorCrescimo = rs.getDouble("valorCrescimo");
                double valorQuitado = rs.getDouble("valorQuitado");
                String observacao = rs.getString("observacao");
                char flagTipoConta = rs.getString("flagTipoConta").charAt(0);
                char status = rs.getString("status").charAt(0);
                String dataHoraEmissaoStr = rs.getString("dataHoraEmissao");
                String dataVencimentoStr = rs.getString("dataVencimento");
                String dataQuitacaoStr = rs.getString("dataQuitacao");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHoraEmissao = sdf.parse(dataHoraEmissaoStr);
                java.util.Date dataVencimento = sdf.parse(dataVencimentoStr);
                java.util.Date dataQuitacao = sdf.parse(dataQuitacaoStr);

                Venda venda = new VendaDAO().retrieve(vendaId);
                Compra compra = new CompraDAO().retrieve(compraId);

                Contas conta = new Contas(id, dataHoraEmissao, dataVencimento, dataQuitacao, valorEmitido, valorDesconto, valorCrescimo, valorQuitado, observacao, flagTipoConta, status, venda, compra);
                contas.add(conta);
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return contas;
    }

    public Contas retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT venda_id, compra_id, valorEmitido, valorDesconto, valorCrescimo, valorQuitado, observacao, flagTipoConta, status, dataHoraEmissao, dataVencimento, dataQuitacao FROM contas WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int vendaId = rs.getInt("venda_id");
                int compraId = rs.getInt("compra_id");
                double valorEmitido = rs.getDouble("valorEmitido");
                double valorDesconto = rs.getDouble("valorDesconto");
                double valorCrescimo = rs.getDouble("valorCrescimo");
                double valorQuitado = rs.getDouble("valorQuitado");
                String observacao = rs.getString("observacao");
                char flagTipoConta = rs.getString("flagTipoConta").charAt(0);
                char status = rs.getString("status").charAt(0);
                String dataHoraEmissaoStr = rs.getString("dataHoraEmissao");
                String dataVencimentoStr = rs.getString("dataVencimento");
                String dataQuitacaoStr = rs.getString("dataQuitacao");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHoraEmissao = sdf.parse(dataHoraEmissaoStr);
                java.util.Date dataVencimento = sdf.parse(dataVencimentoStr);
                java.util.Date dataQuitacao = sdf.parse(dataQuitacaoStr);

                Venda venda = new VendaDAO().retrieve(vendaId);
                Compra compra = new CompraDAO().retrieve(compraId);

                return new Contas(id, dataHoraEmissao, dataVencimento, dataQuitacao, valorEmitido, valorDesconto, valorCrescimo, valorQuitado, observacao, flagTipoConta, status, venda, compra);
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return null;
    }

    public List<Contas> retrieve(Contas filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM contas WHERE 1=1";
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

            if (filtro.getCompra() != null && filtro.getCompra().getId() != 0) {
                sql += " AND compra_id = ?";
                parametros.add(filtro.getCompra().getId());
            }

            if (filtro.getValorEmitido() != 0.0) {
                sql += " AND valorEmitido = ?";
                parametros.add(filtro.getValorEmitido());
            }

            if (filtro.getValorDesconto() != 0.0) {
                sql += " AND valorDesconto = ?";
                parametros.add(filtro.getValorDesconto());
            }

            if (filtro.getValorCrescimo() != 0.0) {
                sql += " AND valorCrescimo = ?";
                parametros.add(filtro.getValorCrescimo());
            }

            if (filtro.getValorQuitado() != 0.0) {
                sql += " AND valorQuitado = ?";
                parametros.add(filtro.getValorQuitado());
            }

            if (filtro.getObservacao() != null && !filtro.getObservacao().isEmpty()) {
                sql += " AND observacao LIKE ?";
                parametros.add("%" + filtro.getObservacao() + "%");
            }

            if (filtro.getFlagTipoConta() != '\0') {
                sql += " AND flagTipoConta = ?";
                parametros.add(filtro.getFlagTipoConta());
            }

            if (filtro.getStatus() != '\0') {
                sql += " AND status = ?";
                parametros.add(filtro.getStatus());
            }

            if (filtro.getDataHoraEmissora() != null) {
                sql += " AND dataHoraEmissao = ?";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                parametros.add(sdf.format(filtro.getDataHoraEmissora()));
            }

            if (filtro.getDataVencimento() != null) {
                sql += " AND dataVencimento = ?";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                parametros.add(sdf.format(filtro.getDataVencimento()));
            }

            if (filtro.getDataQuitacao() != null) {
                sql += " AND dataQuitacao = ?";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                parametros.add(sdf.format(filtro.getDataQuitacao()));
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Contas> contas = new ArrayList<>();

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
                int compraId = rs.getInt("compra_id");
                double valorEmitido = rs.getDouble("valorEmitido");
                double valorDesconto = rs.getDouble("valorDesconto");
                double valorCrescimo = rs.getDouble("valorCrescimo");
                double valorQuitado = rs.getDouble("valorQuitado");
                String observacao = rs.getString("observacao");
                char flagTipoConta = rs.getString("flagTipoConta").charAt(0);
                char status = rs.getString("status").charAt(0);
                String dataHoraEmissaoStr = rs.getString("dataHoraEmissao");
                String dataVencimentoStr = rs.getString("dataVencimento");
                String dataQuitacaoStr = rs.getString("dataQuitacao");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHoraEmissao = sdf.parse(dataHoraEmissaoStr);
                java.util.Date dataVencimento = sdf.parse(dataVencimentoStr);
                java.util.Date dataQuitacao = sdf.parse(dataQuitacaoStr);

                Venda venda = new VendaDAO().retrieve(vendaId);
                Compra compra = new CompraDAO().retrieve(compraId);

                Contas conta = new Contas(id, dataHoraEmissao, dataVencimento, dataQuitacao, valorEmitido, valorDesconto, valorCrescimo, valorQuitado, observacao, flagTipoConta, status, venda, compra);
                contas.add(conta);
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return contas;
    }

    public void update(Contas conta) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "UPDATE contas SET venda_id = ?, compra_id = ?, valorEmitido = ?, valorDesconto = ?, valorCrescimo = ?, valorQuitado = ?, observacao = ?, flagTipoConta = ?, status = ?, dataHoraEmissao = ?, dataVencimento = ?, dataQuitacao = ? WHERE id = ?";
            pstm = conexao.prepareStatement(sql);

            pstm.setInt(1, conta.getVenda().getId());
            pstm.setInt(2, conta.getCompra().getId());
            pstm.setDouble(3, conta.getValorEmitido());
            pstm.setDouble(4, conta.getValorDesconto());
            pstm.setDouble(5, conta.getValorCrescimo());
            pstm.setDouble(6, conta.getValorQuitado());
            pstm.setString(7, conta.getObservacao());
            pstm.setString(8, String.valueOf(conta.getFlagTipoConta()));
            pstm.setString(9, String.valueOf(conta.getStatus()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            pstm.setString(10, sdf.format(conta.getDataHoraEmissora()));
            pstm.setString(11, sdf.format(conta.getDataVencimento()));
            pstm.setString(12, sdf.format(conta.getDataQuitacao()));
            pstm.setInt(13, conta.getId());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    public void delete(Contas conta) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "DELETE FROM contas WHERE id = ?";
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, conta.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

}
