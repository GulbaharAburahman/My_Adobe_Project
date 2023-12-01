package frontpagetestcases;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.StoreFrontPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class publicPageFunctionalTest extends BaseClass {
    StoreFrontPage storeFrontPage;
    BaseClass baseClass;
    UtilityClass utilityClass =new UtilityClass();
    String excelFilePath="testdatafolder/my.xlsx";
    @BeforeClass
    public void setup(){
       baseClass=new BaseClass();
       baseClass.launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties","browser")));
       baseClass.navigateToPublicPage();
       storeFrontPage=new StoreFrontPage(baseClass.driver);
    }

    @Test(priority = 1, description = "A user should be able to create an account")
    public void publicUserCreateAccount() throws IOException, InvalidFormatException {
        String firstname= FunctionLibrary.getFakeFirstname();
        String lastname=FunctionLibrary.getFakeLastname();
        String email=FunctionLibrary.getFakeEmail();
        String password=FunctionLibrary.getPassword();
        storeFrontPage.createAccount(firstname,lastname,email,password);
        Assert.assertTrue(storeFrontPage.isAccountCreated());
        storeFrontPage.logout();
        ArrayList<String> userInfo=new ArrayList<>(List.of(firstname,lastname,email,password));
        utilityClass.writeListToExistingExcel(excelFilePath,0,2,userInfo);
    }

    @Test (priority = 2,description = "A registered user can login to His/Her Account with valid credentials")
    public void loginToAccount () throws IOException {
     String email=utilityClass.getCellData(excelFilePath,0,2,2);
     String password=utilityClass.getCellData(excelFilePath,0,2,3);
    storeFrontPage.loginToAccount(email,password);
    Assert.assertTrue(storeFrontPage.isLoginSuccessful());
    }

    @Test(priority = 3,description = "A user should be able to add products to shopping cart ")
    public void  addProductToShoppingCart() throws IOException {
    String rootCategory= utilityClass.getCellData(excelFilePath,1,2,0);
    String subCategory= utilityClass.getCellData(excelFilePath,1,2,1);
    String productName=utilityClass.getCellData(excelFilePath,1,2,2);
    storeFrontPage.addToCart(rootCategory,subCategory,productName);
    Assert.assertTrue(storeFrontPage.isSuccessMessageDisplayed());
    }
@AfterClass
    public void tearDown(){
        baseClass.teardown();
}
















}
