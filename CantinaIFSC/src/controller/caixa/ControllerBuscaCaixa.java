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
        telaBuscaCaixa.getjButtonSair().addActionListener(e -> fecharTelaBuscaCaixa());

    }

    private void carregarDadosParaCadastro() {
        controller.caixa.ControllerCadastroCaixa.codigo = (int) this.telaBuscaCaixa.getjTable().getValueAt(this.telaBuscaCaixa.getjTable().getSelectedRow(), 0);
        this.telaBuscaCaixa.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCaixa.getjTable().getModel();
        table.setRowCount(0);
        for (Caixa caixa : model.dao.Persiste.getInstancia().listaCaixa) {
            table.addRow(new Object[]{
                caixa.getId(),
                caixa.getFuncionario().getNome(),
                caixa.getDataHoraAberto(),
                caixa.getDataHoraFechamento(),
                caixa.getValorAbertura(),
                caixa.getValorFechamento()
            });
        }
    }

    private void fecharTelaBuscaCaixa() {
        this.telaBuscaCaixa.dispose();
    }
}
