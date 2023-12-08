package com.unitedcoder.backend.storemodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
    FunctionLibrary functionLibrary;
    public StorePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
}
