package aplicacao.menu.menucliente;

import dominio.Pedido.ItemPedido;
import dominio.Produto.Produto;
import dominio.Pedido.Pedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import java.util.List;
import java.util.Scanner;

public class MenuProduto {
    private Scanner scanner;
    private RepositorioProduto repositorioProduto;
    private Pedido pedido;

    public MenuProduto(Scanner scanner, RepositorioProduto repositorioProduto, Pedido pedido) {
        this.scanner = scanner;
        this.repositorioProduto = repositorioProduto;
        this.pedido = pedido;
    }

    public void exibirMenu() {
        List<Produto> produtos = repositorioProduto.listarProdutosAtivos();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
            return;
        }

        System.out.println("Lista de Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        System.out.println("\nDigite o ID do produto para adicioná-lo ao pedido ou 'voltar' para retornar:");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("voltar")) {
            return;
        }

        try {
            long id = Long.parseLong(input);
            Produto produto = repositorioProduto.buscarPorId(id);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
                return;
            }

            boolean produtoJaAdicionado = false;
            for (ItemPedido item : pedido.getItens()) {
                if (item.getProduto().equals(produto)) {
                    produtoJaAdicionado = true;
                    break;
                }
            }

            if (produtoJaAdicionado) {
                System.out.println("O produto já foi adicionado ao pedido.");
                return;
            }

            System.out.print("Informe a quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida. Deve ser maior que 0.");
                return;
            }

            double valorVenda = produto.getValorProduto();
            pedido.adicionarItem(produto, quantidade, valorVenda);
            System.out.println("Produto adicionado ao pedido.");

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número válido.");
        }
    }

}
