package repositorio.cliente;

import dominio.Cliente.Cliente;

public interface ClienteManipulacao {
    void adicionar(Cliente cliente);

    void remover(Cliente cliente);
}
