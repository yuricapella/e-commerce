package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoEletronico extends Produto {
    public ProdutoEletronico(String nome, BigDecimal valorProduto) {
        super(nome, valorProduto, TipoProduto.ELETRONICO);
        if (!validarProdutoAtivo()) {
            throw new IllegalArgumentException("Produto eletrônico inválido.");
        }
    }

    @Override
    public boolean validarProdutoAtivo() {
        return ValidadorProduto.validar(this);
    }
}
