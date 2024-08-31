package SRP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterNaviagtionBar{
	WebDriver driver;
	public FooterNaviagtionBar(WebDriver driver) {
		this.driver=driver;
	}
	
	By Flights = By.cssSelector("li.sc-zdy0j7-9:nth-child(3)");
	By Hotels = By.cssSelector("li.sc-zdy0j7-9:nth-child(4)");
	By Cabs = By.cssSelector("li.sc-zdy0j7-9:nth-child(5)");
	By Bus = By.cssSelector("li.sc-zdy0j7-9:nth-child(6)");
	By Trains = By.cssSelector("li.sc-zdy0j7-9:nth-child(7)");
	
	public void SelectFlight() {
		driver.findElement(Flights).click();
	}

}
