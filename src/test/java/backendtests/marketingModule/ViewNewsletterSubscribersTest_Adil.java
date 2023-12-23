package backendtests.marketingModule;

import com.seleniummaster.backend.LoginToAdminPage;
import com.seleniummaster.backend.marketingmodule.NewsletterPage;
import com.seleniummaster.commonuse.BaseClass;
import com.seleniummaster.commonuse.BrowserType;
import com.seleniummaster.commonuse.FunctionLibrary;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ViewNewsletterSubscribersTest_Adil extends BaseClass {
    NewsletterPage newsletterPage;
    FunctionLibrary functionLibrary;
    LoginToAdminPage loginToAdminPage;
    @BeforeTest
    public void setUp(){
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        newsletterPage=new NewsletterPage(driver);
        functionLibrary=new FunctionLibrary(driver);
        loginToAdminPage=new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("marketingmanager");
    }
    @Test(description = "Marketing Manager can view newsletter subscribers ")
    public void viewNewsletterSubscribers(){
        newsletterPage.viewNewsletterSubscribers();
        Assert.assertTrue(newsletterPage.isViewNewsletterSubscribers());
    }
    @AfterClass
    public void tearDown(){
        teardown();
    }
}
