package dominio.usuario;

public abstract class Usuario {
    private String login;
    private String senha;
    private TipoUsuario tipo;
    private boolean ativo;

    public Usuario(String login, String senha, TipoUsuario tipo) {
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
