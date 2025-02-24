package dominio.Cliente;

public class Cliente {
    private String nome;
    private String documento;
    private String email;
    private long id;
    private static long contador = 1;

    public Cliente(String nome, String documento, String email) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
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

    @Override
    public String toString() {
        return String.format("Cliente [ID: %d, Nome: %s, Documento: %s, Email: %s]",
                id, nome, documento, email);
    }

}
