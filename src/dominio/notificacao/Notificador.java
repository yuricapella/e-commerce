package dominio.notificacao;

import dominio.cliente.Cliente;
import dominio.pedido.PedidoStatus;

public interface Notificador {
    void notificar(Cliente cliente, PedidoStatus status);
}
