package StepDefenition;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Utilities;

import POJOClasses.AddPlacePOJO;
import POJOClasses.Location;
import Resources.TestDataBuild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.*;

public class StepDef1 extends Resources.Utilities {
	RequestSpecification AddPlaceRequest;
//	RequestSpecification Request;
//	ResponseSpecification Res;
	io.restassured.response.Response Response;

	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		TestDataBuild TestData = new TestDataBuild();

		AddPlaceRequest = given().spec(requestSpecification()).body(TestData.AddPlacePayload(name,language,address));

	}

	@When("User calls {string} with POST http Request")
	public void user_calls_with_post_http_request(String string) {
		
		Response = AddPlaceRequest.when().post("maps/api/place/add/json").then().spec(responseSpecification()).log().all().extract()
				.response();

	}

	@Then("the API call is successful with status code is {int}")
	public void the_api_call_is_successful_with_status_code_is(Integer int1) {
		assertEquals(Response.getStatusCode(), 200);

	}

	@Then("{string} in response body should be {string}")
	public void in_response_body_should_be(String key, String value) {
		String Resp = Response.asString();
		JsonPath js = new JsonPath(Resp);
		;
		assertEquals(js.get(key), value);
		System.out.println(key + ":" + value);
	}

}
