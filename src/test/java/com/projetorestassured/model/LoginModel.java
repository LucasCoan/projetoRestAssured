package com.projetorestassured.model;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class LoginModel {

    private Response response;
    String Url = "https://serverest.dev/login";

    @DisplayName("Efetuando o Login")
    public void testEfetuandoLogin() {

        String filePath = "src/test/resources/payloads/login.json";

        try {
            Path path = Paths.get(filePath);
            byte[] fileBytes = Files.readAllBytes(path);
            String payload = new String(fileBytes);

            response = given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post(Url)
                    .then()
                    .log().all()
                    .extract()
                    .response();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getStatusCode(){
        return response.getStatusCode();
    }

    public String validarCampoAuthorizationNaoNulo(){
        if (response.jsonPath().get("authorization").equals("")){
            throw new IllegalArgumentException("Campo 'authorization' não pode ser vazio!");
        } else {
            System.out.println("Campo 'authorization' preenchido!");
        }
        return null;
    }
}



