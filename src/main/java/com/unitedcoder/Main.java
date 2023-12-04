package com.unitedcoder;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.frontend.PublicPage;
import org.openqa.selenium.By;

public class Main {
    public static void main(String[] args) {
     BaseClass baseClass=new BaseClass();
       baseClass.launchBrowser(BrowserType.CHROME);
        baseClass.navigateToPublicPage();
        PublicPage publicPage =new PublicPage(baseClass.driver);


    }
}