package backendtests.marketingModule;


import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.marketingmodule.PromotionsPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteCatalogPricingRuleTest extends BaseClass {
    LoginToAdminPage loginToAdminPage;
    PromotionsPage promotionsPage;

    String categoryPricingRuleName = "you can delete me-Team4 Catalog Pricing Rule";

    @BeforeClass
    public void setup() {
        launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties", "browser")));
        navigateToBackEnd();
        loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("marketingManager");
        promotionsPage = new PromotionsPage(driver);
    }

    @Test(priority = 1, description = "Marketing Manager can delete an existing Catalog Price Rule ")
    public void deleteCatalogPriceRule() {
        promotionsPage.addNewCatalogPriceRule(categoryPricingRuleName, "This is Catalog Price Rule for Team4 Testing", "Active",
                "Team4-Website", "Team4 - Sweden", "12/23/2023", "12/23/2024", "To Percentage", "30");
        String ruleId = promotionsPage.getIdOfCatalogPriceRule(categoryPricingRuleName);
        promotionsPage.deleteMyCategoryPricingRule(categoryPricingRuleName, ruleId);
        Assert.assertTrue(promotionsPage.isNewCategoryPriceRuleCreated());
    }

    @AfterTest
    public void tearDown() {
        teardown();
    }

}
