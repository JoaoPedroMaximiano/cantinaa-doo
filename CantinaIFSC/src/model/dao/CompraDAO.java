package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.bo.Compra;
import model.bo.Fornecedor;

public class CompraDAO implements InterfaceDAO<Compra> {

    @Override
    public void create(Compra compra) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO compra (fornecedor_id, numeroNf, valorDesconto, flagTipoDesconto, status, observacao, dataHoraCompra) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, compra.getFornecedor().getId());
            pstm.setInt(2, compra.getNumeroNf());
            pstm.setDouble(3, compra.getValorDesconto());
            pstm.setString(4, String.valueOf(compra.getFlagTipoDesconto()));
            pstm.setString(5, String.valueOf(compra.getStatus()));
            pstm.setString(6, compra.getObservacao());
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataHoraCompra = sdf.format(compra.getDataHoraCompra());
            pstm.setString(7, dataHoraCompra);
            
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Compra> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, fornecedor_id, numeroNf, valorDesconto, flagTipoDesconto, status, observacao, dataHoraCompra FROM compra";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int fornecedorId = rs.getInt("fornecedor_id");
                int numeroNf = rs.getInt("numeroNf");
                double valorDesconto = rs.getDouble("valorDesconto");
                char flagTipoDesconto = rs.getString("flagTipoDesconto").charAt(0);
                char status = rs.getString("status").charAt(0);
                String observacao = rs.getString("observacao");
                String dataHoraCompra = rs.getString("dataHoraCompra");

                Fornecedor fornecedor = new FornecedorDAO().retrieve(fornecedorId);
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHora = sdf.parse(dataHoraCompra);

                Compra compra = new Compra(id, numeroNf, dataHora, valorDesconto, observacao, flagTipoDesconto, status, fornecedor);
                compras.add(compra);
            }
        } catch (SQLException | java.text.ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return compras;
    }

    @Override
    public Compra retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT fornecedor_id, numeroNf, valorDesconto, flagTipoDesconto, status, observacao, dataHoraCompra FROM compra WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Compra compra = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int fornecedorId = rs.getInt("fornecedor_id");
                int numeroNf = rs.getInt("numeroNf");
                double valorDesconto = rs.getDouble("valorDesconto");
                char flagTipoDesconto = rs.getString("flagTipoDesconto").charAt(0);
                char status = rs.getString("status").charAt(0);
                String observacao = rs.getString("observacao");
                String dataHoraCompra = rs.getString("dataHoraCompra");

                Fornecedor fornecedor = new FornecedorDAO().retrieve(fornecedorId);
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHora = sdf.parse(dataHoraCompra);

                compra = new Compra(id, numeroNf, dataHora, valorDesconto, observacao, flagTipoDesconto, status, fornecedor);
            }
        } catch (SQLException | java.text.ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return compra;
    }

    @Override
    public List<Compra> retrieve(Compra filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, fornecedor_id, numeroNf, valorDesconto, flagTipoDesconto, status, observacao, dataHoraCompra FROM compra WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getFornecedor() != null && filtro.getFornecedor().getId() != 0) {
                sql += " AND fornecedor_id = ?";
                parametros.add(filtro.getFornecedor().getId());
            }

            if (filtro.getNumeroNf() != 0) {
                sql += " AND numeroNf = ?";
                parametros.add(filtro.getNumeroNf());
            }

            if (filtro.getValorDesconto() != 0.0) {
                sql += " AND valorDesconto = ?";
                parametros.add(filtro.getValorDesconto());
            }

            if (filtro.getFlagTipoDesconto() != 0) {
                sql += " AND flagTipoDesconto = ?";
                parametros.add(String.valueOf(filtro.getFlagTipoDesconto()));
            }

            if (filtro.getStatus() != 0) {
                sql += " AND status = ?";
                parametros.add(String.valueOf(filtro.getStatus()));
            }

            if (filtro.getDataHoraCompra() != null) {
                sql += " AND dataHoraCompra = ?";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                parametros.add(sdf.format(filtro.getDataHoraCompra()));
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();

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
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int fornecedorId = rs.getInt("fornecedor_id");
                int numeroNf = rs.getInt("numeroNf");
                double valorDesconto = rs.getDouble("valorDesconto");
                char flagTipoDesconto = rs.getString("flagTipoDesconto").charAt(0);
                char status = rs.getString("status").charAt(0);
                String observacao = rs.getString("observacao");
                String dataHoraCompra = rs.getString("dataHoraCompra");

                Fornecedor fornecedor = new FornecedorDAO().retrieve(fornecedorId);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date dataHora = sdf.parse(dataHoraCompra);

                Compra compra = new Compra(id, numeroNf, dataHora, valorDesconto, observacao, flagTipoDesconto, status, fornecedor);
                compras.add(compra);
            }
        } catch (SQLException | java.text.ParseException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return compras;
    }
    
    @Override
    public void update(Compra compra) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE compra SET fornecedor_id = ?, numeroNf = ?, valorDesconto = ?, flagTipoDesconto = ?, status = ?, observacao = ?, dataHoraCompra = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, compra.getFornecedor().getId());
            pstm.setInt(2, compra.getNumeroNf());
            pstm.setDouble(3, compra.getValorDesconto());
            pstm.setString(4, String.valueOf(compra.getFlagTipoDesconto()));
            pstm.setString(5, String.valueOf(compra.getStatus()));
            pstm.setString(6, compra.getObservacao());
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataHoraCompra = sdf.format(compra.getDataHoraCompra());
            pstm.setString(7, dataHoraCompra);
            
            pstm.setInt(8, compra.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Compra compra) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM compra WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, compra.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }
}
