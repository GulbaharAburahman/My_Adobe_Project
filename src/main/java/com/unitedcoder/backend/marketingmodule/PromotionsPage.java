package com.unitedcoder.backend.marketingmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PromotionsPage {

    FunctionLibrary functionLibrary;

    public PromotionsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
}
