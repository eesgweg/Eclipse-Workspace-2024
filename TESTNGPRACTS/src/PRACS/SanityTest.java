package PRACS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SanityTest {
	JFrame frame;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println(n);
	  System.out.println(s);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AfterMethod");
  }


  @DataProvider
  public Object[][] dp() {
	  System.out.println("DP Running");
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	 
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforetest");
	   frame = new JFrame("Message Frame");
				
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
	 // assertEquals(false, true);
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuit");
	  System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\swats\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuit");
  }

  @Parameters({"Environment","Box"})
  @Test(groups = {"Sanity","Regression"})
  public void SmokeGroupMethod(String Environment, String Box) {
	  System.err.println("SanityGroupMethod");
	  System.out.println(Environment+" : "+Box);
	  
  }
}
