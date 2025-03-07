package dominio.desconto.Produto;

import dominio.pedido.ItemPedido;

public interface DescontoProduto {
    double calcular(ItemPedido itemPedido);
}
