package repositorio.produto.interfaces.especificas;

import dominio.Produto.Produto;

import java.util.List;

public interface ProdutoConsulta {
    List<Produto> listarProdutosInativos();
    List<Produto> listarProdutosAtivos();
    List<Produto> listarTodosProdutos();
    Produto buscarPorNome(String nome);
    Produto buscarPorId(long id);
}
