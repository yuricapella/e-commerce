package dominio.Pagamento;

import dominio.Notificacao.Notificador;
import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoStatus;

public class ServicoPagamento {
    private final Notificador notificador;
    private final Pedido pedido;

    public ServicoPagamento(Notificador notificador, Pedido pedido) {
        this.notificador = notificador;
        this.pedido = pedido;
    }

    public void processarPagamento() {
        if (pedido.getStatus() == PedidoStatus.AGUARDANDO_PAGAMENTO) {
            pedido.setStatus(PedidoStatus.PAGO);
            notificador.notificar(pedido.getCliente(), pedido.getStatus());
        } else {
            throw new IllegalStateException("Pedido não está aguardando pagamento.");
        }
    }
}

