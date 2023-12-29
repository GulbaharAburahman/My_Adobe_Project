package backendtests.marketingModule;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.marketingmodule.NewsLetterPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ViewNewsletterSubscribersTest_Adil extends BaseClass {
    NewsLetterPage newsletterPage;
    FunctionLibrary functionLibrary;
    LoginToAdminPage loginToAdminPage;
    @BeforeTest
    public void setUp(){
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        newsletterPage=new NewsLetterPage(driver);
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
