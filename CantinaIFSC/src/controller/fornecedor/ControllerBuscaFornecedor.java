package controller.fornecedor;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import service.FornecedorService;
import view.fornecedor.TelaBuscaFornecedor;

public class ControllerBuscaFornecedor {

    TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        filtrarPesquisa();
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

        Fornecedor filtro = new Fornecedor();
        filtro.setInscricaoEstadual(this.telaBuscaFornecedor.getjTextFieldInscricaoEstadual().getText());
        filtro.setRazaoSocial(this.telaBuscaFornecedor.getjTextFieldRazaoSocial().getText());
        filtro.setCnpj(this.telaBuscaFornecedor.getjFormattedTextFieldCNPJ().getText().trim().equals("  .   .   /    -  ".trim()) ? "" : this.telaBuscaFornecedor.getjFormattedTextFieldCNPJ().getText());
        filtro.setNome(this.telaBuscaFornecedor.getjTextFieldNome().getText());
        
        List<Fornecedor> fornecedores = !filtro.getCnpj().equals("")  
        || !filtro.getInscricaoEstadual().equals("")
        || !filtro.getNome().equals("")
        || !filtro.getRazaoSocial().equals("")
        ? new FornecedorService().carregar(filtro) : new FornecedorService().carregar();

        fornecedores.forEach(fornecedor -> {
            table.addRow(new Object[]{
                fornecedor.getId(),
                fornecedor.getCnpj(),
                fornecedor.getNome(),
                fornecedor.getFone1(),
                fornecedor.getEmail(),
                fornecedor.getStatus(),
                fornecedor.getInscricaoEstadual()
            });
        });
    }    

    private void carregarFecharBuscaFornecedor() {
        this.telaBuscaFornecedor.dispose();
    }
    
}
