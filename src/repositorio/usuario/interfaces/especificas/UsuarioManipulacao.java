package repositorio.usuario.interfaces.especificas;

import dominio.usuario.Usuario;

public interface UsuarioManipulacao {
    void adicionar(Usuario usuario);
    void remover(Usuario usuario);
}
