package repositorio.produto.interfaces.especificas;

import dominio.Produto.Produto;

import java.util.List;

public interface ProdutoConsulta {
    List<Produto> listarProdutos();
    Produto buscarPorNome(String nome);
    Produto buscarPorId(long id);
}
