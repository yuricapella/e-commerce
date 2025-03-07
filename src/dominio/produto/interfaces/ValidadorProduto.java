package dominio.produto.interfaces;

import dominio.produto.Produto;

public interface ValidadorProduto {
    boolean validarProdutoAtivo(Produto produto);
}
