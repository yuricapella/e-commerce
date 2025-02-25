package teste.unitario;

import dominio.Cliente.Cliente;
import dominio.Cliente.ClientePessoaFisica;
import dominio.Cliente.ClientePessoaJuridica;

public class TesteCliente {
    public static void main(String[] args) {
        Cliente cliente = new ClientePessoaFisica("Cliente 1","12345678910","cliente1@gmail.com");
        System.out.println(cliente.getNome());
        System.out.println(cliente.getDocumento());
        System.out.println(cliente.getEmail());
        System.out.println(cliente.getId());
        System.out.println(cliente);

        Cliente cliente2 = new ClientePessoaJuridica("Cliente 2","12345678000112","cliente2@gmail.com");
        System.out.println(cliente2);
    }
}
