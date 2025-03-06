package aplicacao.Menu.MenuCliente;

import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoStatus;
import dominio.Pedido.ServicoPedido;
import java.util.Scanner;

public class MenuPagamento {
    private Scanner scanner;
    private Pedido pedido;

    public MenuPagamento(Scanner scanner, Pedido pedido) {
        this.scanner = scanner;
        this.pedido = pedido;
    }

    public void exibirMenu() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n==== Pagamento ====");
            System.out.println("Status do Pedido: " + pedido.getStatus());
            if (pedido.getStatus().equals(PedidoStatus.AGUARDANDO_PAGAMENTO)) {
                System.out.println("1. Processar Pagamento");
            } else if (pedido.getStatus().equals(PedidoStatus.PAGO)) {
                System.out.println("1. Finalizar Pedido");
            } else if (pedido.getStatus().equals(PedidoStatus.FINALIZADO)) {
                System.out.println("Pedido finalizado.");
            }
            System.out.println("2. Voltar");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    processarOpcaoPagamento();
                    break;
                case "2":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void processarOpcaoPagamento() {
        ServicoPedido servicoPedido = new ServicoPedido();
        try {
            if (pedido.getStatus().equals(PedidoStatus.AGUARDANDO_PAGAMENTO)) {
                servicoPedido.processarPagamento(pedido);
                System.out.println("Pagamento processado. Novo status: " + pedido.getStatus());
            } else if (pedido.getStatus().equals(PedidoStatus.PAGO)) {
                servicoPedido.finalizarPedido(pedido);
                System.out.println("Pedido finalizado. Novo status: " + pedido.getStatus());
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
