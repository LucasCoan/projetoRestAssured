package com.projetorestassured.utils.request;

import com.projetorestassured.pojo.LoginPojo;

public class RequestLoginUtils {

    public static LoginPojo criarUsuarioLogin() {
        LoginPojo login = new LoginPojo();
        login.setEmail("fulano@qa.com");
        login.setPassword("teste");

        return login;

    }
}
