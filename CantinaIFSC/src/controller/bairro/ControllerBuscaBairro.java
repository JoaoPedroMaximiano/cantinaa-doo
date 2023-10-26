package controller.bairro;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import view.bairro.TelaBuscaBairro;

public class ControllerBuscaBairro {

    TelaBuscaBairro telaBuscaBairro;

    public ControllerBuscaBairro(TelaBuscaBairro telaBuscaBairro) {
        this.telaBuscaBairro = telaBuscaBairro;
        setupActionListeners();
        filtrarPesquisa();
    }
    
    private void setupActionListeners() {
        telaBuscaBairro.getjButtonPesquisar().addActionListener(e -> filtrarPesquisa());
        telaBuscaBairro.getjButtonCarregar().addActionListener(e -> carregarDadosParaCadastro());
        telaBuscaBairro.getjButtonSair().addActionListener(e -> fecharTelaBuscaBairro());

    }

    private void carregarDadosParaCadastro() {
        controller.bairro.ControllerCadastroBairro.codigo = (int) this.telaBuscaBairro.getjTable().getValueAt(this.telaBuscaBairro.getjTable().getSelectedRow(), 0);
        this.telaBuscaBairro.dispose();
    }

    private void filtrarPesquisa() {
        DefaultTableModel table = (DefaultTableModel) this.telaBuscaBairro.getjTable().getModel();
        table.setRowCount(0);

        Bairro filtro = new Bairro();
        filtro.setDescricao(telaBuscaBairro.getjTextFieldDescricao().getText());
        List<Bairro> bairros = filtro.getDescricao().equals("") ? BairroService.carregar() : BairroService.carregar(filtro);

        bairros.forEach(bairro -> {
            table.addRow(new Object[]{
                bairro.getId(),
                bairro.getDescricao()
            });
        });
    }

    private void fecharTelaBuscaBairro() {
        this.telaBuscaBairro.dispose();
    }
}
