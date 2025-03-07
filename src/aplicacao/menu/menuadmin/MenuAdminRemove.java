package aplicacao.menu.menuadmin;

import dominio.produto.Produto;
import dominio.cliente.Cliente;
import dominio.usuario.Usuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;
import java.util.List;
import java.util.Scanner;

public class MenuAdminRemove {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private RepositorioCliente repositorioCliente;
    private RepositorioProduto repositorioProduto;
    private RepositorioPedido repositorioPedido;
    private RepositorioUsuario repositorioUsuario;

    public MenuAdminRemove(Scanner scanner, Usuario usuarioLogado,
                           RepositorioCliente repositorioCliente,
                           RepositorioProduto repositorioProduto,
                           RepositorioPedido repositorioPedido,
                           RepositorioUsuario repositorioUsuario) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;
        this.repositorioCliente = repositorioCliente;
        this.repositorioProduto = repositorioProduto;
        this.repositorioPedido = repositorioPedido;
        this.repositorioUsuario = repositorioUsuario;
    }

    public void exibirMenu() {
        boolean adminMenuAtivo = true;
        while (adminMenuAtivo) {
            System.out.println("\nBem-vindo, " + usuarioLogado.getLogin() + "! Remoção de dados.");
            System.out.println("1. Remover Cliente");
            System.out.println("2. Remover Produto");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    desativarCliente();
                    break;
                case "2":
                    desativarProduto();
                    break;
                case "3":
                    removerUsuario();
                    break;
                case "4":
                    adminMenuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void desativarCliente() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            List<Cliente> clientesAtivos = repositorioCliente.listarClientesAtivos();

            if (clientesAtivos.isEmpty()) {
                System.out.println("Não há clientes ativos para desativar.");
                break;
            }

            System.out.println("\nClientes Ativos:");
            clientesAtivos.forEach(System.out::println);

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Desativar Cliente");
            System.out.println("2. Voltar");
            System.out.print("Digite a opção: ");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.print("Digite o ID do cliente a ser desativado: ");
                    String idStr = scanner.nextLine();
                    long idCliente = Long.parseLong(idStr);

                    Cliente cliente = repositorioCliente.buscarPorId(idCliente);

                    if (cliente != null && cliente.isAtivo()) {
                        repositorioCliente.remover(cliente);
                        System.out.println("Cliente desativado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado ou já está inativo.");
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

    private void desativarProduto() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            List<Produto> produtosAtivos = repositorioProduto.listarProdutosAtivos();

            if (produtosAtivos.isEmpty()) {
                System.out.println("Não há produtos ativos para desativar.");
                break;
            }

            System.out.println("\nProdutos Ativos:");
            produtosAtivos.forEach(System.out::println);

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Desativar Produto");
            System.out.println("2. Voltar");
            System.out.print("Digite a opção: ");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.print("Digite o ID do produto a ser desativado: ");
                    String idStr = scanner.nextLine();
                    long idProduto = Long.parseLong(idStr);

                    Produto produto = repositorioProduto.buscarPorId(idProduto);

                    if (produto != null && produto.isAtivo()) {
                        repositorioProduto.remover(produto);
                        System.out.println("Produto desativado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado ou já está inativo.");
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

    private void removerUsuario() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            List<Usuario> usuariosAtivos = repositorioUsuario.listarUsuariosAtivos();

            if (usuariosAtivos.isEmpty()) {
                System.out.println("Não há usuários ativos para remover.");
                break;
            }

            System.out.println("\nUsuários Ativos:");
            usuariosAtivos.forEach(System.out::println);

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Remover Usuário");
            System.out.println("2. Voltar");
            System.out.print("Digite a opção: ");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.print("Digite o ID do usuário a ser removido: ");
                    String idStr = scanner.nextLine();
                    long idUsuario = Long.parseLong(idStr);

                    Usuario usuario = repositorioUsuario.buscarPorId(idUsuario);

                    if (usuario != null && usuario.isAtivo()) {
                        repositorioUsuario.remover(usuario);
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado ou não está ativo.");
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

}
