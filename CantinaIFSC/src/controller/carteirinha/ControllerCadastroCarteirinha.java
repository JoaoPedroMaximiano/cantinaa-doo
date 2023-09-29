package controller.carteirinha;

import model.bo.Carteirinha;
import model.bo.Cliente;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.carteirinha.TelaBuscaCarteirinha;
import view.carteirinha.TelaCadastroCarteirinha;

public class ControllerCadastroCarteirinha {
    TelaCadastroCarteirinha telaCadastroCarteirinha;
    public static int codigo;

    public ControllerCadastroCarteirinha(TelaCadastroCarteirinha telaCadastroCarteirinha) {
        this.telaCadastroCarteirinha = telaCadastroCarteirinha;

        setupActionListeners();

        for (Cliente cliente : model.dao.Persiste.getInstancia().listaCliente) {
            this.telaCadastroCarteirinha.getjComboBoxCliente().addItem(cliente.getCpf());
        }
        
        ativa(true, this.telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroCarteirinha.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroCarteirinha.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaCarteirinha());
        telaCadastroCarteirinha.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCarteirinha.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroCarteirinha.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCarteirinha.getjButtonSair().addActionListener(e -> fecharTelaCadastroCarteirinha());
    }

    private void abrirTelaBuscaCarteirinha() {
        
        codigo = 0;
        TelaBuscaCarteirinha telaBuscaCarteirinha = new TelaBuscaCarteirinha(null, true);
        ControllerBuscaCarteirinha controllerBuscaCarteirinha = new ControllerBuscaCarteirinha(telaBuscaCarteirinha);
        telaBuscaCarteirinha.setVisible(true);
        
        if (codigo != 0) {
            Carteirinha carteirinha = new Carteirinha();
            carteirinha = model.dao.Persiste.getInstancia().listaCarteirinha.get(codigo -1);
            
            ativa(false, this.telaCadastroCarteirinha.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroCarteirinha.getjPanelCorpo());
            this.telaCadastroCarteirinha.getjTextFieldID().setText(carteirinha.getId() + "");
            this.telaCadastroCarteirinha.getjComboBoxCliente().setSelectedItem(carteirinha.getCliente().getCpf());
            this.telaCadastroCarteirinha.getjTextFieldCodigoBarra().setText(carteirinha.getCodigoBarra());
            this.telaCadastroCarteirinha.getjFormattedTextFieldDataGeracao().setText(carteirinha.getDataCancelamento());
            this.telaCadastroCarteirinha.getjFormattedTextFieldDataCancelamento().setText(carteirinha.getDataGeracao());
            this.telaCadastroCarteirinha.getjTextFieldID().setEnabled(false);
        }
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCarteirinha.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroCarteirinha.getjPanelCorpo());
    }

    private void fecharTelaCadastroCarteirinha() {
        telaCadastroCarteirinha.dispose();
    }

    private void realizarAcaoGravar() {
        Carteirinha carteirinha = new Carteirinha();
        carteirinha.setId(model.dao.Persiste.getInstancia().listaCarteirinha.size() + 1);
        carteirinha.setDataGeracao(this.telaCadastroCarteirinha.getjFormattedTextFieldDataGeracao().getText());
        
        if (!this.telaCadastroCarteirinha.getjFormattedTextFieldDataCancelamento().getText().equals("  /  /    ")) {
            carteirinha.setDataCancelamento(this.telaCadastroCarteirinha.getjFormattedTextFieldDataCancelamento().getText());
        }
        
        carteirinha.setCodigoBarra(this.telaCadastroCarteirinha.getjTextFieldCodigoBarra().getText());
        for (Cliente cliente : model.dao.Persiste.getInstancia().listaCliente) {
            if (cliente.getCpf().equals(this.telaCadastroCarteirinha.getjComboBoxCliente().getSelectedItem().toString())) {
                carteirinha.setCliente(cliente);
            }
        }
        
        model.dao.Persiste.getInstancia().listaCarteirinha.add(carteirinha);
        ativa(true, telaCadastroCarteirinha.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCarteirinha.getjPanelCorpo());   
    }
}
