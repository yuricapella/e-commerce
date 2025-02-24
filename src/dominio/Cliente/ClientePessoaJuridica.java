package dominio.Cliente;

public class ClientePessoaJuridica extends Cliente{
    public ClientePessoaJuridica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_JURIDICA);
    }

    @Override
    public boolean validarDocumento() {
        return ValidadorDocumento.validarCNPJ(documento);
    }
}
