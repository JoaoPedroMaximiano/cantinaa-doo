package controller.carteirinha;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Carteirinha;
import model.bo.Cliente;
import service.CarteirinhaService;
import service.ClienteService;
import view.carteirinha.TelaBuscaCarteirinha;

public class ControllerBuscaCarteirinha {


    TelaBuscaCarteirinha telaBuscaCarteirinha;

    public ControllerBuscaCarteirinha(TelaBuscaCarteirinha telaBuscaCarteirinha) {
        this.telaBuscaCarteirinha = telaBuscaCarteirinha;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaCarteirinha.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaCarteirinha.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaCarteirinha.getjButtonSair().addActionListener(e -> fecharTelaBuscaCarteirinha());

    }

    private void carregarDadosParaCadastro() {
        controller.carteirinha.ControllerCadastroCarteirinha.codigo = (int) this.telaBuscaCarteirinha.getjTable().getValueAt(this.telaBuscaCarteirinha.getjTable().getSelectedRow(), 0);
        this.telaBuscaCarteirinha.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCarteirinha.getjTable().getModel();
        table.setRowCount(0);
        
        Carteirinha filtro = new Carteirinha();
        filtro.setCodigoBarra(this.telaBuscaCarteirinha.getjTextFieldCodigoBarra().toString());
        filtro.setDataCancelamento(this.telaBuscaCarteirinha.getjFormattedTextFieldDataCancelamento().toString());
        filtro.setDataGeracao(this.telaBuscaCarteirinha.getjFormattedTextFieldDataGeracao().toString());
        Cliente cliente = new Cliente();
        if (!this.telaBuscaCarteirinha.getjComboBoxCliente().getSelectedItem().toString().equals("")) {
            cliente.setNome(this.telaBuscaCarteirinha.getjComboBoxCliente().getSelectedItem().toString());
            List<Cliente> clientes = new ClienteService().carregar(cliente);
            filtro.setCliente(clientes.get(0));
        }

        List<Carteirinha> carteirinhas = !filtro.getCodigoBarra().equals("") || 
                !filtro.getCliente().getNome().equals("") || !filtro.getDataCancelamento().equals("  /  /       :  :  ")
                || !filtro.getDataGeracao().equals("  /  /       :  :  ") 
                ? new CarteirinhaService().carregar(filtro) 
                : new CarteirinhaService().carregar() ;
        
        for (Carteirinha carteirinha : carteirinhas) {
            table.addRow(new Object[]{
                carteirinha.getId(),
                carteirinha.getCodigoBarra(),
                carteirinha.getDataGeracao(),
                carteirinha.getCliente().getNome(),
                carteirinha.getDataCancelamento()
            });
        }
    }    

    private void fecharTelaBuscaCarteirinha() {
        this.telaBuscaCarteirinha.dispose();
    }
    
}
