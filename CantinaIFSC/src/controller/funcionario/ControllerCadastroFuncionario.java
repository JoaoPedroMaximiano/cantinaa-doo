package controller.funcionario;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
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
        telaCadastroFuncionario.getjButtonGravar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroFuncionario.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroFuncionario.getjButtonSair().addActionListener(e -> fecharTelaCadastroFuncionario());
    }

    private void abrirTelaBuscaFuncionario() {
        TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(null, true);
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
}
