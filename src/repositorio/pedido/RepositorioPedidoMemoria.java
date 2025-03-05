package repositorio.pedido;

import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoStatus;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPedidoMemoria implements RepositorioPedido {
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void adicionar(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void remover(Pedido pedido) {
        pedidos.remove(pedido);
    }

    @Override
    public Pedido buscarPorId(long id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public List<Pedido> listarEmAndamento() {
        List<Pedido> emAndamento = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() != PedidoStatus.FINALIZADO) {
                emAndamento.add(pedido);
            }
        }
        return emAndamento;
    }

    @Override
    public List<Pedido> listarFinalizados() {
        List<Pedido> finalizados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == PedidoStatus.FINALIZADO) {
                finalizados.add(pedido);
            }
        }
        return finalizados;
    }
}
