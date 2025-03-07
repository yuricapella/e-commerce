package aplicacao.menu.menuadmin;

import dominio.pedido.interfaces.ValidadorPedido;
import dominio.produto.servico.ServicoProduto;
import dominio.cliente.servico.ServicoCliente;
import dominio.usuario.servico.ServicoUsuario;
import dominio.usuario.Usuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private RepositorioCliente repositorioCliente;
    private RepositorioProduto repositorioProduto;
    private RepositorioPedido repositorioPedido;
    private RepositorioUsuario repositorioUsuario;

    private MenuAdminAdiciona menuAdiciona;
    private MenuAdminRemove menuRemove;
    private MenuAdminConsulta menuConsulta;

    public MenuAdmin(Scanner scanner, Usuario usuarioLogado,
                     RepositorioCliente repositorioCliente,
                     RepositorioProduto repositorioProduto,
                     RepositorioPedido repositorioPedido,
                     RepositorioUsuario repositorioUsuario,
                     ServicoCliente servicoCliente,
                     ServicoUsuario servicoUsuario,
                     ServicoProduto servicoProduto,
                     ValidadorPedido validadorPedido) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;
        this.repositorioCliente = repositorioCliente;
        this.repositorioProduto = repositorioProduto;
        this.repositorioPedido = repositorioPedido;
        this.repositorioUsuario = repositorioUsuario;

        this.menuAdiciona = new MenuAdminAdiciona(scanner, usuarioLogado, servicoCliente, servicoProduto, servicoUsuario, repositorioCliente, repositorioPedido, validadorPedido);
        this.menuRemove = new MenuAdminRemove(scanner, usuarioLogado, repositorioCliente, repositorioProduto, repositorioPedido, repositorioUsuario);
        this.menuConsulta = new MenuAdminConsulta(scanner, usuarioLogado, repositorioCliente, repositorioProduto, repositorioPedido, repositorioUsuario);
    }

    public void exibirMenu() {
        boolean adminMenuAtivo = true;
        while (adminMenuAtivo) {
            System.out.println("\n====Menu Adiciona====");
            System.out.println("1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Consultar");
            System.out.println("4. Deslogar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    menuAdiciona.exibirMenu();
                    break;
                case "2":
                    menuRemove.exibirMenu();
                    break;
                case "3":
                    menuConsulta.exibirMenu();
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
}
