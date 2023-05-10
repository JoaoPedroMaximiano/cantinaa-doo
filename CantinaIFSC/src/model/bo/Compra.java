package model.bo;

import java.util.Date;

public class Compra {

    private int id;
    private int numberoNf;
    private Date dataHoraCompra;
    private double valorDesconto;
    private String observacao;
    private char flagTipoDesconto;
    private char status;

    public Compra() {
    }

    public Compra(int id, int numberoNf, Date dataHoraCompra, double valorDesconto, String observacao, char flagTipoDesconto, char status) {
        this.id = id;
        this.numberoNf = numberoNf;
        this.dataHoraCompra = dataHoraCompra;
        this.valorDesconto = valorDesconto;
        this.observacao = observacao;
        this.flagTipoDesconto = flagTipoDesconto;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberoNf() {
        return numberoNf;
    }

    public void setNumberoNf(int numberoNf) {
        this.numberoNf = numberoNf;
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

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", numberoNf=" + numberoNf + ", dataHoraCompra=" + dataHoraCompra + ", valorDesconto=" + valorDesconto + ", observacao=" + observacao + ", flagTipoDesconto=" + flagTipoDesconto + ", status=" + status + '}';
    } 
    
}
