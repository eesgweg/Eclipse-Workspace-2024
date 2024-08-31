package StepDefenition;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import POJOClasses.OrderDetailsPOJO;
import Resources.APIResources;
import Resources.MessageValidations;
import Resources.TestDataBuild;
import Resources.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class StepDef_Ecommerce extends Resources.Utilities {
	RequestSpecification Request;
	Response Response;
 static String AccessToken, UserID, ProductID,OrderID;
	String AccessTokenForProcessing;
	static TestDataBuild TestData;
	static String LoginUserID, LoginPassword, ResponseMessage, CurrentAPI;
	WebDriver driver;
	 JavascriptExecutor js;

	@Given("Login Payload with {string} User credentials")
	public void login_payload_with_user_credentials(String Type) throws IOException {
		TestData = new TestDataBuild();
//		System.out.println(getGlobalValues("UserID"));
//		System.out.println(getGlobalValues("Password"));
		if (Type.equalsIgnoreCase("valid")) {
			LoginUserID = "rainamani.444@gmail.com";
			LoginPassword = "Mani@1997";
			ResponseMessage = "Login Successfully";
		} else if (Type.equalsIgnoreCase("invaliduserid")) {
			LoginUserID = "rainam.444@gmail.com";
			LoginPassword = "Mani@1997";
			ResponseMessage = "Incorrect email or password.";
		} else if (Type.equalsIgnoreCase("invalidpassword")) {
			LoginUserID = "rainamani.444@gmail.com";
			LoginPassword = "Man1997";
			ResponseMessage = "Incorrect email or password.";
		} else if (Type.equalsIgnoreCase("nouserid")) {
			LoginUserID = "";
			LoginPassword = "Man1997";
			ResponseMessage = "Email is required";
		} else if (Type.equalsIgnoreCase("nopassword")) {
			LoginUserID = "rainamani.444@gmail.com";
			LoginPassword = "";
			ResponseMessage = "Password is required";
		}
		Request = given().spec(requestSpecification()).body(TestData.EcommerceLoginPayload(LoginUserID, LoginPassword));
	}

	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String Resource, String APIType) {
		APIResources APIResources = Resources.APIResources.valueOf(Resource);

		if (Resource.equals("EcommerceLoginResourceAPI") && APIType.equals("POST")) {
			System.err.println(APIResources.getResource());
			Response = Request.when().post(APIResources.getResource()).then().log().all().extract().response();
			System.out.println(Response.asString());

		} else if (Resource.equals("EcommerceCreateProductResourceAPI") && APIType.equals("POST")) {
			System.err.println(APIResources.getResource());
			Response = Request.when().post(APIResources.getResource()).then().log().all().extract().response();
			System.out.println(Response.asString());

			ResponseMessage = "Product Added Successfully";

		} else if (Resource.equals("EcommerceDeleteProductResourceAPI") && APIType.equals("DELETE")) {
			System.err.println(APIResources.getResource());
			Response = Request.when().delete(APIResources.getResource() + "/{productid}").then().log().all().extract()
					.response();
			System.out.println(Response.asString());
			ResponseMessage = "Product Deleted Successfully";
		}else if (Resource.equals("EcommerceCreateOrderResourceAPI") && APIType.equals("POST")) {
			System.err.println(APIResources.getResource());
			Response = Request.when().post(APIResources.getResource()).then().log().all().extract()
					.response();
			System.err.println("-------------------------------------------");
			
			System.err.println(Response.asString());
			System.err.println("-------------------------------------------");
			//Response.as(OrderDetailsPOJO.class);
//			given().auth().basic("", "")
//			given().auth().oauth(APIType, APIType, Resource, APIType)
			ResponseMessage = "Order Placed Successfully";

		}
	}

	@Then("Validate Status code is {int}")
	public void validate_status_code_is(Integer StatusCode) {
		System.out.println(Response);
		System.out.println(StatusCode);
		assertEquals(Response.getStatusCode(), StatusCode);
	}

	@Then("Fetch TokenID and UserID")
	public void fetch_token_id_and_user_id() {
		AccessToken = GetJSONPath(Response, "token");
		UserID = GetJSONPath(Response, "userId");
		System.err.println(AccessToken);
		System.err.println(UserID);
		
	}

	@Then("Validate message")
	public void validate_message() {

		assertEquals(GetJSONPath(Response, "message"), ResponseMessage);

	}
	

	@Given("{string} product details to be added")
	public void product_details_to_be_added(String ProductName) throws IOException {
		Request = given().baseUri(getGlobalValues("BaseUrl")).log().all().header("Authorization", AccessToken)
				.formParam("productName", ProductName).formParam("productAddedBy", UserID)
				.formParam("productCategory", "Accessories").formParam("productSubCategory", "Systems")
				.formParam("productPrice", "45000").formParam("productDescription", "DELL I7")
				.formParam("productFor", "men")
				.multiPart("productImage", new File("C://Users//swats//OneDrive//Desktop//Study//Laptop.jpg"));
	}

	@Given("{string} product details to be Deleted")
	public void product_details_to_be_Deleted(String ProductName) throws IOException {
		Request = given().baseUri(getGlobalValues("BaseUrl")).log().all().header("Authorization", AccessToken)
				.pathParam("productid", ProductID);
	}

	@Then("Fetch ProductID")
	public void fetch_product_id() {
		ProductID = GetJSONPath(Response, "productId");
	}
	
	@Given("CreateOrder Payload")
	public void create_order_payload() throws IOException {
	System.err.println(AccessTokenForProcessing);
	   Request =  given().baseUri(getGlobalValues("BaseUrl")).log().all().header("Authorization", AccessToken)
			   .header("Content-Type","application/json")
			   .body(TestData.EcommerceCreateOrder(ProductID));
	}
	@Then("Fetch OrderID")
	public void fetch_order_id() {
//	   Response.as(OrderDetailsPOJO.class);
//		OrderDetailsPOJO OrderDetailsPOJO = new OrderDetailsPOJO();
//		System.err.println(OrderDetailsPOJO.getOrders().get(0));
//		System.err.println(OrderDetailsPOJO.getProductOrderId().get(0));
//		System.err.println(OrderDetailsPOJO.getMessage());
		OrderID = GetJSONPath(Response, "orders[0]");
		System.out.println("OrderID: "+OrderID);
		
	}
	
	
	@Given("Successfully logging into portal")
	public void successfully_logging_into_portal() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(options);
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.id("userEmail")).sendKeys(LoginUserID);
		driver.findElement(By.id("userPassword")).sendKeys(LoginPassword);
		driver.findElement(By.id("login")).click();
		
		
		
	}
	@When("User Navigates to Orders Tab")
	public void user_navigates_to_orders_tab() {
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[3]/button")).click();
	}
	@Then("Validate OrderID")
	public void validate_order_id() {
		String OrderIDFromUI= driver.findElement(By.cssSelector("tr.ng-star-inserted > th:nth-child(1)")).getText();
		org.testng.Assert.assertEquals(OrderIDFromUI, OrderID);
	}
	
	@Then("Validate OrderDetails")
	public void Validate_OrderDetails() {
		driver.findElement(By.cssSelector("tr.ng-star-inserted > td:nth-child(6) > button:nth-child(1)")).click();
		assertEquals(driver.findElement(By.cssSelector(".email-title")).getText().trim().toUpperCase(), "ORDER SUMMARY");
		assertEquals(driver.findElement(By.cssSelector(".col-text")).getText(), OrderID);
		assertEquals(driver.findElement(By.cssSelector("div.row:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(2)")).getText(), LoginUserID);	 
		 // Create a JavascriptExecutor instance
         js = (JavascriptExecutor) driver;
        // Scroll down by a specific amount
        js.executeScript("window.scrollBy(0, 1000);");
		assertEquals(driver.findElement(By.cssSelector(".price")).getText(), "$ 45000");
		assertEquals(driver.findElement(By.cssSelector(".title")).getText().trim().toUpperCase(), "LAPTOP");
		driver.findElement(By.cssSelector("div.btn")).click();
	}
	@Then("Delete Order in UI")
	public void Delete_Order_in_UI() {	
		driver.findElement(By.cssSelector(".btn-danger")).click();
		System.out.println("OrderID: "+OrderID+" has been deleted successfully");
		driver.quit();
	}


}
