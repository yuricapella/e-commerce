package aplicacao.Menu.MenuCadastro;

import java.util.List;
import java.util.Scanner;

public class CadastroUsuario {
    private Scanner scanner;
    private List<Usuario> usuarios;

    public CadastroUsuario(Scanner scanner, List<Usuario> usuarios) {
        this.scanner = scanner;
        this.usuarios = usuarios;
    }

    public void cadastrar() {
        System.out.print("Digite um login: ");
        String login = scanner.nextLine();
        System.out.print("Digite uma senha: ");
        String senha = scanner.nextLine();

        if (login.isEmpty() || senha.isEmpty()) {
            System.out.println("Login e senha não podem ser vazios.");
            return;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                System.out.println("Usuário já cadastrado.");
                return;
            }
        }

        usuarios.add(new Usuario(login, senha, false));
        System.out.println("Usuário cadastrado com sucesso!");
    }
}
