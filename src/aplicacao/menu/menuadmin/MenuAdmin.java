package aplicacao.menu.menuadmin;

import dominio.cliente.Cliente;
import dominio.Pedido.Pedido;
import dominio.Produto.Produto;
import dominio.usuario.Usuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private RepositorioCliente repositorioCliente;
    private RepositorioProduto repositorioProduto;
    private RepositorioPedido repositorioPedido;
    private RepositorioUsuario repositorioUsuario;

    public MenuAdmin(Scanner scanner, Usuario usuarioLogado,
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
            System.out.println("\nBem-vindo, " + usuarioLogado.getLogin() + "! Acesso concedido como administrador.");
            System.out.println("1. Clientes");
            System.out.println("2. Produtos");
            System.out.println("3. Pedidos");
            System.out.println("4. Usuários");
            System.out.println("5. Deslogar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    exibirClientes();
                    break;
                case "2":
                    exibirProdutos();
                    break;
                case "3":
                    exibirPedidos();
                    break;
                case "4":
                    exibirUsuarios();
                    break;
                case "5":
                    System.out.println("Deslogando...");
                    adminMenuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirClientes() {
        System.out.println("\n1. Todos os Clientes");
        System.out.println("2. Clientes Ativos");
        System.out.println("3. Clientes Inativos");
        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();
        switch (escolha) {
            case "1":
                System.out.println("\nTodos os Clientes:");
                List<Cliente> todosClientes = repositorioCliente.listarTodosClientes();
                for (Cliente cliente : todosClientes) {
                    System.out.println(cliente); // Utiliza o toString() de Cliente
                }
                break;
            case "2":
                System.out.println("\nClientes Ativos:");
                List<Cliente> clientesAtivos = repositorioCliente.listarClientesAtivos();
                for (Cliente cliente : clientesAtivos) {
                    System.out.println(cliente);
                }
                break;
            case "3":
                System.out.println("\nClientes Inativos:");
                List<Cliente> clientesInativos = repositorioCliente.listarClientesInativos();
                for (Cliente cliente : clientesInativos) {
                    System.out.println(cliente);
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void exibirProdutos() {
        System.out.println("\n1. Todos os Produtos");
        System.out.println("2. Produtos Ativos");
        System.out.println("3. Produtos Inativos");
        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();
        switch (escolha) {
            case "1":
                System.out.println("\nTodos os Produtos:");
                List<Produto> todosProdutos = repositorioProduto.listarTodosProdutos();
                for (Produto produto : todosProdutos) {
                    System.out.println(produto); // Utiliza o toString() de Produto
                }
                break;
            case "2":
                System.out.println("\nProdutos Ativos:");
                List<Produto> produtosAtivos = repositorioProduto.listarProdutosAtivos();
                for (Produto produto : produtosAtivos) {
                    System.out.println(produto);
                }
                break;
            case "3":
                System.out.println("\nProdutos Inativos:");
                List<Produto> produtosInativos = repositorioProduto.listarProdutosInativos();
                for (Produto produto : produtosInativos) {
                    System.out.println(produto);
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void exibirPedidos() {
        System.out.println("\n1. Todos os Pedidos");
        System.out.println("2. Pedidos em Andamento");
        System.out.println("3. Pedidos Finalizados");
        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();
        switch (escolha) {
            case "1":
                System.out.println("\nTodos os Pedidos:");
                List<Pedido> todosPedidos = repositorioPedido.listarTodosPedidos();
                for (Pedido pedido : todosPedidos) {
                    System.out.println(pedido); // Utiliza o toString() de Pedido
                }
                break;
            case "2":
                System.out.println("\nPedidos em Andamento:");
                List<Pedido> pedidosAndamento = repositorioPedido.listarEmAndamento();
                for (Pedido pedido : pedidosAndamento) {
                    System.out.println(pedido);
                }
                break;
            case "3":
                System.out.println("\nPedidos Finalizados:");
                List<Pedido> pedidosFinalizados = repositorioPedido.listarFinalizados();
                for (Pedido pedido : pedidosFinalizados) {
                    System.out.println(pedido);
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void exibirUsuarios() {
        System.out.println("\n1. Todos os Usuários");
        System.out.println("2. Usuários Ativos");
        System.out.println("3. Usuários Inativos");
        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();
        switch (escolha) {
            case "1":
                System.out.println("\nTodos os Usuários:");
                List<Usuario> todosUsuarios = repositorioUsuario.listarTodosUsuarios();
                for (Usuario usuario : todosUsuarios) {
                    System.out.println(usuario); // Recomenda-se implementar toString() em Usuario
                }
                break;
            case "2":
                System.out.println("\nUsuários Ativos:");
                List<Usuario> usuariosAtivos = repositorioUsuario.listarUsuariosAtivos();
                for (Usuario usuario : usuariosAtivos) {
                    System.out.println(usuario);
                }
                break;
            case "3":
                System.out.println("\nUsuários Inativos:");
                List<Usuario> usuariosInativos = repositorioUsuario.listarUsuariosInativos();
                for (Usuario usuario : usuariosInativos) {
                    System.out.println(usuario);
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
