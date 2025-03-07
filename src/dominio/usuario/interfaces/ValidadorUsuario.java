package dominio.usuario.interfaces;

import dominio.usuario.Usuario;

public interface ValidadorUsuario {
    boolean validarUsuarioAtivo(Usuario usuario);
    boolean validarLogin(String login);
    boolean validarSenha(String senha);
}
