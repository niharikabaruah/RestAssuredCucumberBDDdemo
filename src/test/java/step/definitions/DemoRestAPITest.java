package step.definitions;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Assert;

import java.net.URI;


public class DemoRestAPITest {

    private Scenario scenario;
    private Response response;
    private Response response2;
    private final String BASE_URL = "http://localhost:3000";

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
    }

    @Given("Get Call to {string}")
    public void get_call_to_url(String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given();
        response = req.when().get(new URI(url));
    }

    @Then("Response Code {string} is validated")
    public void response_is_validated(String responseMessage) {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseMessage, responseCode+"");
    }

    @Then("Response  is array total {string}")
    public void responseIsArrayWith(String arg0) {
        response.then().statusCode(200);
        response = response.then().extract().response();
        scenario.log("Response Received == " + response.asPrettyString());
        JSONArray resJson = new JSONArray(response.asString());
        Assert.assertEquals(resJson.length()+"",arg0);


    }

    @Given("Get Call to {string} with id")
    public void get_call_to_url_with_id (String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given();
        response2 = req.when().get(new URI(url));
    }
    @Then("Response Code {string} is validated for the id")
    public void response_is_validated_for_the_id(String responseMessage) {
        int responseCode = response2.then().extract().statusCode();
        Assert.assertEquals(responseMessage, responseCode+"");
    }


}

