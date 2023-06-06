package controller.cidade;

import model.bo.Cidade;
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
        telaCadastroCidade.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroCidade.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCidade.getjButtonSair().addActionListener(e -> fecharTelaCadastroCidade());
    }

    private void abrirTelaBuscaCidade() {
        TelaBuscaCidade telaBuscaCidade = new TelaBuscaCidade(null, true);
        ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(telaBuscaCidade);
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

    private void realizarAcaoGravar() {
        Cidade cidade = new Cidade();
        cidade.setId(model.dao.Persiste.getInstancia().listaCidade.size() + 1);
        cidade.setDescricao(this.telaCadastroCidade.getjTextFieldDescricao().getText());
        cidade.setUf(this.telaCadastroCidade.getjComboBoxUF().getSelectedItem().toString());
        model.dao.Persiste.getInstancia().listaCidade.add(cidade);
        ativa(true, telaCadastroCidade.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCidade.getjPanelCorpo());   
    }
}
