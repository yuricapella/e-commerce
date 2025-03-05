package dominio.cliente.interfaces;

import dominio.cliente.Cliente;

public interface ValidadorCliente {
    boolean validarClienteAtivo(Cliente cliente);
    boolean validarNome(String nome);
    boolean validarDocumento(String documento);
    boolean validarEmail(String email);
}