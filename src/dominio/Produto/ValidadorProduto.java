package dominio.Produto;

import java.math.BigDecimal;

public class ValidadorProduto {
    public static boolean validar(Produto produto) {
        return validarNome(produto.getNome()) && validarValor(produto.getValorProduto());
    }

    private static boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        return nome.matches("^(?=.*[A-Za-z])[A-Za-z0-9 ]+$");
    }

    private static boolean validarValor(double valor) {
        return valor > 0;
    }


}
