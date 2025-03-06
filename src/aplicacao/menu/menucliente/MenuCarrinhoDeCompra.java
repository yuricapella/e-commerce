package aplicacao.menu.menucliente;

import aplicacao.menu.util.CalculadoraDeValoresPedido;
import dominio.Desconto.Produto.DescontoProduto;
import dominio.Desconto.ServicoDesconto;
import dominio.Frete.FreteFactory;
import dominio.Frete.ServicoFrete;
import dominio.Pedido.Pedido;
import dominio.Pedido.ServicoPedido;
import dominio.Produto.Produto;
import dominio.Pedido.ItemPedido;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuCarrinhoDeCompra {
    private Scanner scanner;
    private Pedido pedido;
    private ServicoDesconto servicoDesconto;
    private ServicoFrete servicoFrete;
    private ServicoPedido servicoPedido;

    public MenuCarrinhoDeCompra(Scanner scanner, Pedido pedido, ServicoDesconto servicoDesconto, ServicoPedido servicoPedido) {
        this.scanner = scanner;
        this.pedido = pedido;
        this.servicoDesconto = servicoDesconto;
        this.servicoFrete = new ServicoFrete(FreteFactory.criarFretes());
        this.servicoPedido = servicoPedido;
    }

    public void exibirMenu() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n==== Carrinho de Compras ====");

            System.out.printf("Pedido: %d, %s, Status: %s\n",
                    pedido.getId(), pedido.getCliente().getNome(), pedido.getStatus());
            System.out.printf("Data Criação: %s\n",
                    pedido.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            System.out.println("\nItens do Pedido:");
            for (ItemPedido item : pedido.getItens()) {
                Produto produto = item.getProduto();

                // Calcula o desconto específico para este produto
                double descontoItem = 0;
                for (DescontoProduto desconto : servicoDesconto.getDescontosProduto()) {
                    descontoItem += desconto.calcular(item);
                }

                System.out.printf("ID: %d - %s | Quantidade: %d | Valor Unitário: R$ %.2f | Valor Total: R$ %.2f | Desconto Produto: R$ %.2f\n",
                        produto.getId(), produto.getNome(), item.getQuantidade(), produto.getValorProduto(), item.getValorTotal(), descontoItem);
            }
            System.out.printf("Valor total pedido sem desconto: R$ %.2f\n",pedido.getValorTotal());

            double descontoPedido = CalculadoraDeValoresPedido.calcularDescontoPedido(pedido, servicoDesconto);
            double totalDesconto = descontoPedido + CalculadoraDeValoresPedido.calcularDescontoProduto(pedido, servicoDesconto);
            double valorTotalComDesconto = CalculadoraDeValoresPedido.calcularValorTotalComDesconto(pedido, servicoDesconto);
            double valorFrete = CalculadoraDeValoresPedido.calcularValorFrete(pedido, servicoFrete);
            double valorTotalFinal = CalculadoraDeValoresPedido.calcularValorTotalFinal(pedido, servicoDesconto, servicoFrete);

            System.out.printf("\nDesconto Pedido: R$ %.2f\n", descontoPedido);
            System.out.printf("Valor Total de Descontos: R$ %.2f\n", totalDesconto);
            System.out.printf("Valor Total com Desconto: R$ %.2f\n", valorTotalComDesconto);
            System.out.printf("Valor do Frete: R$ %.2f\n", valorFrete);
            System.out.printf("Valor Total Final (com frete): R$ %.2f\n", valorTotalFinal);

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Remover item");
            System.out.println("2. Alterar quantidade do item");
            System.out.println("3. Finalizar pedido");
            System.out.println("4. Voltar ao menu anterior");

            // Espera a entrada do usuário
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
        try {
            servicoPedido.concluirPedido(pedido);
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
