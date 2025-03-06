package dominio.usuario;

import dominio.cliente.Cliente;

public abstract class Usuario {
    private String login;
    private String senha;
    private TipoUsuario tipo;
    private boolean ativo;
    private long id;
    private static long contador = 1;
    private Cliente cliente;

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

    public Cliente getCliente() {
        return cliente;
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public String toString() {
        return String.format("Usuário [ID: %d, Login: %s, Tipo: %s, Ativo: %b]", getId(), getLogin(), getTipo(), isAtivo());
    }
}
