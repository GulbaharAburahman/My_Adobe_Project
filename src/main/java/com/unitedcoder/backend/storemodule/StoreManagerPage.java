package com.unitedcoder.backend.storemodule;

import com.unitedcoder.backend.salesmodule.SalesManagerPage;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StoreManagerPage {
    FunctionLibrary functionLibrary;
    public StoreManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
}
