package dominio.Desconto.Factory;

import dominio.Desconto.Pedido.DescontoFixo;
import dominio.Desconto.Pedido.DescontoPedido;
import dominio.Desconto.Pedido.DescontoPercentual;

import java.util.List;

public class DescontoPedidoFactory {
    public static List<DescontoPedido> getListaDescontoPedido() {
        return List.of(new DescontoFixo(200, 20), new DescontoPercentual(10));
    }
}
