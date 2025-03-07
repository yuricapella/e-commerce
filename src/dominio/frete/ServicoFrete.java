package dominio.frete;

import dominio.pedido.Pedido;

import java.util.List;

public class ServicoFrete {
    private List<Frete> opcoesFrete;

    public ServicoFrete(List<Frete> opcoesFrete) {
        this.opcoesFrete = opcoesFrete;
    }

    public double calcularFrete(Pedido pedido) {
        double menorFrete = Double.MAX_VALUE;

        for (Frete frete : opcoesFrete) {
            double valorFrete = frete.calcular(pedido);
            if (valorFrete < menorFrete) {
                menorFrete = valorFrete;
            }
        }

        return (menorFrete == Double.MAX_VALUE) ? 0 : menorFrete;
    }
}
