package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoLivro extends Produto {
    public ProdutoLivro(String nome, double valorProduto) {
        super(nome, valorProduto, TipoProduto.LIVRO);
        if (!validarProduto()) {
            throw new IllegalArgumentException("Produto livro inválido.");
        }
    }

    @Override
    public boolean validarProduto() {
        return ValidadorProduto.validar(this);
    }
}
