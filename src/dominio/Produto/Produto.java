package dominio.Produto;

import java.math.BigDecimal;

public abstract class Produto {
    protected String nome;
    protected BigDecimal valorProduto;
    protected BigDecimal valorVenda;
    protected BigDecimal valorDesconto;

    protected boolean ativo;
    protected TipoProduto tipo;

    protected long id;
    protected static long contador = 1;

    public Produto(String nome, BigDecimal valorProduto, TipoProduto tipo) {
        if(nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
        if(valorProduto == null || valorProduto.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor do produto deve ser maior que zero.");

        this.id = contador++;
        this.nome = nome;
        this.valorProduto = valorProduto;
        this.valorVenda = valorProduto;
        this.valorDesconto = BigDecimal.ZERO;
        this.ativo = true;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public long getId() {
        return id;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public String toString() {
        return String.format(
                "%s [ID: %d, Nome: %s, Valor Base: R$ %.2f, Valor Venda: R$ %.2f, Desconto: R$ %.2f, Ativo: %b]",
                tipo, id, nome, valorProduto, valorDesconto, valorVenda, ativo
        );
    }
}
