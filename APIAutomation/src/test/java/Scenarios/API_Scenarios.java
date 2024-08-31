package Scenarios;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.PrettyPrinter;

import Files.Libraries;
import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class API_Scenarios {
	
	public static void UpdateAddressandverify() {
		System.out.println("----------------Add Place-----------------");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(payload.addplace())
				.when().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.body("status", equalTo("OK"))
				.header("Content-Type", "application/json;charset=UTF-8")
				.extract().response().asString();
				
		
		System.err.println(Response);
		
		String Place_id = Libraries.RawToJSON(Response).getString("place_id");
		System.err.println(Place_id);
		
		//Update Place
		String NewAddress =Libraries.NewAddress();
		System.out.println("----------------Update Place-----------------");
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+Place_id+"\",\r\n"
				+ "\"address\":\""+NewAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all()
		.assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		
		System.out.println("----------------Verify Place updated-----------------");
		String GetUpdatedResponse= given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", Place_id)
		.when().get("maps/api/place/get/json")
		.then().log().all()
		.assertThat().statusCode(200)		
		.extract().response().asString();
		System.out.println(GetUpdatedResponse);
		String GetUpdatedResponseAddress = Libraries.RawToJSON(GetUpdatedResponse).getString("address");
		System.out.println(GetUpdatedResponseAddress);
		Assert.assertEquals(NewAddress,GetUpdatedResponseAddress ,"Address Updated Successfully");
//		System.out.println("----------------Done-----------------");
		
	}
	

	@Test(dataProvider="UserData")
	public static void AddUsers(String UserName, String Designation) {

		RestAssured.baseURI="https://reqres.in";
		String Resource = "/api/users";
		String ResponseMessage=given().log().all().headers("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"name\": \""+UserName+"\",\r\n"
				+ "    \"job\": \""+Designation+"\"\r\n"
				+ "}")
		.when().post(Resource)
		.then().log().all()
		.assertThat().statusCode(201)
		.body("name",equalTo(UserName))
		.body("job",equalTo(Designation)).extract().response().asString();
		System.err.println("---------------------------------------------");
		String ID = Libraries.RawToJSON(ResponseMessage).getString("id");
		String CreatedDate = Libraries.RawToJSON(ResponseMessage).getString("createdAt");
		System.err.println(ID);
		System.err.println("---------------------------------------------");
		if(CreatedDate.contains("2024-06-29")) {
			System.out.println("Success");
		}
		
		
		
		
	}
	
	@Test
	public static void AddPlaceusingJSONFile() throws IOException {
		System.out.println("----------------Add Place-----------------");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//Content of JSOn File to String --> String to Byte  --> Byte to String
		String RequestBodyFromJsonFile = new String(Files.readAllBytes(Paths.get("C:\\Users\\swats\\OneDrive\\Desktop\\Study\\AddPlaceJSON.json")));
		Response Response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(RequestBodyFromJsonFile)
				.when().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.body("status", equalTo("OK"))
				.header("Content-Type", "application/json;charset=UTF-8")
				.extract().response();
		
		String a =Response.prettyPrint();
		String FilePath = "C:\\Users\\swats\\OneDrive\\Desktop\\Study\\Response.json";
		
		FileWriter FileWriter = new FileWriter(FilePath);
		FileWriter.write(a);
		FileWriter.close();
		System.out.println("FileWriter is done");
		
		//System.err.println(Response);
	}
	
	
	@DataProvider(name="UserData")
	public static Object[][] getUserData() {
		return new Object[][] {{"Sonia","Pilot"},{"Ravi","Locopoilot"},{"Sham","Unemployed"}};
		
	}
	
	
}
