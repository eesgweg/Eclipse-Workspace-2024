package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StaticDriverClass {
	static WebDriver driver;
	public static void  DriverAssignment(){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver",
				"G:\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		DesiredCapabilities caps
		= new DesiredCapabilities();
		options.addArguments("-private");
		caps.setCapability("moz:firefoxOptions", options);
		driver = new FirefoxDriver(options);
	}

}
