package common;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class Base {
    public Response response = null;
    public String responseBody;
    public RequestSpecification request;
    public static final String BASE_URL = "https://api.spacexdata.com/v4/launches/latest";


    public void getResponse(){
        this.response = request.when().get(this.BASE_URL);
    }

    public void getBodyAsString(){
        ResponseBody body = response.getBody();
        responseBody = body.asString();
    }

}
