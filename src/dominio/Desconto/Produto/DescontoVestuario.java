package dominio.Desconto.Produto;

import dominio.Pedido.ItemPedido;

public class DescontoVestuario implements DescontoProduto {
    @Override
    public double calcular(ItemPedido itemPedido) {
        return 0;
    }
}
