package com.projetorestassured.utils.request;

import com.projetorestassured.pojo.UsuarioPojo;

public class RequestUsuarioUtils {
    public static UsuarioPojo AdicionarUsuario() {
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome("Lucas Coan Mazzuco");
        usuario.setEmail("lukas1@gmail.com");
        usuario.setPassword("123456");
        usuario.setAdministrador("true");

        return usuario;
    }

    public static UsuarioPojo AdicionarUsuarioIsolado() {
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome("Lucas Coan Mazzuco");
        usuario.setEmail("coan2@gmail.com");
        usuario.setPassword("123456");
        usuario.setAdministrador("true");

        return usuario;
    }

    public static UsuarioPojo AlterarUsuario() {
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome("Lucas Coan Mazzuco");
        usuario.setEmail("mazzuco1@gmail.com");
        usuario.setPassword("654321");
        usuario.setAdministrador("true");

        return usuario;
    }
}
