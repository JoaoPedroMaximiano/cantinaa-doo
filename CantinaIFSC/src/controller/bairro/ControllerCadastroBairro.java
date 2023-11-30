package controller.bairro;

import model.bo.Bairro;
import service.BairroService;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.bairro.TelaBuscaBairro;
import view.bairro.TelaCadastroBairro;

public class ControllerCadastroBairro {
    TelaCadastroBairro telaCadastroBairro;
    public static int codigo;

    public ControllerCadastroBairro(TelaCadastroBairro telaCadastroBairro) {
        this.telaCadastroBairro = telaCadastroBairro;

        setupActionListeners();

        ativa(true, this.telaCadastroBairro.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroBairro.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroBairro.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaBairro());
        telaCadastroBairro.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroBairro.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroBairro.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroBairro.getjButtonSair().addActionListener(e -> fecharTelaCadastroBairro());
    }

    private void abrirTelaBuscaBairro() {
        
        codigo = 0;
        
        TelaBuscaBairro telaBuscaBairro = new TelaBuscaBairro(null, true);
        ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(telaBuscaBairro);
        telaBuscaBairro.setVisible(true);
        
        if (codigo != 0) {
            Bairro bairro = new Bairro();
            bairro = BairroService.carregar(codigo);
            ativa(false, this.telaCadastroBairro.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroBairro.getjPanelCorpo());
            
            this.telaCadastroBairro.getjTextFieldID().setText(bairro.getId() + "");
            this.telaCadastroBairro.getjTextFieldDescricao().setText(bairro.getDescricao());
            this.telaCadastroBairro.getjTextFieldID().setEnabled(false);
        }
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroBairro.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroBairro.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroBairro.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroBairro.getjPanelCorpo());
        this.telaCadastroBairro.getjTextFieldID().setEnabled(false);
    }

    private void fecharTelaCadastroBairro() {
        telaCadastroBairro.dispose();
    }

    private void realizarAcaoGravar() {
        
        Bairro bairro = new Bairro();
        bairro.setDescricao(this.telaCadastroBairro.getjTextFieldDescricao().getText());
        if (this.telaCadastroBairro.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
            new service.BairroService().adicionar(bairro);
        } else {
            bairro.setId(Integer.parseInt(this.telaCadastroBairro.getjTextFieldID().getText()));
            new service.BairroService().atualizar(bairro);
        }
        ativa(true, telaCadastroBairro.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroBairro.getjPanelCorpo());
    }
}
