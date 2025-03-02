package dominio.Desconto.Pedido;

import dominio.Pedido.Pedido;

public interface DescontoPedido {
    double calcular(Pedido pedido);
}
