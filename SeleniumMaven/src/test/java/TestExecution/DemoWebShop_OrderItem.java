package TestExecution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POMs.DemoWebshop_AddingToCart;
import POMs.DemoWebshop_HomePage;
import Utlilities.BrowserAssignment;
import Utlilities.UserActions;

public class DemoWebShop_OrderItem {
	WebDriver driver;
	BrowserAssignment BrowserAssignment= new BrowserAssignment();
	DemoWebshop_HomePage DemoWebshop_HomePage;
	DemoWebshop_AddingToCart DemoWebshop_AddingToCart;
	String Book1price =null,Book2price =null;
	
	@Test(description = "Log In to Demo Workshop Portal",priority = 1)
	public void Launch_And_Login() throws InterruptedException, IOException {
		driver=BrowserAssignment.browser("FIREFOX");
		DemoWebshop_HomePage= new DemoWebshop_HomePage(driver);
		DemoWebshop_HomePage.ClickLoginTab();
		DemoWebshop_HomePage.LoginToDemoShop();	
	}
	
	@Test(description = "Adding Items to the Shopping Cart", dependsOnMethods = "Launch_And_Login")
	public void AddToCart() throws IOException, InterruptedException {
		DemoWebshop_AddingToCart = new DemoWebshop_AddingToCart(driver);
		String BookPrices = DemoWebshop_AddingToCart.AddBooksToCart();
		String[] prices = BookPrices.split(",");
		Book1price =prices[0];Book1price =prices[1];
		System.out.println(Book1price);
		System.out.println(Book2price);
	}

}
