package aplicacao.Menu.MenuCliente;

import java.util.Scanner;


public class MenuCliente {
    private Scanner scanner;
    private Usuario usuarioLogado;

    public MenuCliente(Scanner scanner, Usuario usuarioLogado) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;
    }

    public void exibirMenu() {
        boolean clienteMenuAtivo = true;
        while (clienteMenuAtivo) {
            System.out.println("Bem-vindo, " + usuarioLogado.getLogin() + "! Acesso concedido como cliente.");
            System.out.println("1. Produtos");
            System.out.println("2. Pedidos");
            System.out.println("3. Deslogar");
            System.out.print("Escolha uma opção: ");

            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    System.out.println("Exibe lista produtos...");
                    // Lógica para exibir produtos
                    break;
                case "2":
                    System.out.println("Carrinho");
                    // Lógica para exibir o carrinho
                    break;
                case "3":
                    System.out.println("Deslogando...");
                    clienteMenuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
