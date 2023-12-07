package backendtests;

import com.unitedcoder.backend.DashBoardPage;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BackEndLoginTest extends BaseClass {
    LoginToAdminPage loginPage;
    DashBoardPage dashBoardPage;

    @BeforeClass
    public void setup(){
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        System.out.println("at login :"+ driver.getTitle());
        loginPage=new LoginToAdminPage(driver);
        dashBoardPage=new DashBoardPage(driver);
    }
    @Test
    public void loginAsCustomerManager(){
        loginPage.loginToAdminPanelWithCredentials("customerManager");
       Assert.assertTrue(dashBoardPage.isLoginSuccessful("customerManager"));
        dashBoardPage.logout();
    }

    @Test
    public void loginAsCatalogManager(){
        loginPage.loginToAdminPanelWithCredentials("catalogManager");
        Assert.assertTrue( dashBoardPage.isLoginSuccessful("catalogManager"));
        dashBoardPage.logout();
    }

    @Test
    public void loginAsSalesManager(){
        loginPage.loginToAdminPanelWithCredentials("catalogManager");
        Assert.assertTrue( dashBoardPage.isLoginSuccessful("catalogManager"));
        dashBoardPage.logout();
    }

    @Test
    public void loginAsStoreManager(){
        loginPage.loginToAdminPanelWithCredentials("StoreManager");
        Assert.assertTrue( dashBoardPage.isLoginSuccessful("StoreManager"));
        dashBoardPage.logout();
    }
    @Test
    public void loginAsReportingManager(){
        loginPage.loginToAdminPanelWithCredentials("ReportingManager");
        Assert.assertTrue( dashBoardPage.isLoginSuccessful("ReportingManager"));
        dashBoardPage.logout();
    }
    @Test
    public void loginAsMarketingManager(){
        loginPage.loginToAdminPanelWithCredentials("MarketingManager");
        Assert.assertTrue( dashBoardPage.isLoginSuccessful("MarketingManager"));
        dashBoardPage.logout();
    }




    @AfterClass
    public void tearDown(){
        teardown();
    }



}
