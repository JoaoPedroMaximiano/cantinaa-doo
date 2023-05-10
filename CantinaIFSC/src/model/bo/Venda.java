package model.bo;

import java.util.Date;

public class Venda {

    private int id;
    private Date dataHoraVenda;
    private double valorDesconto;
    private String observacao;
    private char flagTipoDesconto;
    private char Status;
    private Carteirinha carteirinha;
    private Funcionario funcionario;

    public Venda() {
    }

    public Venda(int id, Date dataHoraVenda, double valorDesconto, String observacao, char flagTipoDesconto, char Status, Carteirinha carteirinha, Funcionario funcionario) {
        this.id = id;
        this.dataHoraVenda = dataHoraVenda;
        this.valorDesconto = valorDesconto;
        this.observacao = observacao;
        this.flagTipoDesconto = flagTipoDesconto;
        this.Status = Status;
        this.carteirinha = carteirinha;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(Date dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
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
        return Status;
    }

    public void setStatus(char Status) {
        this.Status = Status;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataHoraVenda=" + dataHoraVenda + ", valorDesconto=" + valorDesconto + ", observacao=" + observacao + ", flagTipoDesconto=" + flagTipoDesconto + ", Status=" + Status + ", carteirinha=" + carteirinha + ", funcionario=" + funcionario + '}';
    }
    
}
