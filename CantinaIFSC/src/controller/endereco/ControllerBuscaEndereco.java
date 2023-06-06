package controller.endereco;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Endereco;
import view.endereco.TelaBuscaEndereco;

public class ControllerBuscaEndereco {
    TelaBuscaEndereco telaBuscaEndereco;

    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco) {
        this.telaBuscaEndereco = telaBuscaEndereco;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaEndereco.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaEndereco.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());

    }

    private void carregarDadosParaCadastro() {
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaEndereco.getjTable().getModel();
        table.setRowCount(0);
        model.dao.Persiste.getInstancia().listaEndereco.forEach(endereco -> {
            table.addRow(new Object[]{
                endereco.getId(),
                endereco.getCep(),
                endereco.getCidade().getDescricao(),
                endereco.getBairro().getDescricao(),
                endereco.getLogradouro(),
                endereco.getStatus()
            });
        });
    }
}
