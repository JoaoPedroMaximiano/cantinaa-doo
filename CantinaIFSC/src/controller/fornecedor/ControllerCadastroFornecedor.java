package controller.fornecedor;
import controller.endereco.ControllerCadastroEndereco;
import javax.swing.JOptionPane;
import model.bo.Endereco;
import model.bo.Fornecedor;
import service.EnderecoService;
import service.FornecedorService;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.endereco.TelaCadastroEndereco;
import view.fornecedor.TelaBuscaFornecedor;
import view.fornecedor.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor {

    static int codigo;
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
        telaCadastroFornecedor.getjButtonSearch().addActionListener(e -> abrirTelaBuscarCepEndereco());
    }

    private void abrirTelaBuscaFornecedor() {
                
        codigo = 0;
        
        TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(null, true);
        ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
        telaBuscaFornecedor.setVisible(true);

        if (codigo != 0) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor = new FornecedorService().carregar(codigo);
            ativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroFornecedor.getjPanelCorpo());
            
            String status = String.valueOf(fornecedor.getStatus());
            this.telaCadastroFornecedor.getjTextFieldID().setText(fornecedor.getId() + "");
            this.telaCadastroFornecedor.getjFormattedTextFieldCEP().setText(fornecedor.getEndereco().getCep());
            this.telaCadastroFornecedor.getjFormattedTextFieldCNPJ().setText(fornecedor.getCnpj());
            this.telaCadastroFornecedor.getjFormattedTextFieldTelefone1().setText(fornecedor.getFone1());
            this.telaCadastroFornecedor.getjFormattedTextFieldTelefone2().setText(fornecedor.getFone2());
            this.telaCadastroFornecedor.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" : (status.equals("2") ? "Desativado" : "Pendente")
            );
            this.telaCadastroFornecedor.getjTextFieldBairro().setText(fornecedor.getEndereco().getBairro().getDescricao());
            this.telaCadastroFornecedor.getjTextFieldCidade().setText(fornecedor.getEndereco().getCidade().getDescricao());
            this.telaCadastroFornecedor.getjTextFieldComplementoEndereco().setText(fornecedor.getComplementoEndereco());
            this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().setText(fornecedor.getInscricaoEstadual());
            this.telaCadastroFornecedor.getjTextFieldLogradouro().setText(fornecedor.getEndereco().getLogradouro());
            this.telaCadastroFornecedor.getjTextFieldNome().setText(fornecedor.getNome());
            this.telaCadastroFornecedor.getjTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial());
            this.telaCadastroFornecedor.getjTextEmail().setText(fornecedor.getEmail());
            this.telaCadastroFornecedor.getjTextFieldID().setEnabled(false);
        }
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
        TelaCadastroEndereco telacadastroEndereco = new TelaCadastroEndereco(null, true);
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(telacadastroEndereco);
        telacadastroEndereco.setVisible(true);
    }

    private void realizarAcaoGravar() {
        Fornecedor fornecedor  = new Fornecedor();

        if (this.telaCadastroFornecedor.getjTextFieldNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo nome é obrigatório!");
            return;
        }
        fornecedor.setNome(this.telaCadastroFornecedor.getjTextFieldNome().getText());

        if ("  .   .   /    -  ".equals(this.telaCadastroFornecedor.getjFormattedTextFieldCNPJ().getText())) {
            JOptionPane.showMessageDialog(null, "Campo CNPJ é obrigatório!");
            return;
        }
        fornecedor.setCnpj(this.telaCadastroFornecedor.getjFormattedTextFieldCNPJ().getText());

        if (this.telaCadastroFornecedor.getjTextFieldRazaoSocial().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo razão social é obrigatório!");
            return;
        }
        fornecedor.setRazaoSocial(this.telaCadastroFornecedor.getjTextFieldRazaoSocial().getText());

        if (this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo inscrição estadual é obrigatório!");
            return;
        }
        fornecedor.setInscricaoEstadual(this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().getText());

        if ("(  )      -    ".equals(this.telaCadastroFornecedor.getjFormattedTextFieldTelefone1().getText())) {
            JOptionPane.showMessageDialog(null, "Campo Telefone é obrigatório!");
            return;
        }
        fornecedor.setFone1(this.telaCadastroFornecedor.getjFormattedTextFieldTelefone1().getText());
        fornecedor.setFone2(this.telaCadastroFornecedor.getjFormattedTextFieldTelefone2().getText());

        if (this.telaCadastroFornecedor.getjTextEmail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo e-mail é obrigatório!");
            return;
        }
        fornecedor.setEmail(this.telaCadastroFornecedor.getjTextEmail().getText());

        if (this.telaCadastroFornecedor.getjTextFieldComplementoEndereco().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo complemento endereço é obrigatório!");
            return;
        }
        fornecedor.setComplementoEndereco(this.telaCadastroFornecedor.getjTextFieldComplementoEndereco().getText());

        if (this.telaCadastroFornecedor.getjComboBoxStatus().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Campo Status é obrigatório!");
            return;
        }
        String status = this.telaCadastroFornecedor.getjComboBoxStatus().getSelectedItem().toString();
        fornecedor.setStatus(status == "Ativo" ? '1' : (status == "Desativado" ? '2' : '3'));

        if ("     -   ".equals(this.telaCadastroFornecedor.getjFormattedTextFieldCEP().getText())) {
            JOptionPane.showMessageDialog(null, "Campo CEP é obrigatório!");
            return;
        }
        fornecedor.setEndereco(new EnderecoService().carregar(new Endereco(this.telaCadastroFornecedor.getjFormattedTextFieldCEP().getText())).get(0));

        if (this.telaCadastroFornecedor.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
            new service.FornecedorService().adicionar(fornecedor);
        } else {
            fornecedor.setId(Integer.parseInt(this.telaCadastroFornecedor.getjTextFieldID().getText()));
            new service.FornecedorService().atualizar(fornecedor);
        }        

        ativa(true, telaCadastroFornecedor.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroFornecedor.getjPanelCorpo());
    }

    private void abrirTelaBuscarCepEndereco() {
        Endereco endereco = new EnderecoService().carregar(new Endereco(this.telaCadastroFornecedor.getjFormattedTextFieldCEP().getText())).get(0);
        this.telaCadastroFornecedor.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
        this.telaCadastroFornecedor.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
        this.telaCadastroFornecedor.getjTextFieldLogradouro().setText(endereco.getLogradouro());
    }

    
}
