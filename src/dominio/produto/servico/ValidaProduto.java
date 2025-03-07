package dominio.produto.servico;

import dominio.produto.Produto;
import dominio.produto.interfaces.ValidadorProduto;

public class ValidaProduto implements ValidadorProduto {

    public boolean validarProdutoAtivo(Produto produto) {
        if (!produto.isAtivo()) {
            throw new IllegalStateException("Produto inativo. Alteração não permitida.");
        }
        return true;
    }

    public static boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    public static boolean validarPreco(Double preco) {
        return preco != null && preco > 0;
    }
}
