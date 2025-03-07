package teste.integracao;

import dominio.produto.*;
import dominio.produto.interfaces.AlteradorProduto;
import dominio.produto.interfaces.ValidadorProduto;
import dominio.produto.servico.AlteraProduto;
import dominio.produto.servico.ServicoProduto;
import dominio.produto.servico.ValidaProduto;
import repositorio.produto.RepositorioProdutoMemoria;
import repositorio.produto.interfaces.compostas.RepositorioProduto;

public class TesteProdutoCompleto {
    public static void main(String[] args) {
        // Criação de produtos
        Produto produto1 = new ProdutoEletronico("Tv 1", 1080);
        Produto produto2 = new ProdutoPapelaria("Caderno 1", 29.99);
        Produto produto3 = new ProdutoLivro("Livro 1", 75.0);
        Produto produto4 = new ProdutoVestuario("Camisa 1", 49.50);

        // Inicialização do repositório, validadores e serviços
        RepositorioProduto repositorioProduto = new RepositorioProdutoMemoria();
        ValidadorProduto validadorProduto = new ValidaProduto();
        AlteradorProduto alteradorProduto = new AlteraProduto(validadorProduto);
        ServicoProduto servicoProduto = new ServicoProduto(repositorioProduto, alteradorProduto);

        // Adicionando produtos ao repositório
        System.out.println("Adicionando produtos ao repositório...");
        servicoProduto.adicionarProduto(produto1);
        servicoProduto.adicionarProduto(produto2);
        servicoProduto.adicionarProduto(produto3);
        servicoProduto.adicionarProduto(produto4);
        System.out.println("Produtos adicionados com sucesso.\n");

        // Teste de busca de produto por nome
        System.out.println("Buscando produto por nome 'Livro 1'...");
        Produto produtoEncontrado = repositorioProduto.buscarPorNome("Livro 1");
        System.out.println("Produto encontrado: " + produtoEncontrado + "\n");

        // Teste de alteração de nome do produto
        System.out.println("Alterando nome do produto 'Tv 1' para 'Livro 2'...");
        alteradorProduto.alterarNome(produto1, "Livro 2");

        // Buscando o produto com nome alterado
        System.out.println("Buscando produto por nome 'Livro 1' após alteração...");
        produtoEncontrado = repositorioProduto.buscarPorNome("Livro 1");
        System.out.println("Produto encontrado: " + produtoEncontrado + "\n");

        // Listando todos os produtos
        System.out.println("Listando todos os produtos ativos...");
        System.out.println(repositorioProduto.listarProdutosAtivos() + "\n");

        System.out.println("Listando todos os produtos inativos...");
        System.out.println(repositorioProduto.listarProdutosInativos() + "\n");

        System.out.println("Listando todos os produtos...");
        System.out.println(repositorioProduto.listarTodosProdutos() + "\n");

        // Buscando produto por ID
        System.out.println("Buscando produto por ID '1'...");
        Produto produtoPorId = repositorioProduto.buscarPorId(1);
        System.out.println("Produto encontrado por ID: " + produtoPorId + "\n");
    }
}
