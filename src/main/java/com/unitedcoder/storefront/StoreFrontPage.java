package com.unitedcoder.storefront;
import com.unitedcoder.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoreFrontPage extends BaseClass {

  @FindBy (css = "a.skip-link.skip-account")
  WebElement accountIcon;

  @FindBy(id = "editing-view-port")
  WebElement searchBar;
  @FindAll(@FindBy(css = "ol.nav-primary>li"))
  List<WebElement> allRootCategories;

  @FindBy(linkText= "//div[@id='header-account']//a[text()='My Account'][@title='My Account']")
  WebElement myAccount;

  @FindBy(linkText ="//a[text()='My Wishlist']" )
  WebElement myWishlist;

  @FindBy(linkText = "//a[text()='My Cart']")
  WebElement myCart;
  @FindBy(linkText = "//a[text()='Checkout']")
  WebElement checkOut;

  @FindBy(linkText = "//a[text()='Register']")
  WebElement register;

  @FindBy(linkText = "//a[text()='Log In']")
  WebElement logIn;

  @FindBy(css = "div.header-minicart")
  WebElement cart;

  @FindBy(css = "input#newsletter.input-text.required-entry.validate-email")
  WebElement newsLetterSubscribe;

  public StoreFrontPage() {
    PageFactory.initElements(driver,this);
  }




}
