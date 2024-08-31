package SerializationPOJO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import Files.payload;
import io.restassured.RestAssured;

public class Serialization {
	
	@Test
	public static void SerializeAddPlaceJSON() {
		AddPlacePOJO Apl = new AddPlacePOJO();
		Apl.setAccuracy(50);
		Apl.setAddress("110, Left layout, cohen 90");
		Apl.setLanguage("Tamil-IN");
		Apl.setName("New Bond");
		Apl.setPhone_number("(+91) 983 893 3937");
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		Apl.setTypes(types);
		Location L = new Location();
		L.setLat(-38.383494);
		L.setLng(33.427362);
		Apl.setLocation(L);
		Apl.setWebsite("http://google.com");
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		 given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(Apl)
				.when().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.body("status", equalTo("OK"));
		 
		
	}
	
	
}
