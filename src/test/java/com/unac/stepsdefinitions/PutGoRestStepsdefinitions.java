package com.unac.stepsdefinitions;

import com.unac.apis.GoRestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PutGoRestStepsdefinitions {

    @Given("se establece la base url {string}")
    public void seEstableceLaBaseUrl(String baseUrl) {
        GoRestApi.setBaseUrl(baseUrl);
    }

    @When("consulta en endpoint {string} por id {string} y se modifica el nombre {string} y email {string}")
    public void consultaEnEndpointPorIdYSeModificaElNombreYEmail(String endpoint, String id, String name, String email) {
        GoRestApi.executionPutToken(endpoint, id, name, email);
    }

    @Then("se valida que el status code sea {int} y que contenga el nombre {string} y email {string}")
    public void seValidaQueElStatusCodeSeaYQueContengaElNombreYEmail(Integer statusCode, String name, String email) {
        GoRestApi.validateResponse(statusCode, name, email);
    }
}
