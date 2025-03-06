package aplicacao;

import aplicacao.menu.MenuPrincipal;
import dominio.Desconto.Factory.DescontoPedidoFactory;
import dominio.Desconto.Factory.DescontoProdutoFactory;
import dominio.Notificacao.Notificador;
import dominio.Notificacao.NotificadorEmail;
import dominio.Notificacao.ServicoNotificador;
import dominio.Produto.*;
import dominio.Produto.interfaces.AlteradorProduto;
import dominio.Produto.interfaces.ValidadorProduto;
import dominio.cliente.interfaces.AlteradorCliente;
import dominio.cliente.interfaces.ValidadorCliente;
import dominio.cliente.servico.AlteraCliente;
import dominio.cliente.servico.ValidaCliente;
import dominio.usuario.*;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;
import repositorio.pedido.interfaces.compostas.RepositorioPedido;
import repositorio.produto.interfaces.compostas.RepositorioProduto;
import repositorio.usuario.RepositorioUsuarioMemoria;
import repositorio.cliente.RepositorioClienteMemoria;
import repositorio.produto.RepositorioProdutoMemoria;
import repositorio.pedido.RepositorioPedidoMemoria;
import dominio.Desconto.ServicoDesconto;
import dominio.Pedido.ServicoPedido;
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
                servicoCliente
        );

        // Exibindo o menu
        menuPrincipal.exibirMenu();
        scanner.close();
    }
}
