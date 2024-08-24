package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class jpsStepdefinitions {
    String endpoint;
    Response response;
    JsonPath responseJP;

    @Given("Kullanici {string} base Url'ine gider")
    public void kullanici_base_url_ine_gider(String jPHBaseUrl) {
        endpoint = ConfigReader.getProperty("jPHBaseUrl"); //https://jsonplaceholder.typicode.com"
    }

    @Then("Path parametreleri icin {string} kullanir")
    public void path_parametreleri_icin_kullanir(String pathparams) {
        endpoint = endpoint + "/" + pathparams;
    }

    @Then("jPH server'a GET request gonderir ve testleri yapmak icin response degerini kaydeder")
    public void j_ph_server_a_get_request_gonderir_ve_testleri_yapmak_icin_response_degerini_kaydeder() {
        response = given().when().get(endpoint);
        response.prettyPrint();
    }

    @Then("jPH response'da status degerinin {int}")
    public void j_ph_response_da_status_degerinin(Integer statusCode) {
        Assert.assertEquals(statusCode, (Integer) response.statusCode());
    }

    @Then("jPH response'da content Type degerinin {string}")
    public void j_ph_response_da_content_type_degerinin(String contentType) {
        Assert.assertEquals(contentType, response.contentType());
    }

    @Then("jPH GET response body'sinde {string} degerinin Integer {int}")
    public void j_ph_get_response_body_sinde_degerinin_integer(String attribute, Integer expectedValue) {
        responseJP = response.jsonPath();
        Assert.assertEquals(expectedValue, (Integer) responseJP.getInt(attribute));
    }

    @Then("jPH GET response body'sinde {string} degerinin String {string}")
    public void j_ph_get_response_body_sinde_degerinin_string(String attribute, String expectedValue) {
        responseJP = response.jsonPath();
        Assert.assertEquals(expectedValue, responseJP.getString(attribute));

    }


}
