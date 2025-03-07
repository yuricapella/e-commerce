package dominio.cliente.util;

import dominio.cliente.TipoCliente;

public class SelecionaTipoCliente {
    public static TipoCliente determinarTipoCliente(String documento) {
        if (documento.length() == 11) {
            return TipoCliente.PESSOA_FISICA;
        } else if (documento.length() == 14) {
            return TipoCliente.PESSOA_JURIDICA;
        }
        throw new IllegalArgumentException("Documento inválido.");
    }
}
