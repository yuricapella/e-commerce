package dominio.Cliente;

public class AlteraCliente implements AlteradorCliente{
    private ValidadorCliente validador;

    public AlteraCliente(ValidadorCliente validador) {
        this.validador = validador;
    }

    public void alterarNome(Cliente cliente, String novoNome) {
        validador.validarClienteAtivo(cliente);
        cliente.setNome(novoNome);
    }

    public void alterarDocumento(Cliente cliente, String novoDocumento) {
        validador.validarClienteAtivo(cliente);
        cliente.setDocumento(novoDocumento);
    }

    public void alterarEmail(Cliente cliente, String novoEmail) {
        validador.validarClienteAtivo(cliente);
        cliente.setEmail(novoEmail);
    }
}
