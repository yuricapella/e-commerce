package dominio.frete;

import dominio.pedido.Pedido;

public interface Frete {
    double calcular(Pedido pedido);
}
