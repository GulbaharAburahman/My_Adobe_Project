package frontpagetestcases;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.PublicPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class publicPageFunctionalTest extends BaseClass {
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

    @Test(priority = 1, description = "A user should be able to create an account")
    public void publicUserCreateAccount() throws IOException, InvalidFormatException {
        String firstname= FunctionLibrary.getFakeFirstname();
        String lastname=FunctionLibrary.getFakeLastname();
        String email=FunctionLibrary.getFakeEmail();
        String password=FunctionLibrary.getPassword();
        publicPage.createAccount(firstname,lastname,email,password);
        Assert.assertTrue(publicPage.isAccountCreated());
        publicPage.logout();
        ArrayList<String> userInfo=new ArrayList<>(List.of(firstname,lastname,email,password));
        utilityClass.writeListToExistingExcel(excelFilePath,0,2,userInfo);
    }

    @Test (priority = 2,description = "A registered user can login to His/Her Account with valid credentials")
    public void loginToAccount () throws IOException {
    email=utilityClass.getCellData(excelFilePath,0,2,2);
    password=utilityClass.getCellData(excelFilePath,0,2,3);
    publicPage.loginToAccount(email,password);
    Assert.assertTrue(publicPage.isLoginSuccessful());
    }

    @Test(priority = 3,description = "A user should be able to add products to shopping cart")
    public void  addProductToShoppingCart() throws IOException {
    String rootCategory= utilityClass.getCellData(excelFilePath,1,1,0);
    String subCategory= utilityClass.getCellData(excelFilePath,1,1,1);
    String productName=utilityClass.getCellData(excelFilePath,1,1,2);
    publicPage.addToCart(true,rootCategory,subCategory,productName);
    Assert.assertTrue(publicPage.isSuccessMessageDisplayed());
    }

    @Test (priority = 4,description ="A user should be able to view My wish list")
      public void  viewMyWishList() throws IOException {
        String rootCategory= utilityClass.getCellData(excelFilePath,1,1,0);
        String subCategory= utilityClass.getCellData(excelFilePath,1,1,1);
        String productName=utilityClass.getCellData(excelFilePath,1,1,2);
       publicPage.addToWishlist(false,rootCategory,subCategory,productName);
       Assert.assertTrue(publicPage.viewMyWishList(productName));
       publicPage.logout();
    }

    @Test(priority =5, description = "A user should be able to check out the order")
    public void checkoutOrder() throws InterruptedException, IOException {
        email=utilityClass.getCellData(excelFilePath,0,2,2);
        password=utilityClass.getCellData(excelFilePath,0,2,3);
        publicPage.loginToAccount(email,password);
      publicPage.checkOutMyOrderAfterLogin(FunctionLibrary.getFakeAddress(),"Baltimore","21201",FunctionLibrary.getFakeTelNum(),
              "United States","Maryland ","flat rate","check / money order",null);
        Assert.assertTrue(publicPage.isCheckoutOrderSuccessful());
        publicPage.logout();

    }

    @Test(description = "A user should see News Letter Subscriptions Link and contents.")
    public void seeNewsLetter(){
        publicPage.loginToAccount("timthomas@gmail.com","1234567");
        publicPage.seeNewsLetterSubscriptionsLink();
        Assert.assertTrue(publicPage.isNewsLetterPageOpened());
    }



    @AfterClass
    public void tearDown(){
        teardown();
    }







    }























