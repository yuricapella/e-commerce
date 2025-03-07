package repositorio.pedido.interfaces.especificas;

import dominio.pedido.Pedido;

public interface PedidoManipulacao {
    void adicionar(Pedido pedido);
    void remover(Pedido pedido);
}
