package controller.produto;

import model.bo.Produto;
import static utilies.Utilities.ativa;
import static utilies.Utilities.limpaCompenentes;
import view.produto.TelaBuscaProduto;
import view.produto.TelaCadastroProduto;

public class ControllerCadastroProduto {

    static int codigo;
    TelaCadastroProduto telaCadastroProduto;

    public ControllerCadastroProduto(TelaCadastroProduto telaCadastroProduto) {
        this.telaCadastroProduto = telaCadastroProduto;

        setupActionListeners();

        ativa(true, this.telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(false, this.telaCadastroProduto.getjPanelCorpo());
    }

    private void setupActionListeners() {
        telaCadastroProduto.getjButtonBuscar().addActionListener(e -> abrirTelaBuscaProduto());
        telaCadastroProduto.getjButtonCancelar().addActionListener(e -> realizarAcaoCancelarGravar());
        telaCadastroProduto.getjButtonGravar().addActionListener(e -> realizarAcaoGravar());
        telaCadastroProduto.getjButtonNovo().addActionListener(e -> realizarAcaoNovo());
        telaCadastroProduto.getjButtonSair().addActionListener(e -> fecharTelaCadastroProduto());
    }

    private void abrirTelaBuscaProduto() {
        
        codigo = 0;
        
        TelaBuscaProduto telaBuscaProduto = new TelaBuscaProduto(null, true);
        ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(telaBuscaProduto);
        telaBuscaProduto.setVisible(true);
        
        if (codigo != 0) {
            Produto produto = new Produto();
            produto = model.dao.Persiste.getInstancia().listaProduto.get(codigo -1);
            
            ativa(false, this.telaCadastroProduto.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroProduto.getjPanelCorpo());
            
            String status = String.valueOf(produto.getStatus());
            this.telaCadastroProduto.getjTextFieldID().setText(produto.getId() + "");
            this.telaCadastroProduto.getjTextFieldDescricao().setText(produto.getDescricao());
            this.telaCadastroProduto.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" :  "Desativado"
            );
            this.telaCadastroProduto.getjTextFieldCodigoBarra().setText(produto.getCodigoBarra());
            this.telaCadastroProduto.getjTextFieldID().setEnabled(false);
        }        
    }

    private void realizarAcaoCancelarGravar() {
        ativa(true, telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroProduto.getjPanelCorpo());
    }

    private void realizarAcaoNovo() {
        ativa(false, telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(true, telaCadastroProduto.getjPanelCorpo());
    }

    private void fecharTelaCadastroProduto() {
        telaCadastroProduto.dispose();
    }

    private void realizarAcaoGravar() {
        Produto produto = new Produto();
        produto.setId(model.dao.Persiste.getInstancia().listaProduto.size() + 1);
        produto.setDescricao(this.telaCadastroProduto.getjTextFieldDescricao().getText());
        produto.setCodigoBarra(this.telaCadastroProduto.getjTextFieldCodigoBarra().getText());
        produto.setStatus(this.telaCadastroProduto.getjComboBoxStatus().getSelectedItem().toString().equals("Ativo") ? '1' : '0');
        model.dao.Persiste.getInstancia().listaProduto.add(produto);
        ativa(true, telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroProduto.getjPanelCorpo());       
    }
}
