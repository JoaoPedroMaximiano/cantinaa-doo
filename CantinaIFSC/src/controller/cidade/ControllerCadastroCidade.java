package controller.cidade;

import model.bo.Cidade;
import service.CidadeService;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.cidade.TelaBuscaCidade;
import view.cidade.TelaCadastroCidade;

public class ControllerCadastroCidade {

    static int codigo;
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
        
        codigo = 0;
        
        TelaBuscaCidade telaBuscaCidade = new TelaBuscaCidade(null, true);
        ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(telaBuscaCidade);
        telaBuscaCidade.setVisible(true);
        
        if (codigo != 0) {
            Cidade cidade = new Cidade();
            cidade = new CidadeService().carregar(codigo);
            ativa(false, this.telaCadastroCidade.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroCidade.getjPanelCorpo());
            
            this.telaCadastroCidade.getjTextFieldID().setText(cidade.getId() + "");
            this.telaCadastroCidade.getjTextFieldDescricao().setText(cidade.getDescricao());
            this.telaCadastroCidade.getjComboBoxUF().setSelectedItem(cidade.getUf());
            this.telaCadastroCidade.getjTextFieldID().setEnabled(false);
        }
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
        
        cidade.setDescricao(this.telaCadastroCidade.getjTextFieldDescricao().getText());
        cidade.setUf(this.telaCadastroCidade.getjComboBoxUF().getSelectedItem().toString());
        if (this.telaCadastroCidade.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
            new service.CidadeService().adicionar(cidade);
        } else {
            cidade.setId(Integer.parseInt(this.telaCadastroCidade.getjTextFieldID().getText()));
            new service.CidadeService().atualizar(cidade);
        }
        ativa(true, telaCadastroCidade.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCidade.getjPanelCorpo());   
    }
}
