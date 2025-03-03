package aplicacao.Menu;

import aplicacao.Menu.MenuCadastro.CadastroUsuario;
import aplicacao.Menu.MenuLogin.MenuLogin;
import java.util.List;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private MenuLogin login;
    private CadastroUsuario cadastrarUsuario;
    private List<Usuario> usuarios;

    public MenuPrincipal(Scanner scanner, List<Usuario> usuarios) {
        this.scanner = scanner;
        this.usuarios = usuarios;
        this.login = new MenuLogin(scanner, usuarios);
        this.cadastrarUsuario = new CadastroUsuario(scanner, usuarios);
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
