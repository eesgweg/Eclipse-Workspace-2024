package Files;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
/*import org.testng.annotations.Test;*/
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJSONParse {
	@Test
	public static void CourseSum() {
		JsonPath Jsc = new JsonPath(payload.CoursePrice());

		// To Store Courses and Prices
		HashMap<String, String> CourseLog = new HashMap<String, String>();

		// To get the size of the Array-Courses
		int count = Jsc.getInt("Courses.size()");

		// print No of Courses returned by API
		System.out.println(count);

		// Print Purchase Amount
		int PurchaseAmount = Jsc.getInt("dashboard.purchaseAmount");
		System.out.println(PurchaseAmount);

		// Print Title of courses
		String Title1stCourse = Jsc.get("Courses[0].Title");
		System.out.println(Title1stCourse);
		String Title2ndCourse = Jsc.get("Courses[1].Title");
		System.out.println(Title2ndCourse);
		String Title3rdCourse = Jsc.get("Courses[2].Title");
		System.out.println(Title3rdCourse);

		int CourseSumPrice = 0;
		// print title and Price of all courses
		for (int i = 0; i < count; i++) {
			System.out.println(
					Jsc.getString("Courses[" + i + "].Title") + " : " + Jsc.getString("Courses[" + i + "].Price"));
			CourseLog.put(Jsc.getString("Courses[" + i + "].Title"), Jsc.getString("Courses[" + i + "].Price"));
			// Print No of copies sold by DSA
//					if(Jsc.getString("Courses[" + i + "].Title").equals("DSA")) {
//						System.out.println("DSA Sold Copies: "+Jsc.getString("Courses[" + i + "].Copies"));
//						break;
//					}
			CourseSumPrice = CourseSumPrice
					+ (Jsc.getInt("Courses[" + i + "].Price") * Jsc.getInt("Courses[" + i + "].Copies"));

		}
		// print Hashmap
		//System.out.println(CourseLog);

		// To verify if sum of all courses prices should matched the Purchased amount
		Assert.assertEquals(PurchaseAmount, CourseSumPrice);
		System.out.println(PurchaseAmount + " == " + CourseSumPrice);

	}
	
	@Test
	public static void UserDataParse() {
		JsonPath Js = new JsonPath(Scenarios.PracticeAPIScenarios.GetReqresData());
		HashMap<String, String> Hm = new HashMap<String, String>();
		
		int ArraySize = Js.getInt("data.size()");
		System.err.println(ArraySize);
		for(int i=0;i<ArraySize-1;i++) {
			Hm.put(Js.getString("data["+i+"].name"),Js.getString("data["+i+"].id"));
		}

		
		String IDresponse = 
				given()
				.queryParam("id",Hm.get("fuchsia rose"))
				.when().get("api/login/")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
				System.err.println(IDresponse);
				
	}
}

