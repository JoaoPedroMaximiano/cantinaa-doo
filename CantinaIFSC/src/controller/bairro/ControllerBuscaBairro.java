package controller.bairro;

import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import view.bairro.TelaBuscaBairro;

public class ControllerBuscaBairro {

    TelaBuscaBairro telaBuscaBairro;

    public ControllerBuscaBairro(TelaBuscaBairro telaBuscaBairro) {
        this.telaBuscaBairro = telaBuscaBairro;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaBairro.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaBairro.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaBairro.getjButtonSair().addActionListener(e -> fecharTelaBuscaBairro());

    }

    private void carregarDadosParaCadastro() {
        controller.bairro.ControllerCadastroBairro.codigo = (int) this.telaBuscaBairro.getjTable().getValueAt(this.telaBuscaBairro.getjTable().getSelectedRow(), 0);
        this.telaBuscaBairro.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaBairro.getjTable().getModel();
        table.setRowCount(0);
        for (Bairro bairro : model.dao.Persiste.getInstancia().listaBairro) {
            table.addRow(new Object[]{
                bairro.getId(),
                bairro.getDescricao()
            });
        }
    }

    private void fecharTelaBuscaBairro() {
        this.telaBuscaBairro.dispose();
    }
}
