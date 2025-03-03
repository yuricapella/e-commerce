package dominio.Notificacao;

import dominio.Pedido.Pedido;

public class ServicoNotificador {
    private final Notificador notificador;

    public ServicoNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

    public void notificarMudancaDeStatus(Pedido pedido) {
        notificador.notificar(pedido.getCliente(), pedido.getStatus());
    }
}
