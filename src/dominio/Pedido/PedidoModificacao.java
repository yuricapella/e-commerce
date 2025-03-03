package dominio.Pedido;

import dominio.Produto.Produto;

public interface PedidoModificacao {
    void adicionarItem(Produto produto, int quantidade, double valorVenda);
    void removerItem(Produto produto);
    void alterarQuantidadeItem(Produto produto, int novaQuantidade);
}
