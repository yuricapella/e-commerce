package dominio.Notificacao;

import dominio.cliente.Cliente;
import dominio.Pedido.PedidoStatus;

public interface Notificador {
    void notificar(Cliente cliente, PedidoStatus status);
}
