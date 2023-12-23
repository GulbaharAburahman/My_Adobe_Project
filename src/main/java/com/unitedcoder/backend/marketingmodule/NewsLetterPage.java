package com.unitedcoder.backend.marketingmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsLetterPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public NewsLetterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    @FindAll(@FindBy(xpath = "//*[@class=\"header\"]/div/ul/li/a/span"))
    List<WebElement> pageLinkTaps;
    @FindBy(xpath = "//*[@id=\"nav\"]/li/ul/li/a/span[contains(text(),'Newsletter Templates')]")
    WebElement newsletterTemplatesLink;
    @FindBy(xpath = "//*[@id=\"nav\"]/li/ul/li/a/span[contains(text(),'Newsletter Subscribers')]")
    WebElement newsletterSubscribersLink;
    @FindAll(@FindBy(xpath = "//*[@class=\"hor-scroll\"]/table/tbody/tr/td[contains(text(),'')]"))
    List<WebElement> findNewsletterWithName;
    @FindBy(xpath = "//*[@title=\"Next page\"]")
    WebElement nextPageButton;
    @FindBy(xpath = "//*[@title=\"Delete Template\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//div/*[@name=\"code\"]")
    WebElement templateNameFiled;
    @FindBy(xpath = "//*[@title=\"Search\"]")
    WebElement searchButton;
    @FindBy(xpath = "//*[@class=\"data\"]/tbody/tr/td[contains(text(),'No records found')]")
    WebElement noFindMassage;
    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div/table/tbody/tr/td/h3[contains(text(),'Newsletter Subscribers')]")
    WebElement verifyNewsletterSubscribersLink;
    public void deleteExistingNewsletterTemplate(String templateName){
        Actions actions = new Actions(driver);
        for (WebElement each:pageLinkTaps){
            functionLibrary.waitForElementPresent(each);
            if (each.getText().equals("Newsletter")){
                actions.moveToElement(each).build().perform();
                break;
            }
        }
        functionLibrary.waitForElementPresent(newsletterTemplatesLink);
        newsletterTemplatesLink.click();
        functionLibrary.sleep(2);
//        WebElement templates = driver.findElement(By.xpath(String.format("//*[@class=\"hor-scroll\"]/table/tbody/tr/td[contains(text(),'%s')]",templateName)));
        while (true) {
            boolean isTargetCheckBoxClicked = false;
            for (WebElement each : findNewsletterWithName) {
                functionLibrary.waitForElementPresent(each);
                if (each.getText().trim().contains(templateName)) {
                    each.click();
                    isTargetCheckBoxClicked = true;
                    functionLibrary.sleep(2);
                    break;
                }
            }
            if (!isTargetCheckBoxClicked) {
                try {
                    functionLibrary.waitForElementPresent(nextPageButton);
                    nextPageButton.click();
                    functionLibrary.sleep(2);
                } catch (NoSuchElementException e) {
                    break;
                }
            } else break;
        }
        functionLibrary.waitForElementPresent(deleteButton);
        deleteButton.click();
        driver.switchTo().alert().accept();
    }
    public boolean isNewsletterTemplateDeleted(String templateName) {
        functionLibrary.waitForElementPresent(templateNameFiled);
        templateNameFiled.sendKeys(templateName);
        functionLibrary.waitForElementPresent(searchButton);
        searchButton.click();
        functionLibrary.sleep(2);
        functionLibrary.waitForElementPresent(noFindMassage);
        if (noFindMassage.isDisplayed()){
            return true;
        }else {
            return false;
        }

    }
    public void viewNewsletterSubscribers(){
        Actions actions = new Actions(driver);
        for (WebElement each:pageLinkTaps){
            functionLibrary.waitForElementPresent(each);
            if (each.getText().equals("Newsletter")){
                actions.moveToElement(each).build().perform();
                break;
            }
        }
        functionLibrary.waitForElementPresent(newsletterSubscribersLink);
        newsletterSubscribersLink.click();
        functionLibrary.sleep(2);
    }
    public boolean isViewNewsletterSubscribers(){
        return verifyNewsletterSubscribersLink.isDisplayed();
    }








}
