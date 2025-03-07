package dominio.desconto.Factory;

import dominio.desconto.Produto.DescontoProduto;
import dominio.desconto.Produto.DescontoVestuario;

import java.util.List;

public class DescontoProdutoFactory {
    public static List<DescontoProduto> getListaDescontoProduto() {
        return List.of(new DescontoVestuario(3,10));
    }
}
