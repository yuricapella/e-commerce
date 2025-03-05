package dominio.Produto.interfaces;

import dominio.Produto.Produto;

public interface ValidadorProduto {
    boolean validarProdutoAtivo(Produto produto);
}
