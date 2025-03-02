package dominio.Produto;

import java.math.BigDecimal;

public class ValidadorProduto {
    public static boolean validar(Produto produto) {
        return validarValor(produto.getValorProduto());
    }

    private static boolean validarValor(double valor) {
        return valor > 0;
    }


}
