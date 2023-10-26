package controller.cidade;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Cidade;
import service.CidadeService;
import view.cidade.TelaBuscaCidade;

public class ControllerBuscaCidade {

    TelaBuscaCidade telaBuscaCidade;

    public ControllerBuscaCidade(TelaBuscaCidade telaBuscaCidade) {
        this.telaBuscaCidade = telaBuscaCidade;
        setupActionListeners();
        filtrarPesquisa();
    }
    
    private void setupActionListeners() {
        telaBuscaCidade.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaCidade.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaCidade.getjButtonSair().addActionListener(e -> fecharTelaBuscaCidade());

    }

    private void carregarDadosParaCadastro() {
        controller.cidade.ControllerCadastroCidade.codigo = (int) this.telaBuscaCidade.getjTable().getValueAt(this.telaBuscaCidade.getjTable().getSelectedRow(), 0);
        this.telaBuscaCidade.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaCidade.getjTable().getModel();
        
        Cidade filtro = new Cidade();
        filtro.setDescricao(telaBuscaCidade.getjTextFieldDescricao().getText());
        filtro.setUf(telaBuscaCidade.getjComboBoxUF().getSelectedItem().toString());
        
        List<Cidade> cidades = (filtro.getDescricao().equals("") && filtro.getUf().equals("")) ?
                CidadeService.carregar() :
                CidadeService.carregar(filtro);

        table.setRowCount(0);
        for (Cidade cidade : cidades) {
            table.addRow(new Object[]{
                cidade.getId(),
                cidade.getDescricao(),
                cidade.getUf()
            });
        }
    }

    private void fecharTelaBuscaCidade() {
        this.telaBuscaCidade.dispose();
    }
}
