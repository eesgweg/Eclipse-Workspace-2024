package WindowHandles;

import java.time.Duration;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Windowhandles {
	public static WebDriverWait wait;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "G:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       
		
		driver.get("https://demowebshop.tricentis.com/");
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/register']"))));
//		driver.switchTo().newWindow(WindowType.WINDOW).get("https://rahulshettyacademy.com/AutomationPractice");
		driver.switchTo().newWindow(WindowType.TAB).get("https://rahulshettyacademy.com/AutomationPractice");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='alertbtn']"))));
//		driver.switchTo().newWindow(WindowType.WINDOW).get("https://id.atlassian.com/login");
//	//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='username']"))));
		Set<String> AllWindows = driver.getWindowHandles();
		for(String x : AllWindows) {
			System.out.println(driver.switchTo().window(x).getTitle());
		}
		List<String> a = new LinkedList<String>(AllWindows);
		driver.switchTo().window(a.get(0));
		System.err.println(driver.getTitle());
//		driver.findElement(By.xpath("//a[@href='/register']")).click();
		driver.switchTo().window(a.getLast());
		System.err.println(driver.getTitle());
	//	driver.findElement(By.xpath("//*[@id='username']")).click();
		driver.quit();
		
	}
	
	

}
