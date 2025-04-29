package stepdefinitions;
import Utils.Configfilereader;
import Utils.testdata;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Hook;
import io.cucumber.plugin.event.HookTestStep;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;
import Utils.testdata;
import hooks.Hooks;

public class stepdefinition {
    private RequestSpecification request;
    private Response response;
    private String endpoint;
    String baseUrl = Configfilereader.getproperty("BASE_URL");
    String apikey =Configfilereader.getproperty("API_KEY");


    @Given("I perform GET request on {string}")
    public void i_Perform_get_Request_On(String endpoint) {
           this.endpoint=endpoint;
           request=given().header("Content-Type","application/json")
                   .header("X-API-Key", apikey);

           response=request.when().get(baseURI+ endpoint);
        System.out.println("response------"+response.getBody().asPrettyString());
        Hooks.getTest().log(Status.INFO, "Request URL: " + endpoint);


    }
    @Then("I should get response code {int}")
    public void i_should_get_response_code(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        Hooks.getTest().log(Status.INFO, "Response Status Code: " + response.getStatusCode());
    }

    @Given("I perform POST request on {string}")
    public void i_perform_post_request_on(String endpoint) {
        this.endpoint = endpoint;
        request = given().header("Content-Type", "application/json")
         .header("X-API-Key", apikey);
    }

    @Then("response should contain {string} as {string}")
    public void response_should_contain_as(String key, String expectedValue) {
        response.then().assertThat().body(key, equalTo(expectedValue));
        System.out.println("Response Body:\n" + response.getBody().asPrettyString());
        Hooks.getTest().log(Status.INFO, "Response Body: " + response.getBody().asString());
    }

    @And("I send request payload from pay_body")
    public void i_send_request_payload_from_pay_body() {
        String payload = testdata.pay_body();
        response = request.body(payload).when().post(baseUrl + endpoint);
        System.out.println("Payload for request:\n" + payload);
        System.out.println("Response:\n" + response.getBody().asPrettyString());
    }


}
