package Scenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.IObject;

import Files.Libraries;
import Files.payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LibraryAPI {
	public static String ID;

	@Test(dataProvider = "BooksData")
	public static void addBook(String isbn, String aisle) throws IOException {

		RestAssured.baseURI = "http://216.10.245.166";
		String Response = given().header("Content-Type", "application/json").body(payload.AddbookPL(isbn, aisle)).when()
				.post("Library/Addbook.php").then().assertThat().statusCode(200)
				.body("Msg", equalTo("successfully added")).extract().response().asString();

		ID = Libraries.RawToJSON(Response).getString("ID");
		System.out.println(ID);
		// return ID;
	}

	@Test
	public static void addBook() throws IOException {

		RestAssured.baseURI = "http://216.10.245.166";
		String Response = given().header("Content-Type", "application/json").body(payload.AddBookHashMapPayload())
				.when().post("Library/Addbook.php").then().assertThat().statusCode(200)
				.body("Msg", equalTo("successfully added")).extract().response().asString();

		ID = Libraries.RawToJSON(Response).getString("ID");
		System.out.println(ID);
		// return ID;
	}

	@Test(dataProvider = "BooksData")
	public static void DeleteBook(String isbn, String aisle) {
		ID = isbn + aisle;
		RestAssured.baseURI = "http://216.10.245.166";
		given().header("Content-Type", "application/json").body(payload.DeletebookPL(ID)).when()
				.put("/Library/DeleteBook.php").then().assertThat().statusCode(200)
				.body("Msg", equalTo("book is successfully deleted"));

	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		// Arrays - collection of elements
		// Multidimensional Array - Collection of arrays
		return new Object[][] { { "jkbh", "5644" }, { "vhjv", "5645" }, { "b", "5646" } };
	}

}
