package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Carteirinha;
import model.bo.Cliente;

public class CarteirinhaDAO implements InterfaceDAO<Carteirinha> {

    @Override
    public void create(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO carteirinha (cliente_id, codigoBarra, dataGeracao, dataCancelamento) VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objeto.getCliente().getId());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getDataGeracao());
            pstm.setString(4, objeto.getDataCancelamento());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Carteirinha> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, cliente_id, codigoBarra, dataGeracao, dataCancelamento FROM carteirinha";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Carteirinha> carteirinhas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                String codigoBarra = rs.getString("codigoBarra");
                String dataGeracao = rs.getString("dataGeracao");
                String dataCancelamento = rs.getString("dataCancelamento");

                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.retrieve(clienteId);

                Carteirinha carteirinha = new Carteirinha(id, codigoBarra, dataGeracao, dataCancelamento, cliente);
                carteirinhas.add(carteirinha);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return carteirinhas;
    }

    @Override
    public Carteirinha retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT cliente_id, codigoBarra, dataGeracao, dataCancelamento FROM carteirinha WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Carteirinha carteirinha = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int clienteId = rs.getInt("cliente_id");
                String codigoBarra = rs.getString("codigoBarra");
                String dataGeracao = rs.getString("dataGeracao");
                String dataCancelamento = rs.getString("dataCancelamento");

                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.retrieve(clienteId);

                carteirinha = new Carteirinha(id, codigoBarra, dataGeracao, dataCancelamento, cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return carteirinha;
    }

    @Override
    public List<Carteirinha> retrieve(Carteirinha filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder("SELECT c.id, c.cliente_id, c.codigoBarra, c.dataGeracao, c.dataCancelamento"
                + " FROM carteirinha c"
                + " INNER JOIN cliente cl ON c.cliente_id = cl.id"
                + " WHERE 1=1");

        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getCliente() != null) {
                sql.append(" AND c.cliente_id = ?");
                parametros.add(filtro.getCliente().getId());
            }

            if (filtro.getCodigoBarra() != null && !filtro.getCodigoBarra().isEmpty()) {
                sql.append(" AND c.codigoBarra = ?");
                parametros.add(filtro.getCodigoBarra());
            }

            if (filtro.getDataGeracao() != null && !filtro.getDataGeracao().isEmpty()) {
                sql.append(" AND c.dataGeracao = ?");
                parametros.add(filtro.getDataGeracao());
            }

            if (filtro.getDataCancelamento() != null && !filtro.getDataCancelamento().isEmpty()) {
                sql.append(" AND c.dataCancelamento = ?");
                parametros.add(filtro.getDataCancelamento());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Carteirinha> carteirinhas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                pstm.setString(i + 1, parametro.toString());
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                String codigoBarra = rs.getString("codigoBarra");
                String dataGeracao = rs.getString("dataGeracao");
                String dataCancelamento = rs.getString("dataCancelamento");

                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.retrieve(clienteId);

                Carteirinha carteirinha = new Carteirinha(id, codigoBarra, dataGeracao, dataCancelamento, cliente);
                carteirinhas.add(carteirinha);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return carteirinhas;
    }

    @Override
    public void update(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE carteirinha SET cliente_id = ?, codigoBarra = ?, dataGeracao = ?, dataCancelamento = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objeto.getCliente().getId());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getDataGeracao());
            pstm.setString(4, objeto.getDataCancelamento());
            pstm.setInt(5, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM carteirinha WHERE id = ?";

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
