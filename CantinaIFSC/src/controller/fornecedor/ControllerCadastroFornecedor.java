package controller.fornecedor;

import controller.endereco.ControllerCadastroEndereco;

import model.bo.Endereco;
import model.bo.Fornecedor;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaCadastroEndereco;
import view.fornecedor.TelaBuscaFornecedor;
import view.fornecedor.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor {

    static int codigo;
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
        telaCadastroFornecedor.getjButtonSearch().addActionListener(e -> abrirTelaBuscarCepEndereco());
    }

    private void abrirTelaBuscaFornecedor() {
                
        codigo = 0;
        
        TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(null, true);
        ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
        telaBuscaFornecedor.setVisible(true);

        if (codigo != 0) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor = model.dao.Persiste.getInstancia().listaFornecedor.get(codigo -1);
            
            ativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroFornecedor.getjPanelCorpo());
            
            String status = String.valueOf(fornecedor.getStatus());
            this.telaCadastroFornecedor.getjTextFieldID().setText(fornecedor.getId() + "");
            this.telaCadastroFornecedor.getjFormattedTextFieldCEP().setText(fornecedor.getEndereco().getCep());
            this.telaCadastroFornecedor.getjFormattedTextFieldCNPJ().setText(fornecedor.getCnpj());
            this.telaCadastroFornecedor.getjFormattedTextFieldTelefone1().setText(fornecedor.getFone1());
            this.telaCadastroFornecedor.getjFormattedTextFieldTelefone2().setText(fornecedor.getFone2());
            this.telaCadastroFornecedor.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" : (status.equals("2") ? "Desativado" : "Pendente")
            );
            this.telaCadastroFornecedor.getjTextFieldBairro().setText(fornecedor.getEndereco().getBairro().getDescricao());
            this.telaCadastroFornecedor.getjTextFieldCidade().setText(fornecedor.getEndereco().getCidade().getDescricao());
            this.telaCadastroFornecedor.getjTextFieldComplementoEndereco().setText(fornecedor.getComplementeEndereco());
            this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().setText(fornecedor.getInscricaoEstadual());
            this.telaCadastroFornecedor.getjTextFieldLogradouro().setText(fornecedor.getEndereco().getLogradouro());
            this.telaCadastroFornecedor.getjTextFieldNome().setText(fornecedor.getNome());
            this.telaCadastroFornecedor.getjTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial());
            this.telaCadastroFornecedor.getjTextEmail().setText(fornecedor.getEmail());
            this.telaCadastroFornecedor.getjTextFieldID().setEnabled(false);
        }
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
        TelaCadastroEndereco telacadastroEndereco = new TelaCadastroEndereco(null, true);
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(telacadastroEndereco);
        telacadastroEndereco.setVisible(true);
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
        fornecedor.setComplementeEndereco(this.telaCadastroFornecedor.getjTextFieldComplementoEndereco().getText());
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

    private void abrirTelaBuscarCepEndereco() {
        for (Endereco endereco : model.dao.Persiste.getInstancia().listaEndereco) {
            if (endereco.getCep().equals(this.telaCadastroFornecedor.getjFormattedTextFieldCEP().getText())) {
                this.telaCadastroFornecedor.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                this.telaCadastroFornecedor.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                this.telaCadastroFornecedor.getjTextFieldLogradouro().setText(endereco.getLogradouro());
            }
        }
    }

    
}
