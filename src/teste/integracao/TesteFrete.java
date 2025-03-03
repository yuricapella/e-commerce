package teste.integracao;

import dominio.Cliente.Cliente;
import dominio.Cliente.ClientePessoaFisica;
import dominio.Cliente.ServicoCliente;
import dominio.Desconto.Factory.DescontoPedidoFactory;
import dominio.Desconto.Factory.DescontoProdutoFactory;
import dominio.Desconto.ServicoDesconto;
import dominio.Frete.FreteFactory;
import dominio.Frete.ServicoFrete;
import dominio.Notificacao.Notificador;
import dominio.Notificacao.NotificadorEmail;
import dominio.Pagamento.ServicoPagamento;
import dominio.Pedido.Pedido;
import dominio.Pedido.PedidoPadrao;
import dominio.Pedido.ServicoPedido;
import dominio.Produto.Produto;
import dominio.Produto.ProdutoEletronico;
import dominio.Produto.ProdutoVestuario;
import dominio.Produto.ServicoProduto;
import repositorio.cliente.RepositorioClienteAtivo;
import repositorio.cliente.interfaces.compostas.ClienteAtivo;
import repositorio.produto.RepositorioProdutoAtivo;
import repositorio.produto.interfaces.compostas.ProdutoAtivo;

import java.sql.SQLOutput;

public class TesteFrete {
    public static void main(String[] args) {
        Cliente cliente = new ClientePessoaFisica("Cliente 1","12345678910","cliente1@gmail.com");

        Produto produto = new ProdutoEletronico("Tv 1",499);
        Produto produto2 = new ProdutoVestuario("Calça 1",70.50);

        ProdutoAtivo repositorioProduto = new RepositorioProdutoAtivo();
        ServicoProduto validaProduto = new ServicoProduto(repositorioProduto);


        ClienteAtivo repositorioCliente = new RepositorioClienteAtivo();
        ServicoCliente validaCliente = new ServicoCliente(repositorioCliente);

        validaCliente.adicionarCliente(cliente);

        validaProduto.adicionarProduto(produto);
        validaProduto.adicionarProduto(produto2);

        System.out.println("LISTAGEM DE CLIENTES NO REPOSITORIO");
        System.out.println(repositorioCliente.listarClientes());
        System.out.println("LISTAGEM DE PRODUTOS NO REPOSITORIO");
        System.out.println(repositorioProduto.listarProdutos());

        Pedido pedido = new PedidoPadrao(repositorioCliente.buscarPorId(1));
        pedido.adicionarItem(repositorioProduto.buscarPorId(1),2,499);
        pedido.adicionarItem(repositorioProduto.buscarPorId(2),5,75);

        Pedido pedido2 = new PedidoPadrao(repositorioCliente.buscarPorId(1));
        pedido2.adicionarItem(repositorioProduto.buscarPorId(2),2,70);
        //pedido2.adicionarItem(repositorioProduto.buscarPorId(2),2,100);

        System.out.println("VALOR DE FRETE DO PEDIDO 1");
        ServicoFrete calculaFrete = new ServicoFrete(FreteFactory.criarFretes());
        System.out.println(pedido);
        System.out.println(calculaFrete.calcularFrete(pedido));

        System.out.println("VALOR DE FRETE DO PEDIDO 2");
        System.out.println(pedido2);
        System.out.println(calculaFrete.calcularFrete(pedido2));

    }
}
