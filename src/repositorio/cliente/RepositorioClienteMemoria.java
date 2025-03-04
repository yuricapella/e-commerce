package repositorio.cliente;

import dominio.Cliente.Cliente;
import repositorio.cliente.interfaces.compostas.RepositorioCliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioClienteMemoria implements RepositorioCliente {
    private final Map<Long, Cliente> clientes = new HashMap<>();

    public void adicionar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        cliente.setAtivo(false);
    }

    @Override
    public Cliente buscarPorId(long id) {
        return clientes.get(id);
    }

    @Override
    public List<Cliente> listarClientesAtivos() {
        List<Cliente> clientesAtivos = new ArrayList<>();
        for (Cliente cliente : clientes.values()) {
            if (cliente.isAtivo()) {
                clientesAtivos.add(cliente);
            }
        }
        return clientesAtivos;
    }

    @Override
    public List<Cliente> listarClientesInativos() {
        List<Cliente> clientesInativos = new ArrayList<>();
        for (Cliente cliente : clientes.values()) {
            if (!cliente.isAtivo()) {
                clientesInativos.add(cliente);
            }
        }
        return clientesInativos;
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return new ArrayList<>(clientes.values());
    }

    public Cliente buscarPorDocumento(String documento) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }
}
