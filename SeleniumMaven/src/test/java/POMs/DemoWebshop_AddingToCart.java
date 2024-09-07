package POMs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utlilities.UserActions;

import java.io.IOException;
import org.testng.Reporter;

public class DemoWebshop_AddingToCart {

    public WebDriver driver;
    Utlilities.Utlility Utlility = new Utlilities.Utlility();
    UserActions UserActions = new UserActions(driver);
    

    // Constructor
    public DemoWebshop_AddingToCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(xpath = "//*[@href='/books']")
    private WebElement Books;

    @FindBy(xpath = "//*[@class = 'product-grid']//following::div[1]//div[2]//h2//a")
    private WebElement Book1;

    @FindBy(xpath = "//*[@class = 'product-grid']//following::div[1]//div//div[2]//div[3]//div//span[2]")
    private WebElement Book1Price;

    @FindBy(xpath = "//*[@class = 'product-grid']//following::div[1]//div//div[2]//div[3]//div[2]//input")
    private WebElement Book1AddToCart;

    @FindBy(xpath = "//*[@class = 'product-grid']//*[@class='item-box'][3]//div[@class='details']//h2//a")
    private WebElement Book2;

    @FindBy(xpath = "//*[@class = 'product-grid']//*[@class='item-box'][3]//div[@class='details']//div[3]//div//span[2]")
    private WebElement Book2Price;

    @FindBy(xpath = "//*[@class = 'product-grid']//*[@class='item-box'][3]//div[@class='details']//div[3]//div[2]//input")
    private WebElement Book2AddToCart;

    @FindBy(xpath = "//*[@id='bar-notification']//p")
    private WebElement BarNotification;

    @FindBy(xpath = "//*[@id='bar-notification']//p//a")
    private WebElement ShoppingCart;
    
    @FindBy(css = "#topcartlink>a>span:nth-child(2)")
    private WebElement ShoppingCartOption;

    // Methods for interaction with WebElements
    public void ClickBooksTab() throws IOException {
        UserActions.Click(Books);
        Reporter.log("Books tab clicked.");
    }

    public void SelectBook1() throws IOException {
    	ScrollToElement(Book1,driver);
        UserActions.Click(Book1);
        Reporter.log("Book 1 selected (Computing and Internet).");
    }

    public String GetBook1Price() throws IOException {
        String price = Book1Price.getText();
        Reporter.log("Price of Book 1: " + price);
        return price;
    }

    public void AddBook1ToCart() throws IOException {
        UserActions.Click(Book1AddToCart);
        Reporter.log("Added Book 1 to the cart.");
    }

    public void SelectBook2() throws IOException {
    	ScrollToElement(Book2,driver);
        UserActions.Click(Book2);
        Reporter.log("Book 2 selected (Fiction).");
    }

    public String GetBook2Price() throws IOException {
        String price = Book2Price.getText();
        Reporter.log("Price of Book 2: " + price);
        return price;
    }

    public void AddBook2ToCart() throws IOException {
        UserActions.Click(Book2AddToCart);
        Reporter.log("Added Book 2 to the cart.");
    }

    public String GetBarNotificationText() throws IOException {
        String notificationText = BarNotification.getText();
        Reporter.log("Notification Bar: " + notificationText);
        return notificationText;
    }

    public void ClickShoppingCart() throws IOException {
        UserActions.Click(ShoppingCart);
        Reporter.log("Navigated to the Shopping Cart.");
    }
    
    public void ClickShoppingCartOption() throws IOException {
    	 UserActions.Click(ShoppingCartOption);
         Reporter.log("Navigated to the Shopping Cart.");
    }
    
    public void ScrollToElement(WebElement element,WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0, 100);");
    	
    }

    // Composite method to simulate the process of adding books to the cart
    public String AddBooksToCart() throws IOException, InterruptedException {
        ClickBooksTab();
    //    SelectBook1();
        String Book1price=GetBook1Price();
        AddBook1ToCart();
        Thread.sleep(4000);  // Waiting for the book to be added to the cart
        GetBarNotificationText();
        ClickBooksTab();
        Thread.sleep(3000); 
    //    SelectBook2();
        String Book2price =GetBook2Price();
        AddBook2ToCart();
        Thread.sleep(4000);  // Waiting for the book to be added to the cart
        ClickShoppingCartOption();
        Reporter.log("Books added to the cart and navigated to the Shopping Cart.");
        return Book1price+","+Book2price;
    }
}
