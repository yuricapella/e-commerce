package dominio.Produto;

import repositorio.produto.interfaces.compostas.ProdutoAtivo;

public class ServicoProduto {
    private ProdutoAtivo produtoAtivo;

    public ServicoProduto(ProdutoAtivo produtoAtivo) {
        this.produtoAtivo = produtoAtivo;
    }

    public void adicionarProduto(Produto produto) {
        if (produto.validarProduto()) {
            produtoAtivo.adicionar(produto);
        } else {
            throw new IllegalArgumentException("Produto inválido.");
        }
    }
}
