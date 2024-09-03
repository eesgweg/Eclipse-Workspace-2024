package TestExecution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POMs.DemoWebshop_HomePage;
import Utlilities.BrowserAssignment;
import Utlilities.UserActions;

public class DemoWebShop_OrderItem {
	WebDriver driver;
	BrowserAssignment BrowserAssignment= new BrowserAssignment();
	DemoWebshop_HomePage DemoWebshop_HomePage;
	
	
	@Test(description = "Log In to Demo Workshop Portal")
	public void Launch_And_Login() throws InterruptedException, IOException {
		driver=BrowserAssignment.browser("FIREFOX");
		DemoWebshop_HomePage= new DemoWebshop_HomePage(driver);
		DemoWebshop_HomePage.ClickLoginTab();
		DemoWebshop_HomePage.LoginToDemoShop();	
	}
	
	@Test(description = "Adding Items to the Shopping Cart")
	public void AddToCart() {
		
	}

}
