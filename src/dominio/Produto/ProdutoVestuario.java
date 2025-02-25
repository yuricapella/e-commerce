package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoVestuario extends Produto {
    public ProdutoVestuario(String nome, BigDecimal valorProduto) {
        super(nome, valorProduto, TipoProduto.VESTUARIO);
    }
}
