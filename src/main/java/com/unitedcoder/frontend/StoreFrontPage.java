package com.unitedcoder.frontend;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoreFrontPage extends BaseClass {

  FunctionLibrary functionLibrary;

  @FindBy (css = "div.account-cart-wrapper")
  WebElement accountLink;
  @FindBy(id = "editing-view-port")
  WebElement searchBar;
  @FindAll(@FindBy(css = "ol.nav-primary>li"))
  List<WebElement> allRootCategories;
  @FindAll(@FindBy(xpath = "//div[@id='header-account']//a"))
  List<WebElement> accountDropDownSubLinks;

  @FindAll(@FindBy(xpath = "//ol[@class='nav-primary']//li//li//a"))
  List<WebElement> categoriesDropdownSubmenus;

  @FindAll(@FindBy(xpath = "//div[@class='product-info']//*[@class='product-name']//a"))
  List<WebElement> productNames;

  @FindAll(@FindBy(xpath = "//div[@class='product-info']//*[@class='actions']//a"))
  List<WebElement> productActions;

@FindBy(css = "div.add-to-cart-buttons")
WebElement addToCartButton;

@FindBy(id ="firstname")
WebElement firstnameField;
@FindBy(id="lastname")
WebElement lastnameField;

@FindBy(css = "#email_address")
WebElement emailField;
@FindBy(id="password")
WebElement passwordField;
@FindBy(name = "confirmation")
WebElement confirmPasswordField;

@FindBy(xpath ="//button[@class='button']/span")
WebElement registerButton;
  @FindBy(css = "div.header-minicart")
  WebElement cart;
  @FindBy(css = "input#newsletter.input-text.required-entry.validate-email")
  WebElement newsLetterSubscribe;

  @FindBy(css = "li.success-msg")
  WebElement successMessage;

  @FindBy(xpath="//*[@id='email']")
  WebElement loginEmailField;
  @FindBy(name="login[password]")
  WebElement loginPassword;
  @FindBy(id="send2")
  WebElement loginButton;
  @FindBy(css = "div.welcome-msg")
  WebElement welcomeMessage;


  public StoreFrontPage(WebDriver driver) {
    PageFactory.initElements(driver,this);
   functionLibrary=new FunctionLibrary(driver);
  }

  public void  createAccount( String firstname, String lastname,String email, String password){
    accountLink.click();
    for(WebElement each:accountDropDownSubLinks){
     if( each.getText().equals("Register") ){
       each.click();
       break;
     }
    }
    functionLibrary.waitForElementPresent(firstnameField);
    firstnameField.sendKeys(firstname);
    functionLibrary.waitForElementPresent(lastnameField);
    lastnameField.sendKeys(lastname);
    functionLibrary.waitForElementPresent(emailField);
    emailField.sendKeys(email);
    functionLibrary.waitForElementPresent(passwordField);
    passwordField.sendKeys(password);
    functionLibrary.waitForElementPresent(confirmPasswordField);
    confirmPasswordField.sendKeys(password);
    registerButton.click();
  }

  public boolean isAccountCreated(){
    return successMessage.isDisplayed();
  }

  public void loginToAccount(String email, String password){
    functionLibrary.waitForElementPresent(accountLink);
    accountLink.click();
    for(WebElement each:accountDropDownSubLinks){
      if( each.getText().equals("Log In") ){
        each.click();
        break;
      }
    }
    functionLibrary.waitForElementPresent(loginEmailField);
    loginEmailField.sendKeys(email);
    functionLibrary.waitForElementPresent(loginPassword);
    loginPassword.sendKeys(password);
    functionLibrary.waitForElementPresent(loginButton);
    loginButton.click();
  }

  public boolean isLoginSuccessful(){
    return welcomeMessage.isDisplayed();
  }










}
