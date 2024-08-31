package Files;

import java.util.Random;

import io.restassured.path.json.JsonPath;

public class Libraries {
	public static JsonPath RawToJSON(String Response) {
		JsonPath js = new JsonPath(Response);
		return js;		
	}
	
	public static String NewAddress() {
		String Newadress = RandomGenerator()+"/100 WEST STREET, USA";
		
		return Newadress;
		
	}
	
	public static int RandomGenerator() {
		 Random rand = new Random();
		 int int_random = rand.nextInt(25);
		return int_random; 
		 
	}
}
