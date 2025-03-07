package teste.integracao;

import dominio.desconto.Factory.DescontoPedidoFactory;
import dominio.desconto.Factory.DescontoProdutoFactory;
import dominio.desconto.ServicoDesconto;
import dominio.frete.FreteFactory;
import dominio.frete.ServicoFrete;
import dominio.notificacao.ServicoNotificador;
import dominio.pedido.*;
import dominio.produto.*;
import dominio.produto.interfaces.AlteradorProduto;
import dominio.produto.interfaces.ValidadorProduto;
import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaFisica;
import dominio.notificacao.Notificador;
import dominio.notificacao.NotificadorEmail;
import dominio.pedido.interfaces.ValidadorPedido;
import dominio.pedido.servico.ServicoPedido;
import dominio.pedido.servico.ValidaPedido;
import dominio.produto.servico.AlteraProduto;
import dominio.produto.servico.ServicoProduto;
import dominio.produto.servico.ValidaProduto;
import repositorio.cliente.RepositorioClienteMemoria;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.produto.RepositorioProdutoMemoria;
import repositorio.produto.interfaces.compostas.RepositorioProduto;

public class TestePedido {

    public static void main(String[] args) {
        // Criação e inicialização do cliente
        Cliente cliente = new ClientePessoaFisica("Cliente 1", "12345678910", "cliente1@gmail.com");
        RepositorioCliente repositorioCliente = new RepositorioClienteMemoria();
        repositorioCliente.adicionar(cliente);

        // Criando produtos e inicializando o repositório de produtos
        Produto produto1 = new ProdutoEletronico("Tv 1", 1080);
        Produto produto2 = new ProdutoPapelaria("Caderno 1", 29.99);
        Produto produto3 = new ProdutoLivro("Livro 1", 75.0);
        Produto produto4 = new ProdutoVestuario("Camisa 1", 49.50);

        RepositorioProduto repositorioProduto = new RepositorioProdutoMemoria();
        ValidadorProduto validadorProduto = new ValidaProduto();
        AlteradorProduto alteradorProduto = new AlteraProduto(validadorProduto);
        ServicoProduto servicoProduto = new ServicoProduto(repositorioProduto, alteradorProduto);

        // Adicionando produtos ao repositório
        servicoProduto.adicionarProduto(produto1);
        servicoProduto.adicionarProduto(produto2);
        servicoProduto.adicionarProduto(produto3);
        servicoProduto.adicionarProduto(produto4);

        // Exibindo a listagem de clientes e produtos
        System.out.println("\n### Listagem de Clientes ###");
        System.out.println(repositorioCliente.listarTodosClientes());

        System.out.println("\n### Listagem de Produtos ###");
        System.out.println(repositorioProduto.listarTodosProdutos());

        // Criando pedido
        ValidadorPedido validadorPedido = new ValidaPedido();
        Pedido pedido = new PedidoPadrao(cliente,validadorPedido);
        System.out.println("\n### Pedido Inicial (Sem Produtos) ###");
        System.out.println(pedido);

        // Inicializando notificadores e serviços de pedido
        Notificador notificador = new NotificadorEmail();
        ServicoNotificador servicoNotificador = new ServicoNotificador(notificador);
        ServicoPedido servicoPedido = new ServicoPedido(servicoNotificador);

        // Adicionando itens ao pedido
        System.out.println("\n### Adicionando Produtos ao Pedido ###");
        pedido.adicionarItem(repositorioProduto.buscarPorId(1), 2, 1100);
        pedido.adicionarItem(repositorioProduto.buscarPorId(2), 3, 35);
        System.out.println(pedido);

        // Removendo produto do pedido
        System.out.println("\n### Removendo Produto 1 do Pedido ###");
        pedido.removerItem(repositorioProduto.buscarPorId(1));
        System.out.println(pedido);

        // Alterando quantidade do produto
        System.out.println("\n### Alterando Quantidade do Produto 2 ###");
        pedido.alterarQuantidadeItem(repositorioProduto.buscarPorId(2), 5);
        System.out.println(pedido);

        // Finalizando o pedido
        System.out.println("\n### Concluindo Pedido ###");
        servicoPedido.concluirPedido(pedido);
        System.out.println(pedido);

        // Tentando alterar a quantidade após conclusão do pedido
        System.out.println("\n### Tentando Alterar Quantidade Após Concluir Pedido (Não Permitido) ###");
        pedido.alterarQuantidadeItem(repositorioProduto.buscarPorId(2), 3);
        System.out.println(pedido);

        System.out.println("\n------------ DESCONTO APLICADO ------------");
        ServicoDesconto servicoDesconto = new ServicoDesconto(
                DescontoPedidoFactory.getListaDescontoPedido(),
                DescontoProdutoFactory.getListaDescontoProduto());
        double descontoTotalPedido = servicoDesconto.calcularDescontoTotal(pedido);
        double descontoTotalProduto = servicoDesconto.calcularMelhorDescontoProduto(pedido);
        System.out.println("Desconto aplicado no Pedido: R$ " + descontoTotalPedido);
        System.out.println("Desconto aplicado nos Produtos: R$ " + descontoTotalProduto);

        ServicoFrete servicoFrete = new ServicoFrete(FreteFactory.criarFretes());
        double valorFrete = servicoFrete.calcularFrete(pedido);
        System.out.println("Valor do Frete: R$ " + valorFrete);

        double valorTotalFinal = aplicacao.menu.util.CalculadoraDeValoresPedido.calcularValorTotalFinal(pedido, servicoDesconto, servicoFrete);
        System.out.println("\nValor Total do Pedido (sem desconto): R$ " + pedido.getValorTotal());
        System.out.println("Valor Total com Desconto e Frete: R$ " + valorTotalFinal);

        System.out.println("\n### Processando Pagamento ###");
        servicoPedido.processarPagamento(pedido, valorTotalFinal);
        servicoPedido.finalizarPedido(pedido);
    }
}
