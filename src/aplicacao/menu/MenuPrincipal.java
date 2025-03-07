package aplicacao.menu;

import aplicacao.menu.menucadastro.CadastroUsuario;
import aplicacao.menu.menulogin.MenuLogin;
import dominio.pedido.interfaces.ValidadorPedido;
import dominio.produto.servico.ServicoProduto;
import dominio.cliente.interfaces.ValidadorCliente;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import dominio.desconto.ServicoDesconto;
import dominio.pedido.servico.ServicoPedido;
import dominio.usuario.servico.ServicoUsuario;
import dominio.cliente.servico.ServicoCliente;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private MenuLogin login;
    private CadastroUsuario cadastrarUsuario;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioCliente repositorioCliente;
    private RepositorioProduto repositorioProduto;
    private RepositorioPedido repositorioPedido;
    private ServicoDesconto servicoDesconto;
    private ServicoPedido servicoPedido;
    private ServicoUsuario servicoUsuario;
    private ServicoCliente servicoCliente;
    private ServicoProduto servicoProduto;
    private ValidadorPedido validadorPedido;
    private ValidadorCliente validadorCliente;

    public MenuPrincipal(Scanner scanner,
                         RepositorioUsuario repositorioUsuario,
                         RepositorioCliente repositorioCliente,
                         RepositorioProduto repositorioProduto,
                         RepositorioPedido repositorioPedido,
                         ServicoDesconto servicoDesconto,
                         ServicoPedido servicoPedido,
                         ServicoUsuario servicoUsuario,
                         ServicoCliente servicoCliente,
                         ServicoProduto servicoProduto,
                         ValidadorPedido validadorPedido,
                         ValidadorCliente validadorCliente) {
        this.scanner = scanner;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioCliente = repositorioCliente;
        this.repositorioProduto = repositorioProduto;
        this.repositorioPedido = repositorioPedido;
        this.servicoDesconto = servicoDesconto;
        this.servicoPedido = servicoPedido;
        this.servicoUsuario = servicoUsuario;
        this.servicoCliente = servicoCliente;
        this.servicoProduto = servicoProduto;
        this.validadorPedido = validadorPedido;
        this.validadorCliente = validadorCliente;
        this.login = new MenuLogin(scanner, repositorioUsuario, repositorioCliente, repositorioProduto, repositorioPedido,
                servicoDesconto, servicoPedido, servicoProduto, servicoUsuario, servicoCliente, validadorPedido, validadorCliente);

        this.cadastrarUsuario = new CadastroUsuario(scanner, servicoUsuario, servicoCliente, repositorioUsuario);
    }

    public void exibirMenu() {
        boolean executando = true;
        while (executando) {
            System.out.println("Bem-vindo à plataforma de e-commerce!");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar-se");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    login.realizarLogin();
                    break;
                case "2":
                    cadastrarUsuario.cadastrar();
                    break;
                case "3":
                    System.out.println("Saindo do sistema...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
