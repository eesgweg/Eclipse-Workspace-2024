package API;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

public class XMLJSONConversions {

	public static void main(String[] args) throws IOException {
	
//		        String xmlData = "<employee><name>Sara</name><age>28</age><position>QA Engineer</position></employee>";
//		        
//		       JSONObject json = XML.toJSONObject(xmlData);
//		       System.out.println(json.getJSONObject("employee").getJSONObject("name"));
//		       System.out.println(json.toString(4));
		        String path = "C:\\Users\\swats\\Downloads\\client_secret_1037641691457-a5deasbjt0hboevsp8dn120sk0lbsrcv.apps.googleusercontent.com.json";
		        String jsonData = new String(Files.readAllBytes(Paths.get(path)));
//		        String jsonData = "{ \"employee\": { \"name\": \"Sara\", \"age\": 28, \"position\": \"QA Engineer\" } }";
		        
		        JSONObject jsonobject = new JSONObject(jsonData);
//		       String Xml = XML.toString(jsonobject);
//		       System.out.println(Xml);
		        String token_uri = jsonobject.getJSONObject("installed").getString("token_uri");
		        System.out.println(token_uri); 
		        jsonobject.put("token_uri", "MANI");
		        
//		        HashMap<String, String> a = new HashMap<String, String>();
		        try (FileWriter file = new FileWriter("C:\\\\Users\\\\swats\\\\Downloads\\\\client_secret_1037641691457-a5deasbjt0hboevsp8dn120sk0lbsrcv.apps.googleusercontent.com.json")) {
	                file.write(jsonobject.toString(4)); // Indented JSON output
	                System.out.println("Successfully updated the JSON file!");
	            }
		        String jsonDataupdated = new String(Files.readAllBytes(Paths.get(path)));
		        JSONObject jsonobjectupdated = new JSONObject(jsonDataupdated);
		        System.out.println(jsonobjectupdated.getJSONObject("installed").getString("token_uri"));
		        
		    }
		


	}


