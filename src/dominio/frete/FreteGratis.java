package dominio.frete;

import dominio.pedido.Pedido;

public class FreteGratis implements Frete{
    private double valorMinimo;

    public FreteGratis(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public double calcular(Pedido pedido) {
        return pedido.getValorTotal() >= valorMinimo ? 0 : 20;
    }
}
