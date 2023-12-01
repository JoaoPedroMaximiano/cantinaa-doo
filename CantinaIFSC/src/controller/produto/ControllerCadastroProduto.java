package controller.produto;

import javax.swing.JOptionPane;
import model.bo.Produto;
import service.ProdutoService;
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
            produto = new ProdutoService().carregar(codigo);
            ativa(false, this.telaCadastroProduto.getjPanelBotoes());
            limpaCompenentes(true, this.telaCadastroProduto.getjPanelCorpo());
            
            String status = String.valueOf(produto.getStatus());
            this.telaCadastroProduto.getjTextFieldID().setText(produto.getId() + "");
            this.telaCadastroProduto.getjTextFieldDescricao().setText(produto.getDescricao());
            this.telaCadastroProduto.getjComboBoxStatus().setSelectedItem(
                status.equals("1") ? "Ativo" :  "Desativado"
            );
            this.telaCadastroProduto.getjFormattedTextFieldValor().setText(String.valueOf(produto.getValor()));
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

        if (this.telaCadastroProduto.getjTextFieldDescricao().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Descrição é obrigatório!");
            return;
        }
        produto.setDescricao(this.telaCadastroProduto.getjTextFieldDescricao().getText());

        if (this.telaCadastroProduto.getjTextFieldCodigoBarra().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Código de barra é obrigatório!");
            return;
        }
        produto.setCodigoBarra(this.telaCadastroProduto.getjTextFieldCodigoBarra().getText());

        if (this.telaCadastroProduto.getjComboBoxStatus().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Campo Status é obrigatório!");
            return;
        }
        produto.setStatus(this.telaCadastroProduto.getjComboBoxStatus().getSelectedItem().toString().equals("Ativo") ? '1' : '0');

        if (this.telaCadastroProduto.getjFormattedTextFieldValor().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Valor é obrigatório!");
            return;
        }
        produto.setValor((float) Double.parseDouble(this.telaCadastroProduto.getjFormattedTextFieldValor().getText().replace(',', '.')));

        if (this.telaCadastroProduto.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
            new service.ProdutoService().adicionar(produto);
        } else {
            produto.setId(Integer.parseInt(this.telaCadastroProduto.getjTextFieldID().getText()));
            new service.ProdutoService().atualizar(produto);
        }
        ativa(true, telaCadastroProduto.getjPanelBotoes());
        limpaCompenentes(false, telaCadastroProduto.getjPanelCorpo());       
    }
}
