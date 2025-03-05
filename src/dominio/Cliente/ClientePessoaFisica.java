package dominio.Cliente;

public class ClientePessoaFisica extends Cliente {
    public ClientePessoaFisica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_FISICA);
        if (!validarDocumento()) {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }

    @Override
    public boolean validarDocumento() {
        return ValidaCliente.validarCPF(documento);
    }

    @Override
    public String toString() {
        String clienteToString = super.toString();
        String documentoFormatado = FormataDocumento.formatarCPF(this.documento);
        clienteToString = clienteToString.replace(this.documento, documentoFormatado);
        return clienteToString;
    }
}
