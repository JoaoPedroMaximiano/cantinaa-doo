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
            this.telaBuscaEndereco.getjComboBoxCidade().addItem(cidade.getDescricao());
        }
        for (Bairro bairro : new BairroService().carregar()) {
            this.telaBuscaEndereco.getjComboBoxBairro().addItem(bairro.getDescricao());
        }  
        filtrarPesquisa();
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
        
        if (!this.telaBuscaEndereco.getjComboBoxBairro().getSelectedItem().toString().equals("")) {
            Bairro bairro = new Bairro();
            bairro.setDescricao(this.telaBuscaEndereco.getjComboBoxBairro().getSelectedItem().toString());
            List<Bairro> bairros = new BairroService().carregar(bairro);
            filtro.setBairro(bairros.get(0));
        }
        
        if (!this.telaBuscaEndereco.getjComboBoxCidade().getSelectedItem().toString().equals("")) {
            Cidade cidade = new Cidade();
            cidade.setDescricao(this.telaBuscaEndereco.getjComboBoxCidade().getSelectedItem().toString());
            List<Cidade> cidades = new CidadeService().carregar(cidade);
            filtro.setCidade(cidades.get(0));
        }
        
        filtro.setCep(telaBuscaEndereco.getjFormattedTextFieldCEP().getText().trim().equals("-") ? null : telaBuscaEndereco.getjFormattedTextFieldCEP().getText());
        filtro.setLogradouro(telaBuscaEndereco.getjFormattedTextFieldLogradouro().getText());
        
        String status = this.telaBuscaEndereco.getjComboBoxStatus().getSelectedItem().toString();
        filtro.setStatus(status.equals("Ativo") ? '1' : (status.equals("Desativado") ? '2' : '3'));

        List<Endereco> enderecos = (filtro.getBairro() != null) || (filtro.getCidade() != null) || 
                (!filtro.getCep().isEmpty()) || (!filtro.getLogradouro().equals("")) ||
                (!Character.isDefined(filtro.getStatus()))
                ? new EnderecoService().carregar(filtro) : new EnderecoService().carregar();
        
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
