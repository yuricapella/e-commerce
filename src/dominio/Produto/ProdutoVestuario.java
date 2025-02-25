package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoVestuario extends Produto {
    public ProdutoVestuario(String nome, BigDecimal valorProduto) {
        super(nome, valorProduto, TipoProduto.VESTUARIO);
        if (!validarProdutoAtivo()) {
            throw new IllegalArgumentException("Produto vestuario inválido.");
        }
    }

    @Override
    public boolean validarProdutoAtivo() {
        return ValidadorProduto.validar(this);
    }
}
