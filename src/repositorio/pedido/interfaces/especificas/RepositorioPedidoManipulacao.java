package repositorio.pedido.interfaces.especificas;

import dominio.Pedido.Pedido;

public interface RepositorioPedidoManipulacao {
    void adicionar(Pedido pedido);
    void remover(Pedido pedido);
}
