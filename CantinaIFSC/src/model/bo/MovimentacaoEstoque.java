package model.bo;

import java.util.Date;

public class MovimentacaoEstoque {

    private int id;
    private Date dataHoraMovimento;
    private double qtdMovimentada;
    private String observacaoMovimento;
    private char flagTipoMovimento;
    private char status;
    private Produto produto;
    private ItemVenda itemVenda;
    private ItemCompra itemCompra;
    private Funcionario funcionario;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(int id, Date dataHoraMovimento, double qtdMovimentada, String observacaoMovimento, char flagTipoMovimento, char status, Produto produto, ItemVenda itemVenda, ItemCompra itemCompra, Funcionario funcionario) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.qtdMovimentada = qtdMovimentada;
        this.observacaoMovimento = observacaoMovimento;
        this.flagTipoMovimento = flagTipoMovimento;
        this.status = status;
        this.produto = produto;
        this.itemVenda = itemVenda;
        this.itemCompra = itemCompra;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public void setDataHoraMovimento(Date dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public double getQtdMovimentada() {
        return qtdMovimentada;
    }

    public void setQtdMovimentada(double qtdMovimentada) {
        this.qtdMovimentada = qtdMovimentada;
    }

    public String getObservacaoMovimento() {
        return observacaoMovimento;
    }

    public void setObservacaoMovimento(String observacaoMovimento) {
        this.observacaoMovimento = observacaoMovimento;
    }

    public char getFlagTipoMovimento() {
        return flagTipoMovimento;
    }

    public void setFlagTipoMovimento(char flagTipoMovimento) {
        this.flagTipoMovimento = flagTipoMovimento;
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

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "MovimentacaoEstoque{" + "id=" + id + ", dataHoraMovimento=" + dataHoraMovimento + ", qtdMovimentada=" + qtdMovimentada + ", observacaoMovimento=" + observacaoMovimento + ", flagTipoMovimento=" + flagTipoMovimento + ", status=" + status + ", produto=" + produto + ", itemVenda=" + itemVenda + ", itemCompra=" + itemCompra + ", funcionario=" + funcionario + '}';
    }
    
}
