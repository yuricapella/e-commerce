package dominio.Pedido;

import dominio.Cliente.Cliente;
import dominio.Produto.Produto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
    private static long contador = 1;

    protected final long id;
    protected Cliente cliente;
    protected List<ItemPedido> itens;
    protected LocalDateTime dataCriacao;
    protected PedidoStatus status;

    public Pedido(Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataCriacao = LocalDateTime.now();
        this.status = PedidoStatus.ABERTO;
    }

    public abstract void validarPedido();

    public void adicionarItem(Produto produto, int quantidade, double valorVenda) {
        if (this.status == PedidoStatus.ABERTO) {
            ItemPedido item = new ItemPedido(produto, quantidade, valorVenda);
            this.itens.add(item);
            getValorTotal();
        }else{
            System.out.println("Pedido já foi finalizado");
        }
    }

    public void removerItem(Produto produto) {
        if (this.status == PedidoStatus.ABERTO) {
            this.itens.removeIf(item -> item.getProduto().equals(produto));
            getValorTotal();
        }else{
            System.out.println("Pedido já foi finalizado");
        }
    }

    public void alterarQuantidadeItem(Produto produto, int novaQuantidade) {
        if (this.status == PedidoStatus.ABERTO) {
            for (ItemPedido item : itens) {
                if (item.getProduto().equals(produto)) {
                    item.setQuantidade(novaQuantidade);
                    getValorTotal();
                    break;
                }
            }
        }else{
            System.out.println("Pedido já foi finalizado");
        }
    }

    public void setStatus(PedidoStatus novoStatus) {
        if (this.status == PedidoStatus.ABERTO && novoStatus == PedidoStatus.AGUARDANDO_PAGAMENTO) {
            this.status = novoStatus;
        } else if (this.status == PedidoStatus.AGUARDANDO_PAGAMENTO && novoStatus == PedidoStatus.PAGO) {
            this.status = novoStatus;
        } else if (this.status == PedidoStatus.PAGO && novoStatus == PedidoStatus.FINALIZADO) {
            this.status = novoStatus;
        } else {
            throw new IllegalStateException("Transição de status inválida: " + this.status + " -> " + novoStatus);
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
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public PedidoStatus getStatus() {
        return status;
    }
    public double getValorTotal() {
        return itens.stream().mapToDouble(ItemPedido::getValorTotal).sum();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder texto = new StringBuilder();

        texto.append(String.format("Pedido %d, %s, Status: %s, Valor Total: R$ %.2f, Data Criação: %s\n",
                id, cliente.getNome(), status, getValorTotal(), dataCriacao.format(formatter)));

        if (!itens.isEmpty()) {
            texto.append("Itens do Pedido:\n");
            for (ItemPedido item : itens) {
                texto.append(String.format("- %s, Quantidade: %d, Valor Total: R$ %.2f\n",
                        item.getProduto().getNome(), item.getQuantidade(), item.getValorTotal()));
            }
        } else {
            texto.append("Não há itens no pedido.\n");
        }

        return texto.toString();
    }
}

