package aplicacao.Menu.MenuLogin;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private Scanner scanner;
    private List<Usuario> usuarios;

    public Login(Scanner scanner, List<Usuario> usuarios) {
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
                exibirMenuAdmin();
            } else {
                exibirMenuCliente(usuarioLogado);
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
