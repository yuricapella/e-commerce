package aplicacao.menu.util;

import dominio.pedido.ItemPedido;
import dominio.pedido.Pedido;
import dominio.produto.Produto;
import dominio.desconto.ServicoDesconto;
import dominio.frete.ServicoFrete;
import dominio.cliente.Cliente;
import dominio.usuario.Usuario;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class FormatadorExibicao {

    public static void exibirPedido(Pedido pedido) {
        System.out.println("\n========================================");
        System.out.println("           🛒 Pedido                    ");
        System.out.println("========================================");
        System.out.printf("📌 Pedido: #%d  | Cliente: %s  | Status: %s\n",
                pedido.getId(), pedido.getCliente().getNome(), pedido.getStatus());
        System.out.printf("📅 Data Criação: %s\n",
                pedido.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        System.out.println("\n----------------------------------------");
        System.out.println("           🏷️ Itens do Pedido           ");
        System.out.println("----------------------------------------");
        System.out.printf("%-4s | %-20s | %-8s | %-10s | %-10s\n",
                "ID", "Produto", "Qtd", "V. Unit", "V. Total");
        System.out.println("---------------------------------------------------------------");

        for (ItemPedido item : pedido.getItens()) {
            Produto produto = item.getProduto();
            System.out.printf("%-4d | %-20s | %-8d | R$ %-8.2f | R$ %-8.2f\n",
                    produto.getId(), produto.getNome(), item.getQuantidade(),
                    produto.getValorProduto(), item.getValorTotal());
        }

        System.out.println("\n----------------------------------------");
        System.out.printf("💰 Valor Total (sem desconto): R$ %.2f\n", pedido.getValorTotal());
        System.out.println("========================================");
    }

    public static void exibirPedido(Pedido pedido, ServicoDesconto servicoDesconto, ServicoFrete servicoFrete) {
        System.out.println("\n========================================");
        System.out.println("           🛒 Carrinho de Compras       ");
        System.out.println("========================================");
        System.out.printf("📌 Pedido: #%d  | Cliente: %s  | Status: %s\n",
                pedido.getId(), pedido.getCliente().getNome(), pedido.getStatus());
        System.out.printf("📅 Data Criação: %s\n",
                pedido.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        System.out.println("\n----------------------------------------");
        System.out.println("           🏷️ Itens do Pedido           ");
        System.out.println("----------------------------------------");
        System.out.printf("%-4s | %-20s | %-8s | %-10s | %-10s | %-10s\n",
                "ID", "Produto", "Qtd", "V. Unit", "V. Total", "Desconto");
        System.out.println("---------------------------------------------------------------");

        for (ItemPedido item : pedido.getItens()) {
            Produto produto = item.getProduto();

            double descontoItem = servicoDesconto.getDescontosProduto()
                    .stream().mapToDouble(desconto -> desconto.calcular(item)).sum();

            System.out.printf("%-4d | %-20s | %-8d | R$ %-8.2f | R$ %-8.2f | R$ %-8.2f\n",
                    produto.getId(), produto.getNome(), item.getQuantidade(),
                    produto.getValorProduto(), item.getValorTotal(), descontoItem);
        }

        System.out.println("\n----------------------------------------");
        System.out.printf("💰 Valor Total (sem desconto): R$ %.2f\n", pedido.getValorTotal());

        double descontoPedido = CalculadoraDeValoresPedido.calcularDescontoPedido(pedido, servicoDesconto);
        double totalDesconto = descontoPedido + CalculadoraDeValoresPedido.calcularDescontoProduto(pedido, servicoDesconto);
        double valorTotalComDesconto = CalculadoraDeValoresPedido.calcularValorTotalComDesconto(pedido, servicoDesconto);
        double valorFrete = CalculadoraDeValoresPedido.calcularValorFrete(pedido, servicoFrete);
        double valorTotalFinal = CalculadoraDeValoresPedido.calcularValorTotalFinal(pedido, servicoDesconto, servicoFrete);

        System.out.printf("🎁 Desconto no Pedido: R$ %.2f\n", descontoPedido);
        System.out.printf("🔖 Valor Total de Descontos: R$ %.2f\n", totalDesconto);
        System.out.printf("💲 Valor Total com Desconto: R$ %.2f\n", valorTotalComDesconto);
        System.out.printf("🚚 Valor do Frete: R$ %.2f\n", valorFrete);
        System.out.printf("💳 Valor Final (com frete): R$ %.2f\n", valorTotalFinal);
        System.out.println("========================================");
    }

    public static void exibirProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║              Produtos Disponíveis            ║");
        System.out.println("╠═════════╦════════════════╦══════════════════╦══════════════════╦════════════╣");
        System.out.println("║   ID    ║      Nome      ║     Valor Base   ║       Tipo       ║   Status   ║");
        System.out.println("╠═════════╬════════════════╬══════════════════╬══════════════════╬════════════╣");

        for (Produto produto : produtos) {
            System.out.printf("║ %7d ║ %-14s ║ R$ %-14.2f ║ %-16s ║ %-10s ║\n",
                    produto.getId(), produto.getNome(), produto.getValorProduto(), produto.getTipo(),
                    produto.isAtivo() ? "Ativo ✅" : "Inativo ❌");
        }

        System.out.println("╚═════════╩════════════════╩══════════════════╩══════════════════╩════════════╝");
    }

    public static void exibirCliente(List<Cliente> clientes) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║              Lista de Clientes               ║");
        System.out.println("╠═════════╦════════════════╦══════════════════╦════════════════════════╦════════════════════╦══════════╣");
        System.out.println("║   ID    ║      Nome      ║    Documento     ║          Email         ║       Tipo         ║  Status  ║");
        System.out.println("╠═════════╬════════════════╬══════════════════╬════════════════════════╬════════════════════╬══════════╣");

        for (Cliente cliente : clientes) {
            System.out.printf("║ %7d ║ %-14s ║ %-16s ║ %-22s ║ %-18s ║ %-8s║\n",
                    cliente.getId(), cliente.getNome(), cliente.getDocumento(), cliente.getEmail(),
                    cliente.getTipo(), cliente.isAtivo() ? "Ativo ✅" : "Inativo ❌");
        }

        System.out.println("╚═════════╩════════════════╩══════════════════╩════════════════════════╩════════════════════╩══════════╝");
    }

    public static void exibirCliente(Cliente cliente) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║              Dados do Cliente                ║");
        System.out.println("╠═════════╦════════════════╦══════════════════╦════════════════════════╦════════════════════╦════════════╣");
        System.out.println("║   ID    ║      Nome      ║    Documento     ║          Email         ║       Tipo         ║   Status   ║");
        System.out.println("╠═════════╬════════════════╬══════════════════╬════════════════════════╬════════════════════╬════════════╣");

        System.out.printf("║ %7d ║ %-14s ║ %-16s ║ %-22s ║ %-18s ║ %-9s ║\n",
                cliente.getId(), cliente.getNome(), cliente.getDocumento(), cliente.getEmail(),
                cliente.getTipo(), cliente.isAtivo() ? "Ativo ✅" : "Inativo ❌");

        System.out.println("╚═════════╩════════════════╩══════════════════╩════════════════════════╩════════════════════╩════════════╝");
    }


    public static void exibirUsuarios(List<Usuario> usuarios) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║              Lista de Usuários               ║");
        System.out.println("╠═════════╦════════════════╦══════════════════╦════════════════════════╦════════════════════╦══════════════════╣");
        System.out.println("║   ID    ║      Login     ║      Senha       ║      Tipo              ║       Status       ║");
        System.out.println("╠═════════╬════════════════╬══════════════════╬════════════════════════╬════════════════════╬══════════════════╣");

        for (Usuario usuario : usuarios) {
            System.out.printf("║ %7d ║ %-14s ║ %-16s ║ %-22s ║ %-17s ║\n",
                    usuario.getId(), usuario.getLogin(), usuario.getSenha(),
                    usuario.getTipo(), usuario.isAtivo() ? "Ativo ✅" : "Inativo ❌");
        }

        System.out.println("╚═════════╩════════════════╩══════════════════╩════════════════════════╩════════════════════╩══════════════════╝");
    }


}
