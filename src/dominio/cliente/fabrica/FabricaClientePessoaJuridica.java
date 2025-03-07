package dominio.cliente.fabrica;

import dominio.cliente.Cliente;
import dominio.cliente.ClientePessoaJuridica;
import dominio.cliente.interfaces.FabricaCliente;

public class FabricaClientePessoaJuridica implements FabricaCliente {
    @Override
    public Cliente criarCliente(String nome, String documento, String email) {
        return new ClientePessoaJuridica(nome, documento, email);
    }
}
