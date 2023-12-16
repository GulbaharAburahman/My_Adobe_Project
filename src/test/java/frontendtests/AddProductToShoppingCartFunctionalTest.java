package frontendtests;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.PublicPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddProductToShoppingCartFunctionalTest extends BaseClass {
    PublicPage publicPage;
    UtilityClass utilityClass = new UtilityClass();
    String excelFilePath = "testdata/gulbahar.xlsx";
    String email;
    String password;
    @BeforeClass
    public void setup() throws IOException {
        launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties", "browser")));
        navigateToPublicPage();
        publicPage = new PublicPage(driver);
        email= UtilityClass.getCellData(excelFilePath,0,2,2);
        password= UtilityClass.getCellData(excelFilePath,0,2,3);
        publicPage.loginToAccount(email,password);
        Assert.assertTrue(publicPage.isLoginSuccessful());
    }

        @Test(description = "A user should be able view products under the subcategory and add a product to shopping cart")
        public void addProductToShoppingCart () throws IOException, InterruptedException {
            String rootCategory = UtilityClass.getCellData(excelFilePath, 1, 2, 0);
            String subCategory = UtilityClass.getCellData(excelFilePath, 1, 2, 1);
            String productName=  UtilityClass.getCellData(excelFilePath, 1, 2, 2);
            System.out.println(productName);
            publicPage.addProductToCart(rootCategory,subCategory,productName);
            Assert.assertTrue(publicPage.isAddToCartSuccessful());
        }

    @Test(description = "A user should be able view all products under the root category and add a products to shopping cart")
    public void addToCartFromViewAllProducts () throws IOException, InterruptedException {
        String rootCategory = UtilityClass.getCellData(excelFilePath, 1, 3, 0);
        String subCategory = UtilityClass.getCellData(excelFilePath, 1, 3, 1);
        String productName=  UtilityClass.getCellData(excelFilePath, 1, 3, 2);
        System.out.println(productName);
        publicPage.addProductToShoppingCart1(rootCategory,subCategory,productName);
        FunctionLibrary.sleep(2);
        Assert.assertTrue(publicPage.isAddToCartSuccessful());
    }

  @AfterClass
  public void tearDown(){
     teardown();
 }


    }
