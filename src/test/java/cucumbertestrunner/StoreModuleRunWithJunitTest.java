package cucumbertestrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
glue ={"stepdefinitions"},
monochrome = true,
plugin ={"pretty","junit::target/JunitReports/report.xml","json::target/JSONReports/report.jason"})

public class TestRunnerForStoreModule {


}
