package teste.integracao;

import dominio.Cliente.Cliente;
import dominio.Cliente.ClientePessoaFisica;
import dominio.Cliente.ClientePessoaJuridica;
import repositorio.cliente.RepositorioCliente;

public class TesteRepositorioCliente {
    public static void main(String[] args) {
        Cliente cliente = new ClientePessoaFisica("Cliente 1","12345678910","cliente1@gmail.com");
        Cliente cliente2 = new ClientePessoaJuridica("Cliente 2","12345678000112","cliente2@gmail.com");

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.adicionar(cliente);
        repositorioCliente.adicionar(cliente2);
        System.out.println(repositorioCliente.listarClientes());

        System.out.println(repositorioCliente.buscarPorId(cliente.getId()));
        System.out.println(repositorioCliente.buscarPorDocumento(cliente.getDocumento()));
        System.out.println(repositorioCliente.buscarPorEmail(cliente.getEmail()));
        System.out.println(repositorioCliente.buscarPorNome(cliente.getNome()));
        repositorioCliente.alterarEmail(cliente,"novoemailcliente@gmail.com");
        System.out.println(repositorioCliente.listarClientes());
        repositorioCliente.remover(cliente2);
        System.out.println(repositorioCliente.listarClientes());
    }
}
