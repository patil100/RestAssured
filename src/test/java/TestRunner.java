package runners; // ✅ Make sure this matches the folder location

import  io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",     // ✅ Feature file path
        glue = "stepdefinitions",                // ✅ Step definitions package
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class TestRunner {
}
