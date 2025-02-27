package dominio.Pedido;

import dominio.Cliente.Cliente;

public class PedidoPadrao extends Pedido {
    public PedidoPadrao(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void validarPedido() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido não pode estar vazio");
        }
        if (getValorTotal() <= 0) {
            throw new IllegalStateException("Valor total do pedido inválido");
        }
    }
}
