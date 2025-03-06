package aplicacao.menu.menucliente;

import aplicacao.menu.util.CalculadoraDeValoresPedido;
import dominio.Desconto.ServicoDesconto;
import dominio.Frete.FreteFactory;
import dominio.Frete.ServicoFrete;
import dominio.Pedido.Pedido;
import dominio.Pedido.ServicoPedido;
import dominio.Produto.Produto;
import dominio.Pedido.ItemPedido;
import java.util.Scanner;

public class MenuPedido {
    private Scanner scanner;
    private Pedido pedido;
    private ServicoDesconto servicoDesconto;
    private ServicoFrete servicoFrete;
    private ServicoPedido servicoPedido;

    public MenuPedido(Scanner scanner, Pedido pedido, ServicoDesconto servicoDesconto, ServicoPedido servicoPedido) {
        this.scanner = scanner;
        this.pedido = pedido;
        this.servicoDesconto = servicoDesconto;
        this.servicoFrete = new ServicoFrete(FreteFactory.criarFretes());
        this.servicoPedido = servicoPedido;
    }

    public void exibirMenu() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            exibirInformacoesPedido();

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

    private void exibirInformacoesPedido() {
        double descontoPedido = CalculadoraDeValoresPedido.calcularDescontoPedido(pedido, servicoDesconto);
        double descontoProduto = CalculadoraDeValoresPedido.calcularDescontoProduto(pedido, servicoDesconto);
        double totalDesconto = descontoPedido + descontoProduto;
        double valorTotalComDesconto = CalculadoraDeValoresPedido.calcularValorTotalComDesconto(pedido, servicoDesconto);

        double valorFrete = CalculadoraDeValoresPedido.calcularValorFrete(pedido, servicoFrete);
        double valorTotalFinal = CalculadoraDeValoresPedido.calcularValorTotalFinal(pedido, servicoDesconto, servicoFrete);

        System.out.println("\n==== Carrinho de Compras ====");
        System.out.println(pedido);
        System.out.println("Desconto do Pedido: R$ " + descontoPedido);
        System.out.println("Desconto de Produto: R$ " + descontoProduto);
        System.out.println("Valor Total de Desconto: R$ " + totalDesconto);
        System.out.println("Valor Total com Desconto: R$ " + valorTotalComDesconto);
        System.out.println("Valor do Frete: R$ " + valorFrete);
        System.out.println("Valor Total Final (com frete): R$ " + valorTotalFinal);
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
