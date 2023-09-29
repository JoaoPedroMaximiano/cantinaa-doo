package controller.produto;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Produto;
import service.ProdutoService;
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
        Produto filtro = new Produto();
        filtro.setCodigoBarra(telaBuscaProduto.getjTextFieldCodigoBarra().getText());
        filtro.setDescricao(telaBuscaProduto.getjTextFieldDescricao().getText());
        filtro.setStatus(telaBuscaProduto.getjComboBoxStatus().getSelectedItem().toString().equals("Ativo") ? '1' : '0');
        List<Produto> produtos = filtro.getCodigoBarra().equals("") || 
                filtro.getDescricao().equals("") || 
                Character.isDefined(filtro.getStatus()) ? 
                ProdutoService.carregar(filtro) : ProdutoService.carregar();
        
        produtos.forEach(produto -> {
            table.addRow(new Object[]{
                produto.getId(),
                produto.getDescricao(),
                produto.getStatus()
            });
        });
    }    

    private void carregarFecharBuscaProduto() {
        this.telaBuscaProduto.dispose();
    }
    
}
