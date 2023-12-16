package backendtests;

import com.github.javafaker.Faker;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.customerModule.CustomerPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddCustomerTest extends BaseClass {
    CustomerPage customerPage;
    @BeforeClass
    public void setup(){
        launchBrowser(BrowserType.CHROME);
         navigateToBackEnd();
        LoginToAdminPage loginToAdminPage=new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("customerManager");
        customerPage=new CustomerPage(driver);
    }

    @Test()
    public void addCustomer(){
     String firstName=FunctionLibrary.getFakeFirstname();
     String lastname=FunctionLibrary.getFakeLastname();
     String password=FunctionLibrary.getPassword();
     String email=FunctionLibrary.getFakeEmail();
     String DOB= "13/02/1988";
     String middleName=Faker.instance().name().nameWithMiddle();
    customerPage.addCustomer("Admin","Senem",firstName,middleName,lastname,email,true,DOB,"Female",
             true,password);
    Assert.assertTrue(customerPage.isCustomerAdded());
    }

  @AfterClass()
    public void tearDown(){
        teardown();
    }

}
