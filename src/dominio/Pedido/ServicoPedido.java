package dominio.Pedido;

import dominio.Notificacao.Notificador;

public class ServicoPedido {
    private final Notificador notificador;
    private final Pedido pedido;

    public ServicoPedido(Notificador notificador, Pedido pedido) {
        this.notificador = notificador;
        this.pedido = pedido;
    }

    public void concluirPedido() {
        if (!pedido.getItens().isEmpty() && pedido.getValorTotal() > 0
                && pedido.getStatus() == PedidoStatus.ABERTO) {

            pedido.setStatus(PedidoStatus.AGUARDANDO_PAGAMENTO);
            notificador.notificar(pedido.getCliente(), pedido.getStatus());
        } else {
            throw new IllegalStateException("Pedido deve ter ao menos um item, valor > 0 e estar aberto.");
        }
    }
}
