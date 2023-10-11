package controller.funcionario;

import controller.endereco.ControllerCadastroEndereco;
import java.util.List;
import model.bo.Endereco;
import model.bo.Funcionario;
import service.EnderecoService;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaCadastroEndereco;
import view.funcionario.TelaBuscaFuncionario;
import view.funcionario.TelaCadastroFuncionario;

public class ControllerCadastroFuncionario {

    static int codigo;
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
        
        codigo = 0;
        
        TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(null, true);
        ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(telaBuscaFuncionario);
        telaBuscaFuncionario.setVisible(true);
        
        if (codigo != 0) {
            Funcionario funcionario = new Funcionario();
            funcionario = model.dao.Persiste.getInstancia().listaFuncionario.get(codigo -1);
            
            ativa(false, this.telaCadastroFuncionario.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroFuncionario.getjPanelCorpo());
            
            String status = String.valueOf(funcionario.getStatus());
            this.telaCadastroFuncionario.getjTextFieldID().setText(funcionario.getId() + "");
            this.telaCadastroFuncionario.getjFormattedTextFieldCEP().setText(funcionario.getEndereco().getCep());
            this.telaCadastroFuncionario.getjFormattedTextFieldTelefone1().setText(funcionario.getFone1());
            this.telaCadastroFuncionario.getjFormattedTextFieldTelefone2().setText(funcionario.getFone2());
            this.telaCadastroFuncionario.getjFormattedTextFieldCPF().setText(funcionario.getCpf());
            this.telaCadastroFuncionario.getjFormattedTextFieldRG().setText(funcionario.getRg());
            
            this.telaCadastroFuncionario.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" : (status.equals("2") ? "Desativado" : "Pendente")
            );
            this.telaCadastroFuncionario.getjTextFieldBairro().setText(funcionario.getEndereco().getBairro().getDescricao());
            this.telaCadastroFuncionario.getjTextFieldCidade().setText(funcionario.getEndereco().getCidade().getDescricao());
            this.telaCadastroFuncionario.getjTextFieldComplementoEndereco().setText(funcionario.getComplementoEndereco());
            this.telaCadastroFuncionario.getjTextFieldLogradouro().setText(funcionario.getEndereco().getLogradouro());
            this.telaCadastroFuncionario.getjTextFieldNome().setText(funcionario.getNome());
            this.telaCadastroFuncionario.getjTextEmail().setText(funcionario.getEmail());
            
            this.telaCadastroFuncionario.getjPasswordFieldSenha().setText(funcionario.getSenha());
            this.telaCadastroFuncionario.getjTextFieldUsuario().setText(funcionario.getUsuario());
            this.telaCadastroFuncionario.getjTextFieldID().setEnabled(false);
        }        
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
        funcionario.setComplementoEndereco(this.telaCadastroFuncionario.getjTextFieldComplementoEndereco().getText());
        
        String status = this.telaCadastroFuncionario.getjComboBoxStatus().getSelectedItem().toString();
        funcionario.setStatus(status == "Ativo" ? '1' : (status == "Desativado" ? '2' : '3'));
        Endereco filtro = new Endereco();
        filtro.setCep(this.telaCadastroFuncionario.getjFormattedTextFieldCEP().getText());
        List<Endereco> enderecos = new EnderecoService().carregar(filtro);
        funcionario.setEndereco(enderecos.get(0));
        
        if (this.telaCadastroFuncionario.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
            new service.FuncionarioService().adicionar(funcionario);
        } else {
            funcionario.setId(Integer.parseInt(this.telaCadastroFuncionario.getjTextFieldID().getText()));
            new service.FuncionarioService().atualizar(funcionario);
        }        
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
