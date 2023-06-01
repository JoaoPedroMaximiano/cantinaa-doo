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

    }

    private void carregarDadosParaCadastro() {
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
}
