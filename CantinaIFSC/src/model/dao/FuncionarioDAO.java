package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Endereco;
import model.bo.Funcionario;

public class FuncionarioDAO implements InterfaceDAO<Funcionario> {

    @Override
    public void create(Funcionario funcionario) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO funcionario (endereco_id, nome, email, fone1, fone2, status, complementoEndereco, cpf, rg, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, funcionario.getEndereco().getId());
            pstm.setString(2, funcionario.getNome());
            pstm.setString(3, funcionario.getEmail());
            pstm.setString(4, funcionario.getFone1());
            pstm.setString(5, funcionario.getFone2());
            pstm.setString(6, String.valueOf(funcionario.getStatus()));
            pstm.setString(7, funcionario.getComplementoEndereco());
            pstm.setString(8, funcionario.getCpf());
            pstm.setString(9, funcionario.getRg());
            pstm.setString(10, funcionario.getUsuario());
            pstm.setString(11, funcionario.getSenha());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Funcionario> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, endereco_id, nome, email, fone1, fone2, status, complementoEndereco, cpf, rg, usuario, senha FROM funcionario";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();

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
                String complementoEndereco = rs.getString("complementoEndereco");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                Endereco endereco = new EnderecoDAO().retrive(enderecoId);

                Funcionario funcionario = new Funcionario(cpf, rg, usuario, senha, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return funcionarios;
    }

    @Override
    public Funcionario retrive(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT endereco_id, nome, email, fone1, fone2, status, complementoEndereco, cpf, rg, usuario, senha FROM funcionario WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario funcionario = null;

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
                String complementoEndereco = rs.getString("complementoEndereco");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                Endereco endereco = new EnderecoDAO().retrive(enderecoId);

                funcionario = new Funcionario(cpf, rg, usuario, senha, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return funcionario;
    }

    @Override
    public List<Funcionario> retrive(Funcionario filtro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT id, endereco_id, nome, email, fone1, fone2, status, complementoEndereco, cpf, rg, usuario, senha FROM funcionario WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getId() != 0) {
                sql += " AND id = ?";
                parametros.add(filtro.getId());
            }

            if (filtro.getEndereco() != null && filtro.getEndereco().getId() != 0) {
                sql += " AND endereco_id = ?";
                parametros.add(filtro.getEndereco().getId());
            }
            
            if (filtro.getCpf() != null && !filtro.getCpf().isEmpty()) {
                sql += " AND cpf = ?";
                parametros.add(filtro.getCpf());
            }

            if (filtro.getRg() != null && !filtro.getRg().isEmpty()) {
                sql += " AND rg = ?";
                parametros.add(filtro.getRg());
            }

            if (filtro.getUsuario() != null && !filtro.getUsuario().isEmpty()) {
                sql += " AND usuario = ?";
                parametros.add(filtro.getUsuario());
            }

            if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
                sql += " AND nome = ?";
                parametros.add(filtro.getNome());
            }

            if (filtro.getEmail() != null && !filtro.getEmail().isEmpty()) {
                sql += " AND email = ?";
                parametros.add(filtro.getEmail());
            }

            if (filtro.getFone1() != null && !filtro.getFone1().isEmpty()) {
                sql += " AND fone1 = ?";
                parametros.add(filtro.getFone1());
            }

            if (filtro.getFone2() != null && !filtro.getFone2().isEmpty()) {
                sql += " AND fone2 = ?";
                parametros.add(filtro.getFone2());
            }

            if (filtro.getComplementoEndereco() != null && !filtro.getComplementoEndereco().isEmpty()) {
                sql += " AND complementoEndereco = ?";
                parametros.add(filtro.getComplementoEndereco());
            }

            if (filtro.getStatus() != 0) {
                sql += " AND status = ?";
                parametros.add(String.valueOf(filtro.getStatus()));
            }
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);

            for (int i = 0; i < parametros.size(); i++) {
                Object parametro = parametros.get(i);
                if (parametro instanceof String) {
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
                String complementoEndereco = rs.getString("complementoEndereco");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                Endereco endereco = new EnderecoDAO().retrive(enderecoId);

                Funcionario funcionario = new Funcionario(cpf, rg, usuario, senha, id, nome, fone1, fone2, email, complementoEndereco, status, endereco);
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return funcionarios;
    }

    @Override
    public void update(Funcionario funcionario) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "UPDATE funcionario SET endereco_id = ?, nome = ?, email = ?, fone1 = ?, fone2 = ?, status = ?, complementoEndereco = ?, cpf = ?, rg = ?, usuario = ?, senha = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, funcionario.getEndereco().getId());
            pstm.setString(2, funcionario.getNome());
            pstm.setString(3, funcionario.getEmail());
            pstm.setString(4, funcionario.getFone1());
            pstm.setString(5, funcionario.getFone2());
            pstm.setString(6, String.valueOf(funcionario.getStatus()));
            pstm.setString(7, funcionario.getComplementoEndereco());
            pstm.setString(8, funcionario.getCpf());
            pstm.setString(9, funcionario.getRg());
            pstm.setString(10, funcionario.getUsuario());
            pstm.setString(11, funcionario.getSenha());
            pstm.setInt(12, funcionario.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Funcionario funcionario) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "DELETE FROM funcionario WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, funcionario.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }
}
