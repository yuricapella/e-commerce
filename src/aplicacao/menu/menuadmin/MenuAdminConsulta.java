package aplicacao.menu.menuadmin;

import aplicacao.menu.util.FormatadorExibicao;
import dominio.pedido.Pedido;
import dominio.produto.Produto;
import dominio.cliente.Cliente;
import dominio.usuario.Usuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.List;
import java.util.Scanner;

public class MenuAdminConsulta {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private RepositorioCliente repositorioCliente;
    private RepositorioProduto repositorioProduto;
    private RepositorioPedido repositorioPedido;
    private RepositorioUsuario repositorioUsuario;

    public MenuAdminConsulta(Scanner scanner, Usuario usuarioLogado,
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
            System.out.println("5. Voltar");
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
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n1. Todos os Clientes");
            System.out.println("2. Clientes Ativos");
            System.out.println("3. Clientes Inativos");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    List<Cliente> todosClientes = repositorioCliente.listarTodosClientes();
                    if (todosClientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("\nTodos os Clientes:");
                        FormatadorExibicao.exibirCliente(todosClientes);
                    }
                    break;
                case "2":
                    List<Cliente> clientesAtivos = repositorioCliente.listarClientesAtivos();
                    if (clientesAtivos.isEmpty()) {
                        System.out.println("Nenhum cliente ativo encontrado.");
                    } else {
                        System.out.println("\nClientes Ativos:");
                        FormatadorExibicao.exibirCliente(clientesAtivos);
                    }
                    break;
                case "3":
                    List<Cliente> clientesInativos = repositorioCliente.listarClientesInativos();
                    if (clientesInativos.isEmpty()) {
                        System.out.println("Nenhum cliente inativo encontrado.");
                    } else {
                        System.out.println("\nClientes Inativos:");
                        FormatadorExibicao.exibirCliente(clientesInativos);
                    }
                    break;
                case "4":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    private void exibirProdutos() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n1. Todos os Produtos");
            System.out.println("2. Produtos Ativos");
            System.out.println("3. Produtos Inativos");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    List<Produto> todosProdutos = repositorioProduto.listarTodosProdutos();
                    if (todosProdutos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("\nTodos os Produtos:");
                        FormatadorExibicao.exibirProdutos(todosProdutos);
                    }
                    break;
                case "2":
                    List<Produto> produtosAtivos = repositorioProduto.listarProdutosAtivos();
                    if (produtosAtivos.isEmpty()) {
                        System.out.println("Nenhum produto ativo encontrado.");
                    } else {
                        System.out.println("\nProdutos Ativos:");
                        FormatadorExibicao.exibirProdutos(produtosAtivos);
                    }
                    break;
                case "3":
                    List<Produto> produtosInativos = repositorioProduto.listarProdutosInativos();
                    if (produtosInativos.isEmpty()) {
                        System.out.println("Nenhum produto inativo encontrado.");
                    } else {
                        System.out.println("\nProdutos Inativos:");
                        FormatadorExibicao.exibirProdutos(produtosInativos);
                    }
                    break;
                case "4":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    private void exibirPedidos() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n1. Todos os Pedidos");
            System.out.println("2. Pedidos em Andamento");
            System.out.println("3. Pedidos Finalizados");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    List<Pedido> todosPedidos = repositorioPedido.listarTodosPedidos();
                    if (todosPedidos.isEmpty()) {
                        System.out.println("Nenhum pedido cadastrado.");
                    } else {
                        System.out.println("\nTodos os Pedidos:");
                        for (Pedido pedido : todosPedidos) {
                            FormatadorExibicao.exibirPedido(pedido);
                        }
                    }
                    break;
                case "2":
                    List<Pedido> pedidosAndamento = repositorioPedido.listarEmAndamento();
                    if (pedidosAndamento.isEmpty()) {
                        System.out.println("Nenhum pedido em andamento.");
                    } else {
                        System.out.println("\nPedidos em Andamento:");
                        for (Pedido pedido : pedidosAndamento) {
                            FormatadorExibicao.exibirPedido(pedido);
                        }
                    }
                    break;
                case "3":
                    List<Pedido> pedidosFinalizados = repositorioPedido.listarFinalizados();
                    if (pedidosFinalizados.isEmpty()) {
                        System.out.println("Nenhum pedido finalizado.");
                    } else {
                        System.out.println("\nPedidos Finalizados:");
                        for (Pedido pedido : pedidosFinalizados) {
                            FormatadorExibicao.exibirPedido(pedido);
                        }
                    }
                    break;
                case "4":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    private void exibirUsuarios() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n1. Todos os Usuários");
            System.out.println("2. Usuários Ativos");
            System.out.println("3. Usuários Inativos");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    List<Usuario> todosUsuarios = repositorioUsuario.listarTodosUsuarios();
                    if (todosUsuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("\nTodos os Usuários:");
                        FormatadorExibicao.exibirUsuarios(todosUsuarios);
                    }
                    break;
                case "2":
                    List<Usuario> usuariosAtivos = repositorioUsuario.listarUsuariosAtivos();
                    if (usuariosAtivos.isEmpty()) {
                        System.out.println("Nenhum usuário ativo encontrado.");
                    } else {
                        System.out.println("\nUsuários Ativos:");
                        FormatadorExibicao.exibirUsuarios(usuariosAtivos);
                    }
                    break;
                case "3":
                    List<Usuario> usuariosInativos = repositorioUsuario.listarUsuariosInativos();
                    if (usuariosInativos.isEmpty()) {
                        System.out.println("Nenhum usuário inativo encontrado.");
                    } else {
                        System.out.println("\nUsuários Inativos:");
                        FormatadorExibicao.exibirUsuarios(usuariosInativos);
                    }
                    break;
                case "4":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
