package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utlilities.Log4jListener;
import Utlilities.UserActions;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
//import io.netty.handler.codec.base64.Base64;
import java.util.Base64;

public class DemoWebshop_HomePage {
	public WebDriver driver;
	Utlilities.Utlility Utlility = new Utlilities.Utlility();
	//Log4jListener Log4jListener = new Log4jListener();
	UserActions UserActions = new UserActions(driver);
	
	public DemoWebshop_HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id = 'topcartlink']//preceding::a[1]")
	private WebElement LoginTab;
	
	@FindBy(id = "Email")
	private WebElement Email;
	
	@FindBy(id = "Password")
	private WebElement Password;
	
	@FindBy(xpath = "//*[@value ='Log in']")
	private WebElement LoginButton;
	
	public void ClickLoginTab() throws IOException {
		
		UserActions.Click(LoginTab);
		Reporter.log("Selected Login Tab.....!");
	}
	
	public void EnterUserID() throws IOException {
		UserActions.EnterText(Email,Utlility.Decode(Utlility.Getproperty("userid")));
	//	Email.sendKeys(Utlility.Decode(Utlility.Getproperty("userid")));
		Reporter.log("UserID Enetered");
	}
	
	public void EnterPassword() throws IOException {
		UserActions.EnterText(Password,Utlility.Decode(Utlility.Getproperty("password")));
		//Password.sendKeys(Utlility.Decode(Utlility.Getproperty("password")));
		Reporter.log("Password Enetered");
	}
	
	public void ClickLoginButton() throws IOException {
		//LoginButton.click();
		UserActions.Click(LoginButton);
		Reporter.log("Login Button is clicked");
	}
	
	
	public void LoginToDemoShop() throws InterruptedException, IOException {
		ClickLoginTab();
		EnterUserID();
		EnterPassword();
		ClickLoginButton();
		Thread.sleep(2000);
		Reporter.log("Logged In to DemoWebshop");
	}
	
	
	

}
