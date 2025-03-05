package dominio.Pedido;

import dominio.cliente.Cliente;
import dominio.Produto.Produto;

public class PedidoPadrao extends Pedido {
    public PedidoPadrao(Cliente cliente) {
        super(cliente);
    }

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

    @Override
    public void validarPedido() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido não pode estar vazio");
        }
        if (getValorTotal() <= 0) {
            throw new IllegalStateException("Valor total do pedido inválido");
        }
    }
}
