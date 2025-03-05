package repositorio.pedido.interfaces.especificas;

import dominio.Pedido.Pedido;
import dominio.cliente.Cliente;

import java.util.List;

public interface PedidoConsulta {
    Pedido buscarPorId(long id);
    Pedido buscarPorCliente(Cliente cliente);
    List<Pedido> listarTodosPedidos();
    List<Pedido> listarEmAndamento();
    List<Pedido> listarFinalizados();
}
