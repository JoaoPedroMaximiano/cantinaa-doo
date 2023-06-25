package controller.fornecedor;

import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import view.fornecedor.TelaBuscaFornecedor;

public class ControllerBuscaFornecedor {

    TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaFornecedor.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaFornecedor.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaFornecedor.getjButtonSair().addActionListener(e -> carregarFecharBuscaFornecedor());
    }

    private void carregarDadosParaCadastro() {
        controller.fornecedor.ControllerCadastroFornecedor.codigo = (int) this.telaBuscaFornecedor.getjTable().getValueAt(this.telaBuscaFornecedor.getjTable().getSelectedRow(), 0);
        this.telaBuscaFornecedor.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaFornecedor.getjTable().getModel();
        table.setRowCount(0);
        for (Fornecedor fornecedor : model.dao.Persiste.getInstancia().listaFornecedor) {
            table.addRow(new Object[]{
                fornecedor.getId(),
                fornecedor.getCnpj(),
                fornecedor.getNome(),
                fornecedor.getFone1(),
                fornecedor.getEmail(),
                fornecedor.getStatus(),
                fornecedor.getInscricaoEstadual()
            });
        }
    }    

    private void carregarFecharBuscaFornecedor() {
        this.telaBuscaFornecedor.dispose();
    }
    
}
