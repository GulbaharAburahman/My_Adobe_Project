package com.unitedcoder.backend.catalogmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {

   FunctionLibrary functionLibrary;

 public CatalogPage(WebDriver driver){
     PageFactory.initElements(driver,this);
     functionLibrary=new FunctionLibrary(driver);
 }


}
