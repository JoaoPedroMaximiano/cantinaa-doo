package controller.cliente;

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
        telaCadastroCliente.getjButtonGravar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCliente.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCliente.getjButtonSair().addActionListener(e -> fecharTelaCadastroCliente());
        telaCadastroCliente.getjButtonAdd().addActionListener(e -> abrirTelaCadastroEndereco());
    }

    private void abrirTelaBuscaCliente() {
        TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente(null, true);
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
}
