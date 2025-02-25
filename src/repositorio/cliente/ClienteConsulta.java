package repositorio.cliente;

import dominio.Cliente.Cliente;

import java.util.List;

public interface ClienteConsulta {
    List<Cliente> listarClientes();
    Cliente buscarPorEmail(String email);
    Cliente buscarPorNome(String nome);
    Cliente buscarPorDocumento(String documento);
    Cliente buscarPorId(long id);
}
