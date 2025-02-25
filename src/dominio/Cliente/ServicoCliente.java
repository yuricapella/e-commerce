package dominio.Cliente;

import repositorio.cliente.interfaces.compostas.ClienteAtivo;

public class ServicoCliente {
    private final ClienteAtivo clienteAtivo;

    public ServicoCliente(ClienteAtivo clienteAtivo) {
        this.clienteAtivo = clienteAtivo;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente.validarDocumento()) {
            clienteAtivo.adicionar(cliente);
        } else {
            throw new IllegalArgumentException("Documento inválido.");
        }
    }

}
