package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/OrangeHRM.feature",
        glue = {"stepDefinitions"},
        plugin = {"utils.ExtentReportsUtil"},
        monochrome = true

)
public class OrangeHRMTestRunner {
}
