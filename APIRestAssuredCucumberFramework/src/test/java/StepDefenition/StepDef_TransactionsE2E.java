package StepDefenition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import POJOClasses.CreateAccountPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef_TransactionsE2E extends Utilities{
	RequestSpecification Request;
	Response Response;
 static String APIToken,AccountID;
	String AccessTokenForProcessing;
	static TestDataBuild TestData;
	static String LoginUserID, LoginPassword, ResponseMessage, CurrentAPI;
	WebDriver driver;
	 JavascriptExecutor js;
	 
	 @When("User calls {string} request")
		public void user_calls_request(String Resource) {
		 APIResources APIResources = Resources.APIResources.valueOf(Resource);
		 if(Resource.equals("GenerateNewAPIKey")) {
			 System.out.println(Request);
				Response = Request.when().get(APIResources.getResource()).then().log().all().extract().response();
				  System.out.println("Response lopp done");
				  System.out.println(Response);
			}else if(Resource.equals("CreateAccountAPI")) {
				 System.out.println(Request);
					Response = Request.when().post(APIResources.getResource()).then().log().all().extract().response();
					  System.out.println("Response lopp done");
					  System.out.println(Response);
				}
	 }
	
	@Given("Base URL")
	public void base_url() throws IOException {
		
	   Request = given().spec(requestSpecification());
	   System.out.println("Request lopp done");
	 
	}
	
	@Then("Validate Status code {int}")
	public void validate_status_code(Integer StatusCode) {
		System.out.println(Response);
		System.out.println(StatusCode);
		assertEquals(Response.getStatusCode(), StatusCode);
	}
	@Then("save APIKey")
	public void save_api_key() {
		
		APIToken = GetJSONPath(Response, "apiKey");
		System.err.println("APIToken: "+APIToken);
		
	}
	
	@Given("Account Details Payload")
	public void account_details_payload() throws IOException {
		CreateAccountPojo CreateAccountPojo = new CreateAccountPojo();
		CreateAccountPojo.setOwner("James Bond - FromAccount");
		CreateAccountPojo.setBalance(100);
		CreateAccountPojo.setCurrency("COSMIC_COINS");
	   Request = given().spec(requestSpecification(APIToken)).header("Content-Type","application/json").body(CreateAccountPojo);
	   System.out.println(Request);
	}
	@Then("save AccountID")
	public void save_account_id() {
		AccountID = GetJSONPath(Response, "account.id");
		System.err.println("AccountID: "+AccountID);
	}

	
}
