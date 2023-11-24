package model.bo;

public class Caixa {

    private int id;
    private String dataHoraAberto;
    private String dataHoraFechamento;
    private double valorAbertura;
    private double valorFechamento;
    private String observacao;
    private char status;
    private Funcionario funcionario;

    public Caixa() {
    }

    public Caixa(int id, String dataHoraAberto, String dataHoraFechamento, double valorAbertura, double valorFechamento, String observacao, char status, Funcionario funcionario) {
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

    public String getDataHoraAberto() {
        return dataHoraAberto;
    }

    public void setDataHoraAberto(String dataHoraAberto) {
        this.dataHoraAberto = dataHoraAberto;
    }

    public String getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(String dataHoraFechamento) {
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
        return id + " - " + getFuncionario().getNome() + " - Data de Inicio: " + getDataHoraAberto();
    }
    
}
