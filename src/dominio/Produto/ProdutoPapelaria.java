package dominio.Produto;

import java.math.BigDecimal;

public class ProdutoPapelaria extends Produto {
    public ProdutoPapelaria(String nome, double valorProduto) {
        super(nome, valorProduto, TipoProduto.PAPELARIA);
        if (!validarProduto()) {
            throw new IllegalArgumentException("Produto papelaria inválido.");
        }
    }

    @Override
    public boolean validarProduto() {
        return ValidadorProduto.validar(this);
    }
}
