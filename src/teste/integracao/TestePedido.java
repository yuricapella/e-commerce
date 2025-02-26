package teste.integracao;

import dominio.Cliente.Cliente;
import dominio.Cliente.ClientePessoaFisica;
import dominio.Cliente.ClientePessoaJuridica;
import dominio.Cliente.ServicoCliente;
import dominio.Notificacao.Notificador;
import dominio.Notificacao.NotificadorEmail;
import dominio.Pagamento.ServicoPagamento;
import dominio.Pedido.Pedido;
import dominio.Pedido.ServicoPedido;
import dominio.Produto.*;
import repositorio.cliente.RepositorioClienteAtivo;
import repositorio.cliente.interfaces.compostas.ClienteAtivo;
import repositorio.produto.RepositorioProdutoAtivo;
import repositorio.produto.interfaces.compostas.ProdutoAtivo;

import java.sql.SQLOutput;

public class TestePedido {
    public static void main(String[] args) {

        Cliente cliente = new ClientePessoaFisica("Cliente 1","12345678910","cliente1@gmail.com");

        Produto produto = new ProdutoEletronico("Tv 1",1080);
        Produto produto2 = new ProdutoPapelaria("caderno 1",29.99);

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

        System.out.println("MOSTRANDO PEDIDO SEM PRODUTOS ADICIONADOS");
        Pedido pedido = new Pedido(repositorioCliente.buscarPorId(1));
        System.out.println(pedido);

        Notificador notificarEmail = new NotificadorEmail();
        ServicoPedido servicoPedido = new ServicoPedido(notificarEmail,pedido);
        ServicoPagamento servicoPagamento = new ServicoPagamento(notificarEmail,pedido);

        System.out.println("MOSTRANDO PEDIDO COM PRODUTOS ADICIONADOS");
        pedido.adicionarItem(repositorioProduto.buscarPorId(1),2,1100);
        pedido.adicionarItem(repositorioProduto.buscarPorId(2),3,35);
        System.out.println(pedido);

        System.out.println("REMOVENDO PRODUTO 1");
        pedido.removerItem(repositorioProduto.buscarPorId(1));
        System.out.println(pedido);

        System.out.println("ALTERANDO QUANTIDADE");
        pedido.alterarQuantidadeItem(repositorioProduto.buscarPorId(2),5);
        System.out.println(pedido);

        System.out.println("CONCLUINDO O PEDIDO");
        servicoPedido.concluirPedido();
        System.out.println(pedido);

        System.out.println("ALTERANDO QUANTIDADE APOS CONCLUIR PEDIDO");
        pedido.alterarQuantidadeItem(repositorioProduto.buscarPorId(2),3);
        System.out.println("\n"+pedido);

        System.out.println("PROCESSANDO O PAGAMENTO");
        servicoPagamento.processarPagamento();
        System.out.println(pedido);

    }
}
