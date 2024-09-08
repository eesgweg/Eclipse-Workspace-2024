package TestExecution;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POMs.DemoWebshop_AddingToCart;
import POMs.DemoWebshop_HomePage;
import Utlilities.BrowserAssignment;
import Utlilities.UserActions;

public class DemoWebShop_OrderItem {
	WebDriver driver;
	BrowserAssignment BrowserAssignment = new BrowserAssignment();
	DemoWebshop_HomePage DemoWebshop_HomePage;
	DemoWebshop_AddingToCart DemoWebshop_AddingToCart;
	POMs.DemoWebShop_ShoppingCart DemoWebShop_ShoppingCart;
	String Book1price = null, Book2price = null;

	@Test(description = "Log In to Demo Workshop Portal", priority = 1)
	public void Launch_And_Login() throws InterruptedException, IOException {
		driver = BrowserAssignment.browser("FIREFOX");
		DemoWebshop_HomePage = new DemoWebshop_HomePage(driver);
		DemoWebshop_HomePage.ClickLoginTab();
		DemoWebshop_HomePage.LoginToDemoShop();
	}

	@Test(description = "Adding Items to the Shopping Cart", dependsOnMethods = "Launch_And_Login")
	public void AddToCart() throws IOException, InterruptedException {
		DemoWebshop_AddingToCart = new DemoWebshop_AddingToCart(driver);
		String BookPrices = DemoWebshop_AddingToCart.AddBooksToCart();
		String[] prices = BookPrices.split(",");
		Book1price = prices[0];
		Book2price = prices[1];
		System.out.println(Book1price);
		System.out.println(Book2price);
	}

	@Test(description = "Checkout Items from Shopping Cart", dependsOnMethods = "AddToCart")
	public void Checkout() throws IOException, InterruptedException {
		 DemoWebShop_ShoppingCart= new POMs.DemoWebShop_ShoppingCart(driver);
		 String Book1Name = DemoWebShop_ShoppingCart.getItem1();
		 String Book2Name = DemoWebShop_ShoppingCart.getItem2();
		 System.out.println(Book1Name); System.out.println(Book2Name);
		// float Item1TotalPrice = Integer.parseInt(DemoWebShop_ShoppingCart.getItem1Quantity())  * Float.parseFloat(Book1price);
		 
		 assertEquals(Book1price, DemoWebShop_ShoppingCart.getItem1price());
		 assertEquals(Book2price, DemoWebShop_ShoppingCart.getItem2price());
		 assertEquals(Book1price+"", DemoWebShop_ShoppingCart.getItem1Total());
		 assertEquals(Book2price+"", DemoWebShop_ShoppingCart.getItem2Total());
		 float TotalPrice = Float.parseFloat(Book1price) + Float.parseFloat(Book2price);
		 assertEquals(TotalPrice+"0", DemoWebShop_ShoppingCart.GetTotalPrice());
		 DemoWebShop_ShoppingCart.AgreeToTerms();
		 DemoWebShop_ShoppingCart.ProceedToCheckOut();
		
	}
}
