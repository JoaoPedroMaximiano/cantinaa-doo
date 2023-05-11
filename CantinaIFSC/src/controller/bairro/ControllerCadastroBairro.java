package controller.bairro;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.bairro.TelaBuscaBairro;
import view.bairro.TelaCadastroBairro;

public class ControllerCadastroBairro {
    TelaCadastroBairro telaCadastroBairro;

    public ControllerCadastroBairro(TelaCadastroBairro telaCadastroBairro) {
        this.telaCadastroBairro = telaCadastroBairro;

        setupActionListeners();

        ativa(true, this.telaCadastroBairro.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroBairro.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroBairro.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaBairro());
        telaCadastroBairro.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroBairro.getjButtonGravar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroBairro.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroBairro.getjButtonSair().addActionListener(e -> fecharTelaCadastroBairro());
    }

    private void abrirTelaBuscaBairro() {
        TelaBuscaBairro telaBuscaBairro = new TelaBuscaBairro(null, true);
        telaBuscaBairro.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroBairro.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroBairro.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroBairro.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroBairro.getjPanelCorpo());
    }

    private void fecharTelaCadastroBairro() {
        telaCadastroBairro.dispose();
    }
}
