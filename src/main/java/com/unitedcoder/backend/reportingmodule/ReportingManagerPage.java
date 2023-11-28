package com.unitedcoder.backend.reportingmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReportingManagerPage {
    FunctionLibrary functionLibrary;
    public ReportingManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

}
