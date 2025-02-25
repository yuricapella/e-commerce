package dominio.Produto;

import java.math.BigDecimal;

public abstract class Produto {
    protected String nome;
    protected double valorProduto;
    protected double valorVenda;
    protected double valorDesconto;

    protected boolean ativo;
    protected TipoProduto tipo;

    protected long id;
    protected static long contador = 1;

    public Produto(String nome, double valorProduto, TipoProduto tipo) {
        this.id = contador++;
        this.nome = nome;
        this.valorProduto = valorProduto;
        this.valorVenda = 0;
        this.valorDesconto = 0;
        this.ativo = true;
        this.tipo = tipo;
    }

    public abstract boolean validarProdutoAtivo();

    public String getNome() {
        return nome;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public long getId() {
        return id;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return String.format(
                "%s ID: %d, Nome: %s, Valor Base: R$ %.2f, Desconto: R$ %.2f, Valor Venda: R$ %.2f, Ativo: %b\n",
                tipo, id, nome, valorProduto, valorDesconto, valorVenda, ativo
        );
    }
}
