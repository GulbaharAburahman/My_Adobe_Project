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

public class DeleteCustomerTest extends BaseClass {
    LoginToAdminPage loginToAdminPage;
    CustomerPage customerPage;

    @BeforeClass
    public void setUp(){
      launchBrowser(BrowserType.CHROME);
      navigateToBackEnd();
      loginToAdminPage=new LoginToAdminPage(driver);
      customerPage=new CustomerPage(driver);
      loginToAdminPage.loginToAdminPanelWithCredentials("customerManager");
    }





    @Test(description = "Customer Manager Should be able to Delete an existing Customer")
    public void deleteCustomer() throws InterruptedException {
        String firstName= FunctionLibrary.getFakeFirstname();
        String lastname=FunctionLibrary.getFakeLastname();
        String password=FunctionLibrary.getPassword();
        String email=FunctionLibrary.getFakeEmail();
        String DOB= "13/02/1988";
        String middleName= Faker.instance().name().nameWithMiddle();
        customerPage.addCustomer("Admin","Senem",firstName,middleName,lastname,email,true,DOB,"Female",
                true,password);
        FunctionLibrary.sleep(2);
        customerPage.deleteCustomer(email);
        Assert.assertTrue(customerPage.isCustomerDeleted());
    }


    @AfterClass()
    public void tearDown(){
        teardown();
    }




}
