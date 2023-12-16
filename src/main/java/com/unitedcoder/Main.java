package com.unitedcoder;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.customerModule.CustomerPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;



public class Main {

public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws InterruptedException {
        BaseClass baseClass = new BaseClass();
        baseClass.launchBrowser(BrowserType.CHROME);
        WebDriver driver = baseClass.driver;
        baseClass.navigateToBackEnd();
        LoginToAdminPage loginPage = new LoginToAdminPage(baseClass.driver);
        loginPage.loginToAdminPanelWithCredentials("CustomerManager");
        FunctionLibrary functionLibrary = new FunctionLibrary(driver);

        WebElement customersLinkTab = driver.findElement(By.linkText("Customers"));
        customersLinkTab.click();
        WebElement manageCustomers = driver.findElement(By.linkText("Manage Customers"));
        manageCustomers.click();
        FunctionLibrary.sleep(3);

        String email ="genaro.green@yahoo.com";
        String xpath = String.format("//td[contains(text(),'%s')]//parent::tr//td[@class=' last']/a", email);





        while (true) {

            try {
                FunctionLibrary.sleep(2);
                WebElement edit= driver.findElement(By.xpath(xpath));
                functionLibrary.waitForElementPresent(edit);
                logger.info("found target edit ");
                edit.click();
                logger.info(" clicked on target edit");
                break;
            } catch (NoSuchElementException e) {
                logger.info("can't locate target edit button in this page ");
            }try {
                WebElement next = driver.findElement(By.xpath("//tr//a/img[@alt='Go to Next page']"));
                functionLibrary.waitForElementPresent(next);
                next.click();
            }catch ( NoSuchElementException e){
                logger.info("all pages been checked");
                break;
            }

        }

            FunctionLibrary.sleep(2);
            WebElement delete = driver.findElement(By.cssSelector("button.scalable.delete"));
            delete.click();
            FunctionLibrary.sleep(2);
            functionLibrary.waitForAlertAndAccept();


   //     WebElement next = driver.findElement(By.xpath("//tr//a/img[@alt='Go to Next page']"));
   //     FunctionLibrary.sleep(1);
   //     next.click();

        driver.close();
        driver.quit();




        }
    }



