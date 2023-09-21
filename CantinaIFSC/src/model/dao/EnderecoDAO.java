package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Endereco;
import model.bo.Cidade;
import model.bo.Bairro;

public class EnderecoDAO implements InterfaceDAO<Endereco> {

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO endereco (cep, logradouro, status, cidade_id, bairro_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setString(3, String.valueOf(objeto.getStatus()));
            pstm.setInt(4, objeto.getCidade().getId());
            pstm.setInt(5, objeto.getBairro().getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Endereco> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, cep, logradouro, status, cidade_id, bairro_id FROM endereco";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Endereco> enderecos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String cep = rs.getString("cep");
                String logradouro = rs.getString("logradouro");
                char status = rs.getString("status").charAt(0);
                int cidadeId = rs.getInt("cidade_id");
                int bairroId = rs.getInt("bairro_id");

                Cidade cidade = new CidadeDAO().retrive(cidadeId);
                Bairro bairro = new BairroDAO().retrive(bairroId);

                Endereco endereco = new Endereco(id, cep, logradouro, status, cidade, bairro);
                enderecos.add(endereco);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return enderecos;
    }

    @Override
    public Endereco retrive(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT cep, logradouro, status, cidade_id, bairro_id FROM endereco WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Endereco endereco = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                String cep = rs.getString("cep");
                String logradouro = rs.getString("logradouro");
                char status = rs.getString("status").charAt(0);
                int cidadeId = rs.getInt("cidade_id");
                int bairroId = rs.getInt("bairro_id");

                Cidade cidade = new CidadeDAO().retrive(cidadeId);
                Bairro bairro = new BairroDAO().retrive(bairroId);

                endereco = new Endereco(id, cep, logradouro, status, cidade, bairro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return endereco;
    }

    @Override
    public List<Endereco> retrive(Endereco filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, cep, logradouro, status, cidade_id, bairro_id FROM endereco WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getCep() != null && !filtro.getCep().isEmpty()) {
                sql += " AND cep = ?";
                parametros.add(filtro.getCep());
            }

            if (filtro.getLogradouro() != null && !filtro.getLogradouro().isEmpty()) {
                sql += " AND logradouro = ?";
                parametros.add(filtro.getLogradouro());
            }

            if (filtro.getStatus() != 0) {
                sql += " AND status = ?";
                parametros.add(String.valueOf(filtro.getStatus()));
            }

            if (filtro.getCidade() != null) {
                sql += " AND cidade_id = ?";
                parametros.add(filtro.getCidade().getId());
            }

            if (filtro.getBairro() != null) {
                sql += " AND bairro_id = ?";
                parametros.add(filtro.getBairro().getId());
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Endereco> enderecos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);

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
                String cep = rs.getString("cep");
                String logradouro = rs.getString("logradouro");
                char status = rs.getString("status").charAt(0);
                int cidadeId = rs.getInt("cidade_id");
                int bairroId = rs.getInt("bairro_id");

                Cidade cidade = new CidadeDAO().retrive(cidadeId);
                Bairro bairro = new BairroDAO().retrive(bairroId);

                Endereco endereco = new Endereco(id, cep, logradouro, status, cidade, bairro);
                enderecos.add(endereco);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return enderecos;
    }

    @Override
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE endereco SET cep = ?, logradouro = ?, status = ?, cidade_id = ?, bairro_id = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setString(3, String.valueOf(objeto.getStatus()));
            pstm.setInt(4, objeto.getCidade().getId());
            pstm.setInt(5, objeto.getBairro().getId());
            pstm.setInt(6, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM endereco WHERE id = ?";

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
