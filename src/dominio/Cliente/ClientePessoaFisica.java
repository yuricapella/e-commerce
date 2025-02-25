package dominio.Cliente;

public class ClientePessoaFisica extends Cliente{
    public ClientePessoaFisica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_FISICA);
    }

    @Override
    public boolean validarDocumento() {
        return ValidadorDocumento.validarCPF(documento);
    }
}
