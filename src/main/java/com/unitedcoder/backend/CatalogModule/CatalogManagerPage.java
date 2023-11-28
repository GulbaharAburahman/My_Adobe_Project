package com.unitedcoder.backend.CatalogModule;

import com.unitedcoder.backend.customerModule.CustomerManagerPage;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.xml.catalog.Catalog;

public class CatalogManagerPage {

   FunctionLibrary functionLibrary;

 public CatalogManagerPage(WebDriver driver){
     PageFactory.initElements(driver,this);
     functionLibrary=new FunctionLibrary(driver);
 }


}
