package dominio.Pedido;

public class ServicoPedido {
    // Notificar cliente sobre o pagamento pendente
    public static void concluirPedido(Pedido pedido) {
        if (!pedido.getItens().isEmpty() && pedido.getValorTotal() > 0
                && pedido.getStatus() == PedidoStatus.ABERTO) {

            pedido.setStatus(PedidoStatus.AGUARDANDO_PAGAMENTO);
            System.out.println("Pedido concluído. Aguardando pagamento.");
        } else {
            throw new IllegalStateException("Pedido deve ter ao menos um item, valor > 0 e estar aberto.");
        }
    }
}
