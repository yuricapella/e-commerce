package dominio.pedido.servico;

import dominio.pagamento.Pagamento;
import dominio.pagamento.PagamentoPix;
import dominio.notificacao.ServicoNotificador;
import dominio.pedido.Pedido;
import dominio.pedido.PedidoStatus;

public class ServicoPedido {
    private final ServicoNotificador servicoNotificador;

    public ServicoPedido(ServicoNotificador servicoNotificador) {
        this.servicoNotificador = servicoNotificador;
    }

    public void concluirPedido(Pedido pedido) {
        if (pedido.getItens().isEmpty() || pedido.getValorTotal() <= 0 || pedido.getStatus() != PedidoStatus.ABERTO) {
            throw new IllegalStateException("Pedido deve ter ao menos um item, valor > 0 e estar aberto.");
        }
        pedido.setStatus(PedidoStatus.AGUARDANDO_PAGAMENTO);
        servicoNotificador.notificarMudancaDeStatus(pedido);
    }

    public void processarPagamento(Pedido pedido, double valorPagamento) {
        if (pedido.getStatus() != PedidoStatus.AGUARDANDO_PAGAMENTO) {
            throw new IllegalStateException("Pedido não está aguardando pagamento.");
        }

        Pagamento pagamento = new PagamentoPix();
        boolean pagamentoRealizado = pagamento.realizarPagamento(valorPagamento);

        if (pagamentoRealizado) {
            pedido.setStatus(PedidoStatus.PAGO);
            servicoNotificador.notificarMudancaDeStatus(pedido);
        } else {
            throw new IllegalStateException("Erro ao processar pagamento.");
        }
    }

    public void finalizarPedido(Pedido pedido) {
        if (pedido.getStatus() != PedidoStatus.PAGO) {
            throw new IllegalStateException("Pedido ainda não foi pago!");
        }

        pedido.setStatus(PedidoStatus.FINALIZADO);
        System.out.println("Pedido finalizado e entregue.");
        servicoNotificador.notificarMudancaDeStatus(pedido);
    }
}
