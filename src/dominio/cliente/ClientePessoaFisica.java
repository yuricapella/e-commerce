package dominio.cliente;

import dominio.cliente.util.FormataDocumento;

public class ClientePessoaFisica extends Cliente {
    public ClientePessoaFisica(String nome, String documento, String email) {
        super(nome, documento, email, TipoCliente.PESSOA_FISICA);

    }

    @Override
    public String toString() {
        String clienteToString = super.toString();
        String documentoFormatado = FormataDocumento.formatarCPF(this.getDocumento());
        clienteToString = clienteToString.replace(this.getDocumento(), documentoFormatado);
        return clienteToString;
    }
}
