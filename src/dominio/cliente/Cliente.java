package dominio.cliente;

public abstract class Cliente {
    private String nome;
    private String documento;
    private String email;
    private TipoCliente tipo;
    private long id;
    private static long contador = 1;
    private boolean ativo;

    public Cliente(String nome, String documento, String email, TipoCliente tipo) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.tipo = tipo;
        this.ativo = true;
        this.id = contador++;
    }

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

    public TipoCliente getTipo() {
        return tipo;
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
        return String.format("Cliente [ID: %d, Nome: %s, Documento: %s, Email: %s, Ativo: %b]",
                id, nome, documento, email, ativo);
    }

}
