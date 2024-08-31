package Scenarios;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import Files.Libraries;
import Files.payload;

public class JiraAPI {
	public static String ID;
	
	//NOT WORKING MANUALLY ALSO
	@Test
	//Create a Jira API to create a Bug
	public static void createBug() {
		RestAssured.baseURI="https://rainamani444.atlassian.net/";
		
		String Response = given()
		.header("Content-Type","application/json")
		.header("Authorization","Basic cmFpbmFtYW5pLjQ0NEBnbWFpbC5jb206QVRBVFQzeEZmR0YwQVg3Mkh6Q3Q4SmtYbWs1ZFEtU1ZUNldMUXpuMEc2QWtxYlNtVi1RVV8yb2JHeDJFLWQxS01tTUJTTEk2Z3dVZ19NcVF0ZlNjQzBTdTRqQVhFeTYzUGlPT19vX3IzaUtNYVl4ZjM0bWY2ZVo3dVRCYjBIU3RLb19mRjRQa1ctMjdkNDNtOWpKdzk3QUhpN1M2bEljX1ZqQlpiWEtDeVRZNTVNVnJWTVpPTHBRPUJBNzEwOUU2")
		.body(payload.JiraBugCreatePL())
		.when().post("/rest/api/3/issue").then()
		.assertThat().statusCode(201).log().all()
		.extract().response().asString();
		
		ID = Libraries.RawToJSON(Response).getString("ID");
		
	}
	
	
	//multiPart - To attach Files to request
	@Test
	public static void AddAttachmentToBug() {
		
		given()
		.pathParam("key", ID)
		.header("Content-Type","application/json")
		.header("Authorization","Basic cmFpbmFtYW5pLjQ0NEBnbWFpbC5jb206QVRBVFQzeEZmR0YwQVg3Mkh6Q3Q4SmtYbWs1ZFEtU1ZUNldMUXpuMEc2QWtxYlNtVi1RVV8yb2JHeDJFLWQxS01tTUJTTEk2Z3dVZ19NcVF0ZlNjQzBTdTRqQVhFeTYzUGlPT19vX3IzaUtNYVl4ZjM0bWY2ZVo3dVRCYjBIU3RLb19mRjRQa1ctMjdkNDNtOWpKdzk3QUhpN1M2bEljX1ZqQlpiWEtDeVRZNTVNVnJWTVpPTHBRPUJBNzEwOUU2")
		.multiPart("file", new File("C:\\Users\\swats\\OneDrive\\Desktop\\Sample.xml"))
		.when().post("/rest/api/3/issue/{key}/attachments")
		.then().log().all()
		.assertThat().statusCode(200);
	}

}
