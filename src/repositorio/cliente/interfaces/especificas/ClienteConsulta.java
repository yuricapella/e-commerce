package repositorio.cliente.interfaces.especificas;

import dominio.Cliente.Cliente;

import java.util.List;

public interface ClienteConsulta {
    List<Cliente> listarClientesAtivos();
    List<Cliente> listarClientesInativos();
    List<Cliente> listarTodosClientes();
    Cliente buscarPorDocumento(String documento);
    Cliente buscarPorId(long id);
}
