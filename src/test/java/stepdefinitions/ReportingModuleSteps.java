package stepdefinitions;

import com.unitedcoder.backend.DashBoardPage;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.reportingmodule.ReportingPage;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ReportingModuleSteps extends TestBase {
    ReportingPage reportingPage = new ReportingPage(driver);
    DashBoardPage dashBoardPage = new DashBoardPage(driver);
    LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
    @Given("user is on Login to Admin Panel Page")
    public void userIsOnLoginToAdminPanelPage() {
      Assert.assertTrue(loginToAdminPage.isLoginToAdminPanelPage());
    }
    @When("Enter valid username and password for user Role as {string}")
    public void Login(String arg0) {
        loginToAdminPage.loginToAdminPanelWithCredentials(arg0);
    }

    @Then("Logged into Dashboard as {string}")
    public void validateLogin(String arg0) {
        Assert.assertTrue(dashBoardPage.isLoginSuccessful(arg0));
    }

    @When("User clicks on Reports followed by clicks on Shopping Cart followed by clicks on Products in carts")
    public void seeProductInCartsReport() {
        reportingPage.seeProductsInCarts();
    }

    @Then("Shopping Cart- Product in carts Report Should be displayed")
    public void validateSeeProductInCartReport() {
        Assert.assertTrue(reportingPage.isProductsInCartReportDisplayed());
    }

    @When("User clicks on Reports followed by clicks on Shopping Cart followed by clicks on Abandoned carts")
    public void seeAbandonedCartsReport() {
        reportingPage.seeAbandonedCartsReport();
    }

    @Then("Shopping Cart - Abandoned carts Report Should be displayed")
    public void shoppingCartAbandonedCartsReportShouldBeDisplayed() {
        Assert.assertTrue(reportingPage.isAbandonedCartsReportDisplayed());
    }


    @When("User clicks on Reports followed by clicks on Products and followed by clicks on Bestsellers")
    public void openBestSellersReportPage() {
        reportingPage.openBestSellersReportPage();
    }

    @Then("Products Bestsellers Report Page should be displayed")
    public void productsBestsellersReportPageShouldBeDisplayed() {
        Assert.assertTrue(reportingPage.isProductBestSellersPageDisplayed());
    }

    @When("user selects Show Report For as {string} and enter From field as {string} To field as {string} and click on submit button")
    public void showSpecificProductBestSellersReport(String arg0, String arg1, String arg2) {
        reportingPage.filterBestSellersReport(arg0, arg1, arg2);
    }

    @Then("Products Bestsellers Report data table should be displayed")
    public void productsBestsellersReportDataTableShouldBeDisplayed() {
        Assert.assertTrue(reportingPage.isProductBestSellersReportDisplayed());
    }

    @When("User Clicks on logout button")
    public void userClicksOnLogoutButton() {
        dashBoardPage.logout();
    }

    @Then("user should logged out from dashboard Page to Login to Admin Panel Page")
    public void validateLogout() {
        Assert.assertTrue(loginToAdminPage.isLoginToAdminPanelPage());
    }



}