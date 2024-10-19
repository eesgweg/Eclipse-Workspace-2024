package StepDefenitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumBasicSD {
	WebDriver driver;
	WebDriverWait wait;
	@Given("Browser is launched with Website")
	public void browser_is_launched_with_website() {
		System.setProperty("webriver.firefox.driver", "C:\\Users\\swats\\Mani Eclipse New Workspace\\CucumberSelenium\\Libs\\geckodriver.exe");
	    driver = new FirefoxDriver();
	   DesiredCapabilities Capabilities = new DesiredCapabilities();
	   FirefoxOptions Options = new FirefoxOptions();
	   Options.addArguments("-private");
	   Capabilities.setCapability("moz:firefoxOptions", Options);
	   driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	  
	}

	@When("Radio Button is visible")
	public void radio_button_is_visible() {
	    WebElement radiobutton1 = driver.findElement(By.xpath("//*[@value='radio1']"));
	     wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	    wait.until(ExpectedConditions.visibilityOf(radiobutton1));
	}

	@Then("Click all radio buttons")
	public void click_all_radio_buttons(List<Map.Entry<String,String>> a) {
		System.out.println(a);
	//	driver.findElement(By.xpath("//*[@value='"+a.get(0).get("r1")+"']")).click();
//		driver.findElement(By.xpath("//*[@value='"+a.get("r2")+"']")).click();
//		driver.findElement(By.xpath("//*[@value='"+a.get("r3")+"']")).click();
		
	}

	@And("Verify WebTable Content")
	public void Verify_WebTable_Content(List<List<String>> a) {
		System.out.println(a);
		WebElement table = driver.findElement(By.xpath("//*[text()='Web Table Example']//following-sibling::table"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", table);
//		//HeaderValidation
//		List<WebElement> Header = table.findElements(By.tagName("th"));
//		for(WebElement headings : Header)
//		{
//			for(WebElement x: headings.findElements(By.tagName("td"))) {
//				int headingcount=0;
//				if(x.getText().equals(a.get(0).get(headingcount))){
//					System.out.println(x.getText()+" == "+a.get(0).get(headingcount));
//				}
//				headingcount++;
//			}
//		}
		
		//Table validation
		List<WebElement> Rows = table.findElements(By.tagName("tr"));
		int RowCount =0;
		for(WebElement row : Rows) {	
			 int Colcount =0;
			String TextToVerify=null, Webelementtext=null;
			List<WebElement> Columns = row.findElements(By.tagName("td"));
			for(WebElement cell : Columns) {
				TextToVerify = a.get(RowCount).get(Colcount);
				Webelementtext= cell.getText();
				if(TextToVerify.equals(Webelementtext)) {
					System.err.print("|"+TextToVerify+" == "+Webelementtext+" | ");
				}
				Colcount++;
			}
			System.err.println(RowCount);
			RowCount++;
			if(RowCount == a.size()) {
				break;
			}
		}
		System.out.println();
	}
	
	
	@Then("Close the Broswer")
	public void close_the_broswer() {
	   driver.quit();
	}

}
