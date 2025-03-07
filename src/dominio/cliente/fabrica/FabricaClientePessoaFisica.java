package dominio.cliente.fabrica;

import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaFisica;
import dominio.cliente.interfaces.FabricaCliente;

public class FabricaClientePessoaFisica implements FabricaCliente {
    @Override
    public Cliente criarCliente(String nome, String documento, String email) {
        return new ClientePessoaFisica(nome, documento, email);
    }
}
