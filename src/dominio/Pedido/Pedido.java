package dominio.Pedido;

import dominio.Cliente.Cliente;
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
    private String status;
    private String statusPagamento;
    private double valorTotal;

    public Pedido(Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataCriacao = new Date();
        this.status = "ABERTO";
        this.statusPagamento = "PENDENTE";
        this.valorTotal = 0.0;
    }

    public void adicionarItem(Produto produto, int quantidade, double valorVenda) {
        if ("ABERTO".equals(this.status)) {
            ItemPedido item = new ItemPedido(produto, quantidade, valorVenda);
            this.itens.add(item);
            calcularValorTotal();
        }
    }

    public void removerItem(Produto produto) {
        if ("ABERTO".equals(this.status)) {
            this.itens.removeIf(item -> item.getProduto().equals(produto));
            calcularValorTotal();
        }
    }

    public void alterarQuantidadeItem(Produto produto, int novaQuantidade) {
        if ("ABERTO".equals(this.status)) {
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
        if (itens.size() > 0 && valorTotal > 0) {
            this.statusPagamento = "AGUARDANDO PAGAMENTO";
            // Notificar cliente por email
            System.out.println("Pedido Finalizado. Aguardando pagamento.");
        } else {
            throw new IllegalStateException("Pedido deve ter pelo menos um item e valor maior que zero.");
        }
    }

    public void pagar() {
        if ("AGUARDANDO PAGAMENTO".equals(this.statusPagamento)) {
            this.statusPagamento = "PAGO";
            this.status = "FINALIZADO";
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
    public String getStatus() {
        return status;
    }
    public String getStatusPagamento() {
        return statusPagamento;
    }
    public double getValorTotal() {
        return valorTotal;
    }
}

