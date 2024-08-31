package TestExecution;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POMs.RahulSheetyHomePage;

public class Testing {
	WebDriver driver;
	FirefoxOptions options;
	RahulSheetyHomePage HomePage;

	@BeforeTest
	public void BrowserAssignment() throws InterruptedException {
		System.out.println("OpenBrowser");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		options = new FirefoxOptions();
		options.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		HomePage = new RahulSheetyHomePage(driver);
		HomePage.VerifysectionHeaders();
	}

	@Test(priority = 1,groups = "AGroup")
	public void RadioButtons() {
		HomePage.ClickRadioButton1();
		HomePage.ClickRadioButton2();
		HomePage.ClickRadioButton2();
		System.out.println("RadioButtons-1");
	}

	@Test(priority = 2,groups = "BGroup")
	public void Checkboxes() {
		HomePage.ClickCheckBox1();
		HomePage.ClickCheckBox2();
		HomePage.ClickCheckBox3();
		System.out.println("CheckBoxes-2");
	}

	@Test(priority = 3,groups = "AGroup")
	public void AutoCompleteTextBox() {
		HomePage.EnterCountryName("India");
		System.out.println("AutocompleteTextBox-3");
	}

	@Test(dependsOnMethods = "Checkboxes",groups = "BGroup")
	public void Dropdown() {
		HomePage.SelectDropdownValue("Option2");
		HomePage.SelectDropdownValue("Option3");
		HomePage.SelectDropdownValue("Option1");
		System.out.println("DropdownValue-4");
	}

	@Test(enabled = true, groups = "ExcludedGroup")
	public void AlertHandling() throws InterruptedException {
		HomePage.EnterTextinAlertTextBox("Mani Bharathi M");
		Thread.sleep(2000);
		HomePage.ClickAlertButton();
		Thread.sleep(2000);
		HomePage.VerifyAlertandSubmit("Hello Mani Bharathi M, share this practice page and share your knowledge");
		System.out.println("AlertHandling");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
		System.out.println("CloseBrowser");
	}
}
