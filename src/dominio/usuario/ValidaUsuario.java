package dominio.usuario;

public class ValidaUsuario implements ValidadorUsuario{
    @Override
    public boolean validarUsuarioAtivo(Usuario usuario) {
        return usuario != null && usuario.isAtivo();
    }

    public boolean validarLogin(String login) {
        return login != null && !login.trim().isEmpty();
    }

    public boolean validarSenha(String senha) {
        return senha != null && senha.trim().length() >= 4;
    }
}
