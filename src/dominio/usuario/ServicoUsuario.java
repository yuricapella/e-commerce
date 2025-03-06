package dominio.usuario;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

public class ServicoUsuario {
    private final RepositorioUsuario repositorioUsuario;
    private final AlteradorUsuario alteradorUsuario;
    private final ValidadorUsuario validadorUsuario;
    private final FabricaUsuario fabricaUsuario;

    public ServicoUsuario(RepositorioUsuario repositorioUsuario,
                          AlteradorUsuario alteradorUsuario,
                          ValidadorUsuario validadorUsuario,
                          FabricaUsuario fabricaUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.alteradorUsuario = alteradorUsuario;
        this.validadorUsuario = validadorUsuario;
        this.fabricaUsuario = fabricaUsuario;
    }

    public void adicionarUsuario(Usuario usuario) {
        if (repositorioUsuario.buscarPorLogin(usuario.getLogin()) != null) {
            return;
        }
        validarCredenciais(usuario.getLogin(), usuario.getSenha());
        repositorioUsuario.adicionar(usuario);
    }

    public void atualizarLoginUsuario(Usuario usuario, String novoLogin) {
        if (!validadorUsuario.validarLogin(novoLogin)) {
            throw new IllegalArgumentException("Novo login inválido.");
        }
        alteradorUsuario.alterarLogin(usuario, novoLogin);
    }

    public void atualizarSenhaUsuario(Usuario usuario, String novaSenha) {
        if (!validadorUsuario.validarSenha(novaSenha)) {
            throw new IllegalArgumentException("Nova senha inválida.");
        }
        alteradorUsuario.alterarSenha(usuario, novaSenha);
    }

    public Usuario cadastrarUsuario(String login, String senha) {
        validarCredenciais(login, senha);
        return fabricaUsuario.criarUsuarioCliente(login, senha);
    }

    private void validarCredenciais(String login, String senha) {
        if (!validadorUsuario.validarLogin(login) || !validadorUsuario.validarSenha(senha)) {
            throw new IllegalArgumentException("Login ou senha inválidos.");
        }
    }
}
