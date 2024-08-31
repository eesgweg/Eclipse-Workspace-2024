package StepDefenitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
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
	public void click_all_radio_buttons() {
		driver.findElement(By.xpath("//*[@value='radio1']")).click();
		driver.findElement(By.xpath("//*[@value='radio2']")).click();
		driver.findElement(By.xpath("//*[@value='radio3']")).click();
		
	}

	@Then("Close the Broswer")
	public void close_the_broswer() {
	   driver.quit();
	}

}
