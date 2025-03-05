package repositorio.pedido.interfaces.especificas;

import dominio.Pedido.Pedido;

import java.util.List;

public interface RepositorioPedidoListagem {
    Pedido buscarPorId(long id);
    List<Pedido> listarTodosPedidos();
    List<Pedido> listarEmAndamento();
    List<Pedido> listarFinalizados();
}
