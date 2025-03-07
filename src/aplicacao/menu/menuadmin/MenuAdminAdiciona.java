package aplicacao.menu.menuadmin;

import dominio.pedido.*;
import dominio.produto.ProdutoEletronico;
import dominio.produto.ProdutoLivro;
import dominio.produto.ProdutoPapelaria;
import dominio.produto.ProdutoVestuario;
import dominio.pedido.interfaces.ValidadorPedido;
import dominio.usuario.Usuario;
import dominio.cliente.Cliente;
import dominio.produto.Produto;
import dominio.cliente.servico.ServicoCliente;
import dominio.produto.servico.ServicoProduto;
import dominio.usuario.servico.ServicoUsuario;
import dominio.usuario.UsuarioAdmin;
import dominio.usuario.UsuarioCliente;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;

import java.util.List;
import java.util.Scanner;

public class MenuAdminAdiciona {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private ServicoCliente servicoCliente;
    private ServicoProduto servicoProduto;
    private ServicoUsuario servicoUsuario;
    private RepositorioCliente repositorioCliente;
    private RepositorioPedido repositorioPedido;
    private ValidadorPedido validadorPedido;

    public MenuAdminAdiciona(Scanner scanner, Usuario usuarioLogado,
                             ServicoCliente servicoCliente,
                             ServicoProduto servicoProduto,
                             ServicoUsuario servicoUsuario,
                             RepositorioCliente repositorioCliente,
                             RepositorioPedido repositorioPedido,
                             ValidadorPedido validadorPedido) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;
        this.servicoCliente = servicoCliente;
        this.servicoProduto = servicoProduto;
        this.servicoUsuario = servicoUsuario;
        this.repositorioCliente = repositorioCliente;
        this.repositorioPedido = repositorioPedido;
        this.validadorPedido = validadorPedido;
    }

    public void exibirMenu() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\nBem-vindo, " + usuarioLogado.getLogin() + "! Acesso concedido como administrador.");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Produto");
            System.out.println("3. Adicionar Pedido");
            System.out.println("4. Adicionar Usuário");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    adicionarCliente();
                    break;
                case "2":
                    adicionarProduto();
                    break;
                case "3":
                    adicionarPedido();
                    break;
                case "4":
                    adicionarUsuario();
                    break;
                case "5":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarCliente() {
        boolean cadastroValido = false;

        while (!cadastroValido) {
            System.out.print("Nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Documento do cliente: ");
            String documento = scanner.nextLine();

            System.out.print("Email do cliente: ");
            String email = scanner.nextLine();

            try {
                Cliente cliente = servicoCliente.cadastrarCliente(nome, documento, email);
                servicoCliente.adicionarCliente(cliente);
                System.out.println("Cliente adicionado com sucesso!");
                cadastroValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Nome, Email ou Documento Inválido. Tente novamente.");
            }
        }
    }

    private void adicionarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Valor do produto: ");
        double valor = Double.parseDouble(scanner.nextLine());

        System.out.println("Selecione o tipo de produto:");
        System.out.println("1. Eletrônico");
        System.out.println("2. Livro");
        System.out.println("3. Vestuário");
        System.out.println("4. Papelaria");
        System.out.print("Escolha uma opção: ");
        String tipoEscolha = scanner.nextLine();

        Produto produto = null;

        switch (tipoEscolha) {
            case "1":
                produto = new ProdutoEletronico(nome, valor);
                break;
            case "2":
                produto = new ProdutoLivro(nome, valor);
                break;
            case "3":
                produto = new ProdutoVestuario(nome, valor);
                break;
            case "4":
                produto = new ProdutoPapelaria(nome, valor);
                break;
            default:
                System.out.println("Tipo de produto inválido. Produto não adicionado.");
                return;
        }

        servicoProduto.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void adicionarPedido() {
        System.out.println("Lista de clientes cadastrados:");
        System.out.println(repositorioCliente.listarClientesAtivos());

        System.out.print("ID do cliente para o pedido: ");
        String idClienteStr = scanner.nextLine();

        long idCliente = 0;
        try {
            idCliente = Long.parseLong(idClienteStr);
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Pedido não adicionado.");
            return;
        }

        Cliente cliente = repositorioCliente.buscarPorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Pedido não adicionado.");
            return;
        }

        Pedido pedido = new PedidoPadrao(cliente,validadorPedido);
        repositorioPedido.adicionar(pedido);
        System.out.println("Pedido adicionado com sucesso!");
    }

    private void adicionarUsuario() {
        System.out.println("Lista de Clientes:");
        List<Cliente> clientes = repositorioCliente.listarClientesAtivos();
        System.out.println(clientes);
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados. Adicione um cliente antes.");
            return;
        }

        Cliente clienteSelecionado = null;
        boolean clienteValido = false;

        while (!clienteValido) {
            System.out.print("Escolha o ID do cliente para associar ao usuário: ");
            long idCliente = Long.parseLong(scanner.nextLine());

            clienteSelecionado = repositorioCliente.buscarPorId(idCliente);
            if (clienteSelecionado != null) {
                clienteValido = true;
            } else {
                System.out.println("ID de cliente inválido. Tente novamente.");
            }
        }

        System.out.print("Login do usuário: ");
        String login = scanner.nextLine();

        System.out.print("Senha do usuário: ");
        String senha = scanner.nextLine();

        System.out.println("Tipo de usuário: ");
        System.out.println("1. USUARIO");
        System.out.println("2. ADMINISTRADOR");
        String tipoUsuarioStr = scanner.nextLine();

        Usuario usuario;
        if (tipoUsuarioStr.equals("1")) {
            usuario = new UsuarioCliente(login, senha);
            usuario.setCliente(clienteSelecionado);
        } else {
            usuario = new UsuarioAdmin(login, senha);
        }

        servicoUsuario.adicionarUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }
}
