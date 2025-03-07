package dominio.pedido;

import dominio.cliente.Cliente;
import dominio.produto.Produto;
import dominio.pedido.interfaces.ValidadorPedido;

public class PedidoPadrao extends Pedido {
    private final ValidadorPedido validadorPedido;

    public PedidoPadrao(Cliente cliente, ValidadorPedido validadorPedido) {
        super(cliente);
        this.validadorPedido = validadorPedido;
    }

    public void adicionarItem(Produto produto, int quantidade, double valorVenda) {
        if (this.getStatus() != PedidoStatus.ABERTO) {
            System.out.println("Pedido já foi finalizado.");
            return;
        }

        try {
            validadorPedido.validarAdicaoItem(this, produto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        ItemPedido item = new ItemPedido(produto, quantidade, valorVenda);
        this.getItens().add(item);
        getValorTotal();
    }

    public void removerItem(Produto produto) {
        if (this.getStatus() != PedidoStatus.ABERTO) {
            System.out.println("Pedido já foi finalizado.");
            return;
        }

        try {
            validadorPedido.validarRemocaoItem(this, produto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        this.getItens().removeIf(item -> item.getProduto().equals(produto));
        getValorTotal();
    }

    public void alterarQuantidadeItem(Produto produto, int novaQuantidade) {
        if (this.getStatus() != PedidoStatus.ABERTO) {
            System.out.println("Pedido já foi finalizado.");
            return;
        }

        try {
            validadorPedido.validarAlteracaoQuantidade(this, produto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (ItemPedido item : this.getItens()) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(novaQuantidade);
                getValorTotal();
                return;
            }
        }
    }
}
