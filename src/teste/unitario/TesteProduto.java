package teste.unitario;

import dominio.produto.*;

public class TesteProduto {
    public static void main(String[] args) {
        Produto produto = new ProdutoEletronico("Tv 1",1080);
        Produto produto2 = new ProdutoPapelaria("caderno 1",29.99);
        Produto produto3 = new ProdutoLivro("livro 1",75.0);
        Produto produto4 = new ProdutoVestuario("camisa 1",49.50);

        System.out.println(produto);
        System.out.println(produto2);
        System.out.println(produto3);
        System.out.println(produto4);

        //Produto produto5 = new ProdutoVestuario("2",49.50); invalido
        //Produto produto6 = new ProdutoVestuario("camisa 2",0); invalido
        Produto produto7 = new ProdutoVestuario("camisa 2",0.1);

        System.out.println(produto7);

        //Produto produto8 = new ProdutoVestuario("camisa 2",a);
        //System.out.println(produto8);
    }
}
