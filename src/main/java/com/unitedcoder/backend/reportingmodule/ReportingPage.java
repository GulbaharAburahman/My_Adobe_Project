package com.unitedcoder.backend.reportingmodule;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ReportingPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    Logger logger= LogManager.getLogger();

    public ReportingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }


    @FindBy(xpath ="//table[@id='gridProducts_table']//tbody" )
    WebElement productsInCartDataTableBody;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logout;
@FindBy(xpath = "//span[normalize-space()='Reports']")
WebElement reportsLink;

@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
WebElement shoppingCart;
@FindBy(xpath = "//a[@href='#']/span[normalize-space( )='Products']")
WebElement productsUnderTheReports;
@FindBy(xpath = "//span[normalize-space()='Products in carts']")
WebElement productsInCarts;
@FindBy(xpath = "//span[normalize-space()='Abandoned carts']")
WebElement abandonedCarts;
@FindBy(xpath = "//span[normalize-space()='Bestsellers']")
WebElement bestSellers;
@FindBy(xpath = "//table[@id='gridAbandoned_table']//tbody")
WebElement abandonedCartsDataTableBody;
@FindBy(id="store_switcher")
WebElement selectShowReportFor;
@FindBy(id="sales_report_from")
WebElement fromDateField;
@FindBy(id="sales_report_to")
WebElement toDateField;

@FindBy(xpath = "(//span[contains(text(),'Show Report')])[1]")
WebElement showReportsButton;
@FindBy(xpath = "(//h3[contains(text(),'Products Bestsellers Report')])[1]")
WebElement productBestSellersText;
@FindBy(xpath = "//table[@class='data']/tbody")
WebElement productBestSellersDataTableBody;

    public void logout() {
        logger.info("logout");
        functionLibrary.waitForElementPresent(logout);
        logout.click();
    }

    public void clickOnShoppingCart(){
        logger.info("go to Reports then click on shopping cart ");
        functionLibrary.waitForElementPresent(reportsLink);
        reportsLink.click();
       functionLibrary.waitForElementPresent(shoppingCart);
       shoppingCart.click();
    }

    public void clickOnProducts(){
      logger.info("go to Reports then click on Products");
      functionLibrary.waitForElementPresent(reportsLink);
      reportsLink.click();
      functionLibrary.waitForElementPresent(productsUnderTheReports);
      productsUnderTheReports.click();
    }

    public void openBestSellersReportPage(){
        clickOnProducts();
        logger.info("Click on Best Sellers under the products dropdown menu to open product bestsellers page");
        functionLibrary.waitForElementPresent(bestSellers);
        bestSellers.click();
    }

    public boolean isProductBestSellersPageDisplayed(){
        functionLibrary.waitForElementPresent(productBestSellersText);
        boolean isDisplayed=productBestSellersText.isDisplayed();
        logger.info("Is Product Best Sellers Page Displayed ? : "+isDisplayed);
        return isDisplayed;
    }

    public void filterBestSellersReport(String websiteName, String fromDate, String toDate){
        logger.info("select website to show report and fill From and To date  fields to filter report ");
        functionLibrary.waitForElementPresent(selectShowReportFor);
        selectShowReportFor.sendKeys(websiteName);
        functionLibrary.waitForElementPresent(fromDateField);
        fromDateField.sendKeys(fromDate);
        functionLibrary.waitForElementPresent(toDateField);
        toDateField.sendKeys(toDate);
        functionLibrary.waitForElementPresent(showReportsButton);
        logger.info("click on show report button");
        showReportsButton.click();
    }


    public void seeProductBestsellersReport(String websiteName, String fromDate, String toDate){
        logger.info("See Product Bestsellers Report");
        openBestSellersReportPage();
        filterBestSellersReport( websiteName,fromDate,toDate);
    }


    public boolean isProductBestSellersReportDisplayed(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        functionLibrary.waitForElementPresent(productBestSellersDataTableBody);
        boolean isDisplayed=productBestSellersDataTableBody.isDisplayed();
logger.info("Is Product Best Sellers Report Displayed ?: "+isDisplayed );
return isDisplayed;
    }



    public void seeProductsInCarts(){
        logger.info("see Shopping cart - products in cart report ");
        clickOnShoppingCart();
        logger.info("click on products in carts ");
        functionLibrary.waitForElementPresent(productsInCarts);
        productsInCarts.click();
    }

    public boolean isProductsInCartReportDisplayed(){
        functionLibrary.waitForElementPresent(productsInCartDataTableBody);
        boolean isDisplayed= productsInCartDataTableBody.isDisplayed();
      logger.info("Is products in cart report displayed ? : "+isDisplayed);
      return isDisplayed;
    }

    public void seeAbandonedCartsReport(){
        logger.info("See Shopping cart - Abandoned Carts Report");
        clickOnShoppingCart();
        logger.info("click on Abandoned Carts ");
       functionLibrary.waitForElementPresent(abandonedCarts);
       abandonedCarts.click();
    }



    public boolean isAbandonedCartsReportDisplayed(){
        functionLibrary.waitForElementPresent(abandonedCartsDataTableBody);
        boolean isDisplayed=abandonedCartsDataTableBody.isDisplayed();
        logger.info("Is Abandoned Carts Report Displayed ? : "+isDisplayed);
      return isDisplayed;
    }















}