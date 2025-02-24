package repositorio.cliente;

import dominio.Cliente.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente implements ClienteConsulta, ClienteManipulacao, ClienteAlteracao {
    private final Map<Long, Cliente> clientes = new HashMap<>();

    @Override
    public void alterarEmail(Cliente cliente, String novoEmail) {
        if (cliente != null) {
            cliente.setEmail(novoEmail);
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

    public Cliente buscarPorEmail(String email) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente buscarPorNome(String nome) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

}
