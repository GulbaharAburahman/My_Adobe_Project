import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.commonuse.UtilityClass;
import com.unitedcoder.frontend.StoreFrontPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class publicPageFunctionalTest extends BaseClass {

    StoreFrontPage storeFrontPage;
    UtilityClass utilityClass =new UtilityClass();
    BaseClass baseClass;

    String excelFilePath="testdatafolder/my.xlsx";
    @BeforeClass
    public void setup(){
       baseClass=new BaseClass();
       baseClass.launchBrowser(BrowserType.valueOf(UtilityClass.readFromConfig("config.properties","browser")));
       baseClass.navigateToPublicPage();
       storeFrontPage=new StoreFrontPage(baseClass.driver);
    }

    @Test(description = "A user should be able to create an account")
    public void publicUserCreateAccount() throws IOException, InvalidFormatException {

        String firstname= FunctionLibrary.getFakeFirstname();
        String lastname=FunctionLibrary.getFakeLastname();
        String email=FunctionLibrary.getFakeEmail();
        String password=FunctionLibrary.getPassword();
        storeFrontPage.createAccount(firstname,lastname,email,password);
        Assert.assertTrue(storeFrontPage.isAccountCreated());
        // write created data to Excel file to use in login test
        utilityClass.writeToExistingExcel(excelFilePath,0,1,0,1,2,3,firstname,lastname,email,password);
    }

    @Test (description = "A registered user can login to His/Her Account with valid credentials")
    public void loginToAccount () throws IOException {
    String email= utilityClass.readDataFromExcelColumn(excelFilePath,0,1,2);
    String password = utilityClass.readDataFromExcelColumn(excelFilePath,0,1,3);
    storeFrontPage.loginToAccount(email,password);
    Assert.assertTrue(storeFrontPage.isLoginSuccessful());
    }















}
