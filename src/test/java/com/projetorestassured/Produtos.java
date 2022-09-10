package com.projetorestassured;

import com.projetorestassured.utils.request.RequestLoginUtils;
import com.projetorestassured.utils.request.RequestProdutoUtils;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Produtos {
    public String token;

    @BeforeEach
    void setup(){
        baseURI = "https://serverest.dev";

        this.token = given()
                .contentType(ContentType.JSON)
                .body(RequestLoginUtils.criarUsuarioLogin())
                .when()
                .post("/login")
                .then()
                .log().all()
                .extract()
                .path("authorization");

        System.out.println(token);
    }

    @DisplayName("Efetuar Cadastro de Um Produto")
    @Test
    void testEfetuarCadastroDeUmNovoProduto(){
        given()
                .contentType(ContentType.JSON)
                .body(RequestProdutoUtils.AdicionarProduto())
                .header("authorization", token)
            .when()
                .post("/produtos")
            .then()
                .log().all()
                    .assertThat()
                        .statusCode(201)
                        .body("message", equalTo("Cadastro realizado com sucesso"));

    }

    @DisplayName("Efetuar Busca por Produto Cadastrado")
    @Test
    void testEfetuarBuscaPorProdutoCadastrado(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("nome", "Playstation 5")
                .queryParam("preco", 5000)
                .queryParam("descricao", "Video Game")
                .queryParam("quantidade", 1)
            .when()
                .get("/produtos")
            .then()
                .log().all()
                    .assertThat()
                        .statusCode(200)
                        .body("produtos[0].nome", equalTo("Playstation 5"))
                        .body("produtos[0].preco", equalTo(5000))
                        .body("produtos[0].descricao", equalTo("Video Game"))
                        .body("produtos[0].quantidade", equalTo(1));

    }
}
