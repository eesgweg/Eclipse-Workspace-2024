package InterviewPractice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jdi.Method;

public class Reportstest_Constructor {
	
	Reporting Reporting = new Reporting();
	
	
	@Test
	public void MethodA() {

		try {
            Assert.assertTrue(true);
            Reporting.Reporter("PASS","Test passed...");
        } catch (AssertionError e) {
        	Reporting.Reporter("FAIL","Test Failed...\n"+ e.getMessage());
        }
	}
	
	@Test
	public void MethodB() {
	
		try {
            Assert.assertTrue(false);
            Reporting.Reporter("PASS","Test passed...");
        } catch (AssertionError e) {
        	Reporting.Reporter("FAIL","Test Failed...\n"+ e.getMessage());
        }
	
		
	}
	

}
