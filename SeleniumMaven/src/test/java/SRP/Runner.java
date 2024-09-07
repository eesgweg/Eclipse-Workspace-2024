package SRP;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.CSS.TakeCoverageDeltaResponse;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Runner {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, SecurityException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		DesiredCapabilities caps = new DesiredCapabilities();
		// options.setCapability("acceptInsecureCerts", true);
		options.addArguments("-private");
		caps.setCapability("moz:firefoxOptions", options);

		driver = new FirefoxDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		
		
		WebElement Table = driver.findElement(By.xpath("//*[text()='Web Table Fixed header']//following::table"));
		js.executeScript("arguments[0].scrollIntoView(true);",Table);
		Thread.sleep(2000);
		List<WebElement> headers = Table.findElements(By.tagName("th"));

		// Print the header data
		for (WebElement header : headers) {
		    System.out.print(header.getText() + "\t");
		}
		System.out.println("\n----------");
		
		
		List<WebElement> Rows = Table.findElements(By.tagName("tr"));
		//System.out.println(Rows.size());
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='Web Table Fixed header']//following::table//tbody//tr[last()]")));
		Thread.sleep(2000);
		double amount =0.0;
		for(WebElement row : Rows) {
			List<WebElement> Columns = row.findElements(By.tagName("td"));
			
			for(WebElement cell :  Columns) {
						System.out.print(cell.getText()+ "\t");
						
			}
			System.out.println();
		}
		System.out.println(amount);
	
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		
//		WebElement Dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
//		Point point = driver.findElement(By.cssSelector("#dropdown-class-example")).getLocation();
//		System.out.println("X: "+point.getX());
//		System.out.println("Y: "+point.getY());
//		System.out.println("Height: "+Dropdown.getSize().getHeight());
//		System.out.println("Wieight: "+Dropdown.getSize().getWidth());
		
		
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("D:\\Movies\\Series\\Maya\\scr.png"));
		
		driver.quit();
//		Cookie Cookie2 = new Cookie("name2", "testing");
//		driver.manage().addCookie(Cookie2);
//		System.out.println(driver.manage().getCookieNamed("name"));
//		driver.manage().deleteCookieNamed("name");
//		Set<Cookie> a = driver.manage().getCookies();
//		for (Cookie x : a) {
//			System.out.println(x);
//		}
//		driver.manage().deleteCookieNamed("name2");

//		WebElement Dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
//		Select OptionsDropdown = new Select(Dropdown);
//		OptionsDropdown.selectByIndex(0);
//		OptionsDropdown.selectByIndex(1);
//		OptionsDropdown.selectByIndex(2);
//		OptionsDropdown.selectByIndex(3);
//		System.out.println(OptionsDropdown.getFirstSelectedOption().getText());
//		OptionsDropdown.selectByValue("option2");
//		OptionsDropdown.selectByVisibleText("Option1");
//		Thread.sleep(2000);
////		OptionsDropdown.deselectAll();
//		System.out.println(OptionsDropdown.getOptions());
//		OptionsDropdown.deselectByVisibleText("Option1");

//		driver.navigate().to("https://semantic-ui.com/modules/dropdown.html");
//		driver.manage().window().maximize();		
//		Thread.sleep(7000);
//		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[4]/div[1]/div[1]/div/div/div[1]/div/a[4]")).click();
//		WebElement multipledp =driver.findElement(By.xpath("//*[@id='multiple-selection']//following::select[1]"));
////		js.executeScript("arguments[0].scrollIntoView(true);",multipledp);
//		Select MultipleDropdown = new Select(multipledp);
//		MultipleDropdown.selectByIndex(1);
//		MultipleDropdown.selectByIndex(3);
//		Thread.sleep(2000);
//		MultipleDropdown.deselectAll();

//		driver.findElement(By.id("checkBoxOption1")).click();
//		driver.findElement(By.id("checkBoxOption3")).click();
//		assertEquals(true, driver.findElement(By.id("checkBoxOption1")).isSelected());
//		assertEquals(false, driver.findElement(By.id("checkBoxOption2")).isSelected());
//		assertEquals(true, driver.findElement(By.id("checkBoxOption3")).isSelected());

		List<WebElement> inputTags = driver.findElements(By.tagName("input"));

        // Print the number of input elements found
        System.out.println("-------------------------------");
        System.out.println("Total input tags: " + inputTags.size());
        System.out.println("-------------------------------");

        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Process the first 5 input tags only
        inputTags.stream().limit(5).forEach(inputTag -> {
            // Scroll the element into view
            js.executeScript("arguments[0].scrollIntoView(true);", inputTag);

            // Wait until the input is clickable (for buttons) or visible (for text fields)
            wait.until(ExpectedConditions.visibilityOf(inputTag));

            // Perform action based on the input type
            String inputType = inputTag.getAttribute("type");
            if ("text".equalsIgnoreCase(inputType)) {
                inputTag.sendKeys("MANI BHARATHI");
            } else {
                inputTag.click();
            }
        });

//		driver.findElement(By.linkText("Home")).click();

//		js.executeScript("alert('EXECUTION COMPLETED');");
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
//		js.executeScript("window.scroll(0,'document.body.scrollHeight');");
//		Thread.sleep(2000);
//		WebElement MouseHover= driver.findElement(By.xpath("//button[@id='mousehover']"));
//		js.executeScript("arguments[0].scrollIntoView(true);",MouseHover);
//		Thread.sleep(2000);
//		MouseHover.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='mousehover']//following::a[1]")).click();

//		driver.get("https://www.goibibo.com/");
//		
//		System.out.println("Title: " + driver.getTitle());
//		assertEquals("Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off", driver.getTitle().trim());
//		driver.quit();
//		HomePage homePage = new HomePage(driver);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		homePage.getNavigationBar().SelectFlight();
//		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		homePage.getFooterNaviagtionBar().SelectFlight();

	}

}
