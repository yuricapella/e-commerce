package aplicacao.Menu.MenuCadastro;

import dominio.usuario.ServicoUsuario;
import dominio.usuario.Usuario;
import java.util.Scanner;

public class CadastroUsuario {
    private Scanner scanner;
    private ServicoUsuario servicoUsuario;

    public CadastroUsuario(Scanner scanner, ServicoUsuario servicoUsuario) {
        this.scanner = scanner;
        this.servicoUsuario = servicoUsuario;
    }

    public void cadastrar() {
        String login = obterLogin();
        String senha = obterSenha();

        try {
            Usuario novoUsuario = servicoUsuario.cadastrarUsuario(login, senha);
            servicoUsuario.adicionarUsuario(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    private String obterLogin() {
        System.out.print("Digite um login: ");
        return scanner.nextLine();
    }

    private String obterSenha() {
        System.out.print("Digite uma senha: ");
        return scanner.nextLine();
    }
}
