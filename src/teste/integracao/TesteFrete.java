package teste.integracao;

import dominio.pedido.servico.ValidaPedido;
import dominio.pedido.interfaces.ValidadorPedido;
import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaFisica;
import dominio.produto.Produto;
import dominio.produto.ProdutoEletronico;
import dominio.produto.ProdutoVestuario;
import dominio.pedido.Pedido;
import dominio.pedido.PedidoPadrao;
import dominio.frete.ServicoFrete;
import dominio.frete.FreteFactory;
import repositorio.cliente.RepositorioClienteMemoria;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.produto.RepositorioProdutoMemoria;
import repositorio.produto.interfaces.compostas.RepositorioProduto;

public class TesteFrete {
    public static void main(String[] args) {
        // Criando cliente
        Cliente cliente = new ClientePessoaFisica("Cliente 1", "12345678910", "cliente1@gmail.com");

        // Criando produtos
        Produto produto1 = new ProdutoEletronico("Tv 1", 499);
        Produto produto2 = new ProdutoVestuario("Calça 1", 70.50);

        // Inicializando repositórios
        RepositorioProduto repositorioProduto = new RepositorioProdutoMemoria();
        RepositorioCliente repositorioCliente = new RepositorioClienteMemoria();

        // Adicionando cliente e produtos aos repositórios
        repositorioCliente.adicionar(cliente);
        repositorioProduto.adicionar(produto1);
        repositorioProduto.adicionar(produto2);

        // Listagem de clientes e produtos
        System.out.println("LISTAGEM DE CLIENTES NO REPOSITORIO");
        System.out.println(repositorioCliente.listarTodosClientes());

        System.out.println("LISTAGEM DE PRODUTOS NO REPOSITORIO");
        System.out.println(repositorioProduto.listarTodosProdutos());

        // Criando pedidos e adicionando itens
        ValidadorPedido validadorPedido = new ValidaPedido();
        Pedido pedido1 = new PedidoPadrao(repositorioCliente.buscarPorId(1),validadorPedido);
        pedido1.adicionarItem(repositorioProduto.buscarPorId(1), 2, 499);
        pedido1.adicionarItem(repositorioProduto.buscarPorId(2), 5, 75);

        Pedido pedido2 = new PedidoPadrao(repositorioCliente.buscarPorId(1),validadorPedido);
        pedido2.adicionarItem(repositorioProduto.buscarPorId(2), 2, 70);

        // Calculando e exibindo o valor do frete dos pedidos
        System.out.println("VALOR DE FRETE DO PEDIDO 1");
        ServicoFrete calculaFrete = new ServicoFrete(FreteFactory.criarFretes());
        System.out.println(calculaFrete.calcularFrete(pedido1));

        System.out.println("VALOR DE FRETE DO PEDIDO 2");
        System.out.println(calculaFrete.calcularFrete(pedido2));
    }
}
