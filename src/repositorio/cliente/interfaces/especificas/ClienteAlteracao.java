package repositorio.cliente.interfaces.especificas;

import dominio.Cliente.Cliente;

public interface ClienteAlteracao {
    void alterarEmail(Cliente cliente, String novoEmail);
}
