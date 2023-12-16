package com.unitedcoder;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.frontend.PublicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DisplayProducts extends BaseClass {
    public void main(String[] args) throws InterruptedException {
        BaseClass baseClass = new BaseClass();
        baseClass.launchBrowser(BrowserType.CHROME);
        baseClass.navigateToPublicPage();
        PublicPage publicPage = new PublicPage(baseClass.driver);
        publicPage.loginToAccount("timthomas@gmail.com", "Ab12345");
        //  publicPage.displayProducts(false,"Excellent Home & Decor","Electronics");
        List<WebElement> allRootCategories = baseClass.driver.findElements(By.cssSelector("ol.nav-primary>li"));

        List<WebElement> categoriesDropdownLinks = baseClass.driver.findElements(By.xpath("//ol[@class=\"nav-primary\"]/li/li/a"));
        boolean isRootSelected = false;
        String rootCat = "Excellent Home & Decor";
        String subCatName = "Electronics";
        Actions actions = new Actions(baseClass.driver);
        FunctionLibrary functionLibrary = new FunctionLibrary(baseClass.driver);
        for (WebElement each : allRootCategories) {
            functionLibrary.waitForElementPresent(each);
            if (each.getText().trim().equalsIgnoreCase(rootCat)) {
                actions.moveToElement(each).build().perform();
                isRootSelected=true;
                try {
                    String myXpath = String.format("//ul[@class='level0']//li/a[contains(text(),'%s')]", subCatName);
                    WebElement a = baseClass.driver.findElement(By.xpath(myXpath));
                    functionLibrary.waitForElementPresent(a);
                    a.click();
               log.info(subCatName + ": is clicked");
                    break;
                } catch (NoSuchElementException e) {
                    log.info("cant find matching sub category");
                    each.click();
                    log.info("displayed all Products under the root category: " + rootCat);
                    break;
                }

            }
        }
        if (!isRootSelected) {
            log.info("can not find matching root category, first rootCat is clicked ");
            allRootCategories.get(0).click();
        }
        baseClass.driver.close();
        baseClass.driver.quit();
    }
}

