package dominio.pedido.interfaces;

import dominio.produto.Produto;

public interface PedidoModificacao {
    void adicionarItem(Produto produto, int quantidade, double valorVenda);
    boolean removerItem(Produto produto);
    void alterarQuantidadeItem(Produto produto, int novaQuantidade);
}
