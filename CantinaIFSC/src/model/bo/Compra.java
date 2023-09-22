package model.bo;

import java.util.Date;

public class Compra {

    private int id;
    private int numeroNf;
    private Date dataHoraCompra;
    private double valorDesconto;
    private String observacao;
    private char flagTipoDesconto;
    private char status;
    private Fornecedor fornecedor;

    public Compra() {
    }

    public Compra(int id, int numeroNf, Date dataHoraCompra, double valorDesconto, String observacao, char flagTipoDesconto, char status, Fornecedor fornecedor) {
        this.id = id;
        this.numeroNf = numeroNf;
        this.dataHoraCompra = dataHoraCompra;
        this.valorDesconto = valorDesconto;
        this.observacao = observacao;
        this.flagTipoDesconto = flagTipoDesconto;
        this.status = status;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroNf() {
        return numeroNf;
    }

    public void setNumeroNf(int numeroNf) {
        this.numeroNf = numeroNf;
    }

    public Date getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(Date dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getFlagTipoDesconto() {
        return flagTipoDesconto;
    }

    public void setFlagTipoDesconto(char flagTipoDesconto) {
        this.flagTipoDesconto = flagTipoDesconto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", numeroNf=" + numeroNf + ", dataHoraCompra=" + dataHoraCompra + ", valorDesconto=" + valorDesconto + ", observacao=" + observacao + ", flagTipoDesconto=" + flagTipoDesconto + ", status=" + status + ", fornecedor=" + fornecedor + '}';
    }

}
