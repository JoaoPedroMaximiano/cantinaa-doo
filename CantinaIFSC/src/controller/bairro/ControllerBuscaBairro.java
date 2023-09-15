package controller.bairro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import view.bairro.TelaBuscaBairro;

public class ControllerBuscaBairro {

    TelaBuscaBairro telaBuscaBairro;

    public ControllerBuscaBairro(TelaBuscaBairro telaBuscaBairro) {
        this.telaBuscaBairro = telaBuscaBairro;
        setupActionListeners();
        filtrarPesquisa();
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
        for (Iterator<Bairro> it = (telaBuscaBairro.getjTextFieldDescricao().getText().isEmpty() 
                ? new BairroService().carregar() : 
                new BairroService().carregar(telaBuscaBairro.getjTextFieldDescricao().getText())) .iterator(); it.hasNext();) {
            Bairro bairro = it.next();
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
