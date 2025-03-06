package dominio.Produto;

import repositorio.produto.interfaces.compostas.RepositorioProduto;
import dominio.Produto.interfaces.AlteradorProduto;

import java.util.List;

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

    public void adicionarProduto(List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            if (repositorioProduto.buscarPorId(produto.getId()) != null) {
                System.out.println("Produto já está no repositório: " + produto.getNome());
                continue; // Pula o produto se já existir
            }
            if (produto.validarProduto()) {
                repositorioProduto.adicionar(produto);
            } else {
                System.out.println("Produto inválido: " + produto.getNome());
            }
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
