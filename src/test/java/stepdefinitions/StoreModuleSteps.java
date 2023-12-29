import com.unitedcoder.backend.DashBoardPage;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.storemodule.StorePage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.UtilityClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.Assert;

import java.io.IOException;

public class StoreModuleSteps extends  BaseClass {

    StorePage storePage;
    DashBoardPage dashBoardPage;
    String filePath = "testdata/gulbahar.xlsx";
    String email = UtilityClass.getCellData(filePath, 3, 1, 0);
    String storeName = UtilityClass.getCellData(filePath, 3, 1, 1);
    String groupName = UtilityClass.getCellData(filePath, 3, 1, 2);
    String productId = UtilityClass.getCellData(filePath, 3, 1, 3);
    String customPrice = UtilityClass.getCellData(filePath, 3, 1, 4);
    String quantity = UtilityClass.getCellData(filePath, 3, 1, 5);
    String paymentMethod = UtilityClass.getCellData(filePath, 3, 1, 6);
    String orderNumber = UtilityClass.getCellData(filePath, 3, 1, 7);

    public StoreModuleSteps() throws IOException {
    }


    @Given("Backend Admin Panel Login Page")
    public void backendAdminPanelLoginPage() {
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        storePage = new StorePage(driver);
        dashBoardPage = new DashBoardPage(driver);

    }

    @When("enter valid username and password and click on login button")
    public void enterValidUsernameAndPasswordAndClickOnLoginButton() {
        LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("StoreManager");
    }

    @Then("Admin Dashboard Page displays")
    public void adminDashboardPageDisplays() {
        dashBoardPage.isLoginSuccessful("StoreManager");
    }

    @Given("on Store Manager Dashboard Page")
    public void onStoreManagerDashboardPage() {
        dashBoardPage.isLoginSuccessful("StoreManager");
    }

    @When("user clicks on create order and follow the steps pick the store and add products and related information")
    public void userClicksOnCreateOrderAndFollowTheStepsPickTheStoreAndAddProductsAndRelatedInformation() {
        storePage.createANewOrder(email, storeName, groupName, productId, customPrice, quantity, paymentMethod);
    }

    @Then("new order should be created")
    public void newOrderShouldBeCreated() {
        Assert.assertTrue(storePage.isOrderCreated());
    }

    @When("user finds specific order from data table and edit by following steps and save")
    public void userFindsSpecificOrderFromDataTableAndEditByFollowingStepsAndSave() {
        storePage.editMyOrder(orderNumber, quantity);
    }

    @Then("success confirmation message should displays")
    public void successConfirmationMessageShouldDisplays() {
        Assert.assertTrue(storePage.isOrderUpdated());
    }


    @When("user find the specific order from data table and click on cancel button and accept alert")
    public void userFindTheSpecificOrderFromDataTableAndClickOnCancelButtonAndAcceptAlert() {
        storePage.cancelOrder(orderNumber);
    }

    @Then("confirmation message should displays for cancellation")
    public void confirmationMessageShouldDisplaysForCancellation() {
        Assert.assertTrue(storePage.isOrderCancelled());
    }


    @When("click on logout button")
    public void clickOnLogoutButton() {
        dashBoardPage.logout();
    }

    @Then("Should logged out")
    public void shouldLoggedOut() {
        Assert.assertFalse(dashBoardPage.isLoginSuccessful("StoreManager"));
    }


    @Before
    public void setup(){
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        LoginToAdminPage loginToAdminPage=new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("StoreManager");
        storePage=new StorePage(driver);
        dashBoardPage=new DashBoardPage(driver);
    }

    @After
    public void tearDown(){
        teardown();
    }


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features ={ "src/test/resources/features" },
            glue = {"src.test.java.stepdefinitions"},
            plugin="pretty"

    )

    public static class TestRunner  {


    }
}