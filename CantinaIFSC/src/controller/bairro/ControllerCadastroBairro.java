package controller.bairro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.bairro.TelaCadastroBairro;

public class ControllerCadastroBairro implements ActionListener {
    TelaCadastroBairro telaCadastroBairro;

    public ControllerCadastroBairro(TelaCadastroBairro telaCadastroBairro) {
        this.telaCadastroBairro = telaCadastroBairro;
        
        JButton[] botoes = {
            this.telaCadastroBairro.getjButtonBuscar(),
            this.telaCadastroBairro.getjButtonCancelar(),
            this.telaCadastroBairro.getjButtonGravar(),
            this.telaCadastroBairro.getjButtonNovo(),
            this.telaCadastroBairro.getjButtonSair()
        };

        for (JButton botao : botoes) {
            adicionarActionListener(botao);
        }
//
        utilies.Utilities.ativa(true, this.telaCadastroBairro.getjPanelBotoes());
        utilies.Utilities.limpaCompenentes(false, this.telaCadastroBairro.getjPanelCorpo());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private void adicionarActionListener(JButton button) {
        button.addActionListener(this);
    }
    
}
