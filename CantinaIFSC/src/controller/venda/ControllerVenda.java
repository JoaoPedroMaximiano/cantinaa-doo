package controller.venda;

import model.bo.Caixa;
import service.CaixaService;
import view.venda.TelaVenda;

public class ControllerVenda {
    TelaVenda telaVenda;

    public ControllerVenda(TelaVenda telaVenda) {
        this.telaVenda = telaVenda;
        
        for (Caixa caixa : new CaixaService().carregar()) {
            this.telaVenda.getjComboBoxCaixa().addItem(caixa.toString());
        }
    }
}
