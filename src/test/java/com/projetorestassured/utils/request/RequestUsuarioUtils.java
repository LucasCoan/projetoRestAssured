package com.projetorestassured.utils.request;

import com.projetorestassured.pojo.UsuarioPojo;

public class RequestUsuarioUtils {
    public static UsuarioPojo AdicionarUsuario() {
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome("Lucas Coan Mazzuco");
        usuario.setEmail("lucas3@gmail.com");
        usuario.setPassword("123456");
        usuario.setAdministrador("true");

        return usuario;
    }

    public static UsuarioPojo AdicionarUsuarioIsolado() {
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome("Lucas Coan Mazzuco");
        usuario.setEmail("coan3@gmail.com");
        usuario.setPassword("123456");
        usuario.setAdministrador("true");

        return usuario;
    }

    public static UsuarioPojo AlterarUsuario() {
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome("Lucas Coan Mazzuco");
        usuario.setEmail("mazzuco3@gmail.com");
        usuario.setPassword("654321");
        usuario.setAdministrador("true");

        return usuario;
    }
}
