package com.unitedcoder;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.customerModule.CustomerPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Main {
    public static void main(String[] args) throws InterruptedException {
     BaseClass baseClass=new BaseClass();
       baseClass.launchBrowser(BrowserType.CHROME);
        baseClass.navigateToBackEnd();
        LoginToAdminPage loginPage=new LoginToAdminPage(baseClass.driver);
        loginPage.loginToAdminPanelWithCredentials("CustomerManager");
        CustomerPage customerPage=new CustomerPage(baseClass.driver);

        System.out.println( customerPage.isCustomerAdded() );








    }



}