package repositorio.cliente;

import dominio.Cliente.Cliente;

public interface ClienteAlteracao {
    void alterarEmail(Cliente cliente, String novoEmail);
}
