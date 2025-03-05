package dominio.cliente.criarclientes;

import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaJuridica;

public class FabricaClientePessoaJuridica implements FabricaCliente {
    @Override
    public Cliente criarCliente(String nome, String documento, String email) {
        return new ClientePessoaJuridica(nome, documento, email);
    }
}
