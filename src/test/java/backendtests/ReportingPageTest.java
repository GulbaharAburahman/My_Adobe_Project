package backendtests;

import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.reportingmodule.ReportingPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportingPageTest extends BaseClass {

    ReportingPage reportingPage;

    @BeforeClass
    public void setup() {
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
        LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.loginToAdminPanelWithCredentials("ReportingManager");
        reportingPage = new ReportingPage(driver);
    }

    @Test(description = "Reporting Manager should be able to see Shopping Cart - Product in carts Report")
    public void seeProductInCartReport() {
        reportingPage.seeProductsInCarts();
        Assert.assertTrue(reportingPage.isProductsInCartReportDisplayed());
    }


    @Test(description = "Reporting Manager should be able to see Shopping Cart - Abandoned carts Report ")
    public void seeAbandonedCartsReport() {
        reportingPage.seeAbandonedCartsReport();
        Assert.assertTrue(reportingPage.isAbandonedCartsReportDisplayed());
    }

    @Test(description = "Reporting Manager should be able to see Products - Products Bestsellers Report ")
    public void seeProductsBestsellersReport() {
        reportingPage.seeProductBestsellersReport("All Websites", "06/11/2023", "12/28/2023");
        Assert.assertTrue(reportingPage.isProductBestSellersReportDisplayed());
    }


}
