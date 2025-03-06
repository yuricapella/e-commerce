package aplicacao.menu.menucliente;

import aplicacao.menu.util.CalculadoraDeValoresPedido;
import dominio.Frete.FreteFactory;
import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoStatus;
import dominio.Pedido.ServicoPedido;
import dominio.Desconto.ServicoDesconto;
import dominio.Frete.ServicoFrete;
import java.util.Scanner;

public class MenuPagamento {
    private Scanner scanner;
    private Pedido pedido;
    private ServicoPedido servicoPedido;
    private ServicoDesconto servicoDesconto;
    private ServicoFrete servicoFrete;

    public MenuPagamento(Scanner scanner, Pedido pedido, ServicoPedido servicoPedido,
                         ServicoDesconto servicoDesconto) {
        this.scanner = scanner;
        this.pedido = pedido;
        this.servicoPedido = servicoPedido;
        this.servicoDesconto = servicoDesconto;
        this.servicoFrete = new ServicoFrete(FreteFactory.criarFretes());
    }

    public void exibirMenu() {
        boolean menuAtivo = true;
        while (menuAtivo) {
            double valorTotalFinal = CalculadoraDeValoresPedido.calcularValorTotalFinal(pedido, servicoDesconto, servicoFrete);

            System.out.println("\n==== Pagamento ====");
            System.out.println("Status do Pedido: " + pedido.getStatus());
            System.out.println("Valor Total Final (com descontos e frete): R$ " + valorTotalFinal);

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Processar Pagamento");
            System.out.println("2. Confirmar Recebimento");
            System.out.println("3. Voltar");

            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    processarPagamento();
                    break;
                case "2":
                    confirmarRecebimento();
                    break;
                case "3":
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void processarPagamento() {
        double valorTotalFinal = CalculadoraDeValoresPedido.calcularValorTotalFinal(pedido, servicoDesconto, servicoFrete);
        try {
            if (pedido.getStatus().equals(PedidoStatus.AGUARDANDO_PAGAMENTO)) {
                servicoPedido.processarPagamento(pedido, valorTotalFinal);
                System.out.println("Pagamento processado com sucesso!");
                System.out.println("Por favor, acompanhe a entrega do seu pedido através do rastreamento.");
            } else {
                System.out.println("O pagamento já foi processado.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao processar pagamento: " + e.getMessage());
        }
    }

    private void confirmarRecebimento() {
        try {
            if (pedido.getStatus().equals(PedidoStatus.PAGO)) {
                servicoPedido.finalizarPedido(pedido);
            } else {
                System.out.println("O pagamento ainda não foi processado ou já foi finalizado!");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao confirmar recebimento: " + e.getMessage());
        }
    }
}
