package com.projetorestassured.utils.requestUtils;

public enum EndpointEnum {

    ENDPOINT_LOGIN(UrlEnum.URL_LOGIN.url.concat("/login"));

    private final String pathUrl;

    EndpointEnum(String pathUrl){
        this.pathUrl = pathUrl;
    }

    public String getPathUrl() {
        return this.pathUrl;
    }

    enum UrlEnum {

        URL_LOGIN(ConstantesUtils.ENV_URL.concat(""));


        private final String url;

        UrlEnum(String url) {
            this.url = url;
        }

        static class ConstantesUtils {

            public static final String ENV_URL = "https://serverest.dev";

            private ConstantesUtils(){

            }
        }
    }
}
