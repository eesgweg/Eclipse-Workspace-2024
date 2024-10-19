package InterviewPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class driverAssignment{

	public WebDriver driver;
	Reporting Reporting;
	
	public driverAssignment() {
		Reporting = new Reporting();
	
		try {
		System.setProperty("webdriver.gecko.driver","G:\\geckodriver.exe");
		driver = new FirefoxDriver(MergeOptionsCapabilities());	
		Reporting.Reporter("PASS", "DriverAssignment is done");
		}catch (Exception e) {
			Reporting.Reporter("FAIL", "DriverAssignment is Failed");
			Reporting.Reporter("INFO", e.getStackTrace().toString());
			
		}
		
	}
	
	public DesiredCapabilities Capabilities() {
		DesiredCapabilities dc = new DesiredCapabilities();
		System.out.println("Launching in "+dc.getBrowserName());
		dc.setAcceptInsecureCerts(true);
		return dc;
	}
	
	public FirefoxOptions Options() {
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--private");
		fo.addArguments("--start-maximized");		
		//fo.setHeadless(true);
		fo.addArguments("--disable-popup-blocking");
		fo.addArguments("--disable-web-security");
		//fo.setPageLoadTimeout(Duration.ofSeconds(20));
		return fo;
	}
	
	public FirefoxOptions MergeOptionsCapabilities() {
		return Options().merge(Capabilities());
	}
	
	
	
}
