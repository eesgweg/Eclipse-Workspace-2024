package POMs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RahulSheetyHomePage {
	public WebDriver driver;
	public Alert alert;

	public RahulSheetyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[@for='radio1']//preceding-sibling::legend")
	private WebElement RadioButtonlabel;
	@FindBy(xpath = "//*[@value='radio1']")
	private WebElement RadioButton1;
	@FindBy(xpath = "//*[@value='radio2']")
	private WebElement RadioButton2;
	@FindBy(xpath = "//*[@value='radio3']")
	private WebElement RadioButton3;
	
	
	@FindBy(xpath = "//*[@id='autocomplete']//preceding::legend[1]")
	private WebElement AutocompleteTextBoxLabel;
	@FindBy(css = "[id='autocomplete']")
	private WebElement AutocompleteTextBox;

	@FindBy(css = "#checkbox-example > fieldset >legend")
	private WebElement checkBoxlabel;
	@FindBy(id = "checkBoxOption1")
	private WebElement checkBox1;
	@FindBy(id = "checkBoxOption2")
	private WebElement checkBox2;
	@FindBy(id = "checkBoxOption3")
	private WebElement checkBox3;
	
	@FindBy(id = "dropdown-class-example")
	private WebElement dropDown;
	
	
	@FindBy(id ="name")
	private WebElement Alerttextbox;
	@FindBy(id ="alertbtn")
	private WebElement AlertButton;
	
	public void EnterTextinAlertTextBox(String text) {
		Alerttextbox.sendKeys(text);
	}
	public void ClickAlertButton() {
		AlertButton.click();
		 alert = driver.switchTo().alert();
	}
	public void VerifyAlertandSubmit(String text) {
		assertEquals(alert.getText(), text);
		alert.accept();
	}

	public void VerifysectionHeaders() {
		assertEquals("Radio Button Example", RadioButtonlabel.getText().trim());
		assertEquals("Suggession Class Example", AutocompleteTextBoxLabel.getText().trim());
		assertEquals("Checkbox Example", checkBoxlabel.getText().trim());
	}
	
	
	
	public void ClickCheckBox1() {
		checkBox1.click();
		assertEquals(true, checkBox1.isSelected());
	}

	public void ClickCheckBox2() {
		checkBox2.click();
		assertEquals(true, checkBox2.isSelected());
	}

	public void ClickCheckBox3() {
		checkBox3.click();
		assertEquals(true, checkBox3.isSelected());
	}
	
	public void ClickRadioButton1() {
		RadioButton1.click();
	}
	public void ClickRadioButton2() {
		RadioButton2.click();
	}
	public void ClickRadioButton3() {
		RadioButton3.click();
	}
	
	public void EnterCountryName(String Country) {
		AutocompleteTextBox.sendKeys(Country);
	}
	
	public void SelectDropdownValue(String Value) {
		Select Dropdown = new Select(dropDown);
		Dropdown.selectByVisibleText(Value);
	}
	
	

}
