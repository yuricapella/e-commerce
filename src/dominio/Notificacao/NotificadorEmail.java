package dominio.Notificacao;

import dominio.Cliente.Cliente;

public class NotificadorEmail implements Notificador {
    @Override
    public void notificar(Cliente cliente) {
        String email = cliente.getEmail();
        System.out.printf("Notificação enviada para o email: %s\n", email);
    }
}
