package StepDefenition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Utilities;

import org.junit.runners.JUnit4;

import POJOClasses.AddPlacePOJO;
import POJOClasses.Location;
import Resources.APIResources;
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
import junit.framework.Assert;
import io.restassured.*;

public class StepDef1 extends Resources.Utilities {
	RequestSpecification AddPlaceRequest, GetPlaceRequest,DeleteAPIRequest;
	RequestSpecification Request;
//	ResponseSpecification Res;
	io.restassured.response.Response Response;
	static String PlaceID;
	JsonPath js;
	static TestDataBuild TestData;

	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

	 TestData = new TestDataBuild();
		Request = given().spec(requestSpecification());
		AddPlaceRequest = Request.body(TestData.AddPlacePayload(name, language, address));

	}

	@When("User calls {string} with {string} http Request")
	public void user_calls_with_http_request(String Resource, String HTTPRequestType) {
		// APIResorces APIResorces = new APIResorces();

		APIResources ResourceAPI = APIResources.valueOf(Resource);
		System.out.println(APIResources.valueOf(Resource));
		System.err.println(ResourceAPI.getResource());
		if (HTTPRequestType.equalsIgnoreCase("POST")) {
			System.out.println("POST LOOP");
			Response = AddPlaceRequest.when().post(ResourceAPI.getResource()).then().extract().response();
		} else if (HTTPRequestType.equalsIgnoreCase("GET")) {
			System.out.println("GET LOOP");
			Response = GetPlaceRequest.when().get(ResourceAPI.getResource()).then().extract()
					.response();
			System.out.println("GET LOOP COMPLETED");
		} else if (HTTPRequestType.equalsIgnoreCase("DELETE")) {
			System.out.println("DELETE POST LOOP STARTED");
			Response = DeleteAPIRequest.when().delete(ResourceAPI.getResource()).then().extract().response();
			System.out.println("DELETE POST LOOP COMPLETED");
		} else if (HTTPRequestType.equalsIgnoreCase("UPDATE")) {
			Response = AddPlaceRequest.when().post(ResourceAPI.getResource()).then().extract().response();
		}
	}

	@Then("the API call is successful with status code is {int}")
	public void the_api_call_is_successful_with_status_code_is(Integer StatusCode) {
		System.out.println(Response.getStatusCode());
		assertEquals(Response.getStatusCode(), StatusCode);

	}

	@Then("{string} in response body should be {string}")
	public void in_response_body_should_be(String key, String value) {

		System.out.println("in_response_body_should_be");
		assertEquals(GetJSONPath(Response, key), value);
		System.out.println(key + ":" + value);
	}

	@SuppressWarnings("deprecation")
	@Then("Verify if Place_ID is added successfuly for {string} using {string}")
	public void verify_if_placea_id_is_added_successfuly_for_using(String ActualName, String Resource)
			throws IOException {
		PlaceID = GetJSONPath(Response, "place_id");
		System.err.println(PlaceID);
		GetPlaceRequest = given().spec(requestSpecification()).queryParam("place_id", PlaceID);
		user_calls_with_http_request(Resource, "GET");

		String ExpectedName = GetJSONPath(Response, "name");
		assertEquals(ExpectedName, ActualName);
//	Assert.assertEquals(ExpectedName, ActualName);
		System.err.println(PlaceID);

	}
	
	@Given("Delete API Payload")
	public void delete_api_payload() throws IOException {
		System.err.println(PlaceID);
		DeleteAPIRequest = given().spec(requestSpecification()).body(TestData.DeletePlacePayload(PlaceID));
	}


}
