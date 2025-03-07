package dominio.cliente.servico;

import dominio.cliente.interfaces.AlteradorCliente;
import dominio.cliente.Cliente;
import dominio.cliente.interfaces.ValidadorCliente;

public class AlteraCliente implements AlteradorCliente {
    private final ValidadorCliente validador;

    public AlteraCliente(ValidadorCliente validador) {
        this.validador = validador;
    }

    @Override
    public void alterarNome(Cliente cliente, String novoNome) {
        if (!validador.validarClienteAtivo(cliente)) {
            throw new IllegalStateException("Cliente inativo.");
        }
        if (!validador.validarNome(novoNome)) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        cliente.setNome(novoNome);
    }

    @Override
    public void alterarDocumento(Cliente cliente, String novoDocumento) {
        if (!validador.validarClienteAtivo(cliente)) {
            throw new IllegalStateException("Cliente inativo.");
        }
        if (!validador.validarDocumento(novoDocumento)) {
            throw new IllegalArgumentException("Documento inválido.");
        }
        cliente.setDocumento(novoDocumento);
    }

    @Override
    public void alterarEmail(Cliente cliente, String novoEmail) {
        if (!validador.validarClienteAtivo(cliente)) {
            throw new IllegalStateException("Cliente inativo.");
        }
        if (!validador.validarEmail(novoEmail)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        cliente.setEmail(novoEmail);
    }
}
