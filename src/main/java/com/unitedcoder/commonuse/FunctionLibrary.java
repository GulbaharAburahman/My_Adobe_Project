package com.unitedcoder.commonuse;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class FunctionLibrary {
    public WebDriver driver;

    public FunctionLibrary(WebDriver driver) {
        this.driver = driver;
    }


    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(1000L *seconds);
    }
    public static String getTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS").format(now);
    }

    public void waitForElementPresent(WebElement element) {
        int timeOut = Integer.parseInt(UtilityClass.readFromConfig("config.properties", "timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public static String getFakeFirstname() {
        return Faker.instance().name().firstName();
    }

    public static String getFakeLastname() {
        return Faker.instance().name().lastName();
    }

    public static String getFakeEmail() {
        return Faker.instance().internet().emailAddress();
    }
    public static String getPassword(){
        return Faker.instance().internet().password(7,10);
    }
    public static String getFakeAddress(){return Faker.instance().address().streetAddress();}
    public static String getFakeTelNum(){return Faker.instance().phoneNumber().toString();}

    public static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void waitForAlert() {
        int timeOut = Integer.parseInt(UtilityClass.readFromConfig("config.properties", "timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.alertIsPresent());

    }
    public void waitForAlertAndAccept(){
        int timeOut = Integer.parseInt(UtilityClass.readFromConfig("config.properties", "timeout"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        Alert alert= wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void waitForAlertAndDismiss(){
        int timeOut = Integer.parseInt(UtilityClass.readFromConfig("config.properties", "timeout"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        Alert alert= wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }



    public static void takeScreenshot(String folderName, String fileName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;  //you create a take screenshot interface
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File imageFile = new File(folderName + File.separator + fileName);
        FileUtils.copyFile(screenshotFile, imageFile);
    }

    public void javaScriptClick(WebElement webElement){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",webElement);
    }

    public void javaScriptScroll(WebElement webElement){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",webElement);
    }



}




















