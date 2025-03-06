package aplicacao.menu.util;

import dominio.Desconto.ServicoDesconto;
import dominio.Frete.ServicoFrete;
import dominio.Pedido.Pedido;

public class CalculadoraDeValoresPedido {

    public static double calcularDescontoPedido(Pedido pedido, ServicoDesconto servicoDesconto) {
        return servicoDesconto.calcularMelhorDescontoPedido(pedido);
    }

    public static double calcularDescontoProduto(Pedido pedido, ServicoDesconto servicoDesconto) {
        return servicoDesconto.calcularMelhorDescontoProduto(pedido);
    }

    public static double calcularValorTotalComDesconto(Pedido pedido, ServicoDesconto servicoDesconto) {
        double descontoPedido = calcularDescontoPedido(pedido, servicoDesconto);
        double descontoProduto = calcularDescontoProduto(pedido, servicoDesconto);
        return pedido.getValorTotal() - (descontoPedido + descontoProduto);
    }

    public static double calcularValorFrete(Pedido pedido, ServicoFrete servicoFrete) {
        return servicoFrete.calcularFrete(pedido);
    }

    public static double calcularValorTotalFinal(Pedido pedido, ServicoDesconto servicoDesconto, ServicoFrete servicoFrete) {
        double valorTotalComDesconto = calcularValorTotalComDesconto(pedido, servicoDesconto);
        double valorFrete = calcularValorFrete(pedido, servicoFrete);
        return valorTotalComDesconto + valorFrete;
    }
}