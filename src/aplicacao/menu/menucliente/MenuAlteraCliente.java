package aplicacao.menu.menucliente;

import dominio.cliente.Cliente;
import dominio.cliente.servico.ServicoCliente;
import dominio.cliente.interfaces.ValidadorCliente;
import dominio.usuario.Usuario;

import java.util.Scanner;

public class MenuAlteraCliente {
    private final Scanner scanner;
    private final ServicoCliente servicoCliente;
    private final ValidadorCliente validadorCliente;
    private final Usuario usuarioLogado;

    public MenuAlteraCliente(Scanner scanner, ServicoCliente servicoCliente, ValidadorCliente validadorCliente, Usuario usuarioLogado) {
        this.scanner = scanner;
        this.servicoCliente = servicoCliente;
        this.validadorCliente = validadorCliente;
        this.usuarioLogado = usuarioLogado;
    }

    public void exibirMenu() {
        Cliente cliente = usuarioLogado.getCliente();
        if (cliente == null) {
            System.out.println("Erro: Usuário não possui um cliente associado.");
            return;
        }

        boolean opcaoValida = false;

        while (!opcaoValida) {
            try {
                System.out.println("\n==== Alterar Dados ====");
                System.out.println("1. Alterar nome");
                System.out.println("2. Alterar documento");
                System.out.println("3. Alterar email");
                System.out.println("4. Voltar");
                System.out.print("Escolha uma opção: ");

                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine().trim();
                        if (!validadorCliente.validarNome(novoNome)) {
                            System.out.println("Erro: Nome inválido. Deve conter pelo menos 2 caracteres.");
                            break;
                        }
                        servicoCliente.atualizarNomeCliente(cliente, novoNome);
                        System.out.println("Nome alterado com sucesso.");
                        break;
                    case 2:
                        System.out.print("Novo documento: ");
                        String novoDocumento = scanner.nextLine().trim();
                        if (!validadorCliente.validarDocumento(novoDocumento)) {
                            System.out.println("Erro: Documento inválido.");
                            break;
                        }
                        servicoCliente.atualizarDocumentoCliente(cliente, novoDocumento);
                        System.out.println("Documento alterado com sucesso.");
                        break;
                    case 3:
                        System.out.print("Novo email: ");
                        String novoEmail = scanner.nextLine().trim();
                        if (!validadorCliente.validarEmail(novoEmail)) {
                            System.out.println("Erro: Email inválido.");
                            break;
                        }
                        servicoCliente.atualizarEmailCliente(cliente, novoEmail);
                        System.out.println("Email alterado com sucesso.");
                        break;
                    case 4:
                        opcaoValida = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
            }
        }
    }
}
