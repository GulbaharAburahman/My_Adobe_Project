package com.unitedcoder.commonuse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Set;


public class BaseClass {

 public  WebDriver driver;
 public Logger log = LogManager.getLogger("BaseClass");

    public void launchBrowser(BrowserType browserType ) {
        log.info("launch Browser");
  switch (browserType){
   case CHROME -> {  ChromeOptions chromeOptions=new ChromeOptions();
                  chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        driver=new ChromeDriver(chromeOptions);
       driver.manage().window().maximize();}
   case FIREFOX -> {
       FirefoxOptions firefoxOptions=new FirefoxOptions();
       firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver=new FirefoxDriver(firefoxOptions);
       driver.manage().window().maximize();}
   }
  }

  public   WebDriver getDiver (){
        return this.driver;
  }


  public  void navigateToPublicPage(){
        log.info("navigate to Public page ");
        int time=Integer.parseInt(UtilityClass.readFromConfig("config.properties","implict_wait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
      driver.get(UtilityClass.readFromConfig("config.properties","publicPage_url"));
      Set <Cookie> cookies= driver.manage().getCookies();  // capture all the cookies from the browser.
      System.out.println("Size of cookies:" +cookies.size());
      for(Cookie eachCookie: cookies) {
          System.out.println(eachCookie.getName() + "; " + eachCookie.getValue());
      }
  }

  public void navigateToBackEnd(){
      log.info("navigate to Backend  ");
    driver.get(UtilityClass.readFromConfig("config.properties","backEnd_url"));

  }

  public void teardown(){
      log.info("close browser");
        driver.close();
        driver.quit();
  }




 }




