package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoPapelaria extends Produto {
    public ProdutoPapelaria(String nome, BigDecimal valorProduto) {
        super(nome, valorProduto, TipoProduto.PAPELARIA);
    }
}
