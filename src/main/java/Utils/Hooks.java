package hooks;

import Utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Utils.ExtentReportManager;

public class Hooks {
    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().fail("Scenario Failed: " + scenario.getName());
        } else {
            test.get().pass("Scenario Passed: " + scenario.getName());
        }
        extent.flush();
    }

    public static ExtentTest getTest() {
        return  test.get();
    }
}
