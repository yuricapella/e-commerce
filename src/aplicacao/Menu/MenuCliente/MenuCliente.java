package aplicacao.Menu.MenuCliente;

import dominio.Pedido.Pedido;
import dominio.cliente.Cliente;
import dominio.usuario.Usuario;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import java.util.Scanner;

public class MenuCliente {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private MenuProduto menuProduto;
    private MenuPedido menuPedido;
    private Pedido pedido;

    public MenuCliente(Scanner scanner, Usuario usuarioLogado, RepositorioPedido repositorioPedido, RepositorioProduto repositorioProduto) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;

        if (usuarioLogado.getCliente() == null) {
            System.out.println("Erro: Usuário não possui um cliente associado.");
            return;
        }

        Cliente cliente = usuarioLogado.getCliente();
        pedido = repositorioPedido.buscarPorCliente(cliente);
        if (pedido == null) {
            pedido = new Pedido(cliente);
            repositorioPedido.adicionar(pedido);
            System.out.println("Novo pedido criado para o cliente.");
        }

        this.menuProduto = new MenuProduto(scanner, repositorioProduto, pedido);
        this.menuPedido = new MenuPedido(scanner, pedido);
    }

    public void exibirMenu() {
        Cliente cliente = usuarioLogado.getCliente();
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n==== Menu do Cliente ====");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("=========================");
            System.out.println("1. Produtos (visualizar/adicionar ao pedido)");
            System.out.println("2. Carrinho (visualizar/editar pedido)");
            System.out.println("3. Deslogar");
            System.out.print("Escolha uma opção: ");

            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    menuProduto.exibirMenu();
                    break;
                case "2":
                    menuPedido.exibirMenu();
                    break;
                case "3":
                    System.out.println("Deslogando...");
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
