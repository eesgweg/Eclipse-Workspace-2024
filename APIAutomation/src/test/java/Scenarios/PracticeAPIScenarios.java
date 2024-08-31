package Scenarios;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Files.Libraries;

public class PracticeAPIScenarios {

	@Test
	public static void GetProductList() throws IOException {
		RestAssured.baseURI="https://automationexercise.com/";
		String  Response= given()
		.when().get("api/productsList")
		.then().log().all()
		.assertThat().statusCode(200).extract().response().asString();		
		String ID = Libraries.RawToJSON(Response).getString("products[0]")+"";
		System.err.println(ID);
		String FilePath = "C:\\Users\\swats\\OneDrive\\Desktop\\Study\\Response.json";
		
		FileWriter FileWriter = new FileWriter(FilePath);
		FileWriter.write(Response);
		FileWriter.close();
		System.out.println("FileWriter is done");
		
	}
	
	@Test
	public static String GetReqresData() {
		RestAssured.baseURI="https://reqres.in";
		Response Response = given()
		.when().get("api/login")
		.then().assertThat().statusCode(200)
		.extract().response();		

		Response.prettyPrint();
		return Response.toString();
	}
	
	
	
}
