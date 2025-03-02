package dominio.Desconto.Produto;

import dominio.Pedido.ItemPedido;

public interface DescontoProduto {
    double calcular(ItemPedido itemPedido);
}
