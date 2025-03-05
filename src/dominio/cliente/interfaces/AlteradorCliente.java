package dominio.cliente.interfaces;

import dominio.cliente.Cliente;

public interface AlteradorCliente {
    void alterarNome(Cliente cliente, String novoNome);
    void alterarDocumento(Cliente cliente, String novoDocumento);
    void alterarEmail(Cliente cliente, String novoEmail);
}
