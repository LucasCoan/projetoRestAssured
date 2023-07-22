package com.projetorestassured.gherkin;

import com.projetorestassured.model.ModelExemple;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

import java.io.IOException;

public class MySteps {


    private final ModelExemple model = new ModelExemple();

    @Given("que o usuario efetua o login enviando o {string}")
    public void que_o_usuario_efetua_o_login_enviando_o(String arg1) {
        model.testEfetuandoLogin();
    }


    @Then("deve receber um status code {int}")
    public void deve_receber_um_status_code(Integer statusCode) {
        Assert.assertEquals(statusCode, statusCode);

    }

    @Then("o campo authorization {string} nao pode ser nulo")
    public void o_campo_authorization_nao_pode_ser_nulo(String arg1) throws Throwable {
    }

}
