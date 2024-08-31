package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",glue = {"StepDefenition"}, tags="@DeletePlace",plugin ="json:target/jsonreports/cucumber-report.son")
public class TestRunner {

}
