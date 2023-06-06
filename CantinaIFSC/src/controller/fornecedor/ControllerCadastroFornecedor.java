package controller.fornecedor;

import model.bo.Cliente;
import model.bo.Endereco;
import model.bo.Fornecedor;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaCadastroEndereco;
import view.fornecedor.TelaBuscaFornecedor;
import view.fornecedor.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor {
    TelaCadastroFornecedor telaCadastroFornecedor;

    public ControllerCadastroFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;

        setupActionListeners();

        ativa(true, this.telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroFornecedor.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroFornecedor.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaFornecedor());
        telaCadastroFornecedor.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroFornecedor.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroFornecedor.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroFornecedor.getjButtonSair().addActionListener(e -> fecharTelaCadastroFornecedor());
        telaCadastroFornecedor.getjButtonAdd().addActionListener(e -> abrirTelaCadastroEndereco());
    }

    private void abrirTelaBuscaFornecedor() {
        TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(null, true);
        ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
        telaBuscaFornecedor.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroFornecedor.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroFornecedor.getjPanelCorpo());
    }

    private void fecharTelaCadastroFornecedor() {
        telaCadastroFornecedor.dispose();
    }
    
    private void abrirTelaCadastroEndereco(){
        TelaCadastroEndereco cadastroEndereco = new TelaCadastroEndereco(null, true);
        cadastroEndereco.setVisible(true);
    }

    private void realizarAcaoGravar() {
        Fornecedor fornecedor  = new Fornecedor();
        fornecedor.setId(model.dao.Persiste.getInstancia().listaFornecedor.size() + 1);
        fornecedor.setNome(this.telaCadastroFornecedor.getjTextFieldNome().getText());
        fornecedor.setCnpj(this.telaCadastroFornecedor.getjFormattedTextFieldCNPJ().getText());
        fornecedor.setInscricaoEstadual(this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().getText());
        fornecedor.setRazaoSocial(this.telaCadastroFornecedor.getjTextFieldRazaoSocial().getText());
        fornecedor.setFone1(this.telaCadastroFornecedor.getjFormattedTextFieldTelefone1().getText());
        fornecedor.setFone2(this.telaCadastroFornecedor.getjFormattedTextFieldTelefone2().getText());
        fornecedor.setEmail(this.telaCadastroFornecedor.getjTextEmail().getText());
        
        String status = this.telaCadastroFornecedor.getjComboBoxStatus().getSelectedItem().toString();
        fornecedor.setStatus(status == "Ativo" ? '1' : (status == "Desativado" ? '2' : '3'));
        for (Endereco endereco : model.dao.Persiste.getInstancia().listaEndereco) {
            if (endereco.getCep().equals(this.telaCadastroFornecedor.getjFormattedTextFieldCEP().getText())) {
                fornecedor.setEndereco(endereco);
            }
        }
        
        model.dao.Persiste.getInstancia().listaFornecedor.add(fornecedor);
        ativa(true, telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroFornecedor.getjPanelCorpo());       
    }

    
}
