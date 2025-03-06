package aplicacao.menu.menulogin;

import aplicacao.menu.menuadmin.MenuAdmin;
import aplicacao.menu.menucliente.MenuCliente;
import dominio.Pedido.ValidadorPedido;
import dominio.usuario.TipoUsuario;
import dominio.usuario.Usuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import dominio.Desconto.ServicoDesconto;
import dominio.Pedido.ServicoPedido;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.List;
import java.util.Scanner;

public class MenuLogin {
    private Scanner scanner;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioCliente repositorioCliente;
    private RepositorioProduto repositorioProduto;
    private RepositorioPedido repositorioPedido;
    private ServicoDesconto servicoDesconto;
    private ServicoPedido servicoPedido;
    private ValidadorPedido validadorPedido;

    public MenuLogin(Scanner scanner,
                     RepositorioUsuario repositorioUsuario,
                     RepositorioCliente repositorioCliente,
                     RepositorioProduto repositorioProduto,
                     RepositorioPedido repositorioPedido,
                     ServicoDesconto servicoDesconto,
                     ServicoPedido servicoPedido,
                     ValidadorPedido validadorPedido) {
        this.scanner = scanner;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioCliente = repositorioCliente;
        this.repositorioProduto = repositorioProduto;
        this.repositorioPedido = repositorioPedido;
        this.servicoDesconto = servicoDesconto;
        this.servicoPedido = servicoPedido;
        this.validadorPedido = validadorPedido;
    }

    public void realizarLogin() {
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = repositorioUsuario.buscarPorLoginESenha(login, senha);

        if (usuarioLogado == null) {
            System.out.println("Login ou senha incorretos!");
        } else {
            if (usuarioLogado.getTipo() == TipoUsuario.ADMINISTRADOR) {
                exibirMenuAdmin(usuarioLogado);
            } else {
                exibirMenuCliente(usuarioLogado);
            }
        }
    }

    private void exibirMenuAdmin(Usuario usuarioLogado) {
        System.out.println("Acesso concedido como administrador.");
        MenuAdmin menuAdmin = new MenuAdmin(scanner, usuarioLogado, repositorioCliente, repositorioProduto, repositorioPedido, repositorioUsuario);
        menuAdmin.exibirMenu();
    }

    private void exibirMenuCliente(Usuario usuarioLogado) {
        System.out.println("Bem-vindo, " + usuarioLogado.getLogin() + "!");
        MenuCliente menuCliente = new MenuCliente(scanner, usuarioLogado, repositorioPedido, repositorioProduto,
                servicoDesconto, servicoPedido, validadorPedido);
        menuCliente.exibirMenu();
    }
}
