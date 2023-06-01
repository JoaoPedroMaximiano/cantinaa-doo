package controller.caixa;

import javax.swing.table.DefaultTableModel;
import model.bo.Caixa;
import view.caixa.TelaBuscaCaixa;

public class ControllerBuscaCaixa {
    TelaBuscaCaixa telaBuscaCaixa;

    public ControllerBuscaCaixa(TelaBuscaCaixa telaBuscaCaixa) {
        this.telaBuscaCaixa = telaBuscaCaixa;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaCaixa.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaCaixa.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());

    }

    private void carregarDadosParaCadastro() {
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCaixa.getjTable().getModel();
        table.setRowCount(0);
        for (Caixa caixa : model.dao.Persiste.getInstancia().listaCaixa) {
            table.addRow(new Object[]{
                caixa.getId(),
                caixa.getDataHoraAberto(),
                caixa.getDataHoraFechamento(),
                caixa.getFuncionario(),
                caixa.getObservacao(),
                caixa.getStatus(),
                caixa.getValorAbertura(),
                caixa.getValorFechamento()
            });
        }
    }
}
