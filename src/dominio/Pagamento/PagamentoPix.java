package dominio.Pagamento;

public class PagamentoPix implements Pagamento {
    @Override
    public boolean realizarPagamento(double valor) {
        if (valor > 0) {
            System.out.println("Pagamento de R$ " + valor + " via PIX realizado com sucesso!");
            return true;
        }
        System.out.println("Pagamento falhou.");
        return false;
    }
}
