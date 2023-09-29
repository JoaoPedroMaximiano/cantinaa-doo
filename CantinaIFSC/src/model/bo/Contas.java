package model.bo;

import java.util.Date;

public class Contas {

    private int id;
    private Date dataHoraEmissora;
    private Date dataVencimento;
    private Date dataQuitacao;
    private double valorEmitido;
    private double valorDesconto;
    private double valorCrescimo;
    private double valorQuitado;
    private String observacao;
    private char flagTipoConta;
    private char status;
    private Venda venda;
    private Compra compra;

    public Contas() {
    }

    public Contas(int id, Date dataHoraEmissora, Date dataVencimento, Date dataQuitacao, double valorEmitido, double valorDesconto, double valorCrescimo, double valorQuitado, String observacao, char flagTipoConta, char status, Venda venda, Compra compra) {
        this.id = id;
        this.dataHoraEmissora = dataHoraEmissora;
        this.dataVencimento = dataVencimento;
        this.dataQuitacao = dataQuitacao;
        this.valorEmitido = valorEmitido;
        this.valorDesconto = valorDesconto;
        this.valorCrescimo = valorCrescimo;
        this.valorQuitado = valorQuitado;
        this.observacao = observacao;
        this.flagTipoConta = flagTipoConta;
        this.status = status;
        this.venda = venda;
        this.compra = compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraEmissora() {
        return dataHoraEmissora;
    }

    public void setDataHoraEmissora(Date dataHoraEmissora) {
        this.dataHoraEmissora = dataHoraEmissora;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public double getValorEmitido() {
        return valorEmitido;
    }

    public void setValorEmitido(double valorEmitido) {
        this.valorEmitido = valorEmitido;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorCrescimo() {
        return valorCrescimo;
    }

    public void setValorCrescimo(double valorCrescimo) {
        this.valorCrescimo = valorCrescimo;
    }

    public double getValorQuitado() {
        return valorQuitado;
    }

    public void setValorQuitado(double valorQuitado) {
        this.valorQuitado = valorQuitado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getFlagTipoConta() {
        return flagTipoConta;
    }

    public void setFlagTipoConta(char flagTipoConta) {
        this.flagTipoConta = flagTipoConta;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "Contas{" + "id=" + id + ", dataHoraEmissora=" + dataHoraEmissora + ", dataVencimento=" + dataVencimento + ", dataQuitacao=" + dataQuitacao + ", valorEmitido=" + valorEmitido + ", valorDesconto=" + valorDesconto + ", valorCrescimo=" + valorCrescimo + ", valorQuitado=" + valorQuitado + ", observacao=" + observacao + ", flagTipoConta=" + flagTipoConta + ", status=" + status + ", venda=" + venda + ", compra=" + compra + '}';
    }
    
}
