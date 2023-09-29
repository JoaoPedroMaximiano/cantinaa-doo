package controller.fornecedor;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Fornecedor;
import service.BairroService;
import service.CidadeService;
import service.EnderecoService;
import service.FornecedorService;
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
        Fornecedor filtro = new Fornecedor();
        filtro.setInscricaoEstadual(this.telaBuscaFornecedor.getjTextFieldInscricaoEstadual().getText());
        filtro.setRazaoSocial(this.telaBuscaFornecedor.getjTextFieldRazaoSocial().getText());
        filtro.setComplementoEndereco(this.telaBuscaFornecedor.getjTextFieldComplementoEndereco().getText());
        filtro.setCnpj(this.telaBuscaFornecedor.getjFormattedTextFieldCNPJ().getText());
        filtro.setEmail(this.telaBuscaFornecedor.getjTextEmail().getText());
        filtro.setFone1(this.telaBuscaFornecedor.getjFormattedTextFieldTelefone1().getText());
        filtro.setFone2(this.telaBuscaFornecedor.getjFormattedTextFieldTelefone2().getText());
        filtro.setNome(this.telaBuscaFornecedor.getjTextFieldNome().getText());
        String status = this.telaBuscaFornecedor.getjComboBoxStatus().getSelectedItem().toString();
        filtro.setStatus(status.equals("Ativo") ? '1' : (status.equals("Desativado") ? '2' : '3'));

        Endereco filtroEndereco = new Endereco();
        
        if (this.telaBuscaFornecedor.getjFormattedTextFieldCEP().getText().equals("")){
            filtroEndereco.setCep(this.telaBuscaFornecedor.getjFormattedTextFieldCEP().getText());
        }
        
        if (!telaBuscaFornecedor.getjTextFieldBairro().getText().equals("")) {
            Bairro bairro = new Bairro();
            bairro.setDescricao(telaBuscaFornecedor.getjTextFieldBairro().getText());
            filtroEndereco.setBairro(new BairroService().carregar(bairro).get(0));
        }
        
        if (!telaBuscaFornecedor.getjTextFieldCidade().getText().equals("")) {
            Cidade cidade = new Cidade();
            cidade.setDescricao(telaBuscaFornecedor.getjTextFieldCidade().getText());
            filtroEndereco.setCidade(new CidadeService().carregar(cidade).get(0));
        }
        filtro.setEndereco(EnderecoService.carregar(filtroEndereco).get(0));
        
        List<Fornecedor> fornecedores = !filtro.getCnpj().equals("") || 
        !filtro.getComplementoEndereco().equals("") || 
        !filtro.getEmail().equals("") || filtro.getEndereco() != null || 
        !filtro.getFone1().equals("") || !filtro.getFone2().equals("") || 
        !filtro.getInscricaoEstadual().equals("") || 
        !filtro.getNome().equals("") || 
        !filtro.getRazaoSocial().equals("") || 
        !Character.isDefined(filtro.getStatus()) 
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
