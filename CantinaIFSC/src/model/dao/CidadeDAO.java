package controller.cliente;

import controller.endereco.ControllerCadastroEndereco;
import model.bo.Cliente;
import model.bo.Endereco;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.cliente.TelaBuscaCliente;
import view.cliente.TelaCadastroCliente;
import view.endereco.TelaCadastroEndereco;

public class ControllerCadastroCliente {

    static int codigo;
    TelaCadastroCliente telaCadastroCliente;

    public ControllerCadastroCliente(TelaCadastroCliente telaCadastroCliente) {
        this.telaCadastroCliente = telaCadastroCliente;

        setupActionListeners();

        ativa(true, this.telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroCliente.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroCliente.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaCliente());
        telaCadastroCliente.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCliente.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroCliente.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCliente.getjButtonSair().addActionListener(e -> fecharTelaCadastroCliente());
        telaCadastroCliente.getjButtonAdd().addActionListener(e -> abrirTelaCadastroEndereco());
        telaCadastroCliente.getjButtonSearch().addActionListener(e -> abrirTelaBuscaEndereco());
    }

    private void abrirTelaBuscaCliente() {
        
        codigo = 0;
        
        TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente(null, true);
        ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(telaBuscaCliente);
        telaBuscaCliente.setVisible(true);
        if (codigo != 0) {
            Cliente cliente = new Cliente();
            cliente = model.dao.Persiste.getInstancia().listaCliente.get(codigo -1);
            ativa(false, this.telaCadastroCliente.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroCliente.getjPanelCorpo());

            String status = String.valueOf(cliente.getStatus());
            this.telaCadastroCliente.getjTextFieldID().setText(cliente.getId() + "");
            this.telaCadastroCliente.getjFormattedTextFieldCEP().setText(cliente.getEndereco().getCep());
            this.telaCadastroCliente.getjFormattedTextFieldCPF().setText(cliente.getCpf());
            this.telaCadastroCliente.getjFormattedTextFieldDataNascimento().setText(cliente.getDataNascimento());
            this.telaCadastroCliente.getjFormattedTextFieldMatricula().setText(cliente.getMatricula());
            this.telaCadastroCliente.getjFormattedTextFieldRG().setText(cliente.getRg());
            this.telaCadastroCliente.getjFormattedTextFieldTelefone1().setText(cliente.getFone1());
            this.telaCadastroCliente.getjFormattedTextFieldTelefone2().setText(cliente.getFone2());
            this.telaCadastroCliente.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" : (status.equals("2") ? "Desativado" : "Pendente")
            );
            this.telaCadastroCliente.getjTextEmail().setText(cliente.getEmail());
            this.telaCadastroCliente.getjTextFieldBairro().setText(cliente.getEndereco().getBairro().getDescricao());
            this.telaCadastroCliente.getjTextFieldCidade().setText(cliente.getEndereco().getCidade().getDescricao());
            this.telaCadastroCliente.getjTextFieldComplementoEndereco().setText(cliente.getComplementoEndereco());
            this.telaCadastroCliente.getjTextFieldLogradouro().setText(cliente.getEndereco().getLogradouro());
            this.telaCadastroCliente.getjTextFieldNome().setText(cliente.getNome());
            this.telaCadastroCliente.getjTextFieldID().setEnabled(false);
        }
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCliente.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroCliente.getjPanelCorpo());
    }

    private void fecharTelaCadastroCliente() {
        telaCadastroCliente.dispose();
    }
    
    private void abrirTelaCadastroEndereco(){
        TelaCadastroEndereco telaCadastroEndereco = new TelaCadastroEndereco(null, true);
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(telaCadastroEndereco);
        telaCadastroEndereco.setVisible(true);      
    }   

    private void realizarAcaoGravar() {
        Cliente cliente = new Cliente();
        cliente.setId(model.dao.Persiste.getInstancia().listaCliente.size() + 1);
        cliente.setNome(this.telaCadastroCliente.getjTextFieldNome().getText());
        cliente.setCpf(this.telaCadastroCliente.getjFormattedTextFieldCPF().getText());
        cliente.setRg(this.telaCadastroCliente.getjFormattedTextFieldRG().getText());
        cliente.setMatricula(this.telaCadastroCliente.getjFormattedTextFieldMatricula().getText());
        cliente.setDataNascimento(this.telaCadastroCliente.getjFormattedTextFieldDataNascimento().getText());
        cliente.setFone1(this.telaCadastroCliente.getjFormattedTextFieldTelefone1().getText());
        cliente.setFone2(this.telaCadastroCliente.getjFormattedTextFieldTelefone2().getText());
        cliente.setEmail(this.telaCadastroCliente.getjTextEmail().getText());
        
        String status = this.telaCadastroCliente.getjComboBoxStatus().getSelectedItem().toString();
        cliente.setStatus(status.equals("Ativo") ? '1' : (status.equals("Desativado") ? '2' : '3'));
        for (Endereco endereco : model.dao.Persiste.getInstancia().listaEndereco) {
            if (endereco.getCep().equals(this.telaCadastroCliente.getjFormattedTextFieldCEP().getText())) {
                cliente.setEndereco(endereco);
            }
        }
        
        model.dao.Persiste.getInstancia().listaCliente.add(cliente);
        ativa(true, telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCliente.getjPanelCorpo()); 
    }

    private void abrirTelaBuscaEndereco() {
        for (Endereco endereco : model.dao.Persiste.getInstancia().listaEndereco) {
            if (endereco.getCep().equals(this.telaCadastroCliente.getjFormattedTextFieldCEP().getText())) {
                this.telaCadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                this.telaCadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                this.telaCadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
            }
        }   
    }
}
