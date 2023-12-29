package stepdefinitions;

import com.unitedcoder.backend.DashBoardPage;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.storemodule.StorePage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.TestBase;
import com.unitedcoder.commonuse.UtilityClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class StoreModuleSteps extends TestBase {


LoginToAdminPage loginToAdminPage;
    StorePage storePage=new StorePage(driver);
    DashBoardPage dashBoardPage;
    String filePath = "testdata/gulbahar.xlsx";
    String email = UtilityClass.getCellData(filePath, 3, 1, 0);
    String storeName = UtilityClass.getCellData(filePath, 3, 1, 1);
    String groupName = UtilityClass.getCellData(filePath, 3, 1, 2);
    String productId = UtilityClass.getCellData(filePath, 3, 1, 3);
    String customPrice = UtilityClass.getCellData(filePath, 3, 1, 4);
    String quantity = UtilityClass.getCellData(filePath, 3, 1, 5);
    String paymentMethod = UtilityClass.getCellData(filePath, 3, 1, 6);


    public StoreModuleSteps() throws IOException {
    }

    @Given("Login to Admin Panel Page")
    public void goToLoginToAdminPanelPage() {
       launchBrowser(BrowserType.CHROME);
     navigateToBackEnd();
     storePage=new StorePage(driver);
     dashBoardPage=new DashBoardPage(driver);
    }

    @When("enter Valid username and password for Store Manager Role String {string}")
    public void login(String arg0) {
        loginToAdminPage=new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials(arg0);
    }


    @Then("Logged into Dashboard")
    public void loggedIntoDashboard() {
        dashBoardPage=new DashBoardPage(driver);
        Assert.assertTrue(dashBoardPage.isLoginSuccessful("StoreManager"));
    }


    @Given("on Store Manager Dashboard Page")
    public void onStoreManagerDashboardPage() {
         dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.isLoginSuccessful("StoreManager");
    }

    @When("user clicks on create order and follow the steps pick the store and add products and related information")
    public void createNewOrder() throws IOException {
        storePage.createANewOrder(email, storeName, groupName, productId, customPrice, quantity, paymentMethod);
        String orderNum=storePage.getOrderNumber();
        UtilityClass.WriteCellData(filePath,3,1,7,orderNum);
    }

    @Then("new order should be created")
    public void newOrderShouldBeCreated() {
        Assert.assertTrue(storePage.isOrderCreated());
    }

    @When("user finds specific order from data table and edit by following steps and save")
    public void updateOrder() throws IOException {
        String orderNumber = UtilityClass.getCellData(filePath, 3, 1, 7);
        storePage.editMyOrder(orderNumber, quantity);
    }

    @Then("success confirmation message should displays")
    public void validateUpdatingOrder() {
        Assert.assertTrue(storePage.isOrderUpdated());
    }


    @When("user find the specific order from data table and click on cancel button and accept alert")
    public void cancelOrder() throws IOException {
        String orderNumber = UtilityClass.getCellData(filePath, 3, 1, 7);
        storePage.cancelOrder(orderNumber);
    }

    @Then("confirmation message should displays for cancellation")
    public void validateCancelingOrder() {
        Assert.assertTrue(storePage.isOrderCancelled());
    }
    @And("user should logout and close the browser")
    public void userShouldLogoutAndClose() {
        dashBoardPage.logout();
        teardown();
    }





}