package controller.cliente;

import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
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
        for (Cliente cliente : model.dao.Persiste.getInstancia().listaCliente) {
            table.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getMatricula(),
                cliente.getEmail(),
                cliente.getFone1(),
                cliente.getStatus()
            });
        }
    }

    private void carregarFecharBuscaCliente() {
        this.telaBuscaCliente.dispose();
    }
}
