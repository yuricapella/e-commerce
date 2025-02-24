package dominio.Cliente;

public abstract class Cliente {
    protected String nome;
    protected String documento;
    protected String email;
    protected long id;
    protected boolean ativo = true;
    protected TipoCliente tipo;

    protected static long contador = 1;

    public Cliente(String nome, String documento, String email, TipoCliente tipo) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.tipo = tipo;
        this.id = contador++;
    }

    public abstract boolean validarDocumento();

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Cliente [ID: %d, Nome: %s, Documento: %s, Email: %s]",
                id, nome, documento, email);
    }

}
