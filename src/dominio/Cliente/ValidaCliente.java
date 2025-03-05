package dominio.Cliente;

public class ValidaCliente implements ValidadorCliente{

    public void validarClienteAtivo(Cliente cliente) {
        if (!cliente.isAtivo()) {
            throw new IllegalStateException("Cliente inativo. Alteração não permitida.");
        }
    }

    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.length() == 11 && cpf.matches("\\d+");
    }

    public static boolean validarCNPJ(String cnpj) {
        return cnpj != null && cnpj.length() == 14 && cnpj.matches("\\d+");
    }

}
