package SRP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar {
	WebDriver driver;
	
	By Flights = By.cssSelector("[data-id='dweb-header-root'] > ul:nth-child(2) > li:nth-child(1)");
	By Hotels = By.cssSelector("[data-id='dweb-header-root'] > ul:nth-child(2) > li:nth-child(2)");
	By Trains = By.cssSelector("[data-id='dweb-header-root'] > ul:nth-child(2) > li:nth-child(3)");
	By cabs = By.cssSelector("[data-id='dweb-header-root'] > ul:nth-child(2) > li:nth-child(4)");
	By Bus = By.cssSelector("[data-id='dweb-header-root'] > ul:nth-child(2) > li:nth-child(5)");
	
	
	public NavigationBar(WebDriver driver) {
		this.driver=driver;
	}


	public void SelectFlight() {
		driver.findElement(Flights).click();
	}
	
}




