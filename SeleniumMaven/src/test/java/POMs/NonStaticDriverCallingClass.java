package POMs;

import org.openqa.selenium.WebDriver;

public class NonStaticDriverCallingClass {

	public static void main(String[] args) {
		WebDriver driver = null;
		// TODO Auto-generated method stub
		NonStaticDriverClass Object 
		= new NonStaticDriverClass(driver);
		driver = Object.DriverAssignment();		
		driver.get("https://jsoneditoronline.org");
	}

}
