package controller.venda;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Contas;
import model.bo.ItemVenda;
import model.bo.MovimentacaoEstoque;
import model.bo.MovimentoCaixa;
import model.bo.Produto;
import model.bo.Venda;
import service.CaixaService;
import service.CarteirinhaService;
import service.ContasService;
import service.ItemVendaService;
import service.MovimentacaoEstoqueService;
import service.MovimentoCaixaService;
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
        telaVenda.getjTextFieldQtd().addKeyListener(atalhoProduto);
        
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
            if (e.getKeyCode() == KeyEvent.VK_F3) cancelarVenda();
            if (e.getKeyCode() == KeyEvent.VK_F2) finalizarVenda();
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
        
        if (JOptionPane.showConfirmDialog(telaVenda, "Voce deseja Inciar uma venda?") != 0) return;
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().requestFocus();
        iniciarVenda();
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
            
            itemVendas.add(itemVenda);
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
        this.telaVenda.getjComboBoxTipoDesconto().setEnabled(true);
        this.telaVenda.getjTextFieldValorDesconto().setEnabled(true);
        this.telaVenda.getjLabelValorDesconto().setEnabled(true);

        this.telaVenda.getjComboBoxCaixa().setEnabled(false);
        this.telaVenda.getjLabelCaixa().setEnabled(false);
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().setEnabled(false);
        this.telaVenda.getjLabelCodigoBarraCarteirinha().setEnabled(false);
        this.telaVenda.getjButtonIniciarVenda().setEnabled(false);

        this.telaVenda.getjTextFieldTotal().setText("0.0");
        this.telaVenda.getjTextFieldValorDesconto().setText("0,0");
        this.telaVenda.getjTextFieldCodigoBarraProduto().requestFocus();
        itemVendas = new ArrayList<ItemVenda>();
    }
    
    private void finalizarVenda(){
  
        Caixa filtro = new Caixa();
        filtro.setId(Integer.parseInt(this.telaVenda.getjComboBoxCaixa().getSelectedItem().toString().split(" - ")[0]));
        List<Caixa> caixa = new CaixaService().carregar(filtro);        
        
        Venda venda = new Venda();
        
        venda.setFuncionario(caixa.get(0).getFuncionario());
        venda.setCarteirinha(carteirinha.get(0));
        venda.setObservacao(this.telaVenda.getjTextAreaObs().getText());
        venda.setStatus('1');
//        venda.setValorDesconto(Float.parseFloat(telaVenda.getjTextFieldValorDesconto().getText().replace(',', '.')));
//        venda.setFlagTipoDesconto(telaVenda.getjComboBoxTipoDesconto().getSelectedItem().toString().equals("Porcentagem") ? '0' : '1');
        new VendaService().adicionar(venda);
        
        List<Venda> ultimaVendas = new VendaService().carregar();
        for (ItemVenda itemVenda : itemVendas) {
            itemVenda.setVenda(ultimaVendas.get(ultimaVendas.size()-1));
            new ItemVendaService().adicionar(itemVenda);
            List<ItemVenda> ultimoItemVendas = new ItemVendaService().carregar();
            
            
            MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque();
            
            movimentacaoEstoque.setItemVenda(ultimoItemVendas.get(ultimoItemVendas.size() - 1));
            movimentacaoEstoque.setProduto(itemVenda.getProduto());
            movimentacaoEstoque.setFuncionario(caixa.get(0).getFuncionario());
            movimentacaoEstoque.setFlagTipoMovimento('s');
            movimentacaoEstoque.setQtdMovimentada(itemVenda.getQtdProduto());
            Date dataAtual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = dateFormat.format(dataAtual);        
            movimentacaoEstoque.setDataHoraMovimento(dataFormatada);
            movimentacaoEstoque.setStatus('1');
            
            new MovimentacaoEstoqueService().adicionar(movimentacaoEstoque);
        }
        
        Contas contas = new Contas();
        contas.setVenda(ultimaVendas.get(ultimaVendas.size()-1));
        contas.setValorQuitado(Float.parseFloat(this.telaVenda.getjTextFieldTotal().getText().replace(',', '.')));
        contas.setObservacao(this.telaVenda.getjTextAreaObs().getText());
        contas.setFlagTipoConta('e');
        contas.setValorDesconto(this.telaVenda.getjComboBoxTipoDesconto().getSelectedItem().toString().equals("Porcentagem") ? (Float.parseFloat(this.telaVenda.getjTextFieldValorDesconto().getText().replace(',', '.'))/100) * Float.parseFloat(this.telaVenda.getjTextFieldTotal().getText().replace(',', '.')) : Float.parseFloat(this.telaVenda.getjTextFieldValorDesconto().getText().replace(',', '.')));
        contas.setDataHoraEmissora(new Date());
        contas.setDataQuitacao(new Date());
        contas.setDataVencimento(new Date());
        contas.setStatus('1');
        
        new ContasService().adicionar(contas);
        
        List<Contas> ultimaContas = new ContasService().carregar();
        
        MovimentoCaixa movimentoCaixa = new MovimentoCaixa();
        movimentoCaixa.setCaixa(caixa.get(0));
        movimentoCaixa.setContas(ultimaContas.get(ultimaContas.size() - 1));
        movimentoCaixa.setFlagTipoMovimento('e');
        movimentoCaixa.setStatus('1');
        movimentoCaixa.setValorMovimento(0);         
        movimentoCaixa.setDataHoraMovimento(new Date());
        
        new MovimentoCaixaService().adicionar(movimentoCaixa);
        
        limparTelaVenda();
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
        this.telaVenda.getjComboBoxTipoDesconto().setEnabled(false);
        this.telaVenda.getjTextFieldValorDesconto().setEnabled(false);
        this.telaVenda.getjLabelValorDesconto().setEnabled(false);

        this.telaVenda.getjComboBoxCaixa().setEnabled(true);
        this.telaVenda.getjLabelCaixa().setEnabled(true);
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().setEnabled(true);
        this.telaVenda.getjLabelCodigoBarraCarteirinha().setEnabled(true);
        this.telaVenda.getjButtonIniciarVenda().setEnabled(true);

        this.telaVenda.getjTextFieldTotal().setText("");
        this.telaVenda.getjTextFieldCodigoBarraCarteirinha().setText("");
        this.telaVenda.getjTextAreaObs().setText("");
        DefaultTableModel table = (DefaultTableModel) this.telaVenda.getjTableProdutos().getModel();                   
        
        table.setRowCount(0);       
    }

}
