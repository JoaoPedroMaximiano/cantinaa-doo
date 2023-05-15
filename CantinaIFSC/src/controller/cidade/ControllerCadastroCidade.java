package controller.cidade;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.cidade.TelaBuscaCidade;
import view.cidade.TelaCadastroCidade;

public class ControllerCadastroCidade {
    TelaCadastroCidade telaCadastroCidade;

    public ControllerCadastroCidade(TelaCadastroCidade telaCadastroCidade) {
        this.telaCadastroCidade = telaCadastroCidade;

        setupActionListeners();

        ativa(true, this.telaCadastroCidade.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroCidade.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroCidade.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaCidade());
        telaCadastroCidade.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCidade.getjButtonGravar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCidade.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCidade.getjButtonSair().addActionListener(e -> fecharTelaCadastroCidade());
    }

    private void abrirTelaBuscaCidade() {
        TelaBuscaCidade telaBuscaCidade = new TelaBuscaCidade(null, true);
        telaBuscaCidade.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroCidade.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCidade.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroCidade.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroCidade.getjPanelCorpo());
    }

    private void fecharTelaCadastroCidade() {
        telaCadastroCidade.dispose();
    }
}
