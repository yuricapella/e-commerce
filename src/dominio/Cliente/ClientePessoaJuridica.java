package dominio.Cliente;

public class ClientePessoaJuridica extends Cliente {
    public ClientePessoaJuridica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_JURIDICA);
        if (!validarDocumento()) {
            throw new IllegalArgumentException("CNPJ inválido.");
        }
        this.documento = FormataDocumento.formatarCNPJ(documento);
    }

    @Override
    public boolean validarDocumento() {
        return ValidaCliente.validarCNPJ(documento);
    }
}
