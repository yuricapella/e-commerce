package dominio.usuario;

public interface AlteradorUsuario {
    void alterarLogin(Usuario usuario, String novoLogin);
    void alterarSenha(Usuario usuario, String novaSenha);
}
