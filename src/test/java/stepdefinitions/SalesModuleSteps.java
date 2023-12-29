package stepdefinitions;

import com.unitedcoder.backend.DashBoardPage;
import com.unitedcoder.backend.salesmodule.SalesPage;
import com.unitedcoder.commonuse.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SalesModuleSteps extends TestBase {
    DashBoardPage dashBoardPage =new DashBoardPage(driver);
    SalesPage salesPage =new SalesPage(driver);


    @Given("on the dashboard page logged in as Role Sales Manager")
    public void onTheDashboardPageLoggedInAsRoleSalesManager() {
        dashBoardPage.isLoginSuccessful("salesManager");
    }
    @When("Click on Orders Link under the Sales then click on create new order button")
    public void clickOnOrdersLinkUnderTheSales() {
        salesPage.clickOnCreateOrder();
    }

    @And("select the target customer from customer data table as {string}")
    public void selectTheTargetCustomerFromCustomerDataTableAs(String arg0) {
        salesPage.selectCustomerToCreateOrder(arg0);
    }
    @Then("create a new order from selected store page displays")
    public void selectAStorePageDisplays() {
     Assert.assertTrue(salesPage.isCreateOrderFromStorePageDisplayed());
    }
    @When("select a store by name as {string}")
    public void selectAStoreByNameAs(String arg0) {
        salesPage.chooseTheStore(arg0);
    }

    @When("Account information part select group as {string}")
    public void accountInformationPartSelectGroup(String arg0) {
        salesPage.fillAccountInformation(arg0);
    }
    @And("click on Add products button, search product as {string} and fill quantity as {string} , custom price as {string} atc")
    public void clickOnAddProductsButtonSearchProductAsAndFillQuantityAsCustomPriceAsAtc(String arg0, String arg1, String arg2) {
        salesPage.addProductsFromStore(arg0,arg2,arg1);
    }

    @And("click on radio button of payment method as {string}")
    public void clickOnRadioButtonOfPaymentMethodAs(String arg0) {
        salesPage.clickOnPaymentMethod(arg0);
    }

    @And("click on submit order button")
    public void clickOnSubmitOrderButton() {
        salesPage.submitOrder();
    }

    @Then("confirmation message should display to confirm order created with order number")
    public void validateOrderCreated() {
       Assert.assertTrue(salesPage.isOrderCreated());
    }



}
