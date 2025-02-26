package dominio.Notificacao;

import dominio.Cliente.Cliente;
import dominio.Pedido.PedidoStatus;

public interface Notificador {
    void notificar(Cliente cliente, PedidoStatus status);
}
