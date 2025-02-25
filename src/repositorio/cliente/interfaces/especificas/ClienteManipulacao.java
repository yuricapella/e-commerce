package repositorio.cliente.interfaces.especificas;

import dominio.Cliente.Cliente;

public interface ClienteManipulacao {
    void adicionar(Cliente cliente);

    void remover(Cliente cliente);
}
