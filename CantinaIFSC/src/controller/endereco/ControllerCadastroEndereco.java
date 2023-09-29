package controller.endereco;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
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
        for (Cidade cidade : model.dao.Persiste.getInstancia().listaCidade) {
            this.telaCadastroEndereco.getjComboBoxCidade().addItem(cidade.getDescricao());
        }
        for (Bairro bairro : model.dao.Persiste.getInstancia().listaBairro) {
            this.telaCadastroEndereco.getjComboBoxBairro().addItem(bairro.getDescricao());
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
            this.telaCadastroEndereco.getjComboBoxBairro().setSelectedItem(endereco.getBairro().getDescricao());
            this.telaCadastroEndereco.getjComboBoxCidade().setSelectedItem(endereco.getCidade().getDescricao());
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
        endereco.setId(model.dao.Persiste.getInstancia().listaEndereco.size() + 1);
        endereco.setCep(this.telaCadastroEndereco.getjFormattedTextFieldCEP().getText());
        endereco.setLogradouro(this.telaCadastroEndereco.getjFormattedTextFieldLogradouro().getText());
        for (Bairro bairro : model.dao.Persiste.getInstancia().listaBairro) {
            if (bairro.getDescricao().equals(this.telaCadastroEndereco.getjComboBoxBairro().getSelectedItem().toString())) {
                endereco.setBairro(bairro);
            }
        }
        
        for (Cidade cidade : model.dao.Persiste.getInstancia().listaCidade) {
            if (cidade.getDescricao().equals(this.telaCadastroEndereco.getjComboBoxCidade().getSelectedItem().toString())) {
                endereco.setCidade(cidade);
            }
        }
        String item = this.telaCadastroEndereco.getjComboBoxStatus().getSelectedItem().toString();
        endereco.setStatus(item.equals("Ativo") ? '1' : (item.equals("Desativado") ? '2' : '3'));
        
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
