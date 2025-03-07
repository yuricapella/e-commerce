package aplicacao.menu.menucliente;

import aplicacao.menu.util.FormatadorExibicao;
import dominio.desconto.ServicoDesconto;
import dominio.frete.FreteFactory;
import dominio.frete.ServicoFrete;
import dominio.pedido.Pedido;
import dominio.pedido.servico.ServicoPedido;
import dominio.produto.Produto;
import dominio.pedido.ItemPedido;

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
            FormatadorExibicao.exibirPedido(pedido,servicoDesconto,servicoFrete);

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Remover item");
            System.out.println("2. Alterar quantidade do item");
            System.out.println("3. Finalizar pedido");
            System.out.println("4. Voltar ao menu anterior");

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
        boolean menuAtivo = true;

        while (menuAtivo) {
            System.out.println("\nOpções:");
            System.out.println("1. Remover Produto do Pedido");
            System.out.println("2. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.print("Digite o ID do produto a remover: ");
                    try {
                        long id = Long.parseLong(scanner.nextLine());
                        Produto produto = verificaProdutoItemPedido(id);

                        if (produto == null) {
                            System.out.println("Produto não encontrado no pedido.");
                        } else {
                            pedido.removerItem(produto);
                            System.out.println("Produto removido com sucesso.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                    }
                    break;
                case "2":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    private void alterarQuantidadeItem() {
        boolean menuAtivo = true;

        while (menuAtivo) {
            System.out.println("\nOpções:");
            System.out.println("1. Alterar Quantidade de Produto");
            System.out.println("2. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.print("Digite o ID do produto para alterar a quantidade: ");
                    try {
                        long id = Long.parseLong(scanner.nextLine());
                        Produto produto = verificaProdutoItemPedido(id);

                        if (produto == null) {
                            System.out.println("Produto não encontrado no pedido.");
                        }else {
                            System.out.print("Digite a nova quantidade: ");
                            int novaQuantidade = Integer.parseInt(scanner.nextLine());

                            pedido.alterarQuantidadeItem(produto, novaQuantidade);
                            System.out.println("Quantidade atualizada.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID ou quantidade inválida.");
                    }
                    break;
                case "2":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    private void finalizarPedido() {
        boolean menuAtivo = true;

        while (menuAtivo) {
            System.out.println("\nOpções:");
            System.out.println("1. Finalizar Pedido");
            System.out.println("2. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    try {
                        servicoPedido.concluirPedido(pedido);
                        System.out.println("Pedido finalizado com sucesso.");
                    } catch (IllegalStateException e) {
                        System.out.println("Erro ao finalizar pedido: " + e.getMessage());
                    }
                    break;
                case "2":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
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
