package Resources;

import java.util.ArrayList;
import java.util.List;

import POJOClasses.AddPlacePOJO;
import POJOClasses.Location;

public class TestDataBuild {
	
	public AddPlacePOJO AddPlacePayload(String name, String language, String address) {
		AddPlacePOJO Apl = new AddPlacePOJO();
		Apl.setAccuracy(50);
		Apl.setAddress(address);
		Apl.setLanguage(language);
		Apl.setName(name);
		Apl.setPhone_number("(+91) 983 893 3937");
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		Apl.setTypes(types);
		Location L = new Location();
		L.setLat(-38.383494);
		L.setLng(33.427362);
		Apl.setLocation(L);
		Apl.setWebsite("http://google.com");
		return Apl;
	}
	
	public String DeletePlacePayload(String placeid) {
		return "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
	}

}
