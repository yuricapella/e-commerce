package dominio.Pedido;

import dominio.Pagamento.Pagamento;
import dominio.Pagamento.PagamentoPix;

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

        Pagamento pagamento = new PagamentoPix();
        boolean pagamentoRealizado = pagamento.realizarPagamento(pedido.getValorTotal());

        if (pagamentoRealizado) {
            pedido.setStatus(PedidoStatus.PAGO);
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            throw new IllegalStateException("Erro ao processar pagamento.");
        }
    }

    public void finalizarPedido(Pedido pedido) {
        if (pedido.getStatus() != PedidoStatus.PAGO) {
            throw new IllegalStateException("Pedido ainda não foi pago!");
        }
        pedido.setStatus(PedidoStatus.FINALIZADO);
        System.out.println("Pedido finalizado.");
    }
}
