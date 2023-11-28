package com.unitedcoder.backend.customerModule;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerManagerPage extends BaseClass {
    FunctionLibrary functionLibrary;

    public CustomerManagerPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }



}
