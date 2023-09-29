package controller.carteirinha;

import javax.swing.table.DefaultTableModel;
import model.bo.Carteirinha;
import view.carteirinha.TelaBuscaCarteirinha;

public class ControllerBuscaCarteirinha {


    TelaBuscaCarteirinha telaBuscaCarteirinha;

    public ControllerBuscaCarteirinha(TelaBuscaCarteirinha telaBuscaCarteirinha) {
        this.telaBuscaCarteirinha = telaBuscaCarteirinha;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaCarteirinha.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaCarteirinha.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaCarteirinha.getjButtonSair().addActionListener(e -> fecharTelaBuscaCarteirinha());

    }

    private void carregarDadosParaCadastro() {
        controller.carteirinha.ControllerCadastroCarteirinha.codigo = (int) this.telaBuscaCarteirinha.getjTable().getValueAt(this.telaBuscaCarteirinha.getjTable().getSelectedRow(), 0);
        this.telaBuscaCarteirinha.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCarteirinha.getjTable().getModel();
        table.setRowCount(0);
        for (Carteirinha carteirinha : model.dao.Persiste.getInstancia().listaCarteirinha) {
            table.addRow(new Object[]{
                carteirinha.getId(),
                carteirinha.getCodigoBarra(),
                carteirinha.getDataGeracao(),
                carteirinha.getCliente().getNome(),
                carteirinha.getDataCancelamento()
            });
        }
    }    

    private void fecharTelaBuscaCarteirinha() {
        this.telaBuscaCarteirinha.dispose();
    }
    
}
