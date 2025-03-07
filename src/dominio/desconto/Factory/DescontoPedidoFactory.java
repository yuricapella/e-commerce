package dominio.desconto.Factory;

import dominio.desconto.Pedido.DescontoFixo;
import dominio.desconto.Pedido.DescontoPedido;

import java.util.List;

public class DescontoPedidoFactory {
    public static List<DescontoPedido> getListaDescontoPedido() {
        return List.of(new DescontoFixo(200, 20));
    }
}
