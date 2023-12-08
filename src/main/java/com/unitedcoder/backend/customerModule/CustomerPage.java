package com.unitedcoder.backend.customerModule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
   WebDriver driver;
    FunctionLibrary functionLibrary;

    public CustomerPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    //**************** Customer Manager Home Page ***********************




}
