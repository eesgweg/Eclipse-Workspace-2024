package CrossBrowser;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Edge {
	 WebDriver driver;

	public Edge() {

		System.setProperty("webdriver.edge.driver", "G:\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.setCapability("useWebSocketUrl", true);
		this.driver = new EdgeDriver(options);
	}

}
