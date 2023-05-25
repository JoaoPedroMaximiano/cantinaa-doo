package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bo.Bairro;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Compra;
import model.bo.Contas;
import model.bo.Endereco;
import model.bo.Fornecedor;
import model.bo.Funcionario;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.MovimentacaoEstoque;
import model.bo.MovimentoCaixa;
import model.bo.Produto;
import model.bo.Venda;

public class Persiste {
    private static Persiste instancia;
    public List<Bairro> listaBairro;
    public List<Caixa> listaCaixa;
    public List<Carteirinha> listaCarteirinha;
    public List<Cidade> listaCidade;
    public List<Cliente> listaCliente;
    public List<Compra> listaCompra;
    public List<Contas> listaContas;
    public List<Endereco> listaEndereco;
    public List<Fornecedor> listaFornecedor;
    public List<Funcionario> listaFuncionario;
    public List<ItemCompra> listaItemCompra;
    public List<ItemVenda> listaItemVenda;
    public List<MovimentacaoEstoque> listaMovimentacaoEstoque;
    public List<MovimentoCaixa> listaMovimentoCaixa;
    public List<Produto> listaProduto;
    public List<Venda> listaVenda;

    private Persiste() {
        listaBairro = new ArrayList<>();
        listaCaixa = new ArrayList<>();
        listaCarteirinha = new ArrayList<>();
        listaCidade = new ArrayList<>();
        listaCliente = new ArrayList<>();
        listaCompra = new ArrayList<>();
        listaContas = new ArrayList<>();
        listaEndereco = new ArrayList<>();
        listaFornecedor = new ArrayList<>();
        listaFuncionario = new ArrayList<>();
        listaItemCompra = new ArrayList<>();
        listaItemVenda = new ArrayList<>();
        listaMovimentacaoEstoque = new ArrayList<>();
        listaMovimentoCaixa = new ArrayList<>();
        listaProduto = new ArrayList<>();
        listaVenda = new ArrayList<>();
    }
    
    public static synchronized Persiste getInstancia(){
        if (instancia == null) instancia = new Persiste();
        return instancia;
    }
}
