package controller.cidade;

import javax.swing.table.DefaultTableModel;
import model.bo.Cidade;
import view.cidade.TelaBuscaCidade;

public class ControllerBuscaCidade {

    TelaBuscaCidade telaBuscaCidade;

    public ControllerBuscaCidade(TelaBuscaCidade telaBuscaCidade) {
        this.telaBuscaCidade = telaBuscaCidade;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaCidade.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaCidade.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaCidade.getjButtonSair().addActionListener(e -> fecharTelaBuscaCidade());

    }

    private void carregarDadosParaCadastro() {
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCidade.getjTable().getModel();
        table.setRowCount(0);
        for (Cidade cidade : model.dao.Persiste.getInstancia().listaCidade) {
            table.addRow(new Object[]{
                cidade.getId(),
                cidade.getDescricao(),
                cidade.getUf()
            });
        }
    }

    private void fecharTelaBuscaCidade() {
        this.telaBuscaCidade.dispose();
    }
}
