package com.projetorestassured;

import com.projetorestassured.utils.request.RequestLoginUtils;
import com.projetorestassured.utils.request.RequestUsuarioUtils;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Login {
    private String token;

    @BeforeEach
    void setup() {
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

}
