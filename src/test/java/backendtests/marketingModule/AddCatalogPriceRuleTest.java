package backendtests.marketingModule;

import com.seleniummaster.backend.LoginToAdminPage;
import com.seleniummaster.backend.marketingmodule.PromotionsPage;
import com.seleniummaster.commonuse.BaseClass;
import com.seleniummaster.commonuse.BrowserType;
import com.seleniummaster.commonuse.UtilityClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddCatalogPriceRuleTest extends BaseClass {
    LoginToAdminPage loginToAdminPage;
    PromotionsPage promotionsPage;

    String categoryPricingRuleName = "Team4 Category Pricing Rule";

    @BeforeClass
    public void setup() {
        launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties", "browser")));
        navigateToBackEnd();
        loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("marketingManager");
        promotionsPage = new PromotionsPage(driver);
    }

    @Test(description = "Marketing Manager can add new Catalog Price Rule ")
    public void addNewCatalogPriceRule() {
        promotionsPage.addNewCatalogPriceRule(categoryPricingRuleName, "This is A rule for testing porpuse only", "Active",
                "Team4-Website", "Team4 - Sweden", "12/22/2023", "01/26/2024", "By Percentage", "15");
        Assert.assertTrue(promotionsPage.isNewCategoryPriceRuleCreated());
    }

    @AfterClass
    public void tearDown() {
        teardown();
    }

}
