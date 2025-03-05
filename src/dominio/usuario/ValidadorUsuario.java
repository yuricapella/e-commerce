package dominio.usuario;

public interface ValidadorUsuario {
    boolean validarUsuarioAtivo(Usuario usuario);
    boolean validarLogin(String login);
    boolean validarSenha(String senha);
}
