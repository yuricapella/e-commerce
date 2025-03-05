package dominio.Produto;

import dominio.Produto.interfaces.AlteradorProduto;
import dominio.Produto.interfaces.ValidadorProduto;

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
