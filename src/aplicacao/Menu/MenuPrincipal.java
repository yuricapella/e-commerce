package aplicacao.Menu;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar-se");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Opção de Login selecionada.");
                    break;
                case "2":
                    System.out.println("Opção de Cadastro selecionada.");
                    break;
                case "3":
                    System.out.println("Encerrando o programa...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
