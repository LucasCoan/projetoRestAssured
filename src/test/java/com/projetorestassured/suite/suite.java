package com.projetorestassured.suite;

import com.projetorestassured.Login;
import com.projetorestassured.Usuario;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;


@RunWith(JUnitPlatform.class)
@SuiteDisplayName("teste")
@SelectClasses({
        Usuario.class,
        Login.class})

class suite {
}
