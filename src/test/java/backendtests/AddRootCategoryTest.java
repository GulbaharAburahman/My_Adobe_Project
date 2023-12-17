package backendtests;


import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.catalogmodule.CatalogPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRootCategoryTest extends BaseClass {
    CatalogPage catalogPage;
    LoginToAdminPage loginToAdminPage;

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
        String rootCatName = "Team4-RootCategory" + FunctionLibrary.getTimeStamp();
        catalogPage.addRootCategory(rootCatName, "Yes", "Yes",
                "Sport shoes");
        Assert.assertTrue(catalogPage.isRootCategoryAdded(rootCatName));

    }

    @AfterClass
    public void tearDown() {
        tearDown();
    }


}
