package dominio.Cliente;

import repositorio.cliente.RepositorioCliente;

public class ServicoCliente {
    private final RepositorioCliente repositorioCliente;

    public ServicoCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente.validarDocumento()) {
            repositorioCliente.adicionar(cliente);
        } else {
            throw new IllegalArgumentException("Documento inválido.");
        }
    }

}
