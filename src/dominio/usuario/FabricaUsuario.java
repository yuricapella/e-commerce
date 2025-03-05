package dominio.usuario;

public class FabricaUsuario {
    public UsuarioCliente criarUsuarioCliente(String login, String senha) {
        return new UsuarioCliente(login, senha);
    }
}