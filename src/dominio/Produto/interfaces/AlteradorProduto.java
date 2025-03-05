package dominio.Produto.interfaces;

import dominio.Produto.Produto;

public interface AlteradorProduto {
    void alterarNome(Produto produto, String novoNome);
}
