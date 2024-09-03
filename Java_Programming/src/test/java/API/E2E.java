package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class E2E {
	RequestSpecification req;
	HashMap<String, String> TDM = new HashMap<String, String>();
	Response response;
	JsonPath jp;
	PostmanCollections PostmanCollections = new PostmanCollections();

	public RequestSpecification RequestSpec(int type) {
		switch (type) {
		case 1:
			req = new RequestSpecBuilder().setBaseUri("https://template.postman-echo.com")
					.setContentType(ContentType.JSON).build();
			break;
		case 2:
			req = new RequestSpecBuilder().setBaseUri("https://template.postman-echo.com")
					.addHeader("Content-Type", "application/json").addHeader("api-key", TDM.get("APIKEY"))
					.setContentType(ContentType.JSON).build();
			break;
		}
		return req;
	}

	@Test(priority = 1)
	public void GetAPIToken() {
		String APIKEY = given().spec(RequestSpec(1)).when().get("/api/v1/auth").then().statusCode(200).extract()
				.response().jsonPath().getString("apiKey");
		TDM.put("APIKEY", APIKEY);
		System.err.println("APIKEY: " + APIKEY);
	}

	@Test(priority = 2)
	public void createFromAccount() {
		// GetAPIToken();
		String FromAccountName = PostmanCollections.generateRandomString(5);
		TDM.put("FROMACCOUNTNAME", FromAccountName);
		String FromAccountNumber = given().spec(RequestSpec(2))
				.body("{\"owner\":\"" + FromAccountName
						+ " - FromAccount\",\"balance\":50,\"currency\":\"COSMIC_COINS\"}")
				.when().post("/api/v1/accounts").then().statusCode(200).extract().response().jsonPath()
				.getString("account.id");
		TDM.put("FROMACCOUNTNUMBER", FromAccountNumber);
		System.err.println("FromAccountNumber: " + FromAccountNumber);
	}

	@Test(priority = 3)
	public void createToAccount() {
		// GetAPIToken();
		String ToAccountName = PostmanCollections.generateRandomString(5);
		TDM.put("TOACCOUNTNAME", ToAccountName);
		String ToAccountNumber = given().spec(RequestSpec(2))
				.body("{\"owner\":\"" + ToAccountName + " - ToAccount\",\"balance\":50,\"currency\":\"COSMIC_COINS\"}")
				.when().post("/api/v1/accounts").then().statusCode(200).extract().response().jsonPath()
				.getString("account.id");
		TDM.put("TOACCOUNTNUMBER", ToAccountNumber);
		System.err.println("ToAccountNumber: " + ToAccountNumber);
	}

	@Test(priority = 4)
	public void GetAllAccounts() {
		
		response = given().spec(RequestSpec(2)).when().get("/api/v1/accounts").then().statusCode(200).extract()
				.response();
		jp = response.jsonPath();
		String VerifyResponse = response.toString();
		//assertTrue(VerifyResponse.contains(TDM.get("FROMACCOUNTNUMBER")));
		//assertTrue(VerifyResponse.contains(TDM.get("TOACCOUNTNUMBER")));
//		assertEquals(TDM.get("FROMACCOUNTNUMBER"), jp.getString("accounts[0].id"));
//		assertEquals(TDM.get("FROMACCOUNTNAME") + " - FromAccount", jp.getString("accounts[0].owner"));
//		assertEquals("COSMIC_COINS", jp.getString("accounts[0].currency"));
//		assertEquals(50 + "", jp.getString("accounts[0].balance"));
//		assertEquals(TDM.get("TOACCOUNTNUMBER"), jp.getString("accounts[1].id"));
//		assertEquals(TDM.get("TOACCOUNTNAME") + " - ToAccount", jp.getString("accounts[1].owner"));
//		assertEquals(50 + "", jp.getString("accounts[1].balance"));
//		assertEquals("COSMIC_COINS", jp.getString("accounts[1].currency"));
		PostmanCollections.FileWrite("AccountDetailsReponse",response);
		TDM.put("TRANSCATIONAMOUNT", "20");
	}

	@Test(priority = 5)
	public void CreateTransaction() {	
		String Payload = "{\r\n" + "    \"fromAccountId\": " + TDM.get("FROMACCOUNTNUMBER") + ",\r\n"
				+ "    \"toAccountId\": " + TDM.get("TOACCOUNTNUMBER") + ",\r\n" + "    \"amount\": "
				+ TDM.get("TRANSCATIONAMOUNT") + ",\r\n" + "    \"currency\": \"COSMIC_COINS\"\r\n" + "}";
		response = given().spec(RequestSpec(2)).body(Payload).when().post("/api/v1/transactions").then().statusCode(200).extract().response();
		jp = response.jsonPath();
		assertEquals("true",jp.getString("success")); 
		TDM.put("TRANSCATIONID", jp.getString("transaction.id"));
		System.err.println("Transaction ID: "+TDM.get("TRANSCATIONID"));
	}
	
	@Test(priority = 6)
	public void GetAllTransactions() {
		
		response = given().spec(RequestSpec(2)).queryParam("toAccountId",TDM.get("TOACCOUNTNUMBER")).when().get("/api/v1/transactions").then().statusCode(200).extract().response();
		jp=response.jsonPath();
		assertEquals(TDM.get("TRANSCATIONID"), jp.getString("transactions[0].id"));
		assertEquals(TDM.get("FROMACCOUNTNUMBER"), jp.getString("transactions[0].fromAccountId"));
		assertEquals(TDM.get("TOACCOUNTNUMBER"), jp.getString("transactions[0].toAccountId"));
		assertEquals(TDM.get("TRANSCATIONAMOUNT"), jp.getString("transactions[0].amount"));
		assertEquals("COSMIC_COINS", jp.getString("transactions[0].currency"));
		PostmanCollections.FileWrite("AccountTransactionReponse",response);
		
	}
	
	@Test(priority = 7)
	public void GetTransaction()
	{
		response = given().spec(RequestSpec(2)).pathParam("transactionId",TDM.get("TRANSCATIONID"))
				.when().get("/api/v1/transactions/{transactionId}").then().log().all().extract().response();
		
	}
	
	@Test(priority = 8)
	public void GetFromToAccountCurrentBalance() {
		
		String ToAccountCurrentBalance = given().spec(RequestSpec(2)).pathParam("accountId",TDM.get("TOACCOUNTNUMBER"))
				.when().get("/api/v1/accounts/{accountId}").then().log().all().extract().response().jsonPath().getString("account.balance");
		String FromAccountCurrentBalance = given().spec(RequestSpec(2)).pathParam("accountId",TDM.get("FROMACCOUNTNUMBER"))
				.when().get("/api/v1/accounts/{accountId}").then().log().all().extract().response().jsonPath().getString("account.balance");
		TDM.put("ToAccountCurrentBalance".toUpperCase(), FromAccountCurrentBalance);
		TDM.put("FromAccountCurrentBalance".toUpperCase(), FromAccountCurrentBalance);
		assertEquals("70", ToAccountCurrentBalance);
		assertEquals("30", FromAccountCurrentBalance);
		assertEquals(40+"",
				(Integer.parseInt(ToAccountCurrentBalance) - Integer.parseInt(FromAccountCurrentBalance))+"");
	}
	
	@Test(priority = 10)
	public void DeleteFromToAccounts() {
		
		
		String ToAccountDeleteStatus = given().spec(RequestSpec(2)).pathParam("accountId",TDM.get("TOACCOUNTNUMBER"))
		.when().delete("/api/v1/accounts/{accountId}").then().log().all().extract().response().jsonPath().getString("success");
		String FromAccountDeleteStatus = given().spec(RequestSpec(2)).pathParam("accountId",TDM.get("FROMACCOUNTNUMBER"))
				.when().delete("/api/v1/accounts/{accountId}").then().log().all().extract().response().jsonPath().getString("success");
		assertEquals("true", ToAccountDeleteStatus);
		assertEquals("true", FromAccountDeleteStatus);
		
	}
	
	@Test(priority = 9)
	public void InsufficientFundsTransaction() {
		TDM.put("TRANSCATIONAMOUNT", "100");
		String Payload = "{\r\n" + "    \"fromAccountId\": " + TDM.get("FROMACCOUNTNUMBER") + ",\r\n"
				+ "    \"toAccountId\": " + TDM.get("TOACCOUNTNUMBER") + ",\r\n" + "    \"amount\": "
				+ TDM.get("TRANSCATIONAMOUNT") + ",\r\n" + "    \"currency\": \"COSMIC_COINS\"\r\n" + "}";
		response = given().spec(RequestSpec(2)).body(Payload).when().post("/api/v1/transactions").then().statusCode(400).extract().response();
		jp = response.jsonPath();
		//assertEquals("invalidBody",jp.getString("name"));
		assertEquals("Insufficient balance in fromAccountId to initiate the transaction.",jp.getString("message"));
	}
	
	
}
