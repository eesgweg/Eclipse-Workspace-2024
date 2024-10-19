package API;


import org.json.JSONObject;
import org.json.XML;

public class XMLJSONConversions {

	public static void main(String[] args) {
	
		        String xmlData = "<employee><name>Sara</name><age>28</age><position>QA Engineer</position></employee>";
		        
		       JSONObject json = XML.toJSONObject(xmlData);
		       System.out.println(json.getJSONObject("employee").getJSONObject("name"));
		       System.out.println(json.toString(4));
		        
		        
		        String jsonData = "{ \"employee\": { \"name\": \"Sara\", \"age\": 28, \"position\": \"QA Engineer\" } }";
		        
		        JSONObject jsonobject = new JSONObject(jsonData);
		       String Xml = XML.toString(jsonobject);
		       System.out.println(Xml);
		        
		    }
		


	}


