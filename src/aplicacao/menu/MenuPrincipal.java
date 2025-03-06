package aplicacao.menu;

import aplicacao.menu.menucadastro.CadastroUsuario;
import aplicacao.menu.menulogin.MenuLogin;
import dominio.Pedido.ValidadorPedido;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import dominio.Desconto.ServicoDesconto;
import dominio.Pedido.ServicoPedido;
import dominio.usuario.ServicoUsuario;
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
    private ValidadorPedido validadorPedido;

    public MenuPrincipal(Scanner scanner,
                         RepositorioUsuario repositorioUsuario,
                         RepositorioCliente repositorioCliente,
                         RepositorioProduto repositorioProduto,
                         RepositorioPedido repositorioPedido,
                         ServicoDesconto servicoDesconto,
                         ServicoPedido servicoPedido,
                         ServicoUsuario servicoUsuario,
                         ServicoCliente servicoCliente,
                         ValidadorPedido validadorPedido) {
        this.scanner = scanner;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioCliente = repositorioCliente;
        this.repositorioProduto = repositorioProduto;
        this.repositorioPedido = repositorioPedido;
        this.servicoDesconto = servicoDesconto;
        this.servicoPedido = servicoPedido;
        this.servicoUsuario = servicoUsuario;
        this.servicoCliente = servicoCliente;
        this.validadorPedido = validadorPedido;
        this.login = new MenuLogin(scanner, repositorioUsuario, repositorioCliente, repositorioProduto,
                repositorioPedido, servicoDesconto, servicoPedido, validadorPedido);
        this.cadastrarUsuario = new CadastroUsuario(scanner, servicoUsuario, servicoCliente);
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
