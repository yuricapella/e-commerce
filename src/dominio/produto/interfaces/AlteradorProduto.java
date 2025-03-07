package dominio.produto.interfaces;

import dominio.produto.Produto;

public interface AlteradorProduto {
    void alterarNome(Produto produto, String novoNome);
}
