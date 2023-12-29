package backendtests.marketingModule;


import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.marketingmodule.PromotionsPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
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
