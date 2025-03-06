package repositorio.usuario.interfaces.especificas;

import dominio.Produto.Produto;
import dominio.usuario.Usuario;

import java.util.List;

public interface UsuarioConsulta {
    List<Usuario> listarUsuariosInativos();
    List<Usuario> listarUsuariosAtivos();
    List<Usuario> listarTodosUsuarios();
    Usuario buscarPorLogin(String login);
    Usuario buscarPorLoginESenha(String login, String senha);
    Usuario buscarPorId(long id);
}
