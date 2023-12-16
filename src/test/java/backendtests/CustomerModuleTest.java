package backendtests;

import com.github.javafaker.Faker;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.customerModule.CustomerPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.commonuse.UtilityClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerModuleTest extends BaseClass {
    CustomerPage customerPage;
    @BeforeClass
    public void setup(){
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        LoginToAdminPage loginToAdminPage=new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("customerManager");
        customerPage=new CustomerPage(driver);
    }

    @Test(priority = 1,description = "Customer Manager should able to add new customer ",dataProvider = "getCustomerInfo")
    public void addCustomer(String webSite,String groupName,String firstname,String middleName, String lastname,String email,
                            boolean useCalender,String DOB,String gender,boolean welcomeMail,String password){
        customerPage.addCustomer(webSite,groupName,firstname,middleName, lastname,email,useCalender,DOB,gender,welcomeMail,password);
        Assert.assertTrue(customerPage.isCustomerAdded());
    }

    @Test (priority = 2,description = "customer manager should be able to update customer information",dataProvider = "getCustomerInfo" )
    public void updateCustomerInfo(String webSite,String groupName,String firstname,String middleName, String lastname,String email,
                                   boolean useCalender,String DOB,String gender,boolean welcomeMail,String password ) throws InterruptedException {
        String newDOB = "08/18/1988";
        customerPage.updateCustomer(email,middleName+firstname,newDOB);
        Assert.assertTrue(customerPage.isCustomerInfoUpDated());
    }

    @Test(priority = 3,description = "Customer Manager Should be able to Delete an existing Customer",dataProvider = "getCustomerInfo")
    public void deleteCustomer(String webSite,String groupName,String firstname,String middleName, String lastname,String email,
                               boolean useCalender,String DOB,String gender,boolean welcomeMail,String password) throws InterruptedException {
        customerPage.deleteCustomer(email);
        Assert.assertTrue(customerPage.isCustomerDeleted());
    }



    @AfterClass()
    public void tearDown(){
        teardown();
    }


    @DataProvider
    public Object[][] getCustomerInfo(){
        Object[][] customerInfo ={ { "Admin","Senem" ,"Johny","Jim","Den","jim2@gamil.com",true,"12/22/1998","Male",true,"1234567"} };
        return customerInfo;
    }



}
