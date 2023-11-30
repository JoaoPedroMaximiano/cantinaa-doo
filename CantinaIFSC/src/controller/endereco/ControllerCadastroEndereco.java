package controller.endereco;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import service.BairroService;
import service.CidadeService;
import service.EnderecoService;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaBuscaEndereco;
import view.endereco.TelaCadastroEndereco;

public class ControllerCadastroEndereco {

    static int codigo;
    TelaCadastroEndereco telaCadastroEndereco;

    public ControllerCadastroEndereco(TelaCadastroEndereco telaCadastroEndereco) {
        this.telaCadastroEndereco = telaCadastroEndereco;

        setupActionListeners();
        for (Cidade cidade : new CidadeService().carregar()) {
            this.telaCadastroEndereco.getjComboBoxCidade().addItem(cidade.toString());
        }
        for (Bairro bairro : new BairroService().carregar()) {
            this.telaCadastroEndereco.getjComboBoxBairro().addItem(bairro.toString());
        }        
        
        ativa(true, this.telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroEndereco.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroEndereco.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaEndereco());
        telaCadastroEndereco.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroEndereco.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroEndereco.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroEndereco.getjButtonSair().addActionListener(e -> fecharTelaCadastroEndereco());
    }

    private void abrirTelaBuscaEndereco() {
        
        codigo = 0;
        
        TelaBuscaEndereco telaBuscaEndereco = new TelaBuscaEndereco(null, true);
        ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(telaBuscaEndereco);
        telaBuscaEndereco.setVisible(true);
        
        if (codigo != 0) {
            Endereco endereco = new Endereco();
            endereco = new EnderecoService().carregar(codigo);
            
            ativa(false, this.telaCadastroEndereco.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroEndereco.getjPanelCorpo());
            
            String status = String.valueOf(endereco.getStatus());
            this.telaCadastroEndereco.getjTextFieldID().setText(endereco.getId() + "");
            this.telaCadastroEndereco.getjFormattedTextFieldLogradouro().setText(endereco.getLogradouro());
            this.telaCadastroEndereco.getjComboBoxBairro().setSelectedItem(endereco.getBairro().toString());
            this.telaCadastroEndereco.getjComboBoxCidade().setSelectedItem(endereco.getCidade().toString());
            this.telaCadastroEndereco.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" : (status.equals("2") ? "Desativado" : "Pendente")
            );
            this.telaCadastroEndereco.getjFormattedTextFieldCEP().setText(endereco.getCep());
            this.telaCadastroEndereco.getjTextFieldID().setEnabled(false);
        }
        
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroEndereco.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroEndereco.getjPanelCorpo());
    }

    private void fecharTelaCadastroEndereco() {
        telaCadastroEndereco.dispose();
    }

    private void realizarAcaoGravar() {
        Endereco endereco = new Endereco();

        if (this.telaCadastroEndereco.getjFormattedTextFieldCEP().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo CEP é obrigatório!");
            return;
        }
        endereco.setCep(this.telaCadastroEndereco.getjFormattedTextFieldCEP().getText());
        if (this.telaCadastroEndereco.getjFormattedTextFieldLogradouro().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Logradouro é obrigatório!");
            return;
        }
        endereco.setLogradouro(this.telaCadastroEndereco.getjFormattedTextFieldLogradouro().getText());
        if (this.telaCadastroEndereco.getjComboBoxBairro().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Campo Bairro é obrigatório!");
            return;
        }
        endereco.setBairro(new BairroService().carregar(Integer.parseInt(this.telaCadastroEndereco.getjComboBoxBairro().getSelectedItem().toString().split(" - ")[0])));
        if (this.telaCadastroEndereco.getjComboBoxCidade().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Campo Cidade é obrigatório!");
            return;
        }
        endereco.setCidade(new CidadeService().carregar(Integer.parseInt(this.telaCadastroEndereco.getjComboBoxCidade().getSelectedItem().toString().split(" - ")[0])));
        if (this.telaCadastroEndereco.getjComboBoxStatus().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Campo Status é obrigatório!");
            return;
        }
        String status = this.telaCadastroEndereco.getjComboBoxStatus().getSelectedItem().toString();
        endereco.setStatus(status.equals("Ativo") ? '1' : (status.equals("Desativado") ? '2' : '3'));

        if (this.telaCadastroEndereco.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
            new service.EnderecoService().adicionar(endereco);
        } else {
            endereco.setId(Integer.parseInt(this.telaCadastroEndereco.getjTextFieldID().getText()));
            new service.EnderecoService().atualizar(endereco);
        }

        ativa(true, telaCadastroEndereco.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroEndereco.getjPanelCorpo());   
    }
}
