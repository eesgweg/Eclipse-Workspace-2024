package InterviewPractice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page.CaptureScreenshotFormat;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.beust.jcommander.Parameter;
import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;




public class Reporting implements ITestListener{
	public static ExtentTest test;
	public static  ExtentReports report;
//	Utils utils = new Utils();
	
    
    @Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
    	System.out.println(context.getName() + "Start");
    	setup();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + "Start");
    	test = report.startTest(result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName()+" Finish");
		endTest();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter("FAIL", result.toString());
		

	}

	public static void setup() {
		File f = new File("G:\\Mani Eclipse New Workspace\\Mani Eclipse New Workspace\\SeleniumMaven\\test-output\\ExtendReports\\extendreport.html");
    	report = new ExtentReports(f.toString());
    	System.out.println("Setup complete for Reports");
    	
    	
    		
    }
    
    public static void Reporter(String Status, String Message) {
    	switch(Status.toUpperCase()) {
    		case "PASS":
    			test.log(LogStatus.PASS, Message);
    			break;
    		case "FAIL":
    			test.log(LogStatus.FAIL, Message);
    			break;
    		case "INFO":
    			test.log(LogStatus.INFO, Message);
    			break;
    		default:
    			test.log(LogStatus.INFO, Message);
    	}
    	
    }
    
    
   
  
    public static void endTest()
    {
    	Reporter("Pass","Ending execution");
    report.endTest(test);
    report.flush();
    }

}
