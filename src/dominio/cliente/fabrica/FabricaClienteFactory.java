package dominio.cliente.fabrica;

import dominio.cliente.TipoCliente;
import dominio.cliente.interfaces.FabricaCliente;

public class FabricaClienteFactory {
    public static FabricaCliente obterFabrica(TipoCliente tipo) {
        return switch (tipo) {
            case PESSOA_FISICA -> new FabricaClientePessoaFisica();
            case PESSOA_JURIDICA -> new FabricaClientePessoaJuridica();
            default -> throw new IllegalArgumentException("Tipo de cliente não suportado.");
        };
    }
}