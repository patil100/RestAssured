package stepdefinitions;

import Utils.testdata;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;
import Utils.testdata.*;


public class stepdefinition {
    private RequestSpecification request;
    private Response response;
    private String endpoint;

    private final String BASE_URL="https://psychx-test.safexpay.com/";

//    private final String BASE_URL="https://reqres.in/api";
//
//  @Given("I perform GET request on {string}")
//    public void i_perform_get_request_on(String endporint){
//      response=given().when().get(BASE_URL+endporint);
//      System.out.println("Response Body:\n" + response.getBody().asPrettyString());
//    }
//    @Then("I should get response code {int}")
//    public void i_should_get_response_code(Integer expectedStatusCode) {
//        assertEquals((int) expectedStatusCode, response.getStatusCode());
//        System.out.println("Response Body:\n" + response.getBody().asPrettyString());
//    }
//
//    @Given("I perform POST request on {string}")
//    public void i_perform_post_request_on(String endpoint) {
//        this.endpoint = endpoint;
//        request = given().header("Content-Type", "application/json");
//    }
//
//    @Given("I send request body")
//    public void i_send_request_body(String docString) {
//        response = request.body(docString).when().post(BASE_URL + endpoint);
//        System.out.println("Response Body:\n" + response.getBody().asPrettyString());
//    }
//
//    @Then("response should contain {string} as {string}")
//    public void response_should_contain_as(String key, String expectedValue) {
//        response.then().assertThat().body(key, equalTo(expectedValue));
//        System.out.println("Response Body:\n" + response.getBody().asPrettyString());
//    }

    @Given("I perform POST request on {string}")
    public void i_perform_post_request_on(String endpoint) {
        this.endpoint = endpoint;
        request = given().header("Content-Type", "application/json");
    }



    @Then("response should contain {string} as {string}")
    public void response_should_contain_as(String key, String expectedValue) {
        response.then().assertThat().body(key, equalTo(expectedValue));
        System.out.println("Response Body:\n" + response.getBody().asPrettyString());
    }
    @Then("I should get response code {int}")
    public void i_should_get_response_code(Integer expectedStatusCode) {
        assertEquals((int) expectedStatusCode, response.getStatusCode());
        System.out.println("Response Body:\n" + response.statusCode());
    }


    @And("I send request payload from payload")
    public void iSendRequestPayloadFromPayload() {
        String payload= testdata.payload();
        response = request.body(payload).when().post(BASE_URL + endpoint);
        System.out.println("payload for request----------------"+payload+ "Response -----------------------"+response);
    }
}
