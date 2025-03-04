package dominio.Cliente;

public class ClientePessoaFisica extends Cliente {
    public ClientePessoaFisica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_FISICA);
        if (!validarDocumento()) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.documento = FormataDocumento.formatarCPF(documento);
    }

    @Override
    public boolean validarDocumento() {
        return ValidaCliente.validarCPF(documento);
    }
}
