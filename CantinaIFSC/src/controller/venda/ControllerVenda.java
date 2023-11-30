package controller.venda;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Produto;
import service.CaixaService;
import service.CarteirinhaService;
import service.ProdutoService;
import view.venda.TelaVenda;

public class ControllerVenda {
    TelaVenda telaVenda;

    public ControllerVenda(TelaVenda telaVenda) {
        this.telaVenda = telaVenda;
        
        for (Caixa caixa : new CaixaService().carregar()) {
            this.telaVenda.getjComboBoxCaixa().addItem(caixa.toString());
        }
        
        telaVenda.getjTextFieldCodigoBarraCarteirinha().addKeyListener(atalhoCarteirinha);
        telaVenda.getjTextFieldCodigoBarraProduto().addKeyListener(atalhoProduto);
    }
    
    private final KeyListener atalhoCarteirinha = new KeyListener() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) verificaCarteirinha();
        }

        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {}
    }; 
 
    private final KeyListener atalhoProduto = new KeyListener() {
         @Override
         public void keyPressed(KeyEvent e) {
             if (e.getKeyCode() == KeyEvent.VK_ENTER) cadastraProduto();
         }

         @Override
         public void keyTyped(KeyEvent e) {}
         @Override
         public void keyReleased(KeyEvent e) {}
     }; 
    
    private void verificaCarteirinha(){

        Carteirinha filtro = new Carteirinha();
        filtro.setCodigoBarra(this.telaVenda.getjTextFieldCodigoBarraCarteirinha().getText());
        
        List<Carteirinha> carteirinha = new CarteirinhaService().carregar(filtro);
        if (carteirinha.isEmpty()) {
            JOptionPane.showMessageDialog(telaVenda, "Carteirinha não encontrada!");
            return;
        }
        if (!carteirinha.get(0).getDataCancelamento().isEmpty()) {
            JOptionPane.showMessageDialog(telaVenda, "Carteirinha cancelada!");
            return;
        }
        
        this.telaVenda.getjLabelCodigoBarraProduto().setEnabled(true);
        this.telaVenda.getjTextFieldCodigoBarraProduto().setEnabled(true);
        this.telaVenda.getjLabelQtd().setEnabled(true);
        this.telaVenda.getjTextFieldQtd().setEnabled(true);
        this.telaVenda.getjButtonIniciarVenda().setEnabled(true);

        this.telaVenda.getjComboBoxCaixa().setEnabled(false);
        this.telaVenda.getjLabelCaixa().setEnabled(false);
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().setEnabled(false);
        this.telaVenda.getjLabelCodigoBarraCarteirinha().setEnabled(false);

        this.telaVenda.getjTextFieldCodigoBarraProduto().requestFocus();
        JOptionPane.showMessageDialog(telaVenda, "Carteirinha encontrada!\n" 
                + "Nome do cliente: " + carteirinha.get(0).getCliente().getNome());
    }
    
    private void cadastraProduto(){
        
        if (!this.telaVenda.getjTextFieldCodigoBarraProduto().getText().equals("") && !this.telaVenda.getjTextFieldQtd().getText().equals("0") && !this.telaVenda.getjTextFieldQtd().getText().equals("")) {
            DefaultTableModel table = (DefaultTableModel) this.telaVenda.getjTableProdutos().getModel();
            Produto filtro = new Produto();
            filtro.setCodigoBarra(this.telaVenda.getjTextFieldCodigoBarraProduto().getText());

            ArrayList<Produto> produto = (ArrayList<Produto>) new ProdutoService().carregar(filtro);
            table.addRow(new Object[]{
                produto.get(0).getId(),
                produto.get(0).getDescricao(),
                produto.get(0).getValor(),
                this.telaVenda.getjTextFieldQtd().getText(),
                Float.parseFloat(this.telaVenda.getjTextFieldQtd().getText())*produto.get(0).getValor()
            });        
                        
            this.telaVenda.getjTextFieldCodigoBarraProduto().setText("");
            this.telaVenda.getjTextFieldQtd().setText("");
        } else {
            JOptionPane.showMessageDialog(telaVenda, "Quantidade e código de barras do produto são campos obrigatórios");
        }
        
    }

}
