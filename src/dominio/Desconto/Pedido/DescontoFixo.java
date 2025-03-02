package dominio.Desconto.Pedido;

import dominio.Pedido.Pedido;

public class DescontoFixo implements DescontoPedido {
    private final double valorMinimo;
    private final double valorDesconto;

    public DescontoFixo(double valorMinimo, double valorDesconto) {
        this.valorMinimo = valorMinimo;
        this.valorDesconto = valorDesconto;
    }

    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValorTotal() >= valorMinimo ? valorDesconto : 0;
    }
}
