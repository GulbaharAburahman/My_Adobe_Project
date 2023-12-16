package frontendtests;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.PublicPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartFunctionalTest extends BaseClass {
    PublicPage publicPage;

    @BeforeClass
    public void setup(){
        launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties","browser")));
        navigateToPublicPage();
        publicPage =new PublicPage(driver);
    }

    @Test
    public void addProduct(){
        publicPage.addProductToShoppingCart1("home and decor","electronic","8GB Memory Card");
        Assert.assertTrue(publicPage.isAddToCartSuccessful());
    }

    @AfterClass()
        public void tearDown(){
           teardown();
        }


}
