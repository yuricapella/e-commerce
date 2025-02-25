package teste.integracao;

import dominio.Cliente.*;
import repositorio.cliente.RepositorioCliente;

public class TesteClienteCompleto {
    public static void main(String[] args) {
        Cliente cliente = new ClientePessoaFisica("Cliente 1","12345678910","cliente1@gmail.com");
        Cliente cliente2 = new ClientePessoaJuridica("Cliente 2","12345678000112","cliente2@gmail.com");

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        ServicoCliente validaCliente = new ServicoCliente(repositorioCliente);

        validaCliente.adicionarCliente(cliente);
        validaCliente.adicionarCliente(cliente2);

        System.out.println(ValidadorDocumento.formatarCPF(cliente.getDocumento()));
        System.out.println(ValidadorDocumento.formatarCPF(cliente2.getDocumento()));
        System.out.println(ValidadorDocumento.formatarCNPJ(cliente.getDocumento()));
        System.out.println(ValidadorDocumento.formatarCNPJ(cliente2.getDocumento()));

        System.out.println(repositorioCliente.listarClientes());

    }
}
