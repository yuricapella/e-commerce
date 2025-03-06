package dominio.Pedido;
import dominio.Produto.Produto;

public interface ValidadorPedido {
    boolean itemExiste(Pedido pedido, Produto produto);
    void validarAdicaoItem(Pedido pedido, Produto produto);
    void validarRemocaoItem(Pedido pedido, Produto produto);
    void validarAlteracaoQuantidade(Pedido pedido, Produto produto);
}
