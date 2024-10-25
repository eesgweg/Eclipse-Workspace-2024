package CrossBrowser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.internal.FactoryMethod;

import FactoryClassExp.A;
import FactoryClassExp.B;
import FactoryClassExp.C;

public class Factorybrowser {
	 public WebDriver driver;
	
	public Factorybrowser(String browser) {
		if(browser.equalsIgnoreCase("FireFox")) {
		
			driver = new Firefox().driver;
			
		}else if(browser.equalsIgnoreCase("Chrome")) {
			driver = new Chrome().driver;
		}if(browser.equalsIgnoreCase("Edge")) {
			driver = new Edge().driver;
		}
	}
	
	@BeforeTest
	public void OpenBrowserInstance() {
		driver= new Factorybrowser("Firefox").driver;
	}
	
	
	@Test
	public void Run1() {

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@AfterTest
	public void Closebrowser() {
		driver.close();
	}
	
	
	
}
