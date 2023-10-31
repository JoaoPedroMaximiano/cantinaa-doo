package controller.funcionario;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Funcionario;
import service.FuncionarioService;
import view.funcionario.TelaBuscaFuncionario;

public class ControllerBuscaFuncionario {

    TelaBuscaFuncionario telaBuscaFuncionario;

    public ControllerBuscaFuncionario(TelaBuscaFuncionario telaBuscaFuncionario) {
        this.telaBuscaFuncionario = telaBuscaFuncionario;
        filtrarPesquisa();
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
        filtro.setNome(this.telaBuscaFuncionario.getjTextFieldNome().getText());
        filtro.setRg(this.telaBuscaFuncionario.getjFormattedTextFieldRG().getText().trim().equals("") ? "" : this.telaBuscaFuncionario.getjFormattedTextFieldRG().getText());
        filtro.setCpf(this.telaBuscaFuncionario.getjFormattedTextFieldCPF().getText().trim().equals(".   .   -") ? "" : this.telaBuscaFuncionario.getjFormattedTextFieldCPF().getText());
        filtro.setUsuario(this.telaBuscaFuncionario.getjTextFieldUsuario().getText());
        
        List<Funcionario> funcionarios = 
        !filtro.getCpf().equals("") 
        || !filtro.getNome().equals("") 
        || !filtro.getRg().equals("")
        || !filtro.getUsuario().equals("")
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
