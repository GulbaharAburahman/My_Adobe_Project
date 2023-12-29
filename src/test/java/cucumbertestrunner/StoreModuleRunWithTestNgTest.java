package cucumbertestrunner;
import com.unitedcoder.backend.DashBoardPage;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.TestBase;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = {"src/test/resources/features/StoreModule2.feature"},
        glue = {"stepdefinitions"},
        plugin = {"pretty","html:test-output/cucumber-htm-report.html",
                "json:test-output/JSONReports/report.jason"},
        monochrome = true

     //   tags = "not @ignore"

)
public class StoreModuleRunWithTestNgTest extends AbstractTestNGCucumberTests {

 public static WebDriver driver;
DashBoardPage dashBoardPage;

@BeforeClass
    public void setup(){
    TestBase.launchBrowser(BrowserType.CHROME);
    TestBase.navigateToBackEnd();
    driver= TestBase.driver;
    dashBoardPage =new DashBoardPage(driver);
    LoginToAdminPage loginToAdminPage=new LoginToAdminPage(driver);
    loginToAdminPage.loginToAdminPanelWithCredentials("StoreManager");


}


@AfterClass
    public void teardown(){
    dashBoardPage.logout();
    TestBase.teardown();
}

}
