package dominio.Desconto.Produto;

import dominio.Pedido.ItemPedido;
import dominio.Produto.TipoProduto;

public class DescontoVestuario implements DescontoProduto {
    private final int quantidadeMinima;
    private final double percentualDesconto;

    public DescontoVestuario(int quantidadeMinima, double percentualDesconto) {
        this.quantidadeMinima = quantidadeMinima;
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public double calcular(ItemPedido itemPedido) {
        if (itemPedido.getProduto().getTipo() == TipoProduto.VESTUARIO &&
                itemPedido.getQuantidade() >= quantidadeMinima) {
            return percentualDesconto;
        }
        return 0;
    }
}

