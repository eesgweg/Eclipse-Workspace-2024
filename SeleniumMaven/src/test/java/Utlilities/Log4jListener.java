package Utlilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


	public class Log4jListener implements ITestListener,IInvokedMethodListener  {

	    // Initialize Log4j logger
	    private final Logger logger = Logger.getLogger(Log4jListener.class);
	    public BufferedWriter writer ;
	    @Override
	    public void onStart(ITestContext context) {
	    	try {
				writer = new BufferedWriter(new FileWriter("C:\\Users\\swats\\Mani Eclipse New Workspace\\SeleniumMaven\\test-output\\HTMLREPORTS\\StatusReport.html"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        logger.info("Test Suite started: " + context.getName());
	        WriteToHTML( "<!DOCTYPE html>\n" +
                             "<html>\n" +
                             "<head>\n" +
                             "    <title>"+context.getName()+"</title>\n" +
                             "</head>\n" +
                             "<body>\n" +
                             "    <h1>Starting with Execution</h1>\n" +
                             "    <p>"+"Test Suite started: " + context.getName()+"</p>\n"
                             );
	        
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        logger.info("Test Suite finished: " + context.getName());
	        WriteToHTML("<p>Test Suite finished: </p>" + context.getName());
	        CloseHTML();
	        
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        logger.info("Test started: " + result.getName());
	        WriteToHTML("<p>Test started: " + result.getName()+"</p>");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        logger.info("Test passed: " + result.getName());
	        WriteToHTML("<p>Test passed: " + result.getName()+"</p>");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        logger.error("Test failed: " + result.getName(), result.getThrowable());
	        WriteToHTML("<p>Test failed: " + result.getName() + " : \n"+result.getThrowable()+"</p>");
	        CloseHTML();
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        logger.warn("Test skipped: " + result.getName());
	        WriteToHTML("<p>Test skipped: " + result.getName()+"</p>");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        logger.warn("Test failed but within success percentage: " + result.getName());
	        WriteToHTML("<p>Test failed but within success percentage: " + result.getName()+"</p>");
	       
	    }
	    
	    public void WriteToHTML(String Message) {
	    	try {
	    		System.err.println("-------------"+Message+"-------------");
				writer.write(Message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public void CloseHTML() {
	    	try {
	    		WriteToHTML("</body>\r\n"
	    				+ "</html>");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @Override
	    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	        // Log or perform actions before each method invocation
	        System.out.println("Before Method: " + method.getTestMethod().getMethodName());
	        WriteToHTML("<p>"+"Before Method: " + method.getTestMethod().getMethodName()+"</p>");
	    }

	    @Override
	    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	        // Log or perform actions after each method invocation
	        if (testResult.getStatus() == ITestResult.SUCCESS) {
	            System.out.println("After Method: " + method.getTestMethod().getMethodName() + " - PASSED");
	            WriteToHTML("<p>"+"After Method: " + method.getTestMethod().getMethodName()+ " - PASSED"+"</p>");
	        } else if (testResult.getStatus() == ITestResult.FAILURE) {
	            System.out.println("After Method: " + method.getTestMethod().getMethodName() + " - FAILED");
	            WriteToHTML("<p>"+"After Method: " + method.getTestMethod().getMethodName()+ " - FAILED"+"</p>");
	            CloseHTML();
	        } else if (testResult.getStatus() == ITestResult.SKIP) {
	            System.out.println("After Method: " + method.getTestMethod().getMethodName() + " - SKIPPED");
	            WriteToHTML("<p>"+"After Method: " + method.getTestMethod().getMethodName()+ " - SKIPPED"+"</p>");
	        }
	    }
}

