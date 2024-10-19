package InterviewPractice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jdi.Method;

public class Reportstest_Inheritance extends Reporting{
	
	
	
	
	@Test
	public void MethodA() {

		try {
            Assert.assertTrue(true);
            Reporter("PASS","Test passed...");
        } catch (AssertionError e) {
        	 Reporter("FAIL","Test Failed...\n"+ e.getMessage());
        }
	}
	
	@Test
	public void MethodB() {
	
		try {
            Assert.assertTrue(false);
            Reporter("PASS","Test passed...");
        } catch (AssertionError e) {
        	 Reporter("FAIL","Test Failed...\n"+ e.getMessage());
        }
	
		
	}
	

}
