package dominio.Produto;

public class ProdutoPapelaria extends Produto {
    public ProdutoPapelaria(String nome, double valorProduto) {
        super(nome, valorProduto, TipoProduto.PAPELARIA);
        if (!validarProduto()) {
            throw new IllegalArgumentException("Produto papelaria inválido.");
        }
    }

    @Override
    public boolean validarProduto() {
        return ValidaProduto.validarNome(this.getNome()) && ValidaProduto.validarPreco(this.getValorProduto());
    }
}
