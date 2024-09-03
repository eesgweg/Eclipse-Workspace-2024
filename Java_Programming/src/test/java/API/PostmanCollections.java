package API;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static io.restassured.RestAssured.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;
import java.util.random.RandomGenerator;

public class PostmanCollections {

	HashMap<String, String> TDM= new HashMap<String, String>();
	Response response;

	@Test(groups = "CollectionAPI",priority = 1)
	public void GetAuthenticatedUser() {
		RestAssured.baseURI = "https://api.getpostman.com";

		response = given().header("X-API-Key", "PMAK-66d3d47f1e5c5900010c7343-2de06fdb7de816c3270e681139b77660a3")
				.queryParam("foo", "bar").when().get("/me").then().statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8")
				.body("user.email", equalTo("rainamani.444@gmail.com")).body("user.fullName", equalTo("Mani"))
				.body("user.id", equalTo(36603046)).body("user.isPublic", equalTo(true)).extract().response();

		System.err.println(response.prettyPrint());

		String Userid = response.jsonPath().getString("user.id");
		System.out.println(Userid);
		TDM.put("USERID", Userid);
	}

	@Test(dependsOnMethods = "GetAuthenticatedUser")
	public void CreateCollection() {
		RestAssured.baseURI = "https://api.getpostman.com";
		String jsonbody = null;String Name=generateRandomString(5);
		try {
			jsonbody = new String(Files.readAllBytes(Paths.get(
					"C:\\Users\\swats\\Mani Eclipse New Workspace\\Java_Programming\\src\\main\\java\\PostmanCollectionsPayload.json")));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject requestbody = new JSONObject(jsonbody);

		JSONObject InfoObject = requestbody.getJSONObject("collection").getJSONObject("info");
		InfoObject.put("name", Name);
		InfoObject.put("schema", Name+"900");
		System.out.println(requestbody);

		response = given().header("X-API-Key", "PMAK-66d3d47f1e5c5900010c7343-2de06fdb7de816c3270e681139b77660a3")
				.header("Content-Type", "application/json").body(requestbody.toString()).when().post("/collections").then()
				.statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8")
				.extract().response();
		System.err.println(response.prettyPrint());
		TDM.put("C_ID", response.jsonPath().getString("collection.id"));
		TDM.put("C_NAME", response.jsonPath().getString("collection.name"));
		TDM.put("C_UID", response.jsonPath().getString("collection.uid"));

		System.err.println(TDM);
		FileWrite("CreateCollectionsResponse",response);
		GetCollection();
	}
	
	//@Test(dependsOnMethods = {"CreateCollection","UpdateCollection"})
	public void GetCollection() {
		
		RestAssured.baseURI = "https://api.getpostman.com";

		response = given().header("X-API-Key", "PMAK-66d3d47f1e5c5900010c7343-2de06fdb7de816c3270e681139b77660a3")
				.pathParam("collectionid", TDM.get("C_ID")).when()
				.get("/collections/{collectionid}").then().statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8")
				.extract().response();
		JsonPath js = response.jsonPath();
		
		assertEquals(js.getString("collection.info._postman_id"), TDM.get("C_ID"), "PostMan ID Validation Successfull!!");
		assertEquals(js.getString("collection.info.name"), TDM.get("C_NAME"),"Name Validation Successfull!!");
		String UID = js.getString("collection.info.uid");
		assertTrue(UID.contains(TDM.get("C_ID")));
		assertEquals(js.getString("collection.info.lastUpdatedBy"), TDM.get("USERID"),"USERID Validation Successfull!!");
		//assertEquals(js.getString("collection.info.uid"),TDM.get("USERID")+"-"+TDM.get("C_ID"));
		FileWrite("GetCollectionResponse",response);
		
	}
	
	@Test(dependsOnMethods = "UpdateCollection")
	public void DeleteCollection() {
		
		RestAssured.baseURI = "https://api.getpostman.com";
		response = given().header("X-API-Key", "PMAK-66d3d47f1e5c5900010c7343-2de06fdb7de816c3270e681139b77660a3")
				.pathParam("collectionid", TDM.get("C_ID")).when()
				.delete("/collections/{collectionid}").then().statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8")
				.extract().response();
		
		JsonPath js = response.jsonPath();		
		assertEquals(js.getString("collection.id"), TDM.get("C_ID"), "Collection ID Validation Successfull!!");
		assertEquals(js.getString("collection.uid"), TDM.get("USERID")+"-"+TDM.get("C_ID"),"UID Validation Successfull!!");
		
		FileWrite("DeleteCollectionsResponseFile",response);
		
	}
	
	@Test(dependsOnMethods = "CreateCollection")
	public void UpdateCollection(){
		
		String jsonbody = null;
		String NewName =generateRandomString(5);
		try {
			jsonbody = new String(Files.readAllBytes(Paths.get(
					"C:\\Users\\swats\\Mani Eclipse New Workspace\\Java_Programming\\src\\main\\java\\PostmanCollectionsPayload.json")));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject requestbody = new JSONObject(jsonbody);

		JSONObject InfoObject = requestbody.getJSONObject("collection").getJSONObject("info");
		InfoObject.put("name", NewName);
		InfoObject.put("schema", NewName+"900");
		System.out.println(requestbody);
		
		
		RestAssured.baseURI = "https://api.getpostman.com";
		response = given().header("X-API-Key", "PMAK-66d3d47f1e5c5900010c7343-2de06fdb7de816c3270e681139b77660a3")
				.pathParam("collectionid", TDM.get("C_ID")).when()
				.body(requestbody.toString())
				.put("/collections/{collectionid}").then().log().all().statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8")
				.extract().response();
		JsonPath js = response.jsonPath();	
		TDM.put("C_NAME", NewName);
		//TDM.put("C_UID", js.getString("collection.id").trim());
		
		assertEquals(js.getString("collection.id"), TDM.get("C_ID"), "Collection ID Validation Successfull!!");
		assertEquals(js.getString("collection.name"), TDM.get("C_NAME"),"Name Validation Successfull!!");
		String UID = js.getString("collection.uid");
		assertTrue(UID.contains(TDM.get("C_ID")));

		FileWrite("UpdatedCollectionResponse",response);
		GetCollection();
	}
	
	public void FileWrite(String FileName,Response response) {
		
		try {
			FileWriter Fw = new FileWriter("C:\\Users\\swats\\Mani Eclipse New Workspace\\Java_Programming\\src\\main\\java\\"+FileName+".json");
			Fw.write(response.prettyPrint().toString());
			Fw.close();
			System.out.println(FileName+".json "+"Response File saved----");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public static String generateRandomString(int length) {
	        // Define the characters to choose from
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	        StringBuilder result = new StringBuilder();
	        Random random = new Random();

	        // Generate random string
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            result.append(characters.charAt(index));
	        }

	        return result.toString();
	    }
	 
	 @Test(enabled = false)
	 public void Runner() {
		 GetAuthenticatedUser();
		 CreateCollection();
		 GetCollection();
		 UpdateCollection();
		 GetCollection();
		 DeleteCollection();
	 }
}
