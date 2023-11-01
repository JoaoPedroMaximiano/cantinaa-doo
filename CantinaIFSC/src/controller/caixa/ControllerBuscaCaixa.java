package controller.caixa;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Caixa;
import model.bo.Funcionario;
import service.CaixaService;
import service.FuncionarioService;
import view.caixa.TelaBuscaCaixa;

public class ControllerBuscaCaixa {
    TelaBuscaCaixa telaBuscaCaixa;

    public ControllerBuscaCaixa(TelaBuscaCaixa telaBuscaCaixa) {
        this.telaBuscaCaixa = telaBuscaCaixa;
        
        for (Funcionario funcionario : new FuncionarioService().carregar()) {
            this.telaBuscaCaixa.getjComboBoxFuncionario().addItem(funcionario.toString() + ' ' + funcionario.getCpf());
        }

        filtrarPesquisa();
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        telaBuscaCaixa.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaCaixa.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaCaixa.getjButtonSair().addActionListener(e -> fecharTelaBuscaCaixa());

    }

    private void carregarDadosParaCadastro() {
        controller.caixa.ControllerCadastroCaixa.codigo = (int) this.telaBuscaCaixa.getjTable().getValueAt(this.telaBuscaCaixa.getjTable().getSelectedRow(), 0);
        this.telaBuscaCaixa.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCaixa.getjTable().getModel();
        table.setRowCount(0);
        Caixa filtro = new Caixa();
        filtro.setDataHoraAberto(this.telaBuscaCaixa.getjFormattedTextFieldDataAbertura().getText().trim().equals("/  /       :  :") ? "" : this.telaBuscaCaixa.getjFormattedTextFieldDataAbertura().getText());
        filtro.setDataHoraFechamento(this.telaBuscaCaixa.getjFormattedTextFieldDataFechamento().getText().trim().equals("/  /       :  :") ? "" : this.telaBuscaCaixa.getjFormattedTextFieldDataFechamento().getText());

        filtro.setFuncionario(new FuncionarioService().carregar(Integer.parseInt(this.telaBuscaCaixa.getjComboBoxFuncionario().getSelectedItem().toString().split(" - ")[0])));
        
        String status = this.telaBuscaCaixa.getjComboBoxStatus().getSelectedItem().toString();
        filtro.setStatus(status.equals("Aberto") ? '1' : (status.equals("Fechado") ? '2' : (status.equals("Cancelado") ? '3' : '4')));
        filtro.setValorAbertura(Double.parseDouble(this.telaBuscaCaixa.getjFormattedTextFieldValorAbertura().getText().equals("") ? "0.0" : this.telaBuscaCaixa.getjFormattedTextFieldValorAbertura().getText()));
        filtro.setValorFechamento(Double.parseDouble(this.telaBuscaCaixa.getjFormattedTextFieldValorFechamento().getText().equals("") ? "0.0" : this.telaBuscaCaixa.getjFormattedTextFieldValorFechamento().getText()));
        
        List<Caixa> caixas = !filtro.getDataHoraAberto().equals("")
                || !filtro.getDataHoraFechamento().equals("")
                || !filtro.getFuncionario().getNome().equals("")
                || !Character.isDefined(filtro.getStatus())
                || filtro.getValorAbertura() != 0.0 
                || filtro.getValorFechamento() != 0.0
                ? new CaixaService().carregar(filtro)
                : new CaixaService().carregar();
        
        for (Caixa caixa : caixas) {
            table.addRow(new Object[]{
                caixa.getId(),
                caixa.getFuncionario().getNome(),
                caixa.getDataHoraAberto(),
                caixa.getDataHoraFechamento(),
                caixa.getValorAbertura(),
                caixa.getValorFechamento()
            });
        }
    }

    private void fecharTelaBuscaCaixa() {
        this.telaBuscaCaixa.dispose();
    }
}
