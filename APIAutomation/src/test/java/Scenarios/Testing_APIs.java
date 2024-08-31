package Scenarios;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Get;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;

import POJOPractice.Address;

import static org.hamcrest.Matchers.*;

public class Testing_APIs {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in";
//	Get List using JsonPath	
		
		Response response = given()
		.when().get("api/users?page=2");
		
		JsonPath a = response.jsonPath();
		long time = response.timeIn(TimeUnit.SECONDS);
		int ID = a.get("data[0].id");
		List<Object> list = a.getList("data");
		System.out.println(ID);
		
		//Pojoclass
		//String json = new GsonJsonProvider().toJson(list);
		
		// Extracting Response
	//	User responseUser = new Gson().fromJson(responseBody, User.class);
		for(Object x:list) {
			System.out.println(x);
		}
		System.out.println(time);
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		HashMap<String, String> formParameters = new HashMap<String, String>();
		HashMap<String, String> pathParameters = new HashMap<String, String>();
		Address Address = new Address();
		Address.setCity("Madras");
		Address.setState("TamilNadu");
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.addHeaders(headers)
				.addQueryParams(queryParameters)
				.addFormParams(formParameters)
				.addPathParams(pathParameters)
				.addMultiPart("FileName", new File("path of file"))
				.setContentType(ContentType.JSON)
				.build();
	
		RequestSpecification request = given().spec(req).body(Address);
		POJOPractice.Address Response = request.when().post("api/users?page=2").then().statusCode(200).extract().response().as(Address.class);
		String City = Response.getCity();
		String State = Response.getState();
		Headers Headers = response.getHeaders();
		Map cookies = response.getCookies();
	
//		ValidatableResponse a =given()
//		.when().get("api/users?page=2")
//		.then()
//		.statusCode(200)
//		.body("data",hasItems(7,8,9));
//		System.out.println(a.toString());
		
//		
//		WireMockServer WireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8080));
//		WireMockServer.start();
//		WireMockServer.stubFor(post(urlEqualTo("/api/post"));
		
		
		
	}

}
