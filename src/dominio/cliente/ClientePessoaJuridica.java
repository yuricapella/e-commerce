package dominio.cliente;

import dominio.cliente.util.FormataDocumento;

public class ClientePessoaJuridica extends Cliente {
    public ClientePessoaJuridica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_JURIDICA);
    }
    @Override
    public String toString() {
        String clienteToString = super.toString();
        String documentoFormatado = FormataDocumento.formatarCNPJ(this.getDocumento());
        clienteToString = clienteToString.replace(this.getDocumento(), documentoFormatado);
        return clienteToString;
    }
}
