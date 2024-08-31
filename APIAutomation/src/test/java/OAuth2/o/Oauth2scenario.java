package OAuth2.o;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Oauth2scenario {

@Test	
public void OAuthTest(){
	String URL = "https://rahulshettyacademy.com/getCourse.php?state=your_unique_state_value&code=4%2F0AcvDMrAL3rAGBGKdE3Fgjq-MumJ1EqYC7Vz6Bb15h4AOrzHCTILDbIDLjs9FaZEuhvolqw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=consent";
	String[] a = URL.split("&");
	System.err.println(a[1]);
	String[] b =a[1].split("code=");
	System.err.println(b[1]);
	String Access_Token_Response = given().queryParams("code",b[1])
	.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//	.queryParams("scope","https://www.googleapis.com/auth/userinfo.email")
	.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
	.queryParams("grant_type","authorization_code")
	.when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
	JsonPath js = new JsonPath(Access_Token_Response);
	
	String Access_Token = js.getString("access_token");
	
	
	String Response = given()
	.queryParam("access_token", Access_Token)
	.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
	
	System.out.println(Response);
}

//Google is not allowing to signin into gmail uing any automationscript so cant use selenium UI automation to
// Directly give the code in the query parameter
@Test
public void GetCode() throws InterruptedException {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
	FirefoxOptions options = new FirefoxOptions();
	options.setCapability("acceptInsecureCerts", true);
	 WebDriver driver = new FirefoxDriver(options);
	 
	 String Url = "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=your_unique_state_value";
	 	driver.get(Url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("li.aZvCDf:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2)")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector(".tyoyWc > div:nth-child(1) > button:nth-child(1) > div:nth-child(3)")).click();
//		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("rainamani.444@gmail.com");
		driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > span:nth-child(4)")).click();
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("rainamani.444@gmail.com");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("rainamani.444@gmail.com");
		
		String Code_url = driver.getCurrentUrl();
		
		String[] url_split =Code_url.split("&");
		System.err.println(url_split[1]);
//		return url_split[1];
		
}
}
