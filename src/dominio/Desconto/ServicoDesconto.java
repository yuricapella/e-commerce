package dominio.Desconto;

import dominio.Desconto.Pedido.DescontoPedido;
import dominio.Desconto.Produto.DescontoProduto;
import dominio.Pedido.ItemPedido;
import dominio.Pedido.Pedido;

import java.util.List;

public class ServicoDesconto {
    private List<DescontoPedido> descontosPedido;
    private List<DescontoProduto> descontosProduto;

    public ServicoDesconto(List<DescontoPedido> descontosPedido, List<DescontoProduto> descontosProduto) {
        this.descontosPedido = descontosPedido;
        this.descontosProduto = descontosProduto;
    }

    public double calcularMelhorDesconto(Pedido pedido) {
        double melhorDescontoPedido = 0;

        for (DescontoPedido desconto : descontosPedido) {
            double valorDesconto = desconto.calcular(pedido);
            if (valorDesconto > melhorDescontoPedido) {
                melhorDescontoPedido = valorDesconto;
            }
        }

        double melhorDescontoProduto = 0;

        for (ItemPedido item : pedido.getItens()) {
            for (DescontoProduto desconto : descontosProduto) {
                double valorDesconto = desconto.calcular(item);
                if (valorDesconto > melhorDescontoProduto) {
                    melhorDescontoProduto = valorDesconto;
                }
            }
        }

        return Math.max(melhorDescontoPedido, melhorDescontoProduto);
    }
}
