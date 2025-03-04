package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoEletronico extends Produto {
    public ProdutoEletronico(String nome, double valorProduto) {
        super(nome, valorProduto, TipoProduto.ELETRONICO);
        if (!validarProduto()) {
            throw new IllegalArgumentException("Produto eletrônico inválido.");
        }
    }

    @Override
    public boolean validarProduto() {
        return ValidadorProduto.validar(this);
    }
}
