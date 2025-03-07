package dominio.desconto.Pedido;

import dominio.pedido.Pedido;

public interface DescontoPedido {
    double calcular(Pedido pedido);
}
