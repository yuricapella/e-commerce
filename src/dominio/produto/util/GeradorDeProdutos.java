package dominio.produto.util;

import dominio.produto.*;

import java.util.ArrayList;
import java.util.List;

public class GeradorDeProdutos {
    public static List<Produto> gerarListaDeProdutos(int quantidadeEletronicos, int quantidadeLivros, int quantidadePapelaria, int quantidadeVestuario) {
        List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < quantidadeEletronicos; i++) {
            ProdutoEletronico eletronico = new ProdutoEletronico("Eletrônico " + (i + 1), 50 + i * 10);
            produtos.add(eletronico);
        }

        for (int i = 0; i < quantidadeLivros; i++) {
            ProdutoLivro livro = new ProdutoLivro("Livro " + (i + 1), 20 + i * 5);
            produtos.add(livro);
        }

        for (int i = 0; i < quantidadePapelaria; i++) {
            ProdutoPapelaria papelaria = new ProdutoPapelaria("Caderno " + (i + 1), 5 + i * 2);
            produtos.add(papelaria);
        }

        for (int i = 0; i < quantidadeVestuario; i++) {
            ProdutoVestuario vestuario = new ProdutoVestuario("Camiseta " + (i + 1), 30 + i * 5);
            produtos.add(vestuario);
        }

        return produtos;
    }
}
