package repositorio.cliente.interfaces.especificas;

import dominio.cliente.Cliente;

public interface ClienteManipulacao {
    void adicionar(Cliente cliente);

    void remover(Cliente cliente);
}
