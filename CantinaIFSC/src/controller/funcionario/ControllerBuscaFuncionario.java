package controller.funcionario;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Funcionario;
import service.BairroService;
import service.CidadeService;
import service.EnderecoService;
import service.FuncionarioService;
import view.funcionario.TelaBuscaFuncionario;

public class ControllerBuscaFuncionario {

    TelaBuscaFuncionario telaBuscaFuncionario;

    public ControllerBuscaFuncionario(TelaBuscaFuncionario telaBuscaFuncionario) {
        this.telaBuscaFuncionario = telaBuscaFuncionario;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaFuncionario.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaFuncionario.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaFuncionario.getjButtonSair().addActionListener(e -> carregarFecharBuscaFuncionario());

    }

    private void carregarDadosParaCadastro() {
        controller.funcionario.ControllerCadastroFuncionario.codigo = (int) this.telaBuscaFuncionario.getjTable().getValueAt(this.telaBuscaFuncionario.getjTable().getSelectedRow(), 0);
        this.telaBuscaFuncionario.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaFuncionario.getjTable().getModel();
        table.setRowCount(0);
        Funcionario filtro = new Funcionario();
        filtro.setComplementoEndereco(this.telaBuscaFuncionario.getjTextFieldComplementoEndereco().getText());
        filtro.setCpf(this.telaBuscaFuncionario.getjFormattedTextFieldCPF().getText());
        filtro.setEmail(this.telaBuscaFuncionario.getjTextFieldEmail().getText());
        filtro.setFone1(this.telaBuscaFuncionario.getjFormattedTextFieldTelefone1().getText());
        filtro.setFone2(this.telaBuscaFuncionario.getjFormattedTextFieldTelefone2().getText());
        filtro.setNome(this.telaBuscaFuncionario.getjTextFieldNome().getText());
        filtro.setRg(this.telaBuscaFuncionario.getjFormattedTextFieldRG().getText());
        String status = this.telaBuscaFuncionario.getjComboBoxStatus().getSelectedItem().toString();
        filtro.setStatus(status.equals("Ativo") ? '1' : (status.equals("Desativado") ? '2' : '3'));

        Endereco filtroEndereco = new Endereco();
        
        if (this.telaBuscaFuncionario.getjFormattedTextFieldCEP().getText().equals("")){
            filtroEndereco.setCep(this.telaBuscaFuncionario.getjFormattedTextFieldCEP().getText());
        }
        
        if (!telaBuscaFuncionario.getjTextFieldBairro().getText().equals("")) {
            Bairro bairro = new Bairro();
            bairro.setDescricao(telaBuscaFuncionario.getjTextFieldBairro().getText());
            filtroEndereco.setBairro(new BairroService().carregar(bairro).get(0));
        }
        
        if (!telaBuscaFuncionario.getjTextFieldCidade().getText().equals("")) {
            Cidade cidade = new Cidade();
            cidade.setDescricao(telaBuscaFuncionario.getjTextFieldCidade().getText());
            filtroEndereco.setCidade(new CidadeService().carregar(cidade).get(0));
        }
        filtro.setEndereco(EnderecoService.carregar(filtroEndereco).get(0));
        
        List<Funcionario> funcionarios = !filtro.getComplementoEndereco().equals("") || 
        !filtro.getCpf().equals("") || 
        !filtro.getEmail().equals("") || filtro.getEndereco() != null || 
        !filtro.getFone1().equals("") || !filtro.getFone2().equals("") ||
        !filtro.getNome().equals("") || !filtro.getRg().equals("") || 
        !Character.isDefined(filtro.getStatus())
        ? new FuncionarioService().carregar(filtro) 
        : new FuncionarioService().carregar();
        
        funcionarios.forEach(funcionario -> {
            table.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getEmail(),
                funcionario.getFone1(),
                funcionario.getStatus()
            });
        });
    }    

    private void carregarFecharBuscaFuncionario() {
        this.telaBuscaFuncionario.dispose();
    }
    
}
