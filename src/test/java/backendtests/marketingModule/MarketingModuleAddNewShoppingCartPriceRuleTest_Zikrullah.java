package backendtests.marketingModule;


import com.seleniummaster.backend.LoginToAdminPage;
import com.seleniummaster.backend.marketingmodule.PromotionsPage;
import com.seleniummaster.commonuse.BaseClass;
import com.seleniummaster.commonuse.BrowserType;
import com.seleniummaster.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * @author : ELMA
 * @created : 12/12/2023,5:49 PM
 * @Email : elma231199@gmail.com
 **/
public class MarketingModuleAddNewShoppingCartPriceRuleTest_Zikrullah extends BaseClass {

    BaseClass baseClass;
   PromotionsPage promotionsPage;
  FunctionLibrary functionLibrary;

    @BeforeClass
    public void setUp() {
      baseClass = new BaseClass();
        baseClass.launchBrowser(BrowserType.CHROME);
        WebDriver driver = baseClass.driver;
        baseClass.navigateToBackEnd();
        LoginToAdminPage loginPage = new LoginToAdminPage(baseClass.driver);
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
     baseClass.teardown();

    }
}
