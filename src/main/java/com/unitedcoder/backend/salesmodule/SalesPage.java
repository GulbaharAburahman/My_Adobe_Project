package com.unitedcoder.backend.salesmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SalesManagerPage {
    FunctionLibrary functionLibrary;
    public SalesManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }


}
