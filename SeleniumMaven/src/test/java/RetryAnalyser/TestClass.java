package RetryAnalyser;
import org.testng.annotations.Test;

public class TestClass {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testMethod() {
        System.out.println("Executing test...");
        assert false : "Failing the test to demonstrate retry.";
    }
}
