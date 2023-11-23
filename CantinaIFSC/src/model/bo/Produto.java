package model.bo;

public class Produto {

    private int id;
    private String descricao;
    private String codigoBarra;
    private char status;
    private float valor;

    public Produto() {
    }

    public Produto(int id, String descricao, String codigoBarra, char status, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
        this.status = status;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return id + " - " + descricao;
    }
    
}
