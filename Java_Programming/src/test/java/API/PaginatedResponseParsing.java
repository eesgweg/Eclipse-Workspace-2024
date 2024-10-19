package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
public class PaginatedResponseParsing implements RESTHTTPRequest{
	static Response response,response1;
	static PaginatedResponseParsing Request = new PaginatedResponseParsing();
	static JsonPath js;
	
	PaginatedResponseParsing(){
		RestAssured.baseURI="https://reqres.in";
		
	}
	
	@Test
	public static void GetUsers() {
		// TODO Auto-generated method stub
		
		
		response = Request.GetRequest("api/users");
		js = response.jsonPath();
		List<Map<String,String>> a = new ArrayList<Map<String,String>>();
		a= js.get("data");
		
		for(int i=0;i< a.size();i++) {			
			Map<String,String> map =a.get(i);
			assertTrue(map.containsKey("id"));
			System.out.println(map);
		}

	}
	
	@Test
	public static void Createuser() {
		
		
		response = Request.PutRequest("api/users", "{\r\n"
				+ "    \"name\": \"BBB\",\r\n"
				+ "    \"job\": \"BBBleader\"\r\n"
				+ "}");
		//Assert.assertEquals(response.then().assertThat().statusCode(201),201);
		
	}
	
	

	@Override
	public Response GetRequest(String Resource) {
		return given().when().get(Resource).then().statusCode(200).extract().response();		
	}

	@Override
	public Response PostRequest(String Resource, String Requestbody) {
		// TODO Auto-generated method stub
		return given().body(Requestbody).when().post(Resource).then().extract().response();
	}

	
	@Override
	public Response DeleteRequest(String Resource) {
		// TODO Auto-generated method stub
		return given().when().delete(Resource).then().extract().response();
	}

	@Override
	public Response PutRequest(String Resource, String Requestbody) {
		// TODO Auto-generated method stub
		return given().body(Requestbody).when().put(Resource).then().extract().response();
	}

	@Override
	public Response PatchRequest(String Resource, String Requestbody) {
		// TODO Auto-generated method stub
		return given().body(Requestbody).when().patch(Resource).then().extract().response();
	}

}
