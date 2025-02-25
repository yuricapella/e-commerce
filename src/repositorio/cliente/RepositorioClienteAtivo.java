package repositorio.cliente;

import dominio.Cliente.Cliente;
import repositorio.cliente.interfaces.compostas.ClienteAtivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioClienteAtivo implements ClienteAtivo {
    private final Map<Long, Cliente> clientes = new HashMap<>();

    @Override
    public void alterarEmail(Cliente cliente, String novoEmail) {
        if (cliente != null) {
            cliente.setEmail(novoEmail);
            clientes.put(cliente.getId(), cliente);
        }
    }

    @Override
    public Cliente buscarPorId(long id) {
        return clientes.get(id);
    }

    public void adicionar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        clientes.remove(cliente.getId());
    }

    @Override
    public List<Cliente> listarClientes() {
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
