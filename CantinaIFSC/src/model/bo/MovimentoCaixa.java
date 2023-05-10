package model.bo;

import java.util.Date;

public class MovimentoCaixa {

    private int id;
    private Date dataHoraMovimento;
    private double valorMovimento;
    private String observacao;
    private char flagTipoMovimento;
    private char status;
    private Caixa caixa;

    public MovimentoCaixa() {
    }

    public MovimentoCaixa(int id, Date dataHoraMovimento, double valorMovimento, String observacao, char flagTipoMovimento, char status, Caixa caixa) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.valorMovimento = valorMovimento;
        this.observacao = observacao;
        this.flagTipoMovimento = flagTipoMovimento;
        this.status = status;
        this.caixa = caixa;
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

    public double getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(double valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public String toString() {
        return "MovimentoCaixa{" + "id=" + id + ", dataHoraMovimento=" + dataHoraMovimento + ", valorMovimento=" + valorMovimento + ", observacao=" + observacao + ", flagTipoMovimento=" + flagTipoMovimento + ", status=" + status + ", caixa=" + caixa + '}';
    }
    
}
