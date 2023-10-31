package controller.cliente;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import service.ClienteService;
import view.cliente.TelaBuscaCliente;

public class ControllerBuscaCliente {
    TelaBuscaCliente telaBuscaCliente;

    public ControllerBuscaCliente(TelaBuscaCliente telaBuscaCliente) {
        this.telaBuscaCliente = telaBuscaCliente;

        filtrarPesquisa();
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

        filtro.setNome(this.telaBuscaCliente.getjTextFieldNome().getText());

        filtro.setCpf(this.telaBuscaCliente.getjFormattedTextFieldCPF().getText().trim().equals(".   .   -") ? "" : this.telaBuscaCliente.getjFormattedTextFieldCPF().getText());
        filtro.setDataNascimento(this.telaBuscaCliente.getjFormattedTextFieldDataNascimento().getText().trim().equals("/  /") ? "" : this.telaBuscaCliente.getjFormattedTextFieldDataNascimento().getText());
        
        filtro.setMatricula(this.telaBuscaCliente.getjFormattedTextFieldMatricula().getText().trim().equals("") ? "" : this.telaBuscaCliente.getjFormattedTextFieldMatricula().getText());
        filtro.setRg(this.telaBuscaCliente.getjFormattedTextFieldRG().getText().trim().equals("") ? "" : this.telaBuscaCliente.getjFormattedTextFieldRG().getText());


        List<Cliente> clientes = !filtro.getCpf().equals("")
        || !filtro.getDataNascimento().isEmpty()
        || !filtro.getNome().equals("")
        || !filtro.getRg().equals("")
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
