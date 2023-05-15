package controller.caixa;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.caixa.TelaBuscaCaixa;
import view.caixa.TelaCadastroCaixa;

public class ControllerCadastroCaixa {
    TelaCadastroCaixa telaCadastroCaixa;

    public ControllerCadastroCaixa(TelaCadastroCaixa telaCadastroCaixa) {
        this.telaCadastroCaixa = telaCadastroCaixa;

        setupActionListeners();

        ativa(true, this.telaCadastroCaixa.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroCaixa.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroCaixa.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaCaixa());
        telaCadastroCaixa.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCaixa.getjButtonGravar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCaixa.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCaixa.getjButtonSair().addActionListener(e -> fecharTelaCadastroCaixa());
    }

    private void abrirTelaBuscaCaixa() {
        TelaBuscaCaixa telaBuscaCaixa = new TelaBuscaCaixa(null, true);
        telaBuscaCaixa.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroCaixa.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCaixa.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroCaixa.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroCaixa.getjPanelCorpo());
    }

    private void fecharTelaCadastroCaixa() {
        telaCadastroCaixa.dispose();
    }
}
