package SRP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}


	public SRP.NavigationBar getNavigationBar()
	{
		return new NavigationBar(driver);
	}
	
	
	public FooterNaviagtionBar getFooterNaviagtionBar()
	{
		return new FooterNaviagtionBar(driver);
	}
	
}
