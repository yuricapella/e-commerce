package dominio.produto;

public abstract class Produto {
    private String nome;
    private double valorProduto;
    private long id;
    private static long contador = 1;
    private boolean ativo;
    private TipoProduto tipo;

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-3d | %-20s | R$ %7.2f | %-12s | %s |",
                id, nome, valorProduto, tipo, ativo ? "✅ Ativo" : "❌ Inativo"
        );
    }

}
