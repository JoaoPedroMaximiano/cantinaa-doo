package controller.caixa;

import model.bo.Caixa;
import model.bo.Funcionario;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.caixa.TelaBuscaCaixa;
import view.caixa.TelaCadastroCaixa;

public class ControllerCadastroCaixa {
    TelaCadastroCaixa telaCadastroCaixa;
    public static int codigo;

    public ControllerCadastroCaixa(TelaCadastroCaixa telaCadastroCaixa) {
        this.telaCadastroCaixa = telaCadastroCaixa;

        setupActionListeners();
        
        for (Funcionario funcionario : model.dao.Persiste.getInstancia().listaFuncionario) {
            this.telaCadastroCaixa.getjComboBoxFuncionario().addItem(funcionario.getCpf());
        }

        ativa(true, this.telaCadastroCaixa.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroCaixa.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroCaixa.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaCaixa());
        telaCadastroCaixa.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCaixa.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroCaixa.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCaixa.getjButtonSair().addActionListener(e -> fecharTelaCadastroCaixa());
    }

    private void abrirTelaBuscaCaixa() {
        
        codigo = 0;
        TelaBuscaCaixa telaBuscaCaixa = new TelaBuscaCaixa(null, true);
        ControllerBuscaCaixa controllerBuscaCaixa = new ControllerBuscaCaixa(telaBuscaCaixa);
        telaBuscaCaixa.setVisible(true);
        
        if (codigo != 0) {
            Caixa caixa = new Caixa();
            caixa = model.dao.Persiste.getInstancia().listaCaixa.get(codigo -1);
            
            ativa(false, this.telaCadastroCaixa.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroCaixa.getjPanelCorpo());
            
            String status = String.valueOf(caixa.getStatus());
            this.telaCadastroCaixa.getjTextFieldID().setText(caixa.getId() + "");
            this.telaCadastroCaixa.getjComboBoxStatus().setSelectedItem(
            status.equals("1") ? "Aberto" : (status.equals("2") ? "Fechado" : (status.equals("3") ? "Cancelado" : "Pendente"))
            );
            this.telaCadastroCaixa.getjComboBoxFuncionario().setSelectedItem(caixa.getFuncionario().getCpf());
            this.telaCadastroCaixa.getjFormattedTextFieldDataAbertura().setText(caixa.getDataHoraAberto());
            this.telaCadastroCaixa.getjFormattedTextFieldDataFechamento().setText(caixa.getDataHoraFechamento());
            this.telaCadastroCaixa.getjFormattedTextFieldValorAbertura().setText(String.valueOf(caixa.getValorAbertura()));
            this.telaCadastroCaixa.getjFormattedTextFieldValorFechamento().setText(String.valueOf(caixa.getValorFechamento()));
            this.telaCadastroCaixa.getjTextAreaObservacao().setText(caixa.getObservacao());
            this.telaCadastroCaixa.getjTextFieldID().setEnabled(false);
        }
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroCaixa.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCaixa.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroCaixa.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroCaixa.getjPanelCorpo());
        this.telaCadastroCaixa.getjTextFieldID().setEnabled(false);
    }

    private void fecharTelaCadastroCaixa() {
        telaCadastroCaixa.dispose();
    }

    private void realizarAcaoGravar() {
        Caixa caixa = new Caixa();
        caixa.setId(model.dao.Persiste.getInstancia().listaCaixa.size() + 1);
        
        String status = this.telaCadastroCaixa.getjComboBoxStatus().getSelectedItem().toString();
        caixa.setStatus(status.equals("Aberto") ? '1' : (status.equals("Fechado") ? '2' : (status.equals("Cancelado") ? '3' : '4')));
        
        caixa.setObservacao(this.telaCadastroCaixa.getjTextAreaObservacao().getText());
        caixa.setValorAbertura(Double.parseDouble(this.telaCadastroCaixa.getjFormattedTextFieldValorAbertura().getText().replace(',', '.')));
        caixa.setDataHoraAberto(this.telaCadastroCaixa.getjFormattedTextFieldDataAbertura().getText());
        
        for (Funcionario funcionario : model.dao.Persiste.getInstancia().listaFuncionario) {
            if (funcionario.getCpf().equals(this.telaCadastroCaixa.getjComboBoxFuncionario().getSelectedItem().toString())) {
                caixa.setFuncionario(funcionario);
            }
        }
        
        if (!this.telaCadastroCaixa.getjFormattedTextFieldValorFechamento().getText().equals("")) {
            caixa.setValorFechamento(Double.parseDouble(this.telaCadastroCaixa.getjFormattedTextFieldValorFechamento().getText().replace(',', '.')));
        }
        
        if (!this.telaCadastroCaixa.getjFormattedTextFieldDataFechamento().getText().equals("  /  /       :  :  ")) {
            caixa.setDataHoraFechamento(this.telaCadastroCaixa.getjFormattedTextFieldDataFechamento().getText());
        }
        
        model.dao.Persiste.getInstancia().listaCaixa.add(caixa);
        ativa(true, telaCadastroCaixa.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCaixa.getjPanelCorpo());   
    }
}
