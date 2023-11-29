package com.unitedcoder;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.frontend.StoreFrontPage;

public class Main {
    public static void main(String[] args) {
     BaseClass baseClass=new BaseClass();
       baseClass.launchBrowser(BrowserType.CHROME);
        baseClass.navigateToPublicPage();
        StoreFrontPage storeFrontPage=new StoreFrontPage(baseClass.driver);
        storeFrontPage.createAccount(FunctionLibrary.getFakeFirstname(),FunctionLibrary.getFakeLastname(),FunctionLibrary.getFakeEmail(),"Julia123");
        FunctionLibrary.sleep();
        baseClass.teardown();

    }
}