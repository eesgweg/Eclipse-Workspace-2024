package InterviewPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends driverAssignment{
	
	//WebDriver driver;
	WebDriverWait wait;
	
	public Utils() {
		super();
	}
	
	public List<WebElement> GetLinksInPage() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links);
		Reporting.Reporter("PASS", "links are retrieved");
		return links;
	}
	
	public WebElement findElementByXpath(String Locator) {
		Reporting.Reporter("PASS", "Locator located");
		return driver.findElement(By.xpath(Locator));
		
	}
	
	public void WaitForElement(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 Reporting.Reporter("PASS", "WaitForElement passed");
	}
	
	public void openBrowserWithUrl(String URL) {
		driver.get(URL);
		 Reporting.Reporter("PASS", "browser opened with URL: "+URL);
	}
	
	public void Wait() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Reporting.Reporter("PASS", "Waited for 10 seconds");
	}
	
	public void closeBrowser() {
		driver.close();
		Reporting.Reporter("PASS", "Browser closed");
	}
	
	public String getProperty(String property) throws IOException {
		String configFilePath = System.getProperty("config.file", "src/main/resources/config.properties");
		FileInputStream fis = new FileInputStream(configFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		String Property = prop.get(property).toString();
		//String Property =System.getProperty(property);
		System.out.println("-------------------------------");
		System.out.println(Property);
		System.out.println("-------------------------------");
		Reporting.Reporter("PASS", "Property updated -"+Property);
		return Property;
	}
	
	 


}
