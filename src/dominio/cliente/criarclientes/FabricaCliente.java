package dominio.cliente.criarclientes;

import dominio.cliente.Cliente;

public interface FabricaCliente {
    Cliente criarCliente(String nome, String documento, String email);
}
