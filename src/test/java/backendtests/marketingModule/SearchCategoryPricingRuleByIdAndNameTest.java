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

public class SearchCategoryPricingRuleByIdAndNameTest extends BaseClass {
    LoginToAdminPage loginToAdminPage;
    PromotionsPage promotionsPage;

    String categoryPricingRuleName = "Do not Delete-Team4 Catalog Price Rule ";

    @BeforeClass
    public void setup() {
        launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties", "browser")));
        navigateToBackEnd();
        loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("marketingManager");
        promotionsPage = new PromotionsPage(driver);
    }

    @Test(description = "Marketing Manager can search Catalog Pricing Rule By Id and Rule.")
    public void searchCatalogPricingRuleByIdAndName() {
        String id = promotionsPage.getIdOfCatalogPriceRule(categoryPricingRuleName);
        promotionsPage.searchCatalogPricingRuleByIdAndRuleName(categoryPricingRuleName, id);
        Assert.assertTrue(promotionsPage.isSearchCategoryPricingRuleSuccessful());
    }

    @AfterClass()
    public void tearDown() {
        teardown();
    }


}
