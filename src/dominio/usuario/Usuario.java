package dominio.usuario;

public abstract class Usuario {
    private String login;
    private String senha;
    private TipoUsuario tipo;
    private boolean ativo;
    private long id;
    private static long contador = 1;

    public Usuario(String login, String senha, TipoUsuario tipo) {
        this.id = contador++;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.ativo = true;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
