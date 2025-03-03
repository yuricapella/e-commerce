package aplicacao.Menu.MenuLogin;

import aplicacao.Menu.MenuAdmin.MenuAdmin;
import aplicacao.Menu.MenuCliente.MenuCliente;

import java.util.List;
import java.util.Scanner;

public class MenuLogin {
    private Scanner scanner;
    private List<Usuario> usuarios;

    public MenuLogin(Scanner scanner, List<Usuario> usuarios) {
        this.scanner = scanner;
        this.usuarios = usuarios;
    }

    public void realizarLogin() {
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                break;
            }
        }

        if (usuarioLogado == null) {
            System.out.println("Login ou senha incorretos!");
        } else {
            if (usuarioLogado.isAdmin()) {
                MenuAdmin menuAdmin = new MenuAdmin(scanner, usuarioLogado,repositorioCliente, repositorioProduto, repositorioPedidos);
                menuAdmin.exibirMenu();
            } else {
                MenuCliente menuCliente = new MenuCliente(scanner, usuarioLogado);
                menuCliente.exibirMenu();
            }
        }
    }

    private void exibirMenuAdmin() {
        System.out.println("Acesso concedido como administrador.");
    }

    private void exibirMenuCliente(Usuario usuario) {
        System.out.println("Bem-vindo, " + usuario.getLogin() + "! Acesso concedido como cliente.");
    }
}
