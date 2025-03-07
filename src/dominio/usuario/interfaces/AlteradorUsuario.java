package dominio.usuario.interfaces;

import dominio.usuario.Usuario;

public interface AlteradorUsuario {
    void alterarLogin(Usuario usuario, String novoLogin);
    void alterarSenha(Usuario usuario, String novaSenha);
}
