package dominio.cliente.servico;

import dominio.cliente.Cliente;
import dominio.cliente.interfaces.ValidadorCliente;

public class ValidaCliente implements ValidadorCliente {

    @Override
    public boolean validarClienteAtivo(Cliente cliente) {
        return cliente != null && cliente.isAtivo();
    }

    @Override
    public boolean validarNome(String nome) {
        return nome != null && nome.trim().length() >= 2;
    }

    @Override
    public boolean validarDocumento(String documento) {
        if (documento == null) {
            return false;
        }
        if (documento.length() == 11) {
            return documento.matches("\\d{11}");
        } else if (documento.length() == 14) {
            return documento.matches("\\d{14}");
        }
        return false;
    }

    @Override
    public boolean validarEmail(String email) {
        if (email == null) {
            return false;
        }
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
}
