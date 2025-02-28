package dominio.Desconto.Pedido;

import dominio.Pedido.Pedido;

public class DescontoPercentual implements DescontoPedido {
    @Override
    public double calcular(Pedido pedido) {
        return 0;
    }
}
