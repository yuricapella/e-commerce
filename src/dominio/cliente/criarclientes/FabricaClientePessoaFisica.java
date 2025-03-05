package dominio.cliente.criarclientes;

import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaFisica;

public class FabricaClientePessoaFisica implements FabricaCliente {
    @Override
    public Cliente criarCliente(String nome, String documento, String email) {
        return new ClientePessoaFisica(nome, documento, email);
    }
}
