package dominio.Cliente;

public abstract class Cliente {
    protected String nome;
    protected String documento;
    protected String email;
    protected long id;
    protected static long contador = 1;
    protected boolean ativo;
    protected TipoCliente tipo;

    public Cliente(String nome, String documento, String email, TipoCliente tipo) {
        this.id = contador++;
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.ativo = true;
        this.tipo = tipo;
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

    public long getId() {
        return id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Cliente [ID: %d, Nome: %s, Documento: %s, Email: %s]",
                id, nome, documento, email);
    }

}
