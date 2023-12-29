package cucumbertestrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/ReportingModule.feature"},
        glue ={"stepdefinitions"},
        monochrome = true,
        plugin ={"pretty","html:test-output/cucumber-htm-report.html","junit:test-output/JunitReports/report.xml","json:test-output/JSONReports/report.jason"}
)
public class ReportingModuleTest {

}
