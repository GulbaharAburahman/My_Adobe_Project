package backendtests;


import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.catalogmodule.CatalogPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddUpdateDeleteRootCategoryTest extends BaseClass {
    CatalogPage catalogPage;
    LoginToAdminPage loginToAdminPage;
    String rootCatName = "Team4-RootCategory";
    String  productName="I Love You to the Moon and Back_DON'T DELETE";

    @BeforeClass
    public void setup() {
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("CatalogManager");
        catalogPage = new CatalogPage(driver);
    }

    @Test(description = "Category Manager should be able to add a new root category")
    public void addNewRootCategory() throws InterruptedException {
        catalogPage.addRootCategory(rootCatName, "Yes", "Yes",
                productName);
        Assert.assertTrue(catalogPage.isRootCategoryAdded(rootCatName));

    }

    @Test(description = "Category Manager Should able to update an existing root category" )
    public void updateRootCategory() throws InterruptedException {
        String activeFrom="01/08/2024";
        String activeTo="01/30/2025";
        catalogPage.updateRootCategory(rootCatName,activeFrom,activeTo);
        Assert.assertTrue(catalogPage.isCategoryUpdated());
    }

    @Test(description = "Category Manager should able to delete an existing root category")
    public void deleteCategory() throws InterruptedException {
        catalogPage.deleteRootCategory(rootCatName);
        Assert.assertTrue(catalogPage.isCategoryDeleted());
    }

    @AfterClass
    public void tearDown() {
        teardown();
    }


}
