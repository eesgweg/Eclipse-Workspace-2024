package SRP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {
	WebElement sectionElement;
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver= driver;
	}

	public void findElement(By Findelement) {
		sectionElement.findElement(Findelement);
	}

}
