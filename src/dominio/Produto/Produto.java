package dominio.Produto;

import java.math.BigDecimal;

public abstract class Produto {
    protected String nome;
    protected double valorProduto;

    protected boolean ativo;
    protected TipoProduto tipo;

    protected long id;
    protected static long contador = 1;

    public Produto(String nome, double valorProduto, TipoProduto tipo) {
        this.id = contador++;
        this.nome = nome;
        this.valorProduto = valorProduto;
        this.ativo = true;
        this.tipo = tipo;
    }

    public abstract boolean validarProduto();

    public String getNome() {
        return nome;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public long getId() {
        return id;
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
                "%s ID: %d, Nome: %s, Valor Base: R$ %.2f, Ativo: %b\n",
                tipo, id, nome, valorProduto, ativo
        );
    }
}
