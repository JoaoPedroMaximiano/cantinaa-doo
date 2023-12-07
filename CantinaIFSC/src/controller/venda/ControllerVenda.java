package controller.venda;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Funcionario;
import model.bo.ItemVenda;
import model.bo.MovimentacaoEstoque;
import model.bo.Produto;
import model.bo.Venda;
import service.CaixaService;
import service.CarteirinhaService;
import service.FuncionarioService;
import service.ItemVendaService;
import service.MovimentacaoEstoqueService;
import service.ProdutoService;
import service.VendaService;
import view.venda.TelaVenda;

public class ControllerVenda {
    TelaVenda telaVenda;
    List<Carteirinha> carteirinha;
    List<ItemVenda> itemVendas;
    
    public ControllerVenda(TelaVenda telaVenda) {
        this.telaVenda = telaVenda;
        
        for (Caixa caixa : new CaixaService().carregar()) {
            this.telaVenda.getjComboBoxCaixa().addItem(caixa.toString());
        }
        
        setupActionListeners();
    }
  
    private void setupActionListeners() {
        telaVenda.getjTextFieldCodigoBarraCarteirinha().addKeyListener(atalhoCarteirinha);
        telaVenda.getjTextFieldCodigoBarraProduto().addKeyListener(atalhoProduto);
        
        telaVenda.getjButtonIniciarVenda().addActionListener(e -> iniciarVenda());        
        telaVenda.getjButtonFinalizarVenda().addActionListener(e -> finalizarVenda());        
        telaVenda.getjButtonCancelar().addActionListener(e -> cancelarVenda());        
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
        
        carteirinha = new CarteirinhaService().carregar(filtro);
        if (carteirinha.isEmpty()) {
            JOptionPane.showMessageDialog(telaVenda, "Carteirinha não encontrada!");
            return;
        }
        if (carteirinha.get(0).getDataCancelamento() != null) {
            JOptionPane.showMessageDialog(telaVenda, "Carteirinha cancelada!");
            return;
        }
        this.telaVenda.getjButtonIniciarVenda().setEnabled(true);
        
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
            
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(produto.get(0));
            itemVenda.setValorUnitario(produto.get(0).getValor());
            itemVenda.setStatus('1');
            itemVenda.setQtdProduto(Float.parseFloat(this.telaVenda.getjTextFieldQtd().getText()));
            
            this.telaVenda.getjTextFieldTotal().setText(String.valueOf(Float.parseFloat(this.telaVenda.getjTextFieldTotal().getText()) + Float.parseFloat(this.telaVenda.getjTextFieldQtd().getText())*produto.get(0).getValor()));
            this.telaVenda.getjTextFieldCodigoBarraProduto().setText("");
            this.telaVenda.getjTextFieldQtd().setText("");
        } else {
            JOptionPane.showMessageDialog(telaVenda, "Quantidade e código de barras do produto são campos obrigatórios");
        }
        
    }
    
    private void iniciarVenda(){
        this.telaVenda.getjLabelCodigoBarraProduto().setEnabled(true);
        this.telaVenda.getjTextFieldCodigoBarraProduto().setEnabled(true);
        this.telaVenda.getjLabelQtd().setEnabled(true);
        this.telaVenda.getjTextFieldQtd().setEnabled(true);
        this.telaVenda.getjButtonFinalizarVenda().setEnabled(true);
        this.telaVenda.getjButtonCancelar().setEnabled(true);
        this.telaVenda.getjButtonIniciarVenda().setEnabled(false);

        this.telaVenda.getjComboBoxCaixa().setEnabled(false);
        this.telaVenda.getjLabelCaixa().setEnabled(false);
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().setEnabled(false);
        this.telaVenda.getjLabelCodigoBarraCarteirinha().setEnabled(false);

        this.telaVenda.getjTextFieldTotal().setText("0.0");
        this.telaVenda.getjTextFieldCodigoBarraProduto().requestFocus();
        itemVendas = new ArrayList<ItemVenda>();
    }
    
    private void finalizarVenda(){
        limparTelaVenda();
        
        Funcionario funcionario = new FuncionarioService().carregar(Integer.parseInt(this.telaVenda.getjComboBoxCaixa().getSelectedItem().toString().split(" - ")[0]));
        Venda venda = new Venda();
        
        venda.setFuncionario(funcionario);
        venda.setCarteirinha(carteirinha.get(0));
        venda.setObservacao(this.telaVenda.getjTextAreaObs().getText());
        venda.setStatus('1');
//        venda.setValorDesconto(0);

        new VendaService().adicionar(venda);
        for (ItemVenda itemVenda : itemVendas) {
            new ItemVendaService().adicionar(itemVenda);
            MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque();
            movimentacaoEstoque.setItemVenda(itemVenda);
            movimentacaoEstoque.setProduto(itemVenda.getProduto());
            movimentacaoEstoque.setFuncionario(funcionario);
            movimentacaoEstoque.setFlagTipoMovimento('s');
            movimentacaoEstoque.setQtdMovimentada(itemVenda.getQtdProduto());
            movimentacaoEstoque.setDataHoraMovimento(new Date());
            movimentacaoEstoque.setStatus('1');
            
            new MovimentacaoEstoqueService().adicionar(movimentacaoEstoque);
        }
    }
    
    private void cancelarVenda(){
        limparTelaVenda();
    }
    
    private void limparTelaVenda(){
        this.telaVenda.getjLabelCodigoBarraProduto().setEnabled(false);
        this.telaVenda.getjTextFieldCodigoBarraProduto().setEnabled(false);
        this.telaVenda.getjLabelQtd().setEnabled(false);
        this.telaVenda.getjTextFieldQtd().setEnabled(false);
        this.telaVenda.getjButtonFinalizarVenda().setEnabled(false);
        this.telaVenda.getjButtonCancelar().setEnabled(false);
        this.telaVenda.getjButtonIniciarVenda().setEnabled(true);

        this.telaVenda.getjComboBoxCaixa().setEnabled(true);
        this.telaVenda.getjLabelCaixa().setEnabled(true);
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().setEnabled(true);
        this.telaVenda.getjLabelCodigoBarraCarteirinha().setEnabled(true);

        this.telaVenda.getjTextFieldTotal().setText("");
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().setText("");
        this.telaVenda.getjTextAreaObs().setText("");
        DefaultTableModel table = (DefaultTableModel) this.telaVenda.getjTableProdutos().getModel();                   
        
        table.setRowCount(0);       
    }

}
