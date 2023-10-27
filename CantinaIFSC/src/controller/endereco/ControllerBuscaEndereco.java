package controller.endereco;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import service.BairroService;
import service.CidadeService;
import service.EnderecoService;
import view.endereco.TelaBuscaEndereco;

public class ControllerBuscaEndereco {
    TelaBuscaEndereco telaBuscaEndereco;

    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco) {
        this.telaBuscaEndereco = telaBuscaEndereco;
        
        for (Cidade cidade : new CidadeService().carregar()) {
            this.telaBuscaEndereco.getjComboBoxCidade().addItem(cidade.toString());
        }
        for (Bairro bairro : new BairroService().carregar()) {
            this.telaBuscaEndereco.getjComboBoxBairro().addItem(bairro.toString());
        }  
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaEndereco.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaEndereco.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaEndereco.getjButtonSair().addActionListener(e -> fecharBuscaEndereco());

    }

    private void carregarDadosParaCadastro() {
        controller.endereco.ControllerCadastroEndereco.codigo = (int) this.telaBuscaEndereco.getjTable().getValueAt(this.telaBuscaEndereco.getjTable().getSelectedRow(), 0);
        this.telaBuscaEndereco.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaEndereco.getjTable().getModel();
        table.setRowCount(0);
        
        Endereco filtro = new Endereco();
        filtro.setBairro(new BairroService().carregar(telaBuscaEndereco.getjComboBoxBairro().getSelectedIndex()));
        filtro.setCidade(new CidadeService().carregar(telaBuscaEndereco.getjComboBoxCidade().getSelectedIndex()));
        filtro.setCep(telaBuscaEndereco.getjFormattedTextFieldCEP().getText());
        filtro.setLogradouro(telaBuscaEndereco.getjFormattedTextFieldLogradouro().getText());
        String item = this.telaBuscaEndereco.getjComboBoxStatus().getSelectedItem().toString();
        filtro.setStatus(item.equals("Ativo") ? '1' : (item.equals("Desativado") ? '2' : '3'));
        List<Endereco> enderecos = (filtro.getBairro() != null) || (filtro.getCidade() != null) || 
                (!filtro.getCep().equals("")) || (!filtro.getLogradouro().equals("")) ||
                (!Character.isDefined(filtro.getStatus()))
                ? EnderecoService.carregar(filtro) : EnderecoService.carregar();
        
        enderecos.forEach(endereco -> {
            table.addRow(new Object[]{
                endereco.getId(),
                endereco.getCep(),
                endereco.getCidade().getDescricao(),
                endereco.getBairro().getDescricao(),
                endereco.getLogradouro(),
                endereco.getStatus()
            });
        });
    }

    private void fecharBuscaEndereco() {
        this.telaBuscaEndereco.dispose();
    }
}
