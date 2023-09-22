package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Cliente;
import model.bo.Endereco;

public class ClienteDAO implements InterfaceDAO<Cliente> {

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cliente (endereco_id, nome, email, fone1, fone2, status, complementoEndereco, cpf, rg, matricula, dataNascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objeto.getEndereco().getId());
            pstm.setString(2, objeto.getNome());
            pstm.setString(3, objeto.getEmail());
            pstm.setString(4, objeto.getFone1());
            pstm.setString(5, objeto.getFone2());
            pstm.setString(6, String.valueOf(objeto.getStatus()));
            pstm.setString(7, objeto.getComplementoEndereco());
            pstm.setString(8, objeto.getCpf());
            pstm.setString(9, objeto.getRg());
            pstm.setString(10, objeto.getMatricula());
            pstm.setString(11, objeto.getDataNascimento());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Cliente> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT c.cpf, c.rg, c.matricula, c.dataNascimento, c.id, c.nome, c.fone1, c.fone2, c.email, c.complementoEndereco, c.status, e.id AS endereco_id"
                + " FROM cliente c"
                + " INNER JOIN endereco e ON c.endereco_id = e.id";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String fone1 = rs.getString("fone1");
                String fone2 = rs.getString("fone2");
                String email = rs.getString("email");
                String complementoEndereco = rs.getString("complementoEndereco");
                char status = rs.getString("status").charAt(0);
                int enderecoId = rs.getInt("endereco_id");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String matricula = rs.getString("matricula");
                String dataNascimento = rs.getString("dataNascimento");

                EnderecoDAO enderecoDAO = new EnderecoDAO();
                Endereco endereco = enderecoDAO.retrive(enderecoId);

                Cliente cliente = new Cliente(cpf, rg, matricula, dataNascimento, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return clientes;
    }

    @Override
    public Cliente retrive(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT c.cpf, c.rg, c.matricula, c.dataNascimento, c.nome, c.fone1, c.fone2, c.email, c.complementoEndereco, c.status, e.id AS endereco_id"
                + " FROM cliente c"
                + " INNER JOIN endereco e ON c.endereco_id = e.id"
                + " WHERE c.id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String fone1 = rs.getString("fone1");
                String fone2 = rs.getString("fone2");
                String email = rs.getString("email");
                String complementoEndereco = rs.getString("complementoEndereco");
                char status = rs.getString("status").charAt(0);
                int enderecoId = rs.getInt("endereco_id");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String matricula = rs.getString("matricula");
                String dataNascimento = rs.getString("dataNascimento");

                EnderecoDAO enderecoDAO = new EnderecoDAO();
                Endereco endereco = enderecoDAO.retrive(enderecoId);

                cliente = new Cliente(cpf, rg, matricula, dataNascimento, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return cliente;
    }

    @Override
    public List<Cliente> retrive(Cliente filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder("SELECT c.cpf, c.rg, c.matricula, c.dataNascimento, c.id, c.nome, c.fone1, c.fone2, c.email, c.complementoEndereco, c.status, e.id AS endereco_id"
                + " FROM cliente c"
                + " INNER JOIN endereco e ON c.endereco_id = e.id"
                + " WHERE 1=1");

        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getCpf() != null && !filtro.getCpf().isEmpty()) {
                sql.append(" AND c.cpf = ?");
                parametros.add(filtro.getCpf());
            }

            if (filtro.getRg() != null && !filtro.getRg().isEmpty()) {
                sql.append(" AND c.rg = ?");
                parametros.add(filtro.getRg());
            }

            if (filtro.getMatricula() != null && !filtro.getMatricula().isEmpty()) {
                sql.append(" AND c.matricula = ?");
                parametros.add(filtro.getMatricula());
            }

            if (filtro.getDataNascimento() != null && !filtro.getDataNascimento().isEmpty()) {
                sql.append(" AND c.dataNascimento = ?");
                parametros.add(filtro.getDataNascimento());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                pstm.setString(i + 1, parametro.toString());
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String fone1 = rs.getString("fone1");
                String fone2 = rs.getString("fone2");
                String email = rs.getString("email");
                String complementoEndereco = rs.getString("complementoEndereco");
                char status = rs.getString("status").charAt(0);
                int enderecoId = rs.getInt("endereco_id");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String matricula = rs.getString("matricula");
                String dataNascimento = rs.getString("dataNascimento");

                EnderecoDAO enderecoDAO = new EnderecoDAO();
                Endereco endereco = enderecoDAO.retrive(enderecoId);

                Cliente cliente = new Cliente(cpf, rg, matricula, dataNascimento, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return clientes;
    }

    @Override
    public void update(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE cliente SET endereco_id = ?, nome = ?, email = ?, fone1 = ?, fone2 = ?, status = ?, complementoEndereco = ?, cpf = ?, rg = ?, matricula = ?, dataNascimento = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objeto.getEndereco().getId());
            pstm.setString(2, objeto.getNome());
            pstm.setString(3, objeto.getEmail());
            pstm.setString(4, objeto.getFone1());
            pstm.setString(5, objeto.getFone2());
            pstm.setString(6, String.valueOf(objeto.getStatus()));
            pstm.setString(7, objeto.getComplementoEndereco());
            pstm.setString(8, objeto.getCpf());
            pstm.setString(9, objeto.getRg());
            pstm.setString(10, objeto.getMatricula());
            pstm.setString(11, objeto.getDataNascimento());
            pstm.setInt(12, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM cliente WHERE id = ?";

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
