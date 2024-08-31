package PRACS;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult  result) {
		System.err.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.err.println("Test Passed: " + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.err.println("Test Failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.err.println("Test Skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.err.println("Test Failed but within success percentage: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.err.println("Test Suite Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.err.println("Test Suite Finished: " + context.getName());
	}
}
