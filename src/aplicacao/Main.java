package aplicacao;

import aplicacao.menu.MenuPrincipal;
import dominio.desconto.Factory.DescontoPedidoFactory;
import dominio.desconto.Factory.DescontoProdutoFactory;
import dominio.notificacao.Notificador;
import dominio.notificacao.NotificadorEmail;
import dominio.notificacao.ServicoNotificador;
import dominio.pedido.servico.ValidaPedido;
import dominio.pedido.interfaces.ValidadorPedido;
import dominio.produto.*;
import dominio.produto.interfaces.AlteradorProduto;
import dominio.produto.interfaces.ValidadorProduto;
import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaFisica;
import dominio.cliente.interfaces.AlteradorCliente;
import dominio.cliente.interfaces.ValidadorCliente;
import dominio.cliente.servico.AlteraCliente;
import dominio.cliente.servico.ValidaCliente;
import dominio.produto.servico.AlteraProduto;
import dominio.produto.servico.ServicoProduto;
import dominio.produto.servico.ValidaProduto;
import dominio.produto.util.GeradorDeProdutos;
import dominio.usuario.*;
import dominio.usuario.fabrica.FabricaUsuario;
import dominio.usuario.interfaces.AlteradorUsuario;
import dominio.usuario.interfaces.ValidadorUsuario;
import dominio.usuario.servico.AlteraUsuario;
import dominio.usuario.servico.ServicoUsuario;
import dominio.usuario.servico.ValidaUsuario;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.usuario.RepositorioUsuarioMemoria;
import repositorio.cliente.RepositorioClienteMemoria;
import repositorio.produto.RepositorioProdutoMemoria;
import repositorio.pedido.RepositorioPedidoMemoria;
import dominio.desconto.ServicoDesconto;
import dominio.pedido.servico.ServicoPedido;
import dominio.cliente.servico.ServicoCliente;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Parte Cliente
        RepositorioCliente repositorioCliente = new RepositorioClienteMemoria();
        ValidadorCliente validadorCliente = new ValidaCliente();
        AlteradorCliente alteradorCliente = new AlteraCliente(validadorCliente);
        ServicoCliente servicoCliente = new ServicoCliente(repositorioCliente, alteradorCliente, validadorCliente);

        // Parte Usuario
        RepositorioUsuario repositorioUsuario = new RepositorioUsuarioMemoria();
        ValidadorUsuario validadorUsuario = new ValidaUsuario();
        AlteradorUsuario alteradorUsuario = new AlteraUsuario(validadorUsuario);
        FabricaUsuario fabricaUsuario = new FabricaUsuario();
        ServicoUsuario servicoUsuario = new ServicoUsuario(repositorioUsuario, alteradorUsuario, validadorUsuario, fabricaUsuario);

        Usuario admin = new UsuarioAdmin("admin","1234");
        repositorioUsuario.adicionar(admin);

        Usuario testeCliente = new UsuarioCliente("teste","teste");
        Cliente testeClientePessoaFisica = new ClientePessoaFisica("teste","12345678910","teste@teste.com");
        testeCliente.setCliente(testeClientePessoaFisica);
        repositorioCliente.adicionar(testeClientePessoaFisica);

        repositorioUsuario.adicionar(testeCliente);

        // Parte Produto
        List<Produto> produtos = GeradorDeProdutos.gerarListaDeProdutos(5,5,5,5);

        RepositorioProduto repositorioProduto = new RepositorioProdutoMemoria();
        ValidadorProduto validadorProduto = new ValidaProduto();
        AlteradorProduto alteradorProduto = new AlteraProduto(validadorProduto);
        ServicoProduto servicoProduto = new ServicoProduto(repositorioProduto,alteradorProduto);
        servicoProduto.adicionarProduto(produtos);

        //Parte Notificador
        Notificador notificador = new NotificadorEmail();
        ServicoNotificador servicoNotificador = new ServicoNotificador(notificador);

        // Parte Pedido
        ValidadorPedido validadorPedido = new ValidaPedido();
        RepositorioPedido repositorioPedido = new RepositorioPedidoMemoria();
        ServicoPedido servicoPedido = new ServicoPedido(servicoNotificador);

        // Parte Desconto
        ServicoDesconto servicoDesconto = new ServicoDesconto(DescontoPedidoFactory.getListaDescontoPedido(),
                                                              DescontoProdutoFactory.getListaDescontoProduto());
        // Criando o Scanner
        Scanner scanner = new Scanner(System.in);

        // Criando o MenuPrincipal
        MenuPrincipal menuPrincipal = new MenuPrincipal(
                scanner,
                repositorioUsuario,
                repositorioCliente,
                repositorioProduto,
                repositorioPedido,
                servicoDesconto,
                servicoPedido,
                servicoUsuario,
                servicoCliente,
                servicoProduto,
                validadorPedido,
                validadorCliente
        );

        menuPrincipal.exibirMenu();
        scanner.close();
    }
}
