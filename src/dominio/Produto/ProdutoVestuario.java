package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoVestuario extends Produto {
    public ProdutoVestuario(String nome, double valorProduto) {
        super(nome, valorProduto, TipoProduto.VESTUARIO);
        if (!validarProduto()) {
            throw new IllegalArgumentException("Produto vestuario inválido.");
        }
    }

    @Override
    public boolean validarProduto() {
        return ValidadorProduto.validar(this);
    }
}
