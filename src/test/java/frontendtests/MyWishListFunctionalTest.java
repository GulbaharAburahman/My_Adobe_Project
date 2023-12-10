package frontendtests;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.PublicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyWishListFunctionalTest extends BaseClass {

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
            email = utilityClass.getCellData(excelFilePath, 0, 2, 2);
            password = utilityClass.getCellData(excelFilePath, 0, 2, 3);
            publicPage.loginToAccount(email, password);
            Assert.assertTrue(publicPage.isLoginSuccessful());
        }

        @Test(description = "A registered user should be able add product to myWishlist")
        public void addProductToMyWishlist() throws IOException, InterruptedException {
            String rootCategory = utilityClass.getCellData(excelFilePath, 1, 2, 0);
            String subCategory = utilityClass.getCellData(excelFilePath, 1, 2, 1);
            String productName = utilityClass.getCellData(excelFilePath, 1, 2, 2);
            System.out.println(productName);
            publicPage.addProductToWishList(true, rootCategory, subCategory, productName);
            Assert.assertTrue(publicPage.isAddTOWishListSuccessful());
        }




    }

