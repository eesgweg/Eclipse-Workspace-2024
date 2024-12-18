package Utlilities;

import java.io.BufferedWriter;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class UserActions{
	public static  WebDriver driver;BufferedWriter writer;
	Log4jListener Log4jListener = new Log4jListener();
	
	public UserActions(WebDriver driver) {
		this.driver = driver;
		
		
	}

	public void Click(WebElement element) throws IOException {
		element.click();
		Reporter.log("<p>"+element+" is clicked</p>");
	}
	
	public void EnterText(WebElement element, String text) throws IOException {
		element.sendKeys(text);
		Reporter.log("<p>"+text+" is Entered into the "+element+" TextBox</p>");
	}
	
	public String GetText(WebElement element) throws IOException {
		Reporter.log("<p>"+element.getText()+" is Fetched</p>");
		return element.getText().trim();
	}

}
