package repositorio.produto.interfaces.compostas;

import repositorio.produto.interfaces.especificas.ProdutoConsulta;
import repositorio.produto.interfaces.especificas.ProdutoManipulacao;
import repositorio.produto.interfaces.especificas.ProdutoAlteracao;

public interface ProdutoAtivo extends ProdutoConsulta, ProdutoManipulacao, ProdutoAlteracao {

}
