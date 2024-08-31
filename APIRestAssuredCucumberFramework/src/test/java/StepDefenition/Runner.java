package StepDefenition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.netty.util.Timeout;

public class Runner {
	WebDriver driver;
	HttpURLConnection c;
	URL URL;
	
	@BeforeMethod
	public void BrowserAssignment() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("acceptInsecureCerts", true);
		 driver = new FirefoxDriver(options);
	}
	
	@Test
	public void Seleniumtest() throws IOException {				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		

		System.out.println("Title: " + driver.getTitle());
		List<WebElement> LinksInPage = driver.findElements(By.tagName("a"));
		System.out.println("No of Links in the Page: "+LinksInPage.size());
		for (int i=0;i<LinksInPage.size();i++) {			
			System.out.println(LinksInPage.get(i).getAttribute("href"));
			//Connectiontester(LinksInPage.get(i).getAttribute("href"));
		}
		
	}
	
	public void Connectiontester(String url) throws IOException {
		@SuppressWarnings("deprecation")
		URL URL = new URL(url);
		c = (HttpURLConnection) URL.openConnection();
		c.connect();
		System.out.println(c.getResponseCode());
		System.out.println(c.getResponseMessage());
		if(c.getResponseCode() == 200) {
			System.out.println("Valid URL: "+url);
		}else {
			System.err.println("Incalid URL: "+url);
		}
	}
	
	@AfterMethod
	public void closebrowser() {
		
		driver.quit();
	}

}
