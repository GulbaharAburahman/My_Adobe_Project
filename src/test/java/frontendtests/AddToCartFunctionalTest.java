package frontendtests;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.PublicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartFunctionalTest extends BaseClass {
    PublicPage publicPage;
    UtilityClass utilityClass =new UtilityClass();
    String excelFilePath="testdata/gulbahar.xlsx";
    String email;
    String password;
    @BeforeClass
    public void setup(){
        launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties","browser")));
        navigateToPublicPage();
        publicPage =new PublicPage(driver);
    }

    @Test
    public void addProduct(){
        publicPage.addProductToCart(true,"home and decor","electronic","8GB Memory Card");
        Assert.assertTrue(publicPage.isAddToCartSuccessful());
    }

}
