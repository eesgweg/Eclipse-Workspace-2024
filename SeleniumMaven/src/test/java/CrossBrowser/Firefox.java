package CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Firefox {
	@Test
	public void LaunchFirefox() throws InterruptedException {
	
	System.setProperty("webdriver.gecko.driver", "G:\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/AutomationPractice/"));
//	WebElement a =driver.findElement(By.id("checkBoxOption2"));
//	driver.findElement(RelativeLocator.with(By.tagName("input")).above(a)).click();
//	driver.findElement(RelativeLocator.with(By.tagName("input")).below(a)).click();
//	driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(a)).click();
//	driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(a)).click();
	
//	WebElement iframe =driver.findElement(By.id("courses-iframe"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].scrollIntoView(true);", iframe);

	WebElement Displaytext = driver.findElement(By.id("displayed-text"));
	js.executeScript("arguments[0].scrollIntoView(true);", Displaytext);
	Thread.sleep(2000);
	js.executeScript("arguments[0].style.display='none';", Displaytext);
	Thread.sleep(2000);
	js.executeScript("arguments[0].style.display='block';", Displaytext);
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@class='login-btn']")).click();
//	
//	driver.switchTo().frame("courses-iframe");
//	driver.findElement(By.xpath("//*[@class='login-btn']")).click();
//	driver.switchTo().defaultContent();
	driver.quit();
	
}
}
