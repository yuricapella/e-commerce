package dominio.usuario.fabrica;

import dominio.usuario.UsuarioCliente;

public class FabricaUsuario {
    public UsuarioCliente criarUsuarioCliente(String login, String senha) {
        return new UsuarioCliente(login, senha);
    }
}