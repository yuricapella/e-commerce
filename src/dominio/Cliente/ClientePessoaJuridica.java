package dominio.Cliente;

public class ClientePessoaJuridica extends Cliente {
    public ClientePessoaJuridica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_JURIDICA);
        if (!validarDocumento()) {
            throw new IllegalArgumentException("CNPJ inválido.");
        }
    }

    @Override
    public boolean validarDocumento() {
        return ValidaCliente.validarCNPJ(documento);
    }

    @Override
    public String toString() {
        String clienteToString = super.toString();
        String documentoFormatado = FormataDocumento.formatarCNPJ(this.documento);
        clienteToString = clienteToString.replace(this.documento, documentoFormatado);
        return clienteToString;
    }
}
