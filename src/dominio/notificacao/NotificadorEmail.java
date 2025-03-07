package dominio.notificacao;

import dominio.cliente.Cliente;
import dominio.pedido.PedidoStatus;

public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, PedidoStatus status) {
        String email = cliente.getEmail();
        System.out.printf("Seu pedido está com status: %s\n",status);
        System.out.printf("Notificação enviada para o email: %s\n", email);
    }
}
