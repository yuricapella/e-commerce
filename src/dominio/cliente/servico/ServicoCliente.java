package dominio.cliente.servico;

import dominio.cliente.Cliente;
import dominio.cliente.TipoCliente;
import dominio.cliente.interfaces.FabricaCliente;
import dominio.cliente.fabrica.FabricaClienteFactory;
import dominio.cliente.interfaces.AlteradorCliente;
import dominio.cliente.interfaces.ValidadorCliente;
import dominio.cliente.util.SelecionaTipoCliente;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;

public class ServicoCliente {
    private final RepositorioCliente repositorioCliente;
    private final AlteradorCliente alteradorCliente;
    private final ValidadorCliente validadorCliente;

    public ServicoCliente(RepositorioCliente repositorioCliente,
                          AlteradorCliente alteradorCliente,
                          ValidadorCliente validadorCliente) {
        this.repositorioCliente = repositorioCliente;
        this.alteradorCliente = alteradorCliente;
        this.validadorCliente = validadorCliente;
    }

    public void adicionarCliente(Cliente cliente) {
        if (repositorioCliente.buscarPorId(cliente.getId()) != null) {
            System.out.println("Cliente já existe no repositório.");
            return;
        }
        validarDadosCliente(cliente.getNome(), cliente.getDocumento(), cliente.getEmail());
        repositorioCliente.adicionar(cliente);
    }

    public void atualizarNomeCliente(Cliente cliente, String novoNome) {
        alteradorCliente.alterarNome(cliente, novoNome);
    }

    public void atualizarDocumentoCliente(Cliente cliente, String novoDocumento) {
        alteradorCliente.alterarDocumento(cliente, novoDocumento);
    }

    public void atualizarEmailCliente(Cliente cliente, String novoEmail) {
        alteradorCliente.alterarEmail(cliente, novoEmail);
    }


    public Cliente cadastrarCliente(String nome, String documento, String email) {
        validarDadosCliente(nome, documento, email);
        TipoCliente tipoCliente = SelecionaTipoCliente.determinarTipoCliente(documento);
        FabricaCliente fabricaCliente = FabricaClienteFactory.obterFabrica(tipoCliente);
        return fabricaCliente.criarCliente(nome, documento, email);
    }

    private void validarDadosCliente(String nome, String documento, String email) {
        if (!validadorCliente.validarNome(nome) ||
                !validadorCliente.validarDocumento(documento) ||
                !validadorCliente.validarEmail(email)) {
            throw new IllegalArgumentException("Nome, documento ou email inválidos.");
        }
    }
}
