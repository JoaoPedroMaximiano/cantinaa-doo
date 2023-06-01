package controller.carteirinha;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.carteirinha.TelaBuscaCarteirinha;
import view.carteirinha.TelaCadastroCarteirinha;

public class ControllerCadastroCarteirinha {
    TelaCadastroCarteirinha telaCadastroCarteirinha;

    public ControllerCadastroCarteirinha(TelaCadastroCarteirinha telaCadastroCarteirinha) {
        this.telaCadastroCarteirinha = telaCadastroCarteirinha;

        setupActionListeners();

        ativa(true, this.telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroCarteirinha.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroCarteirinha.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaCarteirinha());
        telaCadastroCarteirinha.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCarteirinha.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroCarteirinha.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCarteirinha.getjButtonSair().addActionListener(e -> fecharTelaCadastroCarteirinha());
    }

    private void abrirTelaBuscaCarteirinha() {
        TelaBuscaCarteirinha telaBuscaCarteirinha = new TelaBuscaCarteirinha(null, true);
        ControllerBuscaCarteirinha controllerBuscaCarteirinha = new ControllerBuscaCarteirinha(telaBuscaCarteirinha);
        telaBuscaCarteirinha.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCarteirinha.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroCarteirinha.getjPanelCorpo());
    }

    private void fecharTelaCadastroCarteirinha() {
        telaCadastroCarteirinha.dispose();
    }

    private void realizarAcaoGravar() {
        ativa(true, telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCarteirinha.getjPanelCorpo());   
    }
}
