package com.projetorestassured.gherkin;

import com.projetorestassured.model.LoginModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MySteps {


    private final LoginModel login = new LoginModel();

    @Given("que o usuario efetua o login enviando o {string}")
    public void queOUsuarioEfetuaOLoginEnviandoO(String payload) {
        login.testEfetuandoLogin();
    }


    @Then("deve receber um status code {int}")
    public void deveReceberUmStatusCode(Integer statusCode) {
        Assert.assertEquals(statusCode, login.getStatusCode());

    }

    @And("o campo authorization authorization nao pode ser nulo")
    public void oCampoAuthorizationAuthorizationNaoPodeSerNulo() {
        login.validarCampoAuthorizationNaoNulo();
    }
}
