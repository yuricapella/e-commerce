package aplicacao.menu.menucliente;

import aplicacao.menu.util.FormatadorExibicao;
import dominio.pedido.Pedido;
import dominio.pedido.PedidoPadrao;
import dominio.pedido.servico.ServicoPedido;
import dominio.pedido.interfaces.ValidadorPedido;
import dominio.cliente.Cliente;
import dominio.cliente.interfaces.ValidadorCliente;
import dominio.cliente.servico.ServicoCliente;
import dominio.usuario.Usuario;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import dominio.desconto.ServicoDesconto;
import java.util.Scanner;

public class MenuCliente {
    private Scanner scanner;
    private Usuario usuarioLogado;
    private MenuProduto menuProduto;
    private MenuCarrinhoDeCompra menuCarrinhoDeCompra;
    private MenuPagamento menuPagamento;
    private MenuAlteraCliente menuAlteraCliente;
    private Pedido pedido;
    private ValidadorPedido validadorPedido;
    private ValidadorCliente validadorCliente;

    public MenuCliente(Scanner scanner, Usuario usuarioLogado, RepositorioPedido repositorioPedido,
                       RepositorioProduto repositorioProduto, ServicoDesconto servicoDesconto,
                       ServicoPedido servicoPedido,
                       ServicoCliente servicoCliente,
                       ValidadorPedido validadorPedido,
                       ValidadorCliente validadorCliente) {
        this.scanner = scanner;
        this.usuarioLogado = usuarioLogado;
        if (usuarioLogado.getCliente() == null) {
            System.out.println("Erro: Usuário não possui um cliente associado. Deslogando...");
            this.usuarioLogado = null;
            return;
        }
        Cliente cliente = usuarioLogado.getCliente();
        pedido = repositorioPedido.buscarPorCliente(cliente);
        if (pedido == null) {
            pedido = new PedidoPadrao(cliente,validadorPedido);
            repositorioPedido.adicionar(pedido);
        }
        this.menuProduto = new MenuProduto(scanner, repositorioProduto, pedido);
        this.menuCarrinhoDeCompra = new MenuCarrinhoDeCompra(scanner, pedido, servicoDesconto, servicoPedido);
        this.menuPagamento = new MenuPagamento(scanner, pedido, servicoPedido, servicoDesconto);
        this.menuAlteraCliente = new MenuAlteraCliente(scanner,servicoCliente,validadorCliente,usuarioLogado);
    }

    public void exibirMenu() {
        if (usuarioLogado == null) {
            System.out.println("Usuário deslogado. Retornando ao menu principal.");
            return;
        }
        Cliente cliente = usuarioLogado.getCliente();
        boolean menuAtivo = true;
        while (menuAtivo) {
            exibirRegrasDeNegocio();

            System.out.println("\n==== Menu do Cliente ====");
            FormatadorExibicao.exibirCliente(cliente);
            System.out.println("1. Produtos");
            System.out.println("2. Carrinho");
            System.out.println("3. Pagamento");
            System.out.println("4. Alterar dados");
            System.out.println("5. Deslogar");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    menuProduto.exibirMenu();
                    break;
                case "2":
                    menuCarrinhoDeCompra.exibirMenu();
                    break;
                case "3":
                    menuPagamento.exibirMenu();
                    break;
                case "4":
                    menuAlteraCliente.exibirMenu();
                    break;
                case "5":
                    System.out.println("Deslogando...");
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirRegrasDeNegocio() {
        System.out.println("\n==== Regras de Desconto e Frete ====");
        System.out.println("1. 10% de desconto em produtos de vestuário a partir de 3 unidades.");
        System.out.println("2. Compras acima de R$200 possuem R$20 de desconto e frete grátis.");
        System.out.println("=====================================");
    }
}
