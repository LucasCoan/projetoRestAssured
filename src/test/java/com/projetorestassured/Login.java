package com.projetorestassured;

import com.projetorestassured.utils.request.RequestLoginUtils;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Login {
//    private String token;
//
//    @BeforeEach
//    void setup() {
//        baseURI = "https://serverest.dev";
//
//        this.token = given()
//                .contentType(ContentType.JSON)
//                .body(RequestLoginUtils.criarUsuarioLogin())
//            .when()
//                .post("/login")
//            .then()
//                .log().all()
//                    .extract()
//                    .path("authorization");
//
//        System.out.println(token);
//    }

    @DisplayName("Efetuando o Login")
    @Test
    void testEfetuandoLogin(){
        given()
                .contentType(ContentType.JSON)
                .body(RequestLoginUtils.criarUsuarioLogin())
                .when()
                .post("/login")
                .then()
                .log().all()
                        .assertThat()
                                .statusCode(200)
                                        .body("message", equalTo("Login realizado com sucesso"));


        //System.out.println(token);
    }

}
