package teste.unitario;

import dominio.Cliente.Cliente;

public class TesteCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Cliente 1","12345678910","cliente1@gmail.com");
        System.out.println(cliente.getNome());
        System.out.println(cliente.getDocumento());
        System.out.println(cliente.getEmail());
        System.out.println(cliente.getId());
        System.out.println(cliente);

        Cliente cliente2 = new Cliente("Cliente 2","12345678911","cliente2@gmail.com");
        System.out.println(cliente2);
    }
}
