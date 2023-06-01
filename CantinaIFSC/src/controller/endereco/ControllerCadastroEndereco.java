package controller.endereco;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaBuscaEndereco;
import view.endereco.TelaCadastroEndereco;

public class ControllerCadastroEndereco {
    TelaCadastroEndereco telaCadastroEndereco;

    public ControllerCadastroEndereco(TelaCadastroEndereco telaCadastroEndereco) {
        this.telaCadastroEndereco = telaCadastroEndereco;

        setupActionListeners();

        ativa(true, this.telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroEndereco.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroEndereco.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaEndereco());
        telaCadastroEndereco.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroEndereco.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroEndereco.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroEndereco.getjButtonSair().addActionListener(e -> fecharTelaCadastroEndereco());
    }

    private void abrirTelaBuscaEndereco() {
        TelaBuscaEndereco telaBuscaEndereco = new TelaBuscaEndereco(null, true);
        ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(telaBuscaEndereco);
        telaBuscaEndereco.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroEndereco.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroEndereco.getjPanelCorpo());
    }

    private void fecharTelaCadastroEndereco() {
        telaCadastroEndereco.dispose();
    }

    private void realizarAcaoGravar() {
        ativa(true, telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroEndereco.getjPanelCorpo());   
    }
}
