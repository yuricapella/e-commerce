package dominio.Pagamento;

import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoStatus;

public class ServicoPagamento {
    //Notificar cliente sobre o pagamento aprovado
    public static void processarPagamento(Pedido pedido) {
        if (pedido.getStatus() == PedidoStatus.AGUARDANDO_PAGAMENTO) {
            pedido.setStatus(PedidoStatus.PAGO);
            System.out.println("Pagamento confirmado. Pedido marcado como pago.");
        } else {
            throw new IllegalStateException("Pedido não está aguardando pagamento.");
        }
    }
}

