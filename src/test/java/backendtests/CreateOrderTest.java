package backendtests;

import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.storemodule.StorePage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateOrderTest extends BaseClass {
    StorePage storePage;
    LoginToAdminPage loginToAdminPage;

    String filePath="testdata/gulbahar.xlsx";
    String email;
    String storeName;
    String productId;
    String customPrice;
    String quantity;
    String paymentMethod;
    String orderNumber;
    String groupName;


    @BeforeClass
    public  void setup() throws IOException {
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        loginToAdminPage=new LoginToAdminPage(driver);
        storePage=new StorePage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("storeManager");
        email=UtilityClass.getCellData(filePath,3,1,0);
        storeName=UtilityClass.getCellData(filePath,3,1,1);
        groupName=UtilityClass.getCellData(filePath,3,1,2);
        productId=UtilityClass.getCellData(filePath,3,1,3);
        customPrice=UtilityClass.getCellData(filePath,3,1,4);
        quantity=UtilityClass.getCellData(filePath,3,1,5);
        paymentMethod=UtilityClass.getCellData(filePath,3,1,6);
        orderNumber=UtilityClass.getCellData(filePath,3,1,7);

    }

    @Test(priority = 1)
    public void createAnOrder() throws IOException {
        storePage.createANewOrder(email,storeName,groupName,productId,customPrice,quantity,paymentMethod);
        String orderNum=storePage.getOrderNumber();
        UtilityClass.WriteCellData(filePath,3,1,7,orderNum);
        Assert.assertTrue(storePage.isOrderCreated());
    }


    @Test(priority = 2)
    public void editAnExistingOrder(){
        storePage.editMyOrder(orderNumber,"1");
        Assert.assertTrue(storePage.isOrderUpdated());
    }

    @Test(priority = 3)
    public void cancelOrder(){
        storePage.cancelOrder(orderNumber);
        Assert.assertTrue(storePage.isOrderCancelled());
    }





}
