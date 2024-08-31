package SerializationPOJO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Files.payload;
import io.restassured.RestAssured;

public class AddPlaceAPITest {
	@Test
	public static void AddPlace() {
		System.out.println("----------------Add Place-----------------");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlacePOJO ResponseJSON = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(payload.addplace())
				.when().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.body("status", equalTo("OK"))
				.header("Content-Type", "application/json;charset=UTF-8")
				.extract().response().as(AddPlacePOJO.class);
		System.out.println("--------------------------------");
		System.out.println(ResponseJSON.getLocation().getLat());
		System.out.println(ResponseJSON.getLocation().getLng());
		System.out.println(ResponseJSON.getTypes().get(0));
		System.out.println(ResponseJSON.getTypes().get(1));
		System.out.println(ResponseJSON.getAccuracy());
		System.out.println(ResponseJSON.getAddress());
		System.out.println(ResponseJSON.getLanguage());
		System.out.println(ResponseJSON.getName());
		System.out.println(ResponseJSON.getPhone_number());
		System.out.println(ResponseJSON.getWebsite());
		System.out.println("--------------------------------");
	}

}
