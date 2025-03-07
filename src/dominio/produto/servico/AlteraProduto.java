package dominio.produto.servico;

import dominio.produto.Produto;
import dominio.produto.interfaces.AlteradorProduto;
import dominio.produto.interfaces.ValidadorProduto;

public class AlteraProduto implements AlteradorProduto {
    ValidadorProduto validador;

    public AlteraProduto(ValidadorProduto validador) {
        this.validador = validador;
    }

    @Override
    public void alterarNome(Produto produto, String novoNome) {
        if(validador.validarProdutoAtivo(produto)){
            produto.setNome(novoNome);
        }
    }
}
