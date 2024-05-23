package com.unac.apis;

import com.unac.restinteractions.RestInteractions;

public class GoRestApi {

    private static final String TOKEN = "d569a6e9ab3e7bbd3f295306d33da688cc629eaf56e52d94900b39f8cdbbd4e7";
    private static String pathName = "name";
    private static String pathEmail = "email";

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.setBaseUrl(baseUrl);
    }

    public static void executionPutToken(String endPoint, String idUser, String name, String email){
        RestInteractions.executionPutToken(endPoint, idUser, TOKEN, name, email);
    }

    public static void validateResponse(Integer statusCode, String name, String email) {
        RestInteractions.validateCode(statusCode);
        RestInteractions.validateDataResponse(name, "name");
        RestInteractions.validateDataResponse(email, "email");

    }
}
