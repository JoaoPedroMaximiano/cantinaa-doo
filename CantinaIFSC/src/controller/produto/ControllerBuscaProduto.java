package controller.produto;

import javax.swing.table.DefaultTableModel;
import model.bo.Produto;
import view.produto.TelaBuscaProduto;

public class ControllerBuscaProduto {

    TelaBuscaProduto telaBuscaProduto;

    public ControllerBuscaProduto(TelaBuscaProduto telaBuscaProduto) {
        this.telaBuscaProduto = telaBuscaProduto;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaProduto.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaProduto.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaProduto.getjButtonSair().addActionListener(e -> carregarFecharBuscaProduto());

    }

    private void carregarDadosParaCadastro() {
        controller.produto.ControllerCadastroProduto.codigo = (int) this.telaBuscaProduto.getjTable().getValueAt(this.telaBuscaProduto.getjTable().getSelectedRow(), 0);
        this.telaBuscaProduto.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaProduto.getjTable().getModel();
        table.setRowCount(0);
        table.setRowCount(0);
        for (Produto produto : model.dao.Persiste.getInstancia().listaProduto) {
            table.addRow(new Object[]{
                produto.getId(),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }    

    private void carregarFecharBuscaProduto() {
        this.telaBuscaProduto.dispose();
    }
    
}
