package com.unitedcoder.commonuse;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Set;


public class BaseClass {

 public  WebDriver driver;


    public void launchBrowser(BrowserType browserType ) {
  switch (browserType){
   case CHROME -> {  ChromeOptions chromeOptions=new ChromeOptions();
                      chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        driver=new ChromeDriver(chromeOptions);}
   case FIREFOX -> {
       FirefoxOptions firefoxOptions=new FirefoxOptions();
       firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver=new FirefoxDriver(firefoxOptions);}
   }
  }

  public void navigateToPublicPage(){
        driver.manage().window().maximize();
     driver.get(UtilityClass.readFromConfig("config.properties","publicPage_url"));
   Set <Cookie> cookies= driver.manage().getCookies();  // capture all the cookies from the browser.
      System.out.println("Size of cookies:" +cookies.size());
      for(Cookie eachCookie: cookies){
         System.out.println(eachCookie.getName() +"; "+eachCookie.getValue());
      }
  }

  public void navigateToBackEnd(){
    driver.get(UtilityClass.readFromConfig("config.properties","backEnd_url"));

  }

  public void teardown(){
        driver.close();
  }




 }




