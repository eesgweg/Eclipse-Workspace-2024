package POMs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlilities.UserActions;

public class DemoWebShop_Checkout {
	public WebDriver driver;
	Utlilities.Utlility Utlility = new Utlilities.Utlility();
	//Log4jListener Log4jListener = new Log4jListener();
	UserActions UserActions = new UserActions(driver);
	
	public DemoWebShop_Checkout(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "#billing-buttons-container input")
	private WebElement BillingAddress_Continue;
	
	public void ClickBillingAddress_Continue() throws IOException{
		UserActions.Click(BillingAddress_Continue);
	}
	
	@FindBy(css = "#shipping-buttons-container input")
	private WebElement ShippingAddress_Continue;
	
	public void ClickShippingAddress_Continue() throws IOException {
		UserActions.Click(ShippingAddress_Continue);
	}
	
	@FindBy(css = "#shipping-method-buttons-container input")
	private WebElement ShippingMethod_Continue;
	
	public void ClickShippingMethod_Continue() throws IOException {
		UserActions.Click(ShippingMethod_Continue);
	}
	
	@FindBy(css = "#payment-method-buttons-container input")
	private WebElement PaymentMethod_Continue;
	
	public void PaymentMethod_Continue() throws IOException {
		UserActions.Click(PaymentMethod_Continue);
	}
	
	@FindBy(css = "#payment-info-buttons-container input")
	private WebElement PaymentInfo_Continue;
	
	public void PaymentInfo_Continue() throws IOException {
		UserActions.Click(PaymentInfo_Continue);
	}
	
	@FindBy(css = "#payment-info-buttons-container input")
	private WebElement ConfirmOrder_SubTotal;
	
//	@FindBy(css = "")
//	private WebElement ConfirmOrder_ShippingCharges;
	
	public void Confirm_Order() throws IOException {
		UserActions.GetText(ConfirmOrder_SubTotal);
		
	}
}
