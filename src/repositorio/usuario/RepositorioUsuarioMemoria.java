package repositorio.usuario;

import dominio.usuario.Usuario;
import repositorio.usuario.interfaces.compostas.RepositorioUsuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioUsuarioMemoria implements RepositorioUsuario {
    private final Map<Long, Usuario> usuarios = new HashMap<>();

    @Override
    public void adicionar(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        usuario.setAtivo(false);
    }

    @Override
    public Usuario buscarPorId(long id) {
        return usuarios.get(id);
    }

    @Override
    public List<Usuario> listarUsuariosAtivos() {
        List<Usuario> usuariosAtivos = new ArrayList<>();
        for (Usuario usuario : usuarios.values()) {
            if (usuario.isAtivo()) {
                usuariosAtivos.add(usuario);
            }
        }
        return usuariosAtivos;
    }

    @Override
    public List<Usuario> listarUsuariosInativos() {
        List<Usuario> usuariosInativos = new ArrayList<>();
        for (Usuario usuario : usuarios.values()) {
            if (!usuario.isAtivo()) {
                usuariosInativos.add(usuario);
            }
        }
        return usuariosInativos;
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    public Usuario buscarPorLogin(String login) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }
}
