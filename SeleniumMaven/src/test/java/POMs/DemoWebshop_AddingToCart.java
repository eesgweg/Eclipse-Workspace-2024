package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlilities.UserActions;

public class DemoWebshop_AddingToCart {
	public WebDriver driver;
	Utlilities.Utlility Utlility = new Utlilities.Utlility();
	//Log4jListener Log4jListener = new Log4jListener();
	UserActions UserActions = new UserActions(driver);
	
	public DemoWebshop_AddingToCart(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[@href='/books']")
	private WebElement Books;
	
	@FindBy(xpath = "//*[text()='Computing and Internet']")
	private WebElement Book1;
	
	@FindBy(xpath = "//*[text()='Computing and Internet']//following::span[2]")
	private WebElement Book1Price;
	
	@FindBy(xpath = "//*[text()='Computing and Internet']//following::imput[1]")
	private WebElement Book1AddToCart;
	
	@FindBy(xpath = "//*[text()='Fiction']")
	private WebElement Book2;
	
	@FindBy(xpath = "//*[text()='Fiction']//following::span[2]")
	private WebElement Book2Price;
	
	@FindBy(xpath = "//*[text()='Fiction']//following::imput[1]")
	private WebElement Book2AddToCart;
	
	@FindBy(xpath ="//*[@id='bar-notification']//p")
	private WebElement BarNotification;
	
	@FindBy(xpath ="//*[@id='bar-notification']//p//a")
	private WebElement ShoppingCart;
	
	
	
}
