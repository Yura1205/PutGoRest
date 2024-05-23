package com.unac.restinteractions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import static org.junit.Assert.assertEquals;

public class RestInteractions {

    private static String baseUrl;

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.baseUrl = baseUrl;
    }

    public static void executionPutToken(String endPoint, String idUser, String token, String name, String email){

        String jsonBody = String.format("{\"name\":\"%s\", \"email\":\"%s\"}", name, email);
        String fullUrl = baseUrl.concat(endPoint).concat(idUser);

        SerenityRest.given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .put(fullUrl);

        SerenityRest.lastResponse().prettyPeek();
    }

    public static void validateCode(Integer statusCode) {
        Integer statusActual = SerenityRest.lastResponse().statusCode();
        assertEquals(statusActual,statusCode);
    }

    public static void validateDataResponse(String expectedValue, String path) {
        String actualValue = SerenityRest.lastResponse()
                .jsonPath().getString(path);
        assertEquals(expectedValue, actualValue);
    }

}
