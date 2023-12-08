package com.unitedcoder;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;


public class Main {
    public static void main(String[] args) {
     BaseClass baseClass=new BaseClass();
       baseClass.launchBrowser(BrowserType.CHROME);
        baseClass.navigateToBackEnd();
        LoginToAdminPage loginPage=new LoginToAdminPage(baseClass.driver);
        loginPage.loginToAdminPanelWithCredentials("CustomerManager");


    }
}