package aplicacao;

import aplicacao.Menu.MenuPrincipal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();

        MenuPrincipal menuPrincipal = new MenuPrincipal(scanner, usuarios);
        menuPrincipal.exibirMenu();
    }
}
