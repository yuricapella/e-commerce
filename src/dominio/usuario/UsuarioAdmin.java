package dominio.usuario;

public class UsuarioAdmin extends Usuario {
    public UsuarioAdmin(String login, String senha) {
        super(login, senha, TipoUsuario.ADMINISTRADOR);
    }
}
