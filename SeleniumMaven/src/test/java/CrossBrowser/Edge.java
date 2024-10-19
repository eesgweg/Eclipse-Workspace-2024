package CrossBrowser;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Edge {

	@Test
	public void LaunchEdge() throws IOException {
		System.setProperty("webdriver.edge.driver", "G:\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.setCapability("useWebSocketUrl", true);
		WebDriver driver = new EdgeDriver(options);
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/AutomationPractice/"));

		
	}
	
}
