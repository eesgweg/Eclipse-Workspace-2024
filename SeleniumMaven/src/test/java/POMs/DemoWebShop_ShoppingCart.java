package POMs;

import java.io.IOException;

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
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[1]//td[4]//span[2]")
	private WebElement CartItem1Price;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[2]//td[4]//span[2]")
	private WebElement CartItem2Price;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[1]//td[5]//input")
	private WebElement CartItem1Quantity;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[2]//td[5]//input")
	private WebElement CartItem2Quantity;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[1]//td[6]//span[2]")
	private WebElement CartItem1Total;
	
	@FindBy(xpath = "//*[@class='cart']//tbody//tr[2]//td[6]//span[2]")
	private WebElement CartItem2Total;
	
	@FindBy(xpath = "//*[@class='cart-total']//tbody//tr[1]//span//span")
	private WebElement CartTotalPrice;
	
	@FindBy(id = "termsofservice")
	private WebElement AgreeToTerms;
	
	@FindBy(id = "checkout")
	private WebElement CheckOut;
	
	public String getItem1() throws IOException {
		return UserActions.GetText(CartItem1);
	}
	
	public String getItem2() throws IOException {
		return UserActions.GetText(CartItem2);
	}
	
	public String getItem1price() throws IOException {
		return UserActions.GetText(CartItem1Price);
	}
	
	public String getItem2price() throws IOException {
		return UserActions.GetText(CartItem2Price);
	}
	
	public String getItem1Quantity() throws IOException {
		return UserActions.GetText(CartItem1Quantity);
	}
	
	public String getItem2Quantity() throws IOException {
		return UserActions.GetText(CartItem2Quantity);
	}
	
	public String getItem1Total() throws IOException {
		return UserActions.GetText(CartItem1Total);
	}
	
	public String getItem2Total() throws IOException {
		return UserActions.GetText(CartItem2Total);
	}
	
	public String GetTotalPrice() throws IOException {
		return UserActions.GetText(CartTotalPrice);
	}
	
	public void AgreeToTerms() throws IOException {
		UserActions.Click(AgreeToTerms);
	}
	
	public void ProceedToCheckOut() throws IOException {
		UserActions.Click(CheckOut);
	}
	
	
	
	
	
	
}
