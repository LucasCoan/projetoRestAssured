package com.projetorestassured.utils.request;

import com.projetorestassured.pojo.ProdutosPojo;

public class RequestProdutoUtils {
    public static ProdutosPojo AdicionarProduto(){
        ProdutosPojo produto = new ProdutosPojo();
        produto.setNome("Playstation 5");
        produto.setPreco(5000);
        produto.setDescricao("Video Game");
        produto.setQuantidade(1);

        return produto;
    }
}
