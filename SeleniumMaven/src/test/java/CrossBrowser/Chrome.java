package CrossBrowser;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {
	WebDriver driver;
	public Chrome() {		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--incognito");
		this.driver = new ChromeDriver(options);
		
	}

}
