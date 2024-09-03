package Utlilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class BrowserAssignment {
	WebDriver driver;
	Utlilities.Utlility Utlility = new Utlilities.Utlility();
	public WebDriver browser(String Browser) throws IOException {
		switch (Browser.toUpperCase()) {
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			DesiredCapabilities caps = new DesiredCapabilities();
			// options.setCapability("acceptInsecureCerts", true);
			options.addArguments("-private");
			caps.setCapability("moz:firefoxOptions", options);
			driver = new FirefoxDriver(options);
			driver.get(Utlility.Getproperty("URL"));
			driver.manage().window().maximize();
			Reporter.log("Initialized FireFox browser......!");
			break;

		default:
			break;
		}
		return driver;
	}

}
