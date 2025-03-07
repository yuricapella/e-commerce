package aplicacao.menu.menulogin;

import aplicacao.menu.menuadmin.MenuAdmin;
import aplicacao.menu.menucliente.MenuCliente;
import dominio.pedido.interfaces.ValidadorPedido;
import dominio.produto.servico.ServicoProduto;
import dominio.cliente.interfaces.ValidadorCliente;
import dominio.cliente.servico.ServicoCliente;
import dominio.usuario.servico.ServicoUsuario;
import dominio.usuario.TipoUsuario;
import dominio.usuario.Usuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import dominio.desconto.ServicoDesconto;
import dominio.pedido.servico.ServicoPedido;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.Scanner;

public class MenuLogin {
    private Scanner scanner;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioCliente repositorioCliente;
    private RepositorioProduto repositorioProduto;
    private RepositorioPedido repositorioPedido;
    private ServicoDesconto servicoDesconto;
    private ServicoPedido servicoPedido;
    private ServicoProduto servicoProduto;
    private ServicoUsuario servicoUsuario;
    private ServicoCliente servicoCliente;
    private ValidadorPedido validadorPedido;
    private ValidadorCliente validadorCliente;

    public MenuLogin(Scanner scanner,
                     RepositorioUsuario repositorioUsuario,
                     RepositorioCliente repositorioCliente,
                     RepositorioProduto repositorioProduto,
                     RepositorioPedido repositorioPedido,
                     ServicoDesconto servicoDesconto,
                     ServicoPedido servicoPedido,
                     ServicoProduto servicoProduto,
                     ServicoUsuario servicoUsuario,
                     ServicoCliente servicoCliente,
                     ValidadorPedido validadorPedido,
                     ValidadorCliente validadorCliente) {
        this.scanner = scanner;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioCliente = repositorioCliente;
        this.repositorioProduto = repositorioProduto;
        this.repositorioPedido = repositorioPedido;
        this.servicoDesconto = servicoDesconto;
        this.servicoPedido = servicoPedido;
        this.servicoProduto = servicoProduto;
        this.servicoUsuario = servicoUsuario;
        this.servicoCliente = servicoCliente;
        this.validadorPedido = validadorPedido;
        this.validadorCliente = validadorCliente;
    }

    public void realizarLogin() {
        System.out.println("Para acesso de administrador digite login: admin  senha: 1234");
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = repositorioUsuario.buscarPorLoginESenha(login, senha);

        if (usuarioLogado == null) {
            System.out.println("Login ou senha incorretos!");
        } else {
            if (!usuarioLogado.isAtivo()) { // Verifica se o usuário está ativo
                System.out.println("Usuário está inativo. Não é possível realizar o login.");
            } else {
                if (usuarioLogado.getTipo() == TipoUsuario.ADMINISTRADOR) {
                    exibirMenuAdmin(usuarioLogado);
                } else {
                    exibirMenuCliente(usuarioLogado);
                }
            }
        }
    }

    private void exibirMenuAdmin(Usuario usuarioLogado) {
        System.out.println("Acesso concedido como administrador.");
        MenuAdmin menuAdmin = new MenuAdmin(scanner, usuarioLogado, repositorioCliente, repositorioProduto, repositorioPedido, repositorioUsuario, servicoCliente, servicoUsuario, servicoProduto, validadorPedido);        menuAdmin.exibirMenu();
    }

    private void exibirMenuCliente(Usuario usuarioLogado) {
        System.out.println("Bem-vindo, " + usuarioLogado.getLogin() + "!");
        MenuCliente menuCliente = new MenuCliente(scanner, usuarioLogado, repositorioPedido, repositorioProduto,
                servicoDesconto, servicoPedido, servicoCliente, validadorPedido, validadorCliente);
        menuCliente.exibirMenu();
    }
}
