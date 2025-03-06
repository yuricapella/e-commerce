package dominio.Pedido;

import dominio.cliente.Cliente;
import dominio.Produto.Produto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Pedido implements PedidoModificacao{
    private static long contador = 1;
    private final long id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private LocalDateTime dataCriacao;
    private PedidoStatus status;

    public Pedido(Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataCriacao = LocalDateTime.now();
        this.status = PedidoStatus.ABERTO;
    }

    public abstract void adicionarItem(Produto produto, int quantidade, double valorVenda);

    public abstract void removerItem(Produto produto);

    public abstract void alterarQuantidadeItem(Produto produto, int novaQuantidade);

    protected void setStatus(PedidoStatus novoStatus) {
        this.status = novoStatus;
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
                texto.append(String.format("- %s, Valor Unitário: %.2f, Quantidade: %d, Valor Total: R$ %.2f\n",
                        item.getProduto().getNome(), item.getValorVenda(), item.getQuantidade(), item.getValorTotal()));
            }
        } else {
            texto.append("Não há itens no pedido.\n");
        }

        return texto.toString();
    }
}

