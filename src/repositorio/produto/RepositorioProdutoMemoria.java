package repositorio.produto;

import dominio.Produto.Produto;
import repositorio.produto.interfaces.compostas.RepositorioProduto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioProdutoMemoria implements RepositorioProduto {
    private final Map<Long, Produto> produtos = new HashMap<>();

    @Override
    public void adicionar(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    @Override
    public void remover(Produto produto) {
        produto.setAtivo(false);
    }

    @Override
    public Produto buscarPorId(long id) {
        return produtos.get(id);
    }

    @Override
    public List<Produto> listarProdutosAtivos() {
        List<Produto> produtosAtivos = new ArrayList<>();
        for (Produto produto : produtos.values()) {
            if (produto.isAtivo()) {
                produtosAtivos.add(produto);
            }
        }
        return produtosAtivos;
    }

    @Override
    public List<Produto> listarProdutosInativos() {
        List<Produto> produtosInativos = new ArrayList<>();
        for (Produto produto : produtos.values()) {
            if (!produto.isAtivo()) {
                produtosInativos.add(produto);
            }
        }
        return produtosInativos;
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return new ArrayList<>(produtos.values());
    }

    public Produto buscarPorNome(String nome) {
        for (Produto produto : produtos.values()) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }
}
