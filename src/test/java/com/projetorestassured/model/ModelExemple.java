package com.projetorestassured.model;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ModelExemple {

    String Url = "https://serverest.dev/login";

    @DisplayName("Efetuando o Login")
    public void testEfetuandoLogin() {

        String filePath = "src/test/resources/payloads/login.json";

        try {
            Path path = Paths.get(filePath);
            byte[] fileBytes = Files.readAllBytes(path);
            String payload = new String(fileBytes);

            given()
                    .contentType(ContentType.JSON)
                .body(payload)
                    .when()
                .post(Url)
                    .then()
                .log().all()
                    .assertThat()
                        .statusCode(200)
                            .body("message", equalTo("Login realizado com sucesso"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
