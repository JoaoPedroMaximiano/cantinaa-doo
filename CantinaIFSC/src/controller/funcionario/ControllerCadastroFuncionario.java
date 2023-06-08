package controller.funcionario;

import controller.endereco.ControllerCadastroEndereco;
import model.bo.Endereco;
import model.bo.Funcionario;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaCadastroEndereco;
import view.funcionario.TelaBuscaFuncionario;
import view.funcionario.TelaCadastroFuncionario;

public class ControllerCadastroFuncionario {
    TelaCadastroFuncionario telaCadastroFuncionario;

    public ControllerCadastroFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        this.telaCadastroFuncionario = telaCadastroFuncionario;

        setupActionListeners();

        ativa(true, this.telaCadastroFuncionario.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroFuncionario.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroFuncionario.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaFuncionario());
        telaCadastroFuncionario.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroFuncionario.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroFuncionario.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroFuncionario.getjButtonSair().addActionListener(e -> fecharTelaCadastroFuncionario());
        telaCadastroFuncionario.getjButtonAdd().addActionListener(e -> abrirTelaCadastroEndereco());
        telaCadastroFuncionario.getjButtonSearch().addActionListener(e -> abrirTelaBuscaEndereco());
    }

    private void abrirTelaBuscaFuncionario() {
        TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(null, true);
        ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(telaBuscaFuncionario);
        telaBuscaFuncionario.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroFuncionario.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroFuncionario.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroFuncionario.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroFuncionario.getjPanelCorpo());
    }

    private void fecharTelaCadastroFuncionario() {
        telaCadastroFuncionario.dispose();
    }
    
    private void abrirTelaCadastroEndereco(){
        TelaCadastroEndereco telaCadastroEndereco = new TelaCadastroEndereco(null, true);
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(telaCadastroEndereco);
        telaCadastroEndereco.setVisible(true);
    }

    private void realizarAcaoGravar() {
        Funcionario funcionario  = new Funcionario();
        funcionario.setId(model.dao.Persiste.getInstancia().listaFuncionario.size() + 1);
        funcionario.setNome(this.telaCadastroFuncionario.getjTextFieldNome().getText());
        funcionario.setCpf(this.telaCadastroFuncionario.getjFormattedTextFieldCPF().getText());
        funcionario.setRg(this.telaCadastroFuncionario.getjFormattedTextFieldRG().getText());
        funcionario.setFone1(this.telaCadastroFuncionario.getjFormattedTextFieldTelefone1().getText());
        funcionario.setFone2(this.telaCadastroFuncionario.getjFormattedTextFieldTelefone2().getText());
        funcionario.setEmail(this.telaCadastroFuncionario.getjTextEmail().getText());
        funcionario.setSenha(this.telaCadastroFuncionario.getjPasswordFieldSenha().getText());
        funcionario.setUsuario(this.telaCadastroFuncionario.getjTextFieldUsuario().getText());
        
        String status = this.telaCadastroFuncionario.getjComboBoxStatus().getSelectedItem().toString();
        funcionario.setStatus(status == "Ativo" ? '1' : (status == "Desativado" ? '2' : '3'));
        for (Endereco endereco : model.dao.Persiste.getInstancia().listaEndereco) {
            if (endereco.getCep().equals(this.telaCadastroFuncionario.getjFormattedTextFieldCEP().getText())) {
                funcionario.setEndereco(endereco);
            }
        }
        
        model.dao.Persiste.getInstancia().listaFuncionario.add(funcionario);
        ativa(true, telaCadastroFuncionario.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroFuncionario.getjPanelCorpo());       
    }

    private void abrirTelaBuscaEndereco() {
        for (Endereco endereco : model.dao.Persiste.getInstancia().listaEndereco) {
            if (endereco.getCep().equals(this.telaCadastroFuncionario.getjFormattedTextFieldCEP().getText())) {
                this.telaCadastroFuncionario.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                this.telaCadastroFuncionario.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                this.telaCadastroFuncionario.getjTextFieldLogradouro().setText(endereco.getLogradouro());
            }
        }    
    }
}
