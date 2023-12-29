package cucumbertestrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/ReportingModule.feature",
        glue={"stepdefinitions"},
        plugin = {"html:test-output/cucumber-reports/cucumberTestReport.html","json:test-output/cucumber-reports/cucumber.jason"},
        monochrome = true
       )
public class ReportingModuleWithTestNGTest extends AbstractTestNGCucumberTests {
}
