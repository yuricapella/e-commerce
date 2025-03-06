package aplicacao.Menu.MenuCliente;

import dominio.Notificacao.Notificador;
import dominio.Notificacao.NotificadorEmail;
import dominio.Pedido.Pedido;
import dominio.Pedido.ServicoPedido;
import dominio.Produto.Produto;
import dominio.Pedido.ItemPedido;
import java.util.Scanner;

public class MenuPedido {
    private Scanner scanner;
    private Pedido pedido;

    public MenuPedido(Scanner scanner, Pedido pedido) {
        this.scanner = scanner;
        this.pedido = pedido;
    }

    public void exibirMenu() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n==== Carrinho de Compras ====");
            System.out.println(pedido);
            System.out.println("1. Remover item");
            System.out.println("2. Alterar quantidade do item");
            System.out.println("3. Finalizar pedido");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    removerItem();
                    break;
                case "2":
                    alterarQuantidadeItem();
                    break;
                case "3":
                    finalizarPedido();
                    break;
                case "4":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void removerItem() {
        System.out.print("Digite o ID do produto a remover: ");
        try {
            long id = Long.parseLong(scanner.nextLine());
            Produto produto = verificaProdutoItemPedido(id);

            if (produto == null) {
                System.out.println("Produto não encontrado no pedido.");
                return;
            }
            pedido.removerItem(produto);
            System.out.println("Produto removido do pedido.");

        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    private void alterarQuantidadeItem() {
        System.out.print("Digite o ID do produto para alterar a quantidade: ");
        try {
            long id = Long.parseLong(scanner.nextLine());
            Produto produto = verificaProdutoItemPedido(id);

            if (produto == null) {
                System.out.println("Produto não encontrado no pedido.");
                return;
            }
            System.out.print("Digite a nova quantidade: ");
            int novaQuantidade = Integer.parseInt(scanner.nextLine());

            pedido.alterarQuantidadeItem(produto, novaQuantidade);
            System.out.println("Quantidade atualizada.");

        } catch (NumberFormatException e) {
            System.out.println("ID ou quantidade inválida.");
        }
    }

    private void finalizarPedido() {
        ServicoPedido servicoPedido = new ServicoPedido();
        Notificador notificador = new NotificadorEmail();
        try {
            servicoPedido.concluirPedido(pedido);
            notificador.notificar(pedido.getCliente(), pedido.getStatus());
        } catch (IllegalStateException e) {
            System.out.println("Erro ao finalizar pedido: " + e.getMessage());
        }
    }

    private Produto verificaProdutoItemPedido(long id) {
        for (ItemPedido item : pedido.getItens()) {
            if (item.getProduto().getId() == id) {
                return item.getProduto();
            }
        }
        return null;
    }
}
