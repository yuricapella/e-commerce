package repositorio.produto.interfaces.especificas;

import dominio.produto.Produto;

public interface ProdutoManipulacao {
    void adicionar(Produto produto);
    void remover(Produto produto);
}
