package controller.fornecedor;

import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaCadastroEndereco;
import view.fornecedor.TelaBuscaFornecedor;
import view.fornecedor.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor {
    TelaCadastroFornecedor telaCadastroFornecedor;

    public ControllerCadastroFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;

        setupActionListeners();

        ativa(true, this.telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroFornecedor.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroFornecedor.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaFornecedor());
        telaCadastroFornecedor.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroFornecedor.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroFornecedor.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroFornecedor.getjButtonSair().addActionListener(e -> fecharTelaCadastroFornecedor());
        telaCadastroFornecedor.getjButtonAdd().addActionListener(e -> abrirTelaCadastroEndereco());
    }

    private void abrirTelaBuscaFornecedor() {
        TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(null, true);
        ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
        telaBuscaFornecedor.setVisible(true);
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroFornecedor.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroFornecedor.getjPanelCorpo());
    }

    private void fecharTelaCadastroFornecedor() {
        telaCadastroFornecedor.dispose();
    }
    
    private void abrirTelaCadastroEndereco(){
        TelaCadastroEndereco cadastroEndereco = new TelaCadastroEndereco(null, true);
        cadastroEndereco.setVisible(true);
    }

    private void realizarAcaoGravar() {
        ativa(true, telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroFornecedor.getjPanelCorpo());       }
    
}
