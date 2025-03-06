package aplicacao.menu.menucadastro;

import dominio.usuario.ServicoUsuario;
import dominio.usuario.Usuario;
import dominio.cliente.servico.ServicoCliente;
import dominio.cliente.Cliente;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.Scanner;

public class CadastroUsuario {
    private Scanner scanner;
    private ServicoUsuario servicoUsuario;
    private ServicoCliente servicoCliente;
    private RepositorioUsuario repositorioUsuario;

    public CadastroUsuario(Scanner scanner, ServicoUsuario servicoUsuario, ServicoCliente servicoCliente, RepositorioUsuario repositorioUsuario) {
        this.scanner = scanner;
        this.servicoUsuario = servicoUsuario;
        this.servicoCliente = servicoCliente;
        this.repositorioUsuario = repositorioUsuario;
    }

    public void cadastrar() {
        String login = obterLogin();
        String senha = obterSenha();

        Usuario usuarioExistente = repositorioUsuario.buscarPorLogin(login);
        Usuario novoUsuario = null;

        if (usuarioExistente != null) {
            System.out.println("Usuário já existe no repositório.");
            novoUsuario = usuarioExistente;
        } else {
            try {
                novoUsuario = servicoUsuario.cadastrarUsuario(login, senha);
                servicoUsuario.adicionarUsuario(novoUsuario);
                System.out.println("Usuário cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro no cadastro de usuário: " + e.getMessage());
                return;
            }
        }

        String nomeCliente = obterNomeCliente();
        String documentoCliente = obterDocumentoCliente();
        String emailCliente = obterEmailCliente();

        try {
            Cliente novoCliente = servicoCliente.cadastrarCliente(nomeCliente, documentoCliente, emailCliente);
            servicoCliente.adicionarCliente(novoCliente);
            novoUsuario.setCliente(novoCliente);
            System.out.println("Cliente cadastrado e associado ao usuário com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no cadastro de cliente: " + e.getMessage());
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

    private String obterNomeCliente() {
        System.out.print("Digite o nome do cliente: ");
        return scanner.nextLine();
    }

    private String obterDocumentoCliente() {
        System.out.print("Digite o documento do cliente: ");
        return scanner.nextLine();
    }

    private String obterEmailCliente() {
        System.out.print("Digite o e-mail do cliente: ");
        return scanner.nextLine();
    }
}