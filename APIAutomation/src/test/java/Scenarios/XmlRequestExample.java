package Scenarios;
import java.beans.XMLDecoder;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XmlRequestExample {
	@Test
    public void Run() throws IOException {
//        // Set the base URI for the API
        RestAssured.baseURI = "https://run.mocky.io/";
//
      
        // Send a POST request with XML body
        Response response = RestAssured
                                .given()
                                .header("Content-Type", "application/xml")
                                .get("v3/05ab6f47-bbb9-47c0-8f2d-a67623cdcd84");
        
        // Print the response
        System.err.println("Response: " + response.prettyPrint());
        XmlPath xmlPath = response.xmlPath();

        // Example: Extracting values from the XML response
        String name = xmlPath.getString("user.name");
        String email = xmlPath.getString("uese.email");
        System.out.println(name+" : "+email);
        
        FileWriter Fr = new FileWriter("C:\\Users\\swats\\Mani Eclipse New Workspace\\APIAutomation\\target\\Response.xml");
        Fr.write(response.prettyPrint());
        Fr.close();
        
//        JSONObject jsonresponse = XML.toJSONObject(response.toString());
//        System.out.println(jsonresponse);
       
        
        
    }
}
