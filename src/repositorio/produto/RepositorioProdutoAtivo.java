package repositorio.produto;

import dominio.Cliente.Cliente;
import dominio.Produto.Produto;
import repositorio.produto.interfaces.compostas.ProdutoAtivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioProdutoAtivo implements ProdutoAtivo {
    private final Map<Long, Produto> produtos = new HashMap<>();

    @Override
    public void alterarNome(Produto produto, String novoNome) {
        if (produto != null) {
            produto.setNome(novoNome);
            produtos.put(produto.getId(), produto);
        }
    }

    @Override
    public Produto buscarPorId(long id) {
        return produtos.get(id);
    }

    public void adicionar(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    @Override
    public void remover(Produto produto) {
        produtos.remove(produto.getId());
    }

    @Override
    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos.values());
    }

    @Override
    public Produto buscarPorNome(String nome) {
        for (Produto produto : produtos.values()) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }
}
