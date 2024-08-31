package TestExecution;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POMs.RahulSheetyHomePage;
import io.netty.util.Timeout;

public class Runner {
	WebDriver driver;
	FirefoxOptions options;

	@BeforeMethod
	public void BrowserAssignment() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		 options = new FirefoxOptions();
		options.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(options);
	}

	@Test(groups = "Windowhandles")
	public void WindowHandles() throws InterruptedException {
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.id("newWindowsBtn")).click();
		//driver.findElement(By.id("newTabsWindowsBtn")).click();
		Thread.sleep(4000);
		String parent=driver.getWindowHandle();
		System.out.println("parent: "+parent);
		Thread.sleep(5000);
		Object[] windows=driver.getWindowHandles().toArray();
		System.out.println(windows);
		driver.switchTo().window((String) windows[1]);
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.id("firstName")).sendKeys("AAAAAAAAAAA");
		driver.findElement(By.id("lastName")).sendKeys("AAAAAAAAAAA");
		driver.switchTo().window((String) windows[2]);
		driver.manage().window().maximize();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	
//		ArrayList<String> Course = new ArrayList<String>();
//		ArrayList<String> Price = new ArrayList<String>();
//		
//		for (int i = 2; i < 10; i++) {
//			
//				Course.add(driver
//					.findElement(By.cssSelector(
//							"[name='courses'] > tbody:nth-child(1) > tr:nth-child(" + i + ") > td:nth-child(2)"))
//					.getText());
//				
//				Price.add(driver
//						.findElement(By.cssSelector(
//								"[name='courses'] > tbody:nth-child(1) > tr:nth-child(" + i + ") > td:nth-child(3)"))
//						.getText());
//			
//			
//		}
//		System.err.println(Course);
//		System.err.println(Price);
		
	}
	
	
	@Test(groups = "Alerts")
	public void AlertHandling() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys("MANI");
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "Hello MANI, share this practice page and share your knowledge");
		alert.accept();
	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void ActionsUsage() {
		Actions actions = new Actions(driver);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
//		actions.moveToElement(driver.findElement(By.id("name"))).sendKeys("India").build().perform();
//		actions.moveToElement(driver.findElement(By.id("name"))).contextClick().build().perform();
		actions.click(driver.findElement(By.id("name")))  // Click on the element to focus (optional)
        .sendKeys("Hello, World!")  
        .keyDown(Keys.CONTROL)  // Press the Ctrl key
        .sendKeys("a")  // Press the 'a' key
        .keyUp(Keys.CONTROL)  // Release the Ctrl key
        .sendKeys(Keys.DELETE)
        .build()
        .perform();  //
	}
	
	@Test(groups = "Hiddenelements")
	public void HiddenElements() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Use WebDriverWait to wait for a condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayed-text")));
		WebElement element1 = driver.findElement(By.id("displayed-text"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.findElement(By.id("hide-textbox")).click();
		js.executeScript("arguments[0].setAttribute('style','display: block;');", element1);
		// Now interact with the element
		element1.sendKeys("Mani");
	}
	
	@Test()
	public void headless() {
		options.addArguments("--headless");
		options.addArguments("--disable-gpu"); // Disable GPU acceleration (optional, for compatibility)
        options.addArguments("--window-size=1920x1080");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement a=  driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(a);
		List<WebElement> c= dropdown.getOptions();
		for(WebElement wb : c) {
			System.out.println(wb.getText());
		}
		
	}
	
	@Test(groups ="PageFactoryExample")
	public void PageFactoryExample() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		RahulSheetyHomePage RahulSheetyHomePage = new RahulSheetyHomePage(driver);
		RahulSheetyHomePage.ClickCheckBox1();
		RahulSheetyHomePage.ClickCheckBox2();
		RahulSheetyHomePage.ClickCheckBox3();
		assertEquals(false, true);
		
	}
	
	@Test(groups = "Checkbrokenlink")
	public void CheckBrokenLink() throws IOException {
		@SuppressWarnings("deprecation")
		URL URL = new URL("https://rahulshettyacademy.com/brokenlink");

		HttpURLConnection c = (HttpURLConnection) URL.openConnection();
		c.connect();
		System.out.println(c.getResponseCode());
		System.out.println(c.getResponseMessage());
		c.disconnect();
		
	}
	
	@Parameters("a")
	@Test(invocationCount = 10,threadPoolSize = 5,groups = "Invocationtest")
	public void InvocationExample(@Optional("Mani") String a) {
				System.out.println(a);
		
	}
	
	@Test
	public void Javascripts() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		Thread.sleep(5000);		 
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		 JS.executeScript("location.reload();") ;
		 Thread.sleep(5000);		 
		JS.executeScript("alert('JS EXECUTION Started');");		
		Thread.sleep(3000);
        driver.switchTo().alert().accept();
		JS.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		WebElement r= driver.findElement(By.cssSelector(".tableFixHead tbody tr:nth-child(9) td:nth-child(4)"));
		JS.executeScript("arguments[0].scrollIntoView(true);",r);
		WebElement r1= driver.findElement(By.cssSelector(".tableFixHead tbody tr:nth-child(1) td:nth-child(4)"));
		Thread.sleep(2000);
		JS.executeScript("arguments[0].scrollIntoView(true);",r1);
		WebElement r2= driver.findElement(By.cssSelector("#mousehover"));
		JS.executeScript("arguments[0].click();",r2);
		WebElement r3= driver.findElement(By.cssSelector("#name"));
		JS.executeScript("arguments[0].scrollIntoView(true);",r3);
		JS.executeScript("arguments[0].value='Mani here';",r3);
		WebElement r4= driver.findElement(By.xpath("//input[@id='hide-textbox']//preceding::legend[1]"));
		assertEquals(JS.executeScript("return arguments[0].innerText;",r4), r4.getText());		
		assertEquals(JS.executeScript("return document.URL;"), driver.getCurrentUrl().trim());
		JS.executeScript("arguments[0].style.border='3px solid red';",r4);
		driver.quit();
	}
	@Test
	public void dropdown() {
		WebElement a = null;
		Select Dropdown = new Select(a);
		Dropdown.getAllSelectedOptions();
	}
	
	@AfterMethod
	public void CloseBrowser() {
		//driver.quit();
	}

}
