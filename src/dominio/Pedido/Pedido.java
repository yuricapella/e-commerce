package dominio.Pedido;

import dominio.Cliente.Cliente;
import dominio.Pagamento.PagamentoStatus;
import dominio.Produto.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Pedido {
    private static long contador = 1;

    private long id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Date dataCriacao;
    private PedidoStatus status;
    private PagamentoStatus statusPagamento;
    private double valorTotal;

    public Pedido(Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataCriacao = new Date();
        this.status = PedidoStatus.ABERTO;
        this.statusPagamento = PagamentoStatus.PENDENTE;
        this.valorTotal = 0.0;
    }

    public void adicionarItem(Produto produto, int quantidade, double valorVenda) {
        if (this.status == PedidoStatus.ABERTO) {
            ItemPedido item = new ItemPedido(produto, quantidade, valorVenda);
            this.itens.add(item);
            calcularValorTotal();
        }
    }

    public void removerItem(Produto produto) {
        if (this.status == PedidoStatus.ABERTO) {
            this.itens.removeIf(item -> item.getProduto().equals(produto));
            calcularValorTotal();
        }
    }

    public void alterarQuantidadeItem(Produto produto, int novaQuantidade) {
        if (this.status == PedidoStatus.ABERTO) {
            for (ItemPedido item : itens) {
                if (item.getProduto().equals(produto)) {
                    item.setQuantidade(novaQuantidade);
                    calcularValorTotal();
                    break;
                }
            }
        }
    }

    public void finalizarPedido() {
        if (!itens.isEmpty() && valorTotal > 0 && this.statusPagamento == PagamentoStatus.PENDENTE) {
            this.statusPagamento = PagamentoStatus.AGUARDANDO_PAGAMENTO;
            System.out.println("Pedido Finalizado. Aguardando pagamento.");
        } else {
            throw new IllegalStateException("Pedido deve ter pelo menos um item, valor maior que zero e estar pendente.");
        }
    }

    public void pagar() {
        if (this.statusPagamento == PagamentoStatus.AGUARDANDO_PAGAMENTO) {
            this.statusPagamento = PagamentoStatus.PAGO;
            this.status = PedidoStatus.FINALIZADO;
            System.out.println("Pagamento confirmado. Pedido finalizado.");
        } else {
            throw new IllegalStateException("Não é possível pagar um pedido que não está aguardando pagamento.");
        }
    }

    private void calcularValorTotal() {
        this.valorTotal = 0;
        for (ItemPedido item : itens) {
            this.valorTotal += item.getValorTotal();
        }
    }

    public long getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public List<ItemPedido> getItens() {
        return itens;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public PedidoStatus getStatus() {
        return status;
    }
    public PagamentoStatus getStatusPagamento() {
        return statusPagamento;
    }
    public double getValorTotal() {
        return valorTotal;
    }
}

