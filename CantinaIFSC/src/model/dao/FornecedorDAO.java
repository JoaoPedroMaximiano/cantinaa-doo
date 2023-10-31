package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Endereco;
import model.bo.Fornecedor;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO fornecedor (endereco_id, nome, email, fone1, fone2, status, complemento_endereco, cnpj, inscricaoEstadual, razaoSocial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstm.setString(8, objeto.getCnpj());
            pstm.setString(9, objeto.getInscricaoEstadual());
            pstm.setString(10, objeto.getRazaoSocial());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, endereco_id, nome, email, fone1, fone2, status, complemento_endereco, cnpj, inscricaoEstadual, razaoSocial FROM fornecedor";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int enderecoId = rs.getInt("endereco_id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String fone1 = rs.getString("fone1");
                String fone2 = rs.getString("fone2");
                char status = rs.getString("status").charAt(0);
                String complementoEndereco = rs.getString("complemento_endereco");
                String cnpj = rs.getString("cnpj");
                String inscricaoEstadual = rs.getString("inscricaoEstadual");
                String razaoSocial = rs.getString("razaoSocial");
                
                Endereco endereco = new EnderecoDAO().retrieve(enderecoId);
                Fornecedor fornecedor = new Fornecedor(cnpj, inscricaoEstadual, razaoSocial, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return fornecedores;
    }

    @Override
    public Fornecedor retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT endereco_id, nome, email, fone1, fone2, status, complemento_endereco, cnpj, inscricaoEstadual, razaoSocial FROM fornecedor WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Fornecedor fornecedor = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                int enderecoId = rs.getInt("endereco_id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String fone1 = rs.getString("fone1");
                String fone2 = rs.getString("fone2");
                char status = rs.getString("status").charAt(0);
                String complementoEndereco = rs.getString("complemento_endereco");
                String cnpj = rs.getString("cnpj");
                String inscricaoEstadual = rs.getString("inscricaoEstadual");
                String razaoSocial = rs.getString("razaoSocial");
                
                Endereco endereco = new EnderecoDAO().retrieve(enderecoId);
                fornecedor = new Fornecedor(cnpj, inscricaoEstadual, razaoSocial, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrieve(Fornecedor filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder("SELECT id, endereco_id, nome, email, fone1, fone2, status, complemento_endereco, cnpj, inscricaoEstadual, razaoSocial FROM fornecedor WHERE 1=1");
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {

            if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
                sql.append(" AND nome = ?");
                parametros.add(filtro.getNome());
            }

            if (filtro.getCnpj() != null && !filtro.getCnpj().isEmpty()) {
                sql.append(" AND cnpj = ?");
                parametros.add(filtro.getCnpj());
            }

            if (filtro.getInscricaoEstadual() != null && !filtro.getInscricaoEstadual().isEmpty()) {
                sql.append(" AND inscricaoEstadual = ?");
                parametros.add(filtro.getInscricaoEstadual());
            }

            if (filtro.getRazaoSocial() != null && !filtro.getRazaoSocial().isEmpty()) {
                sql.append(" AND razaoSocial = ?");
                parametros.add(filtro.getRazaoSocial());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                if (parametro instanceof Integer) {
                    pstm.setInt(i + 1, (Integer) parametro);
                } else if (parametro instanceof String) {
                    pstm.setString(i + 1, (String) parametro);
                }
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int enderecoId = rs.getInt("endereco_id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String fone1 = rs.getString("fone1");
                String fone2 = rs.getString("fone2");
                char status = rs.getString("status").charAt(0);
                String complementoEndereco = rs.getString("complemento_endereco");
                String cnpj = rs.getString("cnpj");
                String inscricaoEstadual = rs.getString("inscricaoEstadual");
                String razaoSocial = rs.getString("razaoSocial");

                Endereco endereco = new EnderecoDAO().retrieve(enderecoId);
                Fornecedor fornecedor = new Fornecedor(cnpj, inscricaoEstadual, razaoSocial, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return fornecedores;
    }

    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE fornecedor SET endereco_id = ?, nome = ?, email = ?, fone1 = ?, fone2 = ?, status = ?, complemento_endereco = ?, cnpj = ?, inscricaoEstadual = ?, razaoSocial = ? WHERE id = ?";

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
            pstm.setString(8, objeto.getCnpj());
            pstm.setString(9, objeto.getInscricaoEstadual());
            pstm.setString(10, objeto.getRazaoSocial());
            pstm.setInt(11, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM fornecedor WHERE id = ?";

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
