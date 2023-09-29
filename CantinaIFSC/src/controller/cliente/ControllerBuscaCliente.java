package controller.cliente;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Endereco;
import service.BairroService;
import service.CidadeService;
import service.ClienteService;
import service.EnderecoService;
import view.cliente.TelaBuscaCliente;

public class ControllerBuscaCliente {
    TelaBuscaCliente telaBuscaCliente;

    public ControllerBuscaCliente(TelaBuscaCliente telaBuscaCliente) {
        this.telaBuscaCliente = telaBuscaCliente;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaCliente.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaCliente.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaCliente.getjButtonSair().addActionListener(e -> carregarFecharBuscaCliente());

    }

    private void carregarDadosParaCadastro() {
        controller.cliente.ControllerCadastroCliente.codigo = (int) this.telaBuscaCliente.getjTable().getValueAt(this.telaBuscaCliente.getjTable().getSelectedRow(), 0);
        this.telaBuscaCliente.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCliente.getjTable().getModel();
        table.setRowCount(0);
        
        Cliente filtro = new Cliente();
        filtro.setComplementoEndereco(this.telaBuscaCliente.getjTextFieldComplementoEndereco().getText());
        filtro.setCpf(this.telaBuscaCliente.getjFormattedTextFieldCPF().getText());
        filtro.setDataNascimento(this.telaBuscaCliente.getjFormattedTextFieldDataNascimento().getText());
        filtro.setEmail(this.telaBuscaCliente.getjTextEmail().getText());
        filtro.setFone1(this.telaBuscaCliente.getjFormattedTextFieldTelefone1().getText());
        filtro.setFone2(this.telaBuscaCliente.getjFormattedTextFieldTelefone2().getText());
        filtro.setMatricula(this.telaBuscaCliente.getjFormattedTextFieldMatricula().getText());
        filtro.setNome(this.telaBuscaCliente.getjTextFieldNome().getText());
        filtro.setRg(this.telaBuscaCliente.getjFormattedTextFieldRG().getText());
        String status = this.telaBuscaCliente.getjComboBoxStatus().getSelectedItem().toString();
        filtro.setStatus(status.equals("Ativo") ? '1' : (status.equals("Desativado") ? '2' : '3'));

        Endereco filtroEndereco = new Endereco();
        
        if (this.telaBuscaCliente.getjFormattedTextFieldCEP().getText().equals("")){
            filtroEndereco.setCep(this.telaBuscaCliente.getjFormattedTextFieldCEP().getText());
        }
        
        if (!telaBuscaCliente.getjTextFieldBairro().getText().equals("")) {
            Bairro bairro = new Bairro();
            bairro.setDescricao(telaBuscaCliente.getjTextFieldBairro().getText());
            filtroEndereco.setBairro(new BairroService().carregar(bairro).get(0));
        }
        
        if (!telaBuscaCliente.getjTextFieldCidade().getText().equals("")) {
            Cidade cidade = new Cidade();
            cidade.setDescricao(telaBuscaCliente.getjTextFieldCidade().getText());
            filtroEndereco.setCidade(new CidadeService().carregar(cidade).get(0));
        }
        filtro.setEndereco(EnderecoService.carregar(filtroEndereco).get(0));
        
        List<Cliente> clientes = !filtro.getComplementoEndereco().equals("") || 
        !filtro.getCpf().equals("") || 
        !filtro.getDataNascimento().equals("") || 
        !filtro.getEmail().equals("") || filtro.getEndereco() != null || 
        !filtro.getFone1().equals("") || !filtro.getFone2().equals("") || 
        !filtro.getMatricula().equals("") || !filtro.getNome().equals("") || 
        !filtro.getRg().equals("") || !Character.isDefined(filtro.getStatus())
        ? new ClienteService().carregar(filtro) 
        : new ClienteService().carregar();
        
        clientes.forEach(cliente -> {
            table.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getMatricula(),
                cliente.getEmail(),
                cliente.getFone1(),
                cliente.getStatus()
            });
        });
    }

    private void carregarFecharBuscaCliente() {
        this.telaBuscaCliente.dispose();
    }
}
