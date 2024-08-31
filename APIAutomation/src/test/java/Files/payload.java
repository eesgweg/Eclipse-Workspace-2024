package Files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import Scenarios.ExcelTest;

public class payload {

	public static String addplace() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Mani house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
		
		
	}
	public static String CoursePrice() {
		return "{\r\n"
				+ "  \"dashboard\":{\r\n"
				+ "    \"purchaseAmount\": 1350,\r\n"
				+ "    \"website\":\"https://rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"Courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"Title\": \"Java\",\r\n"
				+ "      \"Price\": 50,\r\n"
				+ "      \"Copies\": 7\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"Title\": \"DSA\",\r\n"
				+ "      \"Price\": 60,\r\n"
				+ "      \"Copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"Title\": \"NodeJS\",\r\n"
				+ "      \"Price\": 80,\r\n"
				+ "      \"Copies\": 8\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String AddbookPL(String isbn, String aisle) {
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Angular\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\"710"+aisle+"\",\r\n"
				+ "\"author\":\"Stokes\"\r\n"
				+ "}";
	}
	
	@Test
	public static HashMap<String, Object> AddBookHashMapPayload() throws IOException {
		ExcelTest ExcelTest = new ExcelTest();
		ArrayList<String> a = ExcelTest.getdatafromexcel("LibraryData","JASON");
		System.out.println(a);
		
		
		HashMap<String, Object> jsonmap = new HashMap<String, Object>();
		jsonmap.put("name",a.get(4));
		jsonmap.put("isbn",a.get(5));
		jsonmap.put("aisle",a.get(6));
		jsonmap.put("author",a.get(7));
		return jsonmap;
	}
	
	public static String DeletebookPL(String ID) {
		return "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+ID+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
	}
	
	
	public static String JiraBugCreatePL() {
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"MJ\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Dropdown not Working\",\r\n"
				+ "       \"description\": \"Tetsing if able to create POST JIRA API\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }";
	}

}
