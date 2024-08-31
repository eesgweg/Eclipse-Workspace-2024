package Scenarios;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import DeSerializationPOJO.EcommerceLoginResponsePayload;
import DeSerializationPOJO.EcommercePojo;
import DeSerializationPOJO.Orders;
import DeSerializationPOJO.orderarray;
import Files.Libraries;

public class EcommerceAPI {
	public static RequestSpecification Request;
	
	//public static String Token,UserID,Product_id;
	@Test
	public static void LoginRequest() {
		RequestSpecification Request = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com/")
				.setContentType(ContentType.JSON).build();
		EcommercePojo EcommercePojo = new EcommercePojo();
		EcommercePojo.setUserEmail("rainamani.444@gmail.com");
		EcommercePojo.setUserPassword("Mani@1997");
		
		RequestSpecification RequestLogin= given().log().all().spec(Request).body(EcommercePojo);
		EcommerceLoginResponsePayload LoginResponse = RequestLogin.when().post("api/ecom/auth/login").then().extract().response()
				.as(EcommerceLoginResponsePayload.class);
		System.err.println(LoginResponse.getToken());
		String Token=LoginResponse.getToken();
		System.err.println(LoginResponse.getMessage());
		System.err.println(LoginResponse.getUserId());
		String UserID =LoginResponse.getUserId();
		Assert.assertEquals(LoginResponse.getMessage(), "Login Successfully");
		
		
		//Add product
		Request = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com/")
				.addHeader("Authorization",Token).build();
		 RequestSpecification ReqAddproduct = given().log().all().spec(Request)
		 .formParam("productAddedBy", UserID)
		 .formParam("productName", "ManiProduct")
		 .formParam("productCategory", "Laptop")
		 .formParam("productSubCategory", "Dell")
		 .formParam("productPrice", "27000")
		 .formParam("productDescription", "Standard Laptops")
		 .formParam("productFor", "men")
		 .multiPart("productImage",new File("C://Users//swats//OneDrive//Desktop//Study//Laptop.jpg"));
	
		 String Response = ReqAddproduct.when().post("api/ecom/product/add-product").then().extract().response().asString();
		 System.err.println(Response);
		 String Product_id = Libraries.RawToJSON(Response).get("productId");
		 System.err.println(Product_id);
		 //Assert.assertEquals(Libraries.RawToJSON(Response).get("message"), "Product Added Successfully");
		
		 
		 //Create Order
		 Request = new RequestSpecBuilder()
					.setBaseUri("https://rahulshettyacademy.com/")
					.addHeader("Authorization",Token).setContentType(ContentType.JSON).build();
		 orderarray orderarray = new orderarray();
		 orderarray.setCountry("India");
		 orderarray.setProductOrderedId(Product_id);
		 
		 List<orderarray> OrderDetails = new ArrayList<orderarray>();
		 OrderDetails.add(orderarray);
		 
		 Orders Orders = new Orders();
		 Orders.setOrders(OrderDetails);
		 
		 RequestSpecification CreateOrderLogin = given().log().all().spec(Request).body(Orders);
		 
		 String ResponseForOrder = CreateOrderLogin.when().post("api/ecom/order/create-order").then().extract().response().asString();
		 System.err.println(ResponseForOrder);
		 
		 String Product_Order_ID = Libraries.RawToJSON(ResponseForOrder).getString("orders[0]");
		 System.err.println(Product_Order_ID);
		 
		 
		 //RemoveOrder
		  RequestSpecification DeleteRequest = new RequestSpecBuilder()
					.setBaseUri("https://rahulshettyacademy.com/")
					.addHeader("Authorization",Token).addPathParam("orderid", Product_Order_ID).setContentType(ContentType.JSON).build();
		  
		  RequestSpecification DeleteRequestNew= given().log().all().spec(DeleteRequest);
		  
		  String ResponseofDeleteOrder = DeleteRequestNew.when().delete("api/ecom/order/delete-order/{orderid}").then().extract().response().asString();
		  assertEquals(Libraries.RawToJSON(ResponseofDeleteOrder).get("message"),"Orders Deleted Successfully");
		  
		  //Remove Product
		//RemoveOrder
		  RequestSpecification DeleteProductRequest = new RequestSpecBuilder()
					.setBaseUri("https://rahulshettyacademy.com/")
					.addHeader("Authorization",Token).addPathParam("productid", Product_id).setContentType(ContentType.JSON).build();
		  
		  RequestSpecification DeleteProductRequestNew= given().relaxedHTTPSValidation().log().all().spec(DeleteProductRequest);
		  
		  String ResponseofDeleteProduct = DeleteProductRequestNew.when().delete("api/ecom/product/delete-product/{productid}").then().extract().response().asString();
		  assertEquals(Libraries.RawToJSON(ResponseofDeleteProduct).get("message"),"Product Deleted Successfully");
		//----------------------------------------------------
	}

//	@Test
//	public static void AddProduct() {
//		 Request = new RequestSpecBuilder()
//				.setBaseUri("https://rahulshettyacademy.com/")
//				.addHeader("Authorization",Token).build();
//		 RequestSpecification ReqAddproduct = given().log().all().spec(Request)
//		 .formParam("productAddedBy", UserID)
//		 .formParam("productName", "ManiProduct")
//		 .formParam("productCategory", "Laptop")
//		 .formParam("productCategory", "Dell")
//		 .formParam("productPrice", "27000")
//		 .formParam("productDescription", "Standard Laptops")
//		 .formParam("productFor", "men")
//		 .multiPart("productImage",new File("C://Users//swats//OneDrive//Desktop//Study//Laptop.jpg"));
//	
//		 String Response = ReqAddproduct.when().post("api/ecom/product/add-product").then().extract().response().asString();
//		 Product_id = Libraries.RawToJSON(Response).get("productId");
//		 Assert.assertEquals(Libraries.RawToJSON(Response).get("message"), "Product Added Successfully");
//	}
}
