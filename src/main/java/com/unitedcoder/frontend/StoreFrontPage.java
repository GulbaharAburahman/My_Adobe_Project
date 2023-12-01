package com.unitedcoder.frontend;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class StoreFrontPage  {
  FunctionLibrary functionLibrary;
  WebDriver driver;
  @FindBy (css = "div.account-cart-wrapper")
  WebElement accountLink;
  @FindBy(id = "editing-view-port")
  WebElement searchBar;
  @FindAll(@FindBy(css = "ol.nav-primary>li"))
  List<WebElement> allRootCategories;
  @FindAll(@FindBy(xpath = "//div[@id='header-account']//a"))
  List<WebElement> accountDropDownSubLinks;

  @FindAll(@FindBy(xpath = "//ol[@class='nav-primary']//li//li//a"))
  List<WebElement> categoriesDropdownLinks;

  @FindAll(@FindBy(xpath = "//li[@class='item last']"))
  List<WebElement> productsList;


  //li[@class="item last"]//ancestor::div[@class='actions']//button

  @FindAll(@FindBy(xpath = "//h2[@class='product-name']/a"))
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
  @FindBy(css = "span.icon")
  WebElement cartIcon;
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
    this.driver=driver;
    PageFactory.initElements(driver,this);
   functionLibrary=new FunctionLibrary(driver);
  }

  public void selectAccountSubLink(String subLinkName) {
    functionLibrary.waitForElementPresent(accountLink);
    accountLink.click();
    for (WebElement each : accountDropDownSubLinks) {
      if (each.getText().equals(subLinkName)) {
        each.click();
        break;
      }
    }
  }

  public void  createAccount( String firstname, String lastname,String email, String password){
    selectAccountSubLink("Register");
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
    selectAccountSubLink("Log In");
    functionLibrary.waitForElementPresent(loginEmailField);
    loginEmailField.sendKeys(email);
    functionLibrary.waitForElementPresent(loginPassword);
    loginPassword.sendKeys(password);
    functionLibrary.waitForElementPresent(loginButton);
    loginButton.click();
  }

  public boolean isSuccessMessageDisplayed(){
    return successMessage.isDisplayed();
  }
  public boolean isLoginSuccessful(){
    return welcomeMessage.isDisplayed();
  }

  public void checkout(){
    functionLibrary.waitForElementPresent(accountLink);
   selectAccountSubLink("Checkout");
  }

  public void logout(){
    functionLibrary.waitForElementPresent(accountLink);
    selectAccountSubLink("Log Out");
  }



  public void addToCartByRootCategory(String rootCategory,String  productName) {
    try {
      //find root category
      Actions actions = new Actions(driver);
      for (WebElement each : allRootCategories) {
        if (each.getText().equalsIgnoreCase(rootCategory)) {
          actions.moveToElement(each).click().build().perform();
          break;
        }
      }
      //find product by name and click on add to cart
      for (WebElement each : productNames) {
        if (each.getText().equalsIgnoreCase(productName)) {
          System.out.println(each.getText());
          WebElement addToCartAction = each.findElement(By.xpath("//ancestor::li//span[text()='Add to Cart']"));
          addToCartAction.click();
          break;
        }
      }
    } catch (NoSuchElementException e) {
      System.out.println("sorry can't find your product");
    }

  }

  public void findMyProductAndTakeAction(String rootCategory, String subCategory,String productName, String action){
    try {
      //find root category
      Actions actions = new Actions(driver);
      for (WebElement each : allRootCategories) {
        if (each.getText().equalsIgnoreCase(rootCategory)) {
          actions.moveToElement(each).build().perform();
          break;}}

      //find subCategory
      for (WebElement each : categoriesDropdownLinks) {
        if (each.getText().equalsIgnoreCase(subCategory)) {
          each.click();
          break;}}

      //find product by name and do something
      for(WebElement each:productNames) {
        functionLibrary.waitForElementPresent(each);
        if (each.getText().equalsIgnoreCase(productName)) {
          switch (action.toLowerCase()) {
            case "add to cart" -> {
              WebElement addToCartAction = each.findElement(By.xpath("//ancestor::li//span[text()='Add to Cart']"));
              addToCartAction.click();
            }
            case "add to wishlist" -> {
              WebElement addToWishList = each.findElement(By.xpath("//ancestor::li//a[@class='link-wishlist']"));
              addToWishList.click();
            }
            case "add to compare" -> {
              WebElement addToCompare = each.findElement(By.xpath("//ancestor::li//a[@class=\"link-compare\""));
              addToCompare.click();
            }
          }
          break;
        }
      }
    } catch (NoSuchElementException e) {
      System.out.println("oops , cant find your product, check product details please");
    }
  }


  public void addToWishlist(String rootCategory, String subCategory, String productName){
    findMyProductAndTakeAction(rootCategory,subCategory,productName,"add to wishlist");
  }

  public void addToCart(String rootCategory, String subCategory, String productName){
    findMyProductAndTakeAction(rootCategory,subCategory,productName,"add to cart");
  }
//Add to Compare
  public void addToCompare(String rootCategory, String subCategory, String productName){
    findMyProductAndTakeAction(rootCategory,subCategory,productName,"Add to Compare");
  }



}
