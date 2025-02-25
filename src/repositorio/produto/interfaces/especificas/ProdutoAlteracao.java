package repositorio.produto.interfaces.especificas;

import dominio.Produto.Produto;

public interface ProdutoAlteracao {
    void alterarNome(Produto produto, String novoNome);
}
