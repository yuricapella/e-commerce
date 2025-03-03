package aplicacao.Menu.MenuAdmin;

import dominio.Cliente.Cliente;
import dominio.Pedido.Pedido;
import dominio.Produto.Produto;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Pedido> pedidos;

    public MenuAdmin(Scanner scanner, Usuario usuarioLogado, List<Cliente> clientes, List<Produto> produtos, List<Pedido> pedidos) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;
        this.clientes = clientes;
        this.produtos = produtos;
        this.pedidos = pedidos;
    }

    public void exibirMenu() {
        boolean adminMenuAtivo = true;
        while (adminMenuAtivo) {
            System.out.println("Bem-vindo, " + usuarioLogado.getLogin() + "! Acesso concedido como administrador.");
            System.out.println("1. Clientes");
            System.out.println("2. Produtos");
            System.out.println("3. Pedidos");
            System.out.println("4. Deslogar");
            System.out.print("Escolha uma opção: ");

            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    exibirClientes();  // Lógica para exibir clientes
                    break;
                case "2":
                    exibirProdutos();  // Lógica para exibir produtos
                    break;
                case "3":
                    exibirPedidos();  // Lógica para exibir pedidos
                    break;
                case "4":
                    System.out.println("Deslogando...");
                    adminMenuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirClientes() {
        System.out.println("1. Clientes Ativos");
        System.out.println("2. Clientes Inativos");
        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                System.out.println("Clientes Ativos:");
                for (Cliente cliente : clientes) {
                    if (cliente.isAtivo()) {
                        System.out.println(cliente.getNome());
                    }
                }
                break;
            case "2":
                System.out.println("Clientes Inativos:");
                for (Cliente cliente : clientes) {
                    if (!cliente.isAtivo()) {
                        System.out.println(cliente.getNome());
                    }
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void exibirProdutos() {
        System.out.println("1. Produtos Ativos");
        System.out.println("2. Produtos Inativos");
        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                System.out.println("Produtos Ativos:");
                for (Produto produto : produtos) {
                    if (produto.isAtivo()) {
                        System.out.println(produto.getNome());
                    }
                }
                break;
            case "2":
                System.out.println("Produtos Inativos:");
                for (Produto produto : produtos) {
                    if (!produto.isAtivo()) {
                        System.out.println(produto.getNome());
                    }
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void exibirPedidos() {
        System.out.println("1. Pedidos em Andamento");
        System.out.println("2. Pedidos Finalizados");
        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                System.out.println("Pedidos em Andamento:");
                for (Pedido pedido : pedidos) {
                    if (pedido.isEmAndamento()) {
                        System.out.println("Pedido ID: " + pedido.getId());
                    }
                }
                break;
            case "2":
                System.out.println("Pedidos Finalizados:");
                for (Pedido pedido : pedidos) {
                    if (!pedido.isEmAndamento()) {
                        System.out.println("Pedido ID: " + pedido.getId());
                    }
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
