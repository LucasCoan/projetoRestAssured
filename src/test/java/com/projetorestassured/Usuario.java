package com.projetorestassured;

import com.projetorestassured.utils.request.RequestUsuarioUtils;
import groovy.json.JsonOutput;
import io.restassured.http.ContentType;
import org.junit.Ignore;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Usuario {
    public String Id;

    @BeforeEach
    void setup() {
        baseURI = "https://serverest.dev";

    }

    @DisplayName("Realizando o Cadastro De Um Novo Usuário e Extraindo o ID")
    @Test
    @Order(1)
    void testCadastrarUmNovoUsuarios() {
        this.Id = given()
                .contentType(ContentType.JSON)
                .body(RequestUsuarioUtils.AdicionarUsuario())
            .when()
                .post("/usuarios")
                .then()
                .log().all()
                .extract()
                .path("_id");

        System.out.println(Id);

    }

    @DisplayName("Realizando o Cadastro De Um Novo Usuário de Forma Isolada")
    @Test
    @Order(2)
    void testCadastrarUmNovoUsuario() {
     given()
                .contentType(ContentType.JSON)
                .body(RequestUsuarioUtils.AdicionarUsuarioIsolado())
            .when()
                .post("/usuarios")
            .then()
                .log().all()
                .assertThat()
                    .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"));

    }

    @DisplayName("Realizando Buscas Especificas Através do ID de Usuários Cadastrados")
    @Test
    @Order(3)
    void testBuscarUmUsuarioEspecificoCadastrado() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("_Id", Id)
            .when()
                .get("/usuarios")
            .then()
                .log().all()
                    .assertThat()
                        .statusCode(200)
                        .body("usuarios[0].nome", equalTo("Lucas Coan Mazzuco"))
                        .body("usuarios[0].email", equalTo("lucascoan@qa.com"))
                        .body("usuarios[0].password", equalTo("lucasteste"))
                        .body("usuarios[0].administrador", equalTo("true"))
                        .body("_id", equalTo(Id));


    }

    @DisplayName("Relizando Buscas Via Parametro Path")
    @Test
    @Order(4)
    void testBuscarUmUsuarioViaPath() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("_id", Id)
                .when()
                .get("/usuarios/{_id}")
            .then()
                .log().all()
                    .assertThat()
                        .statusCode(200)
                        .body("nome", equalTo("Lucas Coan Mazzuco"))
                        .body("email", equalTo("lucascoan@qa.com"))
                        .body("password", equalTo("lucasteste"))
                        .body("administrador", equalTo("true"))
                        .body("_id", equalTo("BVRBQvLH2XLKd9R3"));

        System.out.println(Id);

    }

    @DisplayName("Efetuando Alteração Em Usuários Já Cadastrados")
    @Test
    @Order(5)
    void testEfetuandoAlteracoesEmUsuario(){
        given()
                .contentType(ContentType.JSON)
                .pathParam("_id", Id)
                .body(RequestUsuarioUtils.AlterarUsuario())
                .when()
                .put("/usuarios/{_id}")
            .then()
                .log().all()
                    .assertThat()
                      .statusCode(200)
                        .body("message", equalTo("Registro alterado com sucesso"));

    }

    @DisplayName("Efetuando a Deleção de um Usuário")
    @Test
    void testEfetuarADelecaoDeUmUsuario(){
        given()
                .contentType(ContentType.JSON)
                .pathParam("_id", Id)
                .then()
                .when()
                .delete()
            .then()
                .log().all()
                    .assertThat()
                        .statusCode(200)
                        .body("message", equalTo("Registro excluído com sucesso"));

    }
}
