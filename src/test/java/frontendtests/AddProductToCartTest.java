package frontendtests;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.frontend.PublicPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddProductToCartTest extends BaseClass {

    PublicPage publicPage;

    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser(BrowserType.CHROME);
        context.setAttribute("driver", driver);
        navigateToPublicPage();
        publicPage = new PublicPage(driver);
    }

    @Test(description = "The user should be able to add product to shopping cart as a guest", dataProvider = "Product info")
    public void addProductToShoppingCartAsGuest( String rootCategory, String subCategory, String productName) {
        publicPage.addProductToShoppingCart1( rootCategory, subCategory, productName);
        Assert.assertTrue(publicPage.isAddToCartSuccessful());
    }


    @DataProvider(name = "Product info")
    public Object[][] getProductData() {
        return new Object[][]{
                {"Excellent Home & Decor", "Electronics", "Madison Earbuds"},
                {"Accessories", "Bags & Luggage", "Houston Travel Wallet"}
        };
    }


    @AfterClass
    public void tearDown(){
        teardown();
    }




}
