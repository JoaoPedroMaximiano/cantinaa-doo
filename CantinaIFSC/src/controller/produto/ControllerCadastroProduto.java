package controller.produto;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.produto.TelaBuscaProduto;
import view.produto.TelaCadastroProduto;

public class ControllerCadastroProduto {
    TelaCadastroProduto telaCadastroProduto;

    public ControllerCadastroProduto(TelaCadastroProduto telaCadastroProduto) {
        this.telaCadastroProduto = telaCadastroProduto;

        setupActionListeners();

        ativa(true, this.telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroProduto.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroProduto.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaProduto());
        telaCadastroProduto.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroProduto.getjButtonGravar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroProduto.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroProduto.getjButtonSair().addActionListener(e -> fecharTelaCadastroProduto());
    }

    private void abrirTelaBuscaProduto() {
        TelaBuscaProduto telaBuscaProduto = new TelaBuscaProduto(null, true);
        telaBuscaProduto.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroProduto.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroProduto.getjPanelCorpo());
    }

    private void fecharTelaCadastroProduto() {
        telaCadastroProduto.dispose();
    }
}
