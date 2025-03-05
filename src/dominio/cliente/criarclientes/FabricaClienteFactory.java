package dominio.cliente.criarclientes;

import dominio.cliente.TipoCliente;

public class FabricaClienteFactory {
    public static FabricaCliente obterFabrica(TipoCliente tipo) {
        return switch (tipo) {
            case PESSOA_FISICA -> new FabricaClientePessoaFisica();
            case PESSOA_JURIDICA -> new FabricaClientePessoaJuridica();
            default -> throw new IllegalArgumentException("Tipo de cliente não suportado.");
        };
    }
}