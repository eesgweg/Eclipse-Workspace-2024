package SpecBuilders;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Libraries;
import Files.payload;
//import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuildersTest {

	@Test
	public static void UpdateAddressandverify() {
		RequestSpecification Req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").addHeader("Content-Type", "application/json")
				.setContentType(ContentType.JSON).build();

		RequestSpecification Request = given().spec(Req);

		ResponseSpecification Response = new ResponseSpecBuilder().expectStatusCode(200)
				.expectHeader("Content-Type", "application/json;charset=UTF-8").expectContentType(ContentType.JSON)
				.build();

		String ResponseBody = Request.body(payload.addplace()).when().post("maps/api/place/add/json").then().log().all().spec(Response).extract().response().asString();

		String Place_id = Libraries.RawToJSON(ResponseBody).getString("place_id");
		System.err.println(Place_id);

		// Update Place
		String NewAddress = Libraries.NewAddress();
		System.out.println("----------------Update Place-----------------");
		Request.body("{\r\n" + "\"place_id\":\"" + Place_id + "\",\r\n" + "\"address\":\"" + NewAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().spec(Response)
				.body("msg", equalTo("Address successfully updated"));

		System.out.println("----------------Verify Place updated-----------------");
		String GetUpdatedResponse = Request.queryParam("place_id", Place_id)
				.when().get("maps/api/place/get/json").then().log().all().spec(Response).extract()
				.response().asString();
		System.out.println(GetUpdatedResponse);
		String GetUpdatedResponseAddress = Libraries.RawToJSON(GetUpdatedResponse).getString("address");
		System.out.println(GetUpdatedResponseAddress);
		Assert.assertEquals(NewAddress, GetUpdatedResponseAddress, "Address Updated Successfully");
//		System.out.println("----------------Done-----------------");

	}
}
