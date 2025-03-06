package aplicacao.menu.menucliente;

import dominio.Notificacao.ServicoNotificador;
import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoPadrao;
import dominio.Pedido.ServicoPedido;
import dominio.cliente.Cliente;
import dominio.usuario.Usuario;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import dominio.Desconto.ServicoDesconto;
import java.util.Scanner;

public class MenuCliente {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private MenuProduto menuProduto;
    private MenuPedido menuPedido;
    private MenuPagamento menuPagamento;
    private Pedido pedido;

    public MenuCliente(Scanner scanner, Usuario usuarioLogado, RepositorioPedido repositorioPedido,
                       RepositorioProduto repositorioProduto, ServicoDesconto servicoDesconto,
                       ServicoNotificador servicoNotificador, ServicoPedido servicoPedido) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;
        if (usuarioLogado.getCliente() == null) {
            System.out.println("Erro: Usuário não possui um cliente associado.");
            return;
        }
        Cliente cliente = usuarioLogado.getCliente();
        pedido = repositorioPedido.buscarPorCliente(cliente);
        if (pedido == null) {
            pedido = new PedidoPadrao(cliente);
            repositorioPedido.adicionar(pedido);
            System.out.println("Novo pedido criado para o cliente.");
        }
        this.menuProduto = new MenuProduto(scanner, repositorioProduto, pedido);
        this.menuPedido = new MenuPedido(scanner, pedido, servicoDesconto, servicoNotificador, servicoPedido);
        this.menuPagamento = new MenuPagamento(scanner, pedido, servicoPedido, servicoDesconto);
    }

    public void exibirMenu() {
        Cliente cliente = usuarioLogado.getCliente();
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n==== Menu do Cliente ====");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("1. Produtos");
            System.out.println("2. Carrinho");
            System.out.println("3. Pagamento");
            System.out.println("4. Deslogar");
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
                    menuPagamento.exibirMenu();
                    break;
                case "4":
                    System.out.println("Deslogando...");
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
