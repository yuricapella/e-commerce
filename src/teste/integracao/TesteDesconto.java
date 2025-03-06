package teste.integracao;

import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaFisica;
import dominio.Desconto.Factory.DescontoPedidoFactory;
import dominio.Desconto.Factory.DescontoProdutoFactory;
import dominio.Desconto.ServicoDesconto;
import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoPadrao;
import dominio.Pedido.ValidaPedido;
import dominio.Produto.Produto;
import dominio.Produto.ProdutoEletronico;
import dominio.Produto.ProdutoVestuario;
import repositorio.cliente.RepositorioClienteMemoria;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.produto.RepositorioProdutoMemoria;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import aplicacao.menu.util.CalculadoraDeValoresPedido;

public class TesteDesconto {
    public static void main(String[] args) {
        Cliente cliente = new ClientePessoaFisica("Cliente 1", "12345678910", "cliente1@gmail.com");

        Produto produto1 = new ProdutoEletronico("Tv 1", 1080);
        Produto produto2 = new ProdutoVestuario("Calça 1", 70.50);

        RepositorioProduto repositorioProduto = new RepositorioProdutoMemoria();
        repositorioProduto.adicionar(produto1);
        repositorioProduto.adicionar(produto2);

        RepositorioCliente repositorioCliente = new RepositorioClienteMemoria();
        repositorioCliente.adicionar(cliente);

        ValidaPedido validadorPedido = new ValidaPedido();

        Pedido pedido = new PedidoPadrao(repositorioCliente.buscarPorId(1), validadorPedido);
        pedido.adicionarItem(produto1, 2, 1080);
        pedido.adicionarItem(produto2, 5, 75);

        ServicoDesconto servicoDesconto = new ServicoDesconto(DescontoPedidoFactory.getListaDescontoPedido(),
                DescontoProdutoFactory.getListaDescontoProduto());

        double descontoPedido = servicoDesconto.calcularDescontoTotal(pedido);
        double descontoProduto = servicoDesconto.calcularMelhorDescontoProduto(pedido);


        System.out.println("------------ PRODUTOS ------------");
        System.out.println(produto1);
        System.out.println(produto2);

        System.out.println("\n------------ PEDIDO ------------");
        System.out.println(pedido);
        System.out.println("Valor Total do Pedido (sem desconto): " + pedido.getValorTotal());
        System.out.println("Valor Total do Pedido (com desconto): " + (pedido.getValorTotal() - (descontoPedido + descontoProduto)));

        System.out.println("\n------------ DESCONTO APLICADO ------------");
        System.out.println("Desconto aplicado no Pedido: " + descontoPedido);
        System.out.println("Desconto aplicado nos Produtos: " + descontoProduto);
    }
}
