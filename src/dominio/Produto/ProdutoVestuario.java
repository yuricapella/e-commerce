package dominio.Produto;

public class ProdutoVestuario extends Produto {
    public ProdutoVestuario(String nome, double valorProduto) {
        super(nome, valorProduto, TipoProduto.VESTUARIO);
        if (!validarProduto()) {
            throw new IllegalArgumentException("Produto vestuario inválido.");
        }
    }

    @Override
    public boolean validarProduto() {
        return ValidaProduto.validarNome(this.getNome()) && ValidaProduto.validarPreco(this.getValorProduto());
    }
}
