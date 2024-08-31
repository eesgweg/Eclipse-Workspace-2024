package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {
	static RequestSpecification Request;
	ResponseSpecification Res;

	public RequestSpecification requestSpecification() throws IOException {
		if (Request == null) {
			PrintStream logtofile = new PrintStream(new FileOutputStream("logging.txt"));
			Request = new RequestSpecBuilder().setBaseUri(getGlobalValues("BaseUrl"))
					.addHeader("Content-Type", "application/json").addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(logtofile))
					.addFilter(ResponseLoggingFilter.logResponseTo(logtofile)).setContentType(ContentType.JSON).build();
			return Request;
		}

		return Request;
	}

	public ResponseSpecification responseSpecification() {
		Res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

		return Res;
	}

	public String getGlobalValues(String key) throws IOException {
		Properties Prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\swats\\Mani Eclipse New Workspace\\RestAssuredAPIFramework\\src\\test\\java\\Resources\\global.properties");
		Prop.load(fis);
		Prop.getProperty(key);

		return Prop.getProperty(key).toString();

	}

}
