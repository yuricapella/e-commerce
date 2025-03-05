package dominio.usuario;

public class AlteraUsuario implements AlteradorUsuario{
    private final ValidadorUsuario validador;

    public AlteraUsuario(ValidadorUsuario validador) {
        this.validador = validador;
    }

    @Override
    public void alterarLogin(Usuario usuario, String novoLogin) {
        if (validador.validarUsuarioAtivo(usuario) && validador.validarLogin(novoLogin)) {
            usuario.setLogin(novoLogin);
        } else {
            throw new IllegalArgumentException("Usuário inativo ou login inválido.");
        }
    }

    @Override
    public void alterarSenha(Usuario usuario, String novaSenha) {
        if (validador.validarUsuarioAtivo(usuario) && validador.validarSenha(novaSenha)) {
            usuario.setSenha(novaSenha);
        } else {
            throw new IllegalArgumentException("Usuário inativo ou senha inválida.");
        }
    }
}
