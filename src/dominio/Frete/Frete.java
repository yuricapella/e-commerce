package dominio.Frete;

import dominio.Pedido.Pedido;

public interface Frete {
    double calcular(Pedido pedido);
}
