package controller.cliente;

import model.bo.Cliente;
import model.bo.Endereco;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.cliente.TelaBuscaCliente;
import view.cliente.TelaCadastroCliente;
import view.endereco.TelaCadastroEndereco;

public class ControllerCadastroCliente {
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
    }

    private void abrirTelaBuscaCliente() {
        TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente(null, true);
        ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(telaBuscaCliente);
        telaBuscaCliente.setVisible(true);
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
        TelaCadastroEndereco cadastroEndereco = new TelaCadastroEndereco(null, true);
        cadastroEndereco.setVisible(true);
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
}
