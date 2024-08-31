package Scenarios;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import DeSerializationPOJO.Api;
import DeSerializationPOJO.GetCoursePOJO;
import DeSerializationPOJO.WebAutomation;
import Files.Libraries;

public class OAuthClientCredAndPOJO_Practice {

	@Test
	public static void OAuthGetToken() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String ResponseBody = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
				.formParam("scope", "trust").when().post("oauthapi/oauth2/resourceOwner/token").then().assertThat()
				.statusCode(200)
//		.body("expires_in", equalTo("<3600>"))
				.body("scope", equalTo("create")).body("token_type", equalTo("Bearer")).extract().response().asString();

		String OAuthToken = Libraries.RawToJSON(ResponseBody).getString("access_token");
		System.err.println("----------------------------------------------------");
		System.err.println("OAuthToken is : " + OAuthToken);
		System.err.println("----------------------------------------------------");
		GetCourseDetails(OAuthToken);
	}

	public static void GetCourseDetails(String OAuthToken) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		GetCoursePOJO Responsejson = given().queryParam("access_token", OAuthToken).when()
				.get("oauthapi/getCourseDetails").then().log().all().assertThat().statusCode(401)
				.body("instructor", equalTo("RahulShetty")).body("expertise", equalTo("Automation")).extract()
				.response().as(GetCoursePOJO.class);

		System.err.println("----------------------------------------------------");
		System.err.println(Responsejson.getExpertise());
		System.err.println(Responsejson.getInstructor());
		System.err.println(Responsejson.getLinkedIn());
		System.err.println(Responsejson.getUrl());
		System.err.println(Responsejson.getServices());
		System.err.println("----------------------------------------------------");
		System.err.println(Responsejson.getCourses().getApi().get(0).getCourseTitle());
		System.err.println(Responsejson.getCourses().getApi().get(0).getPrice());
		System.err.println(Responsejson.getCourses().getWebAutomation().get(1).getCourseTitle());
		System.err.println(Responsejson.getCourses().getWebAutomation().get(1).getPrice());
		System.err.println(Responsejson.getCourses().getMobile().get(0).getCourseTitle());
		System.err.println(Responsejson.getCourses().getMobile().get(0).getPrice());
		System.err.println("----------------------------------------------------");
		List<Api> ApiCourses = Responsejson.getCourses().getApi();
		
		for (int i = 0; i < ApiCourses.size(); i++) {
			if (ApiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.err.println("----------------------------------------------------");
				System.out.println(ApiCourses.get(i).getPrice());
				System.err.println("----------------------------------------------------");
			}

		}
		
		String[] Expected_1 = {"Selenium Webdriver Java","Cypress","Protractor"};
		List<WebAutomation> Webautomation = Responsejson.getCourses().getWebAutomation();
		// Converting Array of String to ArrayList of String as arraylist has the benifit of Dynamic memory allocation
		ArrayList<String> Actual = new ArrayList<String>();
		List<String> Expected =  Arrays.asList(Expected_1);
		for(int j=0;j<Webautomation.size();j++) {
			Actual.add(Webautomation.get(j).getCourseTitle());
		}
		System.out.println(Actual);
		System.out.println(Expected);
		assertEquals(Actual, Expected);

	}

}
