package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/S2.feature",tags = "@R2", glue="StepDefenitions",plugin = {"pretty", "html:target/cucumber-reports.html"})
public class TestRunner {

}
