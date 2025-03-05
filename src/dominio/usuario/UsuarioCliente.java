package dominio.usuario;

public class UsuarioCliente extends Usuario {
    public UsuarioCliente(String login, String senha) {
        super(login, senha, TipoUsuario.USUARIO);
    }
}
