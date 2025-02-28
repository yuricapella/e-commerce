package dominio.Desconto.Factory;

import dominio.Desconto.Produto.DescontoProduto;
import dominio.Desconto.Produto.DescontoVestuario;

import java.util.List;

public class DescontoProdutoFactory {
    public static List<DescontoProduto> getListaDescontoProduto() {
        return List.of(new DescontoVestuario());
    }
}
