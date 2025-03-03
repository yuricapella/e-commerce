package dominio.Pedido;

public class ServicoPedido {
    public void concluirPedido(Pedido pedido) {
        if (pedido.getItens().isEmpty() || pedido.getValorTotal() <= 0 || pedido.getStatus() != PedidoStatus.ABERTO) {
            throw new IllegalStateException("Pedido deve ter ao menos um item, valor > 0 e estar aberto.");
        }
        pedido.setStatus(PedidoStatus.AGUARDANDO_PAGAMENTO);
    }

    public void processarPagamento(Pedido pedido) {
        if (pedido.getStatus() != PedidoStatus.AGUARDANDO_PAGAMENTO) {
            throw new IllegalStateException("Pedido não está aguardando pagamento.");
        }
        pedido.setStatus(PedidoStatus.PAGO);
    }

    public void finalizarPedido(Pedido pedido) {
        if (pedido.getStatus() != PedidoStatus.PAGO) {
            throw new IllegalStateException("Pedido ainda não foi pago!");
        }
        pedido.setStatus(PedidoStatus.FINALIZADO);
    }
}
