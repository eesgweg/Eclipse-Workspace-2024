package GraphQL_Automation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GraphQLE2EScript {
	String Response;
	String LocationID, CharacterID, EpisodeID;
	JsonPath js;

	@Test
	public void GraphQL_Query() throws IOException {
		Response = given().log().all().header("Content-Type", "application/json").body(QueryPayload()).when()
				.post("https://rahulshettyacademy.com/gq/graphql").then().extract().response().prettyPrint();

		js = new JsonPath(Response.toString());
		assertEquals(js.get("data.character.id").toString(), CharacterID);
		assertEquals(js.get("data.location.id").toString(), LocationID);
		assertEquals(js.get("data.episode.id").toString(), EpisodeID);
		FileWriter fr = new FileWriter(
				new File("C:\\Users\\swats\\Mani Eclipse New Workspace\\APIAutomation\\target\\Response.json"));
		fr.write(Response.toString());
		fr.close();

	}

	public String QueryPayload() {
		return "{\"query\":\"query($characterId : Int!, $locationId : Int!, $episodeId: Int!){\\n  \\n  character(characterId: $characterId){\\n    name\\n    gender\\n    status\\n    id\\n  }\\n  \\n  location(locationId: $locationId){\\n    id\\n    name\\n    type\\n    dimension\\n  }\\n  episode(episodeId:$episodeId){\\n    id\\n    name\\n    air_date\\n    episode\\n  }\\n}\",\"variables\":{\"characterId\":"+CharacterID+",\"locationId\":"+LocationID+",\"episodeId\":"+EpisodeID+"}}";

	}

	public String Mutationload() {
		return "{\"query\":\"mutation($locationname: String!, $charactername: String!, $episodename: String!, $locationId: Int!){\\n  createLocation(location: {name: $locationname, type: \\\"North\\\", dimension: \\\"10\\\"}){\\n    id\\n    \\n  }\\n  createCharacter(character: {name: $charactername, type: \\\"Hero\\\" , status: \\\"dead\\\", species: \\\"Alien\\\", gender: \\\"NA\\\", image:\\\"png\\\", originId: $locationId, locationId: $locationId}){\\n    id\\n  }\\n\\n  createEpisode(episode: {name:$episodename, air_date: \\\"2018-05-01\\\", episode: \\\"1\\\"}){\\n    id\\n  }\\n}\\n\",\"variables\":{\"locationname\":\"Alaska\",\"charactername\":\"Badguhmm\",\"episodename\":\"Suites\",\"locationId\":11791}}";
	}

	@Test
	public void GraphQL_Mutation() {
		Response = given().log().all().header("Content-Type", "application/json").body(Mutationload()).when()
				.post("https://rahulshettyacademy.com/gq/graphql").then().extract().response().prettyPrint();
		js = new JsonPath(Response.toString());
		LocationID = js.get("data.createLocation.id").toString();
		CharacterID = js.get("data.createCharacter.id").toString();
		EpisodeID = js.get("data.createEpisode.id").toString();

		System.err.println("LocationID: " + LocationID);
		System.err.println("CharacterID: " + CharacterID);
		System.err.println("EpisodeID: " + EpisodeID);

	}
	
	@Test
	public void runner() throws IOException {
		GraphQL_Mutation();
		GraphQL_Query();
	}

}
