package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlilities.UserActions;

public class DemoWebShop_ShoppingCart {
	public WebDriver driver;
	Utlilities.Utlility Utlility = new Utlilities.Utlility();
	//Log4jListener Log4jListener = new Log4jListener();
	UserActions UserActions = new UserActions(driver);
	
	public DemoWebShop_ShoppingCart(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	String a;
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[1]//td[3]//a")
	private WebElement CartItem1;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[2]//td[3]//a")
	private WebElement CartItem2;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[1]//td[4]//a")
	private WebElement CartItem1Price;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[2]//td[4]//a")
	private WebElement CartItem2Price;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[1]//td[5]//a")
	private WebElement CartItem1Quantity;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[2]//td[5]//a")
	private WebElement CartItem2Quantity;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[1]//td[6]//a")
	private WebElement CartItem1Total;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[2]//td[6]//a")
	private WebElement CartItem2Total;
	
	@FindBy(xpath = "//*[@class='cart-total']//tbody//tr[1]//span//span")
	private WebElement CartTotalPrice;
	
	@FindBy(id = "termsofservice")
	private WebElement AgreeToTerms;
	
	@FindBy(id = "checkout")
	private WebElement CheckOut;
	
	
}
