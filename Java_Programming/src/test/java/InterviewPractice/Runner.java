package InterviewPractice;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasSize;

public class Runner {

	public static void main(String[] args) {
		
//		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//		System.out.println(response.prettyPrint());
//		Assert.assertEquals(response.statusCode(), 200);
//		System.out.println(response.headers());
//		Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
//		System.out.println(response.cookies());
//		JsonPath js = response.jsonPath();
//		System.out.println(js.getString("page"));
//		List<Map<String, String>> data = js.getList("data");
//		for(Map<String, String> a : data) {	
//		System.out.println(a);
//		System.out.println(a.containsKey("email"));	
		
		
		ValidatableResponse a =given()
		.header("Etag","W/\"406-ut0vzoCuidvyMf8arZpMpJ6ZRDw\"") //caching
		.header("Access-Control-Allow-Origin","methods") //CROS
		.when().get("https://reqres.in/api/users?page=2")
		.then().assertThat().statusCode(200)
		.header("Etag",notNullValue())
		.header("Access-Control-Allow-Origin",equalTo("*"))
		.header("Age", greaterThan("0"))
		.header("Report-To", containsString("\"max_age\":3600"))  // Validate the max_age value is 3600
        .header("Report-To", containsString("https://nel.heroku.com/reports?"))  // Ensure the URL is correct
		.body("data",hasSize(6))
		.body("data.id", hasItems(7, 8, 9, 10, 11, 12))  // Verify IDs present in the "data" array
        .body("data[0].first_name", equalTo("Michael"))  // Validate first_name of first user
        .body("support.text", containsString("contributions towards server costs"))  // Validate support text contains expected message
        .log().all();  // Log the full response
		
		}
		
		
//		Roles Roles = new Roles("QA", Arrays.asList("read", "write", "execute"));
//		Roles Roles1 = new Roles("SDET", Arrays.asList("read", "write"));		
//		ContactInfo ContactInfo= new ContactInfo("abc@gmaul.com", "123-456-7890");		
//		UserDetails UserDetails = new UserDetails(1, "Mani", ContactInfo, Arrays.asList(Roles,Roles1), true);		
//		System.out.println(UserDetails.getUserId());		
//		RequestSpecification req = new RequestSpecBuilder().setBaseUri("URL").addHeader("","").addQueryParam("", "").addPathParam("PATH", "")
//				.addCookie("","").setContentType(ContentType.JSON).build();
//		ResponseSpecification response =
//				new ResponseSpecBuilder().expectHeader("", "").expectStatusCode(200).expectContentType(ContentType.JSON).build();		
//		
//		UserDetails res =given()
//		.spec(req)
//		.body(UserDetails)
//		.when().post("Resource/"+"{PATH}")
//		.then().spec(response).extract().as(UserDetails.class);
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
	}


