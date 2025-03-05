package dominio.Produto;

import repositorio.produto.interfaces.compostas.RepositorioProduto;
import dominio.Produto.interfaces.AlteradorProduto;

public class ServicoProduto {
    private final RepositorioProduto repositorioProduto;
    private final AlteradorProduto alteradorProduto;

    public ServicoProduto(RepositorioProduto repositorioProduto, AlteradorProduto alteradorProduto) {
        this.repositorioProduto = repositorioProduto;
        this.alteradorProduto = alteradorProduto;
    }

    public void adicionarProduto(Produto produto) {
        if (repositorioProduto.buscarPorId(produto.getId()) != null) {
            System.out.println("Produto já está no repositório.");
            return;
        }
        if (produto.validarProduto()) {
            repositorioProduto.adicionar(produto);
        } else {
            throw new IllegalArgumentException("Produto inválido.");
        }
    }

    public void atualizarNomeProduto(Produto produto, String novoNome) {
        if (ValidaProduto.validarNome(novoNome)) {
            alteradorProduto.alterarNome(produto, novoNome);
        } else {
            throw new IllegalArgumentException("Nome inválido.");
        }
    }
}
