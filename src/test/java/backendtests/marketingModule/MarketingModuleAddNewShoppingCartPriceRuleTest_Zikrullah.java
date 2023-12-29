package backendtests.marketingModule;


import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.marketingmodule.PromotionsPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class MarketingModuleAddNewShoppingCartPriceRuleTest_Zikrullah extends BaseClass {

   PromotionsPage promotionsPage;
  FunctionLibrary functionLibrary;

    @BeforeClass
    public void setUp() {
launchBrowser(BrowserType.CHROME);
navigateToBackEnd();
LoginToAdminPage loginPage = new LoginToAdminPage(driver);
        loginPage.loginToAdminPanelWithCredentials("marketingmanager");
         functionLibrary = new FunctionLibrary(driver);
         promotionsPage=new PromotionsPage(driver);
    }

    @Test( description = "Marketing Manager can add new Cart Price Rule ")
    public void catalogAddProduct() throws AWTException {
        promotionsPage.navegateToAddNewRulePage();
        promotionsPage.fillRuleInformation("alma"," this is a test rule","Active","Donnell Harvey",
                "group4","No Coupon","1","No" );
        promotionsPage.conditions("Conditions","Conditions combination");
        promotionsPage.actions("Fixed amount discount","2500","3500","222",
                "Yes","For shipment with matching items","Conditions Combination");
        promotionsPage.labels("books");
        Assert.assertTrue(promotionsPage.verifyNewProductAdded());

    }
    @AfterClass
    public void teraDown(){
    teardown();

    }
}
