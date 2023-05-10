package model.bo;

import java.util.Date;

public class Caixa {

    private int id;
    private Date dataHoraAberto;
    private Date dataHoraFechamento;
    private double valorAbertura;
    private double valorFechamento;
    private String observacao;
    private char status;
    private Funcionario funcionario;

    public Caixa() {
    }

    public Caixa(int id, Date dataHoraAberto, Date dataHoraFechamento, double valorAbertura, double valorFechamento, String observacao, char status, Funcionario funcionario) {
        this.id = id;
        this.dataHoraAberto = dataHoraAberto;
        this.dataHoraFechamento = dataHoraFechamento;
        this.valorAbertura = valorAbertura;
        this.valorFechamento = valorFechamento;
        this.observacao = observacao;
        this.status = status;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraAberto() {
        return dataHoraAberto;
    }

    public void setDataHoraAberto(Date dataHoraAberto) {
        this.dataHoraAberto = dataHoraAberto;
    }

    public Date getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Date dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public double getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(double valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public double getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(double valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Caixa{" + "id=" + id + ", dataHoraAberto=" + dataHoraAberto + ", dataHoraFechamento=" + dataHoraFechamento + ", valorAbertura=" + valorAbertura + ", valorFechamento=" + valorFechamento + ", observacao=" + observacao + ", status=" + status + ", funcionario=" + funcionario + '}';
    }
    
}
