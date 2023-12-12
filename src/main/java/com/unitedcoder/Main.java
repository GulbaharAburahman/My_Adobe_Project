package com.unitedcoder;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.customerModule.CustomerPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.events.ScalarEvent;

import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        BaseClass baseClass = new BaseClass();
        baseClass.launchBrowser(BrowserType.CHROME);
        WebDriver driver = baseClass.driver;
        baseClass.navigateToBackEnd();
        LoginToAdminPage loginPage = new LoginToAdminPage(baseClass.driver);
        loginPage.loginToAdminPanelWithCredentials("CustomerManager");
        CustomerPage customerPage = new CustomerPage(baseClass.driver);

        customerPage.addCustomer("Admin", "Senem", "Rita", "Rana", "Martin", "rita@gmail.com",
                true,"11/29/1988", "Female", true, "1234567");




    }
}



