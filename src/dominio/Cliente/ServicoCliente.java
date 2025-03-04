package dominio.Cliente;

import repositorio.cliente.interfaces.compostas.RepositorioCliente;

public class ServicoCliente {
    private final RepositorioCliente repositorioCliente;
    private final AlteradorCliente alteradorCliente;

    public ServicoCliente(RepositorioCliente repositorioCliente, AlteradorCliente alteradorCliente) {
        this.repositorioCliente = repositorioCliente;
        this.alteradorCliente = alteradorCliente;
    }

    public void adicionarCliente(Cliente cliente) {
        if (repositorioCliente.buscarPorId(cliente.getId()) != null) {
            System.out.println("Cliente já está no repositório.");
            return;
        }

        if (cliente.validarDocumento()) {
            repositorioCliente.adicionar(cliente);
        } else {
            throw new IllegalArgumentException("Documento inválido.");
        }
    }

    public void atualizarNomeCliente(Cliente cliente, String novoNome) {
        alteradorCliente.alterarNome(cliente, novoNome);
    }

    public void atualizarDocumentoCliente(Cliente cliente, String novoDocumento) {
        if (cliente.validarDocumento()) {
            alteradorCliente.alterarDocumento(cliente, novoDocumento);
        } else {
            throw new IllegalArgumentException("Documento inválido.");
        }
    }

    public void atualizarEmailCliente(Cliente cliente, String novoEmail) {
        alteradorCliente.alterarEmail(cliente, novoEmail);
    }
}

