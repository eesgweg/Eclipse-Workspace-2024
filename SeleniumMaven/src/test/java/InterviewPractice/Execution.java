package InterviewPractice;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Execution {
	Reporting Reporting = new Reporting();
	static WebDriver driver;
	Utils Utils;

	

	@Test
	public void Runner1() throws IOException {
		Utils = new Utils();
		Utils.openBrowserWithUrl(Utils.getProperty("url"));
		Utils.Wait();
		Utils.GetLinksInPage();
		System.out.println(Method.class.getName());

	}

	@Test
	public void Runner2() throws IOException {
		
		Utils = new Utils();
		Utils.openBrowserWithUrl(Utils.getProperty("url"));
		Utils.Wait();
		Utils.findElementByXpath("//*[@href='index.html']");
		assertTrue(false);
		
	}
	
	@Test
	public void Runner3() throws IOException {
		Utils = new Utils();
		driver.get("file:///G:/HTMLPAGE.html");
	
	}

	@AfterMethod
	public void closebrowser() {
		Utils.closeBrowser();

	}

}
