package dominio.desconto.Pedido;

import dominio.pedido.Pedido;

public class DescontoPercentual implements DescontoPedido {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValorTotal() * (percentual / 100);
    }
}
