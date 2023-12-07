package controller.cliente;
import controller.endereco.ControllerCadastroEndereco;
import javax.swing.JOptionPane;
import model.bo.Cliente;
import model.bo.Endereco;
import service.ClienteService;
import service.EnderecoService;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.cliente.TelaBuscaCliente;
import view.cliente.TelaCadastroCliente;
import view.endereco.TelaCadastroEndereco;

public class ControllerCadastroCliente {

    static int codigo;
    TelaCadastroCliente telaCadastroCliente;

    public ControllerCadastroCliente(TelaCadastroCliente telaCadastroCliente) {
        this.telaCadastroCliente = telaCadastroCliente;

        setupActionListeners();

        ativa(true, this.telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroCliente.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroCliente.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaCliente());
        telaCadastroCliente.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroCliente.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroCliente.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroCliente.getjButtonSair().addActionListener(e -> fecharTelaCadastroCliente());
        telaCadastroCliente.getjButtonAdd().addActionListener(e -> abrirTelaCadastroEndereco());
        telaCadastroCliente.getjButtonSearch().addActionListener(e -> abrirTelaBuscaEndereco());
    }

    private void abrirTelaBuscaCliente() {
        
        codigo = 0;
        
        TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente(null, true);
        ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(telaBuscaCliente);
        telaBuscaCliente.setVisible(true);
        if (codigo != 0) {
            Cliente cliente = new Cliente();
            cliente = new ClienteService().carregar(codigo);
            ativa(false, this.telaCadastroCliente.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroCliente.getjPanelCorpo());

            String status = String.valueOf(cliente.getStatus());
            this.telaCadastroCliente.getjTextFieldID().setText(cliente.getId() + "");
            this.telaCadastroCliente.getjFormattedTextFieldCEP().setText(cliente.getEndereco().getCep());
            this.telaCadastroCliente.getjFormattedTextFieldCPF().setText(cliente.getCpf());
            this.telaCadastroCliente.getjFormattedTextFieldDataNascimento().setText(cliente.getDataNascimento());
            this.telaCadastroCliente.getjFormattedTextFieldMatricula().setText(cliente.getMatricula());
            this.telaCadastroCliente.getjFormattedTextFieldRG().setText(cliente.getRg());
            this.telaCadastroCliente.getjFormattedTextFieldTelefone1().setText(cliente.getFone1());
            this.telaCadastroCliente.getjFormattedTextFieldTelefone2().setText(cliente.getFone2());
            this.telaCadastroCliente.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" : (status.equals("2") ? "Desativado" : "Pendente")
            );
            this.telaCadastroCliente.getjTextEmail().setText(cliente.getEmail());
            this.telaCadastroCliente.getjTextFieldBairro().setText(cliente.getEndereco().getBairro().getDescricao());
            this.telaCadastroCliente.getjTextFieldCidade().setText(cliente.getEndereco().getCidade().getDescricao());
            this.telaCadastroCliente.getjTextFieldComplementoEndereco().setText(cliente.getComplementoEndereco());
            this.telaCadastroCliente.getjTextFieldLogradouro().setText(cliente.getEndereco().getLogradouro());
            this.telaCadastroCliente.getjTextFieldNome().setText(cliente.getNome());
            this.telaCadastroCliente.getjTextFieldID().setEnabled(false);
        }
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCliente.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroCliente.getjPanelCorpo());
    }

    private void fecharTelaCadastroCliente() {
        telaCadastroCliente.dispose();
    }
    
    private void abrirTelaCadastroEndereco(){
        TelaCadastroEndereco telaCadastroEndereco = new TelaCadastroEndereco(null, true);
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(telaCadastroEndereco);
        telaCadastroEndereco.setVisible(true);      
    }
    
    private void realizarAcaoGravar() {
        Cliente cliente = new Cliente();
        if (this.telaCadastroCliente.getjTextFieldNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo nome é obrigatório!");
            return;
        }
        cliente.setNome(this.telaCadastroCliente.getjTextFieldNome().getText());

        if (this.telaCadastroCliente.getjFormattedTextFieldCPF().getText() == "   .   .   -  ") {
            JOptionPane.showMessageDialog(null, "Campo CPF é obrigatório!");
            return;
        }
        cliente.setCpf(this.telaCadastroCliente.getjFormattedTextFieldCPF().getText());

        if (this.telaCadastroCliente.getjFormattedTextFieldRG().getText() == "         ") {
            JOptionPane.showMessageDialog(null, "Campo RG é obrigatório!");
            return;
        }
        cliente.setRg(this.telaCadastroCliente.getjFormattedTextFieldRG().getText());

        if (this.telaCadastroCliente.getjFormattedTextFieldMatricula().getText() == "            ") {
            JOptionPane.showMessageDialog(null, "Campo matrícula é obrigatório!");
            return;
        }
        cliente.setMatricula(this.telaCadastroCliente.getjFormattedTextFieldMatricula().getText());

        if (this.telaCadastroCliente.getjFormattedTextFieldDataNascimento().getText() == "  /  /    ") {
            JOptionPane.showMessageDialog(null, "Campo data de nascimento é obrigatório!");
            return;
        }
        cliente.setDataNascimento(this.telaCadastroCliente.getjFormattedTextFieldDataNascimento().getText());

        if (this.telaCadastroCliente.getjFormattedTextFieldTelefone1().getText() == "(  )      -    ") {
            JOptionPane.showMessageDialog(null, "Campo Telefone é obrigatório!");
            return;
        }
        cliente.setFone1(this.telaCadastroCliente.getjFormattedTextFieldTelefone1().getText());
        cliente.setFone2(this.telaCadastroCliente.getjFormattedTextFieldTelefone2().getText());

        if (this.telaCadastroCliente.getjTextEmail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo e-mail é obrigatório!");
            return;
        }
        cliente.setEmail(this.telaCadastroCliente.getjTextEmail().getText());

        if (this.telaCadastroCliente.getjTextFieldComplementoEndereco().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo complemento endereço é obrigatório!");
            return;
        }
        cliente.setComplementoEndereco(this.telaCadastroCliente.getjTextFieldComplementoEndereco().getText());

        if (this.telaCadastroCliente.getjComboBoxStatus().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Campo Status é obrigatório!");
            return;
        }
        String status = this.telaCadastroCliente.getjComboBoxStatus().getSelectedItem().toString();
        cliente.setStatus(status.equals("Ativo") ? '1' : (status.equals("Desativado") ? '2' : '3'));

        if (this.telaCadastroCliente.getjFormattedTextFieldCEP().getText() == "     -   ") {
            JOptionPane.showMessageDialog(null, "Campo CEP é obrigatório!");
            return;
        }
        cliente.setEndereco(new EnderecoService().carregar(new Endereco(this.telaCadastroCliente.getjFormattedTextFieldCEP().getText())).get(0));

        if (this.telaCadastroCliente.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
            new service.ClienteService().adicionar(cliente);
        } else {
            cliente.setId(Integer.parseInt(this.telaCadastroCliente.getjTextFieldID().getText()));
            new service.ClienteService().atualizar(cliente);
        }
        ativa(true, telaCadastroCliente.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroCliente.getjPanelCorpo());
    }

    private void abrirTelaBuscaEndereco() {
        Endereco endereco = new EnderecoService().carregar(new Endereco(this.telaCadastroCliente.getjFormattedTextFieldCEP().getText())).get(0);
        this.telaCadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
        this.telaCadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
        this.telaCadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
    }
}
