package model.bo;

public class ItemVenda {

    private int id;
    private double qtdProduto;
    private double valorUnitario;
    private char status;
    private Produto produto;
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(int id, double qtdProduto, double valorUnitario, char status, Produto produto, Venda venda) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.valorUnitario = valorUnitario;
        this.status = status;
        this.produto = produto;
        this.venda = venda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(double qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "id=" + id + ", qtdProduto=" + qtdProduto + ", valorUnitario=" + valorUnitario + ", status=" + status + ", produto=" + produto + ", venda=" + venda + '}';
    }
    
}
