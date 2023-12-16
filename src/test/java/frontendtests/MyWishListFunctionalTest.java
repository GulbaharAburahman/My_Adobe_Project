package frontendtests;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.PublicPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.unitedcoder.commonuse.UtilityClass.getCellData;

public class MyWishListFunctionalTest extends BaseClass {

        PublicPage publicPage;
        String excelFilePath = "testdata/gulbahar.xlsx";
        String email;
        String password;

        @BeforeClass
        public void setup() throws IOException {
            launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties", "browser")));
            navigateToPublicPage();
            publicPage = new PublicPage(driver);
            email = getCellData(excelFilePath, 0, 2, 2);
            password = getCellData(excelFilePath, 0, 2, 3);
            publicPage.loginToAccount(email, password);
            Assert.assertTrue(publicPage.isLoginSuccessful());
        }

        @Test(description = "A registered user should be able add product to myWishlist")
        public void addProductToMyWishlist() throws IOException, InterruptedException {
            String rootCategory = getCellData(excelFilePath, 1, 1, 0);
            String subCategory = getCellData(excelFilePath, 1, 1, 1);
            String productName = getCellData(excelFilePath, 1, 1, 2);
            System.out.println(productName);
            publicPage.addProductToWishList( rootCategory, subCategory,productName);
            Assert.assertTrue(publicPage.isAddTOWishListSuccessful());
        }

       @AfterClass
    public void tearDown(){
            teardown();
       }




    }

