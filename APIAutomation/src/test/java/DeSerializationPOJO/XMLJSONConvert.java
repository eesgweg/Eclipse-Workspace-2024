package DeSerializationPOJO;

import javax.xml.crypto.dsig.XMLObject;

import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLJSONConvert {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		String json = "{\"name\":\"John\",\"age\":30}";
		JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject);
	    
System.out.println(xml);



	}
	
	
	

    
}
