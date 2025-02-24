package dominio.Cliente;

public class ValidadorDocumento {
    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.length() == 11 && cpf.matches("\\d+");
    }

    public static boolean validarCNPJ(String cnpj) {
        return cnpj != null && cnpj.length() == 14 && cnpj.matches("\\d+");
    }

    public static String formatarCPF(String cpf) {
        if (validarCPF(cpf)) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                    cpf.substring(6, 9) + "-" + cpf.substring(9);
        }
        return "CPF inválido";
    }

    public static String formatarCNPJ(String cnpj) {
        if (validarCNPJ(cnpj)) {
            return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." +
                    cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
        }
        return "CNPJ inválido";
    }
}
