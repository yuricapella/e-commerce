package dominio.produto;

import dominio.produto.servico.ValidaProduto;

public class ProdutoLivro extends Produto {
    public ProdutoLivro(String nome, double valorProduto) {
        super(nome, valorProduto, TipoProduto.LIVRO);
        if (!validarProduto()) {
            throw new IllegalArgumentException("Produto livro inválido.");
        }
    }

    @Override
    public boolean validarProduto() {
        return ValidaProduto.validarNome(this.getNome()) && ValidaProduto.validarPreco(this.getValorProduto());
    }
}
