package teste.integracao;

import dominio.Produto.*;
import repositorio.produto.RepositorioProdutoAtivo;
import repositorio.produto.interfaces.compostas.ProdutoAtivo;

public class TesteProdutoCompleto {
    public static void main(String[] args) {
        Produto produto = new ProdutoEletronico("Tv 1",1080);
        Produto produto2 = new ProdutoPapelaria("caderno 1",29.99);
        Produto produto3 = new ProdutoLivro("livro 1",75.0);
        Produto produto4 = new ProdutoVestuario("camisa 1",49.50);

        ProdutoAtivo repositorioProduto = new RepositorioProdutoAtivo();
        ServicoProduto validarProduto = new ServicoProduto(repositorioProduto);
        validarProduto.adicionarProduto(produto);
        validarProduto.adicionarProduto(produto2);
        validarProduto.adicionarProduto(produto3);
        validarProduto.adicionarProduto(produto4);

        //produto3.setNome("2");
        //validarProduto.adicionarProduto(produto3); invalido
        System.out.println(repositorioProduto.buscarPorNome("livro 1"));
        repositorioProduto.alterarNome(produto3,"livro 2");

        System.out.println(repositorioProduto.buscarPorNome("livro 1"));

        System.out.println(repositorioProduto.listarProdutos());
        System.out.println(repositorioProduto.buscarPorId(1));

    }
}
