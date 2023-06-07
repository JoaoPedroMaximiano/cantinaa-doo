package controller.funcionario;

import javax.swing.table.DefaultTableModel;
import model.bo.Funcionario;
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
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaFuncionario.getjTable().getModel();
        table.setRowCount(0);
        for (Funcionario funcionario : model.dao.Persiste.getInstancia().listaFuncionario) {
            table.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getFone1(),
                funcionario.getCpf(),
                funcionario.getEmail()
            });
        }
    }    

    private void carregarFecharBuscaFuncionario() {
        this.telaBuscaFuncionario.dispose();
    }
    
}
