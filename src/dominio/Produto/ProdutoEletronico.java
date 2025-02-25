package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoEletronico extends Produto {
    public ProdutoEletronico(String nome, BigDecimal valorProduto) {
        super(nome, valorProduto, TipoProduto.ELETRONICO);
    }
}
