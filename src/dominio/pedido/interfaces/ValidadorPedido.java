package dominio.pedido.interfaces;
import dominio.produto.Produto;
import dominio.pedido.Pedido;

public interface ValidadorPedido {
    boolean itemExiste(Pedido pedido, Produto produto);
    void validarAdicaoItem(Pedido pedido, Produto produto);
    void validarRemocaoItem(Pedido pedido, Produto produto);
    void validarAlteracaoQuantidade(Pedido pedido, Produto produto);
}
