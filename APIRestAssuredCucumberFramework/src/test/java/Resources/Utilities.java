package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import groovy.beans.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {
 static RequestSpecification Request;
	ResponseSpecification Res;
	 Properties Prop;
	 FileInputStream fis;

	public RequestSpecification requestSpecification() throws IOException {
		if (Request == null) {
			PrintStream logtofile = new PrintStream(new FileOutputStream("logging.txt"));
			Request = new RequestSpecBuilder().setBaseUri(getGlobalValues("BaseUrl"))
					.addHeader("Content-Type", "application/json")
					.addFilter(RequestLoggingFilter.logRequestTo(logtofile))
					.addFilter(ResponseLoggingFilter.logResponseTo(logtofile)).setContentType(ContentType.JSON).build();
			System.out.println(Request.log().all());
			return Request;
		}

		return Request;
	}
	
	public RequestSpecification requestSpecification(String AccessToken) throws IOException {
		if (Request == null) {
			PrintStream logtofile = new PrintStream(new FileOutputStream("logging.txt"));
			System.out.println("Inside loop: "+AccessToken);
			Request = new RequestSpecBuilder().setBaseUri(getGlobalValues("BaseUrl")).addHeader("Authorization", AccessToken)
					.addFilter(RequestLoggingFilter.logRequestTo(logtofile))
					.addFilter(ResponseLoggingFilter.logResponseTo(logtofile)).setContentType(ContentType.JSON).build();
			System.out.println(Request.log().all());
			return Request;
		}

		return Request;
	}
	
	

	public ResponseSpecification responseSpecification() {
		Res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

		return Res;
	}

	public String getGlobalValues(String key) throws IOException {
		Prop = new Properties();
	 fis = new FileInputStream(
				"C:\\Users\\swats\\Mani Eclipse New Workspace\\APIRestAssuredCucumberFramework\\src\\test\\java\\Resources\\global.properties");
		Prop.load(fis);	
		System.out.println(Prop.getProperty(key));
		return Prop.getProperty(key).toString();

	}
	
	public String GetJSONPath(Response response, String Key) {
		String Resp = response.asString();
		JsonPath js = new JsonPath(Resp);
		System.out.println(js.get(Key).toString());
		return js.get(Key).toString();
		
	}

}
