package stepDef;
import common.Base;
import common.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;

public class ApiSteps extends Base {

    @Given("Get Request is working")
    public void validate_service_is_working() {
        RestAssured.baseURI = BASE_URL;
        request = given();
        request.header(Constants.CONTENT_TYPE, "application/json");
        getResponse();
        int getStatusCode = response.statusCode();
        Assert.assertEquals(getStatusCode, 200);
    }

    @Then("Response should return success with True")
    public void response_with_success_true() {
        response.then()
                .assertThat().statusCode(HttpStatus.SC_OK);
        getBodyAsString();
        Assert.assertTrue(responseBody.contains("success"));
        JsonPath jsonPathEvaluator = response.jsonPath();
        Boolean successVal = jsonPathEvaluator.get("success");
        Assert.assertTrue(successVal.equals(true));
    }

    @Then("Failure with empty response")
    public void response_with_Failure_as_empty() {
        Assert.assertTrue(responseBody.contains("failures"));
        JsonPath jsonPathEvaluator = response.jsonPath();
        ArrayList<String> failuresVal = jsonPathEvaluator.get("failures");
        Assert.assertTrue(failuresVal.isEmpty());
    }

    @When("Flight number is {int}")
    public void flightNumber(int flight_number) {
        getBodyAsString();
        Assert.assertTrue(responseBody.contains("flight_number"));
        JsonPath jsonPathEvaluator = response.jsonPath();
        int flightNum = jsonPathEvaluator.get("flight_number");
        Assert.assertTrue(flightNum == flight_number);
    }

    @When("the Flight name with respect to flight num is {string}")
    public void flight_name(String flightNameVal) {
        Assert.assertTrue(responseBody.contains("name"));
        JsonPath jsonPathEvaluator = response.jsonPath();
        String flightName = jsonPathEvaluator.get("name");
        Assert.assertTrue(flightName.equals(flightNameVal));
    }
}