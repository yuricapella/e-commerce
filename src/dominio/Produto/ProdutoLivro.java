package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoLivro extends Produto {
    public ProdutoLivro(String nome, BigDecimal valorProduto) {
        super(nome, valorProduto, TipoProduto.LIVRO);
    }
}
