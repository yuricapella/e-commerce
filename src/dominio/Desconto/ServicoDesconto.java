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

    public double calcularDescontoTotal(Pedido pedido) {
        double descontoPedido = calcularMelhorDescontoPedido(pedido);
        double descontoProduto = calcularMelhorDescontoProduto(pedido);
        return descontoPedido + descontoProduto;
    }

    public double calcularMelhorDescontoPedido(Pedido pedido) {
        double totalDesconto = 0;
        for (DescontoPedido desconto : descontosPedido) {
            double valorDesconto = desconto.calcular(pedido);
            totalDesconto += valorDesconto;  // Soma os descontos de pedido
        }
        return totalDesconto;
    }

    public double calcularMelhorDescontoProduto(Pedido pedido) {
        double totalDesconto = 0;
        for (ItemPedido item : pedido.getItens()) {
            for (DescontoProduto desconto : descontosProduto) {
                double valorDesconto = desconto.calcular(item);
                totalDesconto += valorDesconto;  // Soma os descontos de produto
            }
        }
        return totalDesconto;
    }
}
