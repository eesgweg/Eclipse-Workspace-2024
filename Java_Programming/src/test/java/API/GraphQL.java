package API;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GraphQL {
	HashMap<String, Integer> TDM = new HashMap<String, Integer>();
	PostmanCollections postmanCollections = new PostmanCollections();
	Response response;
	@Test(priority = 1)
	public void MutationGraphQL() {
		TDM.put("EPISODEID", RandomNumber(3000));
		TDM.put("CHARACTERID", 888);
		String GraphQLMutationBody=null;
		try {;
			GraphQLMutationBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\swats\\Mani Eclipse New Workspace\\Java_Programming\\src\\main\\java\\GraphQLMutationPayload.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject request = new JSONObject(GraphQLMutationBody);
		request.getJSONObject("variables").put("episodeid", TDM.get("EPISODEID"));
		request.getJSONObject("variables").put("charaterid", TDM.get("CHARACTERID"));
		System.out.println(request.toString());
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		 response =given().header("Content-Type","application/json")
		.body(request.toString())
		.when().post("/gq/graphql")
		.then().statusCode(200).extract().response();
		System.err.println(response.prettyPrint());
		JsonPath js = response.jsonPath();
		 TDM.put("EPISODEID",Integer.parseInt(js.getString("data.createEpisode.id")));
		assertEquals(1+"", js.getString("data.associateEpisodeCharacter.status"));
		postmanCollections.FileWrite("GraphQLMutationResponse",response);
	}
	
	@Test(priority = 2)
	public void QueryGraphQL() {
		
		String GraphQLQueryBody=null;
		try {
		GraphQLQueryBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\swats\\Mani Eclipse New Workspace\\Java_Programming\\src\\main\\java\\GraphQLQueryPayload.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject request = new JSONObject(GraphQLQueryBody);
		request.getJSONObject("variables").put("episodeid", TDM.get("EPISODEID"));
		request.getJSONObject("variables").put("charaterid", TDM.get("CHARACTERID"));
		System.out.println(request.toString());
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		 response =given().header("Content-Type","application/json")
		.body(request.toString())
		.when().post("/gq/graphql")
		.then().statusCode(200).extract().response();
		System.err.println(response.prettyPrint());
		JsonPath js = response.jsonPath();
		assertEquals(TDM.get("EPISODEID")+"",js.getString("data.episode.id"));
		assertEquals(TDM.get("CHARACTERID")+"",js.getString("data.character.id"));
		postmanCollections.FileWrite("GraphQLQueryResponse",response);
	}
	
	public int RandomNumber(int Num) {
		Random random = new Random();
		int randomIntRange = random.nextInt(Num);
		return randomIntRange;
	}

}
