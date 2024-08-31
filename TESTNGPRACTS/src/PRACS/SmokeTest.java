package PRACS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SmokeTest {
	JFrame frame;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println(n);
	  System.out.println(s);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Smoke Class--> beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Smoke Class--> AfterMethod");
  }


  @DataProvider
  public Object[][] dp() {
	  System.out.println("Smoke Class--> DP Running");
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
	  System.out.println("Smoke Class--> afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Smoke Class--> beforetest");
	  frame = new JFrame("Message Frame");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Smoke Class--> afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Smoke Class--> beforeSuit");
  }

  @Parameters("db")
  @AfterSuite
  public void afterSuite(@Optional("IBMDB2") String db) {
	  System.out.println("Smoke Class--> afterSuit");
	  System.err.println("DBCONNECTION = "+db);
  }
  
 
  @Test(groups = {"Smoke","Regression"})
  public void SmokeGroupMethod() {
	  System.err.println("SmokeGroupMethod");
  }

}
