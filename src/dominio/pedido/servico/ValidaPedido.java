package dominio.pedido.servico;

import dominio.produto.Produto;
import dominio.pedido.ItemPedido;
import dominio.pedido.Pedido;
import dominio.pedido.interfaces.ValidadorPedido;

public class ValidaPedido implements ValidadorPedido {

    @Override
    public boolean itemExiste(Pedido pedido, Produto produto) {
        for (ItemPedido item : pedido.getItens()) {
            if (item.getProduto().equals(produto)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void validarAdicaoItem(Pedido pedido, Produto produto) {
        if (itemExiste(pedido, produto)) {
            throw new IllegalArgumentException("O produto já foi adicionado ao pedido.");
        }
    }

    @Override
    public void validarRemocaoItem(Pedido pedido, Produto produto) {
        if (!itemExiste(pedido, produto)) {
            throw new IllegalArgumentException("O item já foi removido ou não existe no pedido.");
        }
    }

    @Override
    public void validarAlteracaoQuantidade(Pedido pedido, Produto produto) {
        if (!itemExiste(pedido, produto)) {
            throw new IllegalArgumentException("O item não existe no pedido.");
        }
    }
}
