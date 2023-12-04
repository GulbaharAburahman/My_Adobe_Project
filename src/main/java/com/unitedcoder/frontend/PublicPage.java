package com.unitedcoder.frontend;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PublicPage {
    FunctionLibrary functionLibrary;
    WebDriver driver;

    //****************  HomePage Section  **********************
    @FindBy(css = "div.account-cart-wrapper")
    WebElement accountIcon;
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

    @FindAll(@FindBy(xpath = "//*[@class='product-name']/a"))
    List<WebElement> productLinks;

    @FindBy(css = "div.add-to-cart-buttons")
    WebElement addToCartButton;


    //****************** Create Account Section ******************
    @FindBy(id = "firstname")
    WebElement firstnameField;
    @FindBy(id = "lastname")
    WebElement lastnameField;

    @FindBy(id = "email_address")
    WebElement emailField;
    @FindBy(css = "input#password")
    WebElement passwordField;
    @FindBy(name = "confirmation")
    WebElement confirmPasswordField;
    @FindBy(css= "button.button[title='Register']")
    WebElement registerButton;
    @FindBy(css = "input#newsletter.input-text.required-entry.validate-email")
    WebElement newsLetterSubscribe;
    @FindBy(css = "li.success-msg")
    WebElement successMessage;

    //************************** Login Section ******************************************
    @FindBy(xpath = "//*[@id='email']")
    WebElement loginEmailField;
    @FindBy(name = "login[password]")
    WebElement loginPassword;
    @FindBy(id = "send2")
    WebElement loginButton;
    @FindBy(css = "div.welcome-msg")
    WebElement welcomeMessage;


    //****************** Checkout method section ********************************
    @FindBy(id = "login:guest")
    WebElement checkoutAsGuestRadioButton;
    @FindBy(id = "login:register")
    WebElement registerAndCheckoutRadioButton;
    @FindBy(id = "onepage-guest-register-button")
    WebElement continueButtonInCheckOutMethod;


    //**************** Check out Billing information Section *******************
    @FindBy(id = "opc-billing")
    WebElement billingInformationSection;
    @FindBy(id = "billing:firstname")
    WebElement billingFirstNameField;
    @FindBy(id = "billing:lastname")
    WebElement billingLastNameField;
    @FindBy(id = "billing:email")
    WebElement billingEmailField;
    @FindBy(id="billing:street1")
    WebElement billingAddress1Field;
    @FindBy(id = "billing:city")
    WebElement billingCityField;
    @FindBy(id = "billing:region_id")
    WebElement billingSelectState;
    @FindBy(id= "billing:postcode")
    WebElement billingPostalCodeField;
    @FindBy(id= "billing:country_id")
    WebElement billingSelectCountry;
    @FindBy(id = "billing:telephone")
    WebElement billingTelephoneField;
    @FindBy(id="billing:customer_password")
    WebElement billingPasswordField;
    @FindBy(id="billing:confirm_password")
    WebElement billingConfirmPasswordField;
    @FindBy(id="billing:use_for_shipping_yes")
    WebElement shipToThisAddress;

    @FindBy(css = "#billing-buttons-container > button")
    WebElement continueButtonInBilling;


    //********************** Shipping Method Section *************************************
    @FindBy(css = "input#s_method_flatrate_flatrate")
    WebElement flatRateRadioButton;
    @FindBy(css = "input#s_method_freeshipping_freeshipping")
    WebElement freeShippingRadioButton;
    @FindBy(css = "button.button[onclick='shippingMethod.save()']")
    WebElement continueButtonInShippingMethod;


    //*********************** PaymentInformation Section *******************************
    @FindBy(css = "input#p_method_checkmo")
    WebElement check_moneyOrder_radioButton;
    @FindBy(css = "input#p_method_purchaseorder")
    WebElement purchaseOrder_radioButton;
    @FindBy(css = "input#p_method_cashondelivery")
    WebElement cashOnDelivery_radioButton;
    @FindBy(css = "input#po_number")
    WebElement purchaseOrderNumberField;
    @FindBy(css = "button.button[onclick='payment.save()']")
    WebElement continueButtonInPayment;
    @FindBy(css = "button.button.btn-checkout")
    WebElement placeOrderButton;
    @FindBy(xpath = "//div[@class='page-title']//*[contains(text(),'Your order has been received')]")
    WebElement checkoutSuccessConfirmation;


    public PublicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public void selectAccountSubLink(String subLinkName) {
        functionLibrary.waitForElementPresent(accountIcon);
        accountIcon.click();
        for (WebElement each : accountDropDownSubLinks) {
            if (each.getText().equalsIgnoreCase(subLinkName) || each.getText().startsWith(subLinkName)) {
                each.click();
                break;
            }
        }
    }

    public void createAccount(String firstname, String lastname, String email, String password) {
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
        functionLibrary.waitForElementPresent(registerButton);
        registerButton.click();
    }

    public boolean isAccountCreated() {
        return successMessage.isDisplayed();
    }

    public void loginToAccount(String email, String password) {
        functionLibrary.waitForElementPresent(accountIcon);
        selectAccountSubLink("Log In");
        functionLibrary.waitForElementPresent(loginEmailField);
        loginEmailField.sendKeys(email);
        functionLibrary.waitForElementPresent(loginPassword);
        loginPassword.sendKeys(password);
        functionLibrary.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public boolean isLoginSuccessful() {
        return welcomeMessage.isDisplayed();
    }

    public void goToCheckout() {
        functionLibrary.waitForElementPresent(accountIcon);
        selectAccountSubLink("Checkout");
    }

    public void logout() {
        functionLibrary.waitForElementPresent(accountIcon);
        selectAccountSubLink("Log Out");
    }


    public void findMyProductAndTakeAction(boolean viewAllProducts, String rootCategory, String subCategory, String productName, String action) {

        try {
            //find root category
            Actions actions = new Actions(driver);
            for (WebElement eachRoot : allRootCategories) {
                if (eachRoot.getText().trim().equalsIgnoreCase(rootCategory)) {
                    String viewOptions = String.valueOf(viewAllProducts);
                    switch (viewOptions) {
                        case "true" -> actions.moveToElement(eachRoot).click().build().perform();
                        case "false" -> {
                            actions.moveToElement(eachRoot).build().perform();
                            //find subCategory
                            for (WebElement category : categoriesDropdownLinks) {
                                if (category.getText().trim().equalsIgnoreCase(subCategory)) {
                                    category.click();
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
            //find product by name and do something
            for (WebElement each : productLinks) {
                if (each.getText().trim().equalsIgnoreCase(productName)) {
                    switch (action.toLowerCase()) {
                        case "add to cart" -> {
                            WebElement addToCartButton = each.findElement(By.xpath("//ancestor::li//span[text()='Add to Cart']"));
                            addToCartButton.click();
                        }
                        case "add to wishlist" -> {
                            WebElement addToWishList = each.findElement(By.xpath("//ancestor::li//a[@class='link-wishlist']"));
                            addToWishList.click();
                        }
                        case "add to compare" -> {
                            WebElement addToCompare = each.findElement(By.xpath("//ancestor::li//a[@class='link-compare']"));
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


    public void addToWishlist(boolean viewAllProducts, String rootCategory, String subCategory, String productName) {
        findMyProductAndTakeAction(viewAllProducts, rootCategory, subCategory, productName, "add to wishlist");
    }

    public void addToCart(boolean viewAllProducts, String rootCategory, String subCategory, String productName) {
        findMyProductAndTakeAction(viewAllProducts, rootCategory, subCategory, productName, "add to cart");
    }

    //Add to Compare
    public void addToCompare(boolean viewAllProducts, String rootCategory, String subCategory, String productName) {
        findMyProductAndTakeAction(viewAllProducts, rootCategory, subCategory, productName, "Add to Compare");
    }

    public boolean viewMyWishList(String productName) {
        boolean isMyWishListDisplayed = false;
        selectAccountSubLink("My Wishlist");
        for (WebElement each : productLinks) {
            if (each.getText().equalsIgnoreCase(productName)) {
                isMyWishListDisplayed = true;
            }
        }
        return isMyWishListDisplayed;
    }

    public void selectCheckoutMethod(String asGuestOrAsRegister) {
        functionLibrary.waitForElementPresent(continueButtonInCheckOutMethod);
        switch (asGuestOrAsRegister.toLowerCase()) {
            case "guest" -> {
                functionLibrary.waitForElementPresent(checkoutAsGuestRadioButton);
                checkoutAsGuestRadioButton.click();}
            case "register" -> {
                functionLibrary.waitForElementPresent(registerAndCheckoutRadioButton);{
                    registerAndCheckoutRadioButton.click();}
            }
        }
        continueButtonInCheckOutMethod.click();
    }

    public void fillOutBillingInfoAsGuest(String firstName, String lastName, String email,String password, String address, String city, String country,
                                          String state, String zipCode, String telNum){
        functionLibrary.waitForElementPresent(billingFirstNameField);
        billingFirstNameField.sendKeys(firstName);
        functionLibrary.waitForElementPresent(billingLastNameField);
        billingLastNameField.sendKeys(lastName);
        functionLibrary.waitForElementPresent(billingEmailField);
        billingEmailField.sendKeys(email);
        functionLibrary.waitForElementPresent(billingAddress1Field);
        billingAddress1Field.sendKeys(address);
        functionLibrary.waitForElementPresent(billingCityField);
        billingCityField.sendKeys(city);
        functionLibrary.waitForElementPresent(billingPostalCodeField);
        billingPostalCodeField.sendKeys(zipCode);
        functionLibrary.waitForElementPresent(billingSelectCountry);
        billingSelectCountry.click();
        Select selectCountry=new Select(billingSelectCountry);
        selectCountry.selectByVisibleText(country);
        if(state.length()!=0) {
            functionLibrary.waitForElementPresent(billingSelectState);
            billingSelectState.click();
            Select selectState = new Select(billingSelectState);
            selectState.selectByVisibleText(state);
        }
        functionLibrary.waitForElementPresent(billingTelephoneField);
        billingTelephoneField.sendKeys(telNum);

        // as register user need to set up password.
        try{
            functionLibrary.waitForElementPresent(billingPasswordField);
            billingPasswordField.sendKeys(password);
            functionLibrary.waitForElementPresent(billingConfirmPasswordField);
            billingConfirmPasswordField.sendKeys(password);
        }catch (ElementNotInteractableException e){
            System.out.println("user as guest don't need to fill password field");
        }

        functionLibrary.waitForElementPresent(shipToThisAddress);
        shipToThisAddress.click();
        functionLibrary.waitForElementPresent(continueButtonInBilling);
        continueButtonInBilling.click();
    }

    public void provideShippingAndPaymentInfo(String shippingMethod, String paymentMethod, String purchaseOrderNumber) {
        functionLibrary.waitForElementPresent(flatRateRadioButton);
        switch (shippingMethod.toLowerCase()) {
            case ("flat rate") -> flatRateRadioButton.click();
            case ("free shipping") -> freeShippingRadioButton.click();
        }
        functionLibrary.waitForElementPresent(continueButtonInShippingMethod);
        functionLibrary.javaScriptClick(continueButtonInShippingMethod);
        functionLibrary.waitForElementPresent(check_moneyOrder_radioButton);
        switch (paymentMethod.toLowerCase()) {
            case "check / money order" -> {
                check_moneyOrder_radioButton.click();
            }
            case "purchase order" -> {
                functionLibrary.waitForElementPresent(purchaseOrder_radioButton);
                purchaseOrder_radioButton.click();
                functionLibrary.waitForElementPresent(purchaseOrderNumberField);
                purchaseOrderNumberField.sendKeys(purchaseOrderNumber);
            }
            case "cash on delivery" -> {
                functionLibrary.waitForElementPresent(cashOnDelivery_radioButton);
                cashOnDelivery_radioButton.click();
            }
        }
        continueButtonInPayment.click();
        functionLibrary.waitForElementPresent(placeOrderButton);
        placeOrderButton.click();
        functionLibrary.waitForElementPresent(checkoutSuccessConfirmation);
    }


    public boolean isCheckoutOrderSuccessful(){
      return   checkoutSuccessConfirmation.isDisplayed();
    }


    public void checkoutMyOrderBeforeLogin(String asGuestOrRegister, String firstName, String lastName, String email, String password, String address, String city, String country, String state,
                                           String zipCode, String telNum, String shippingMethod, String paymentMethod, String purchaseOrderNumber){
      goToCheckout();
     selectCheckoutMethod(asGuestOrRegister);
     fillOutBillingInfoAsGuest(firstName,lastName,email,password,address,city,country,state,zipCode,telNum);
     provideShippingAndPaymentInfo(shippingMethod,paymentMethod,purchaseOrderNumber);
    }


    public void checkOutMyOrderAfterLogin(String address, String city,String zipCode,String telNum,String country,String state,
                                          String shippingMethod,String paymentMethod,String purchaseOrderNumber){
        goToCheckout();
        functionLibrary.waitForElementPresent(continueButtonInBilling);
        try {
          billingAddress1Field.sendKeys(address);
          billingCityField.sendKeys(city);
          billingPostalCodeField.sendKeys(zipCode);
          billingTelephoneField.sendKeys(telNum);
          Select select =new Select(billingSelectCountry);
          select.selectByVisibleText(country);
          if(state.length()!=0){
          functionLibrary.waitForElementPresent(billingSelectState);
          billingSelectState.click();
          Select selectState = new Select(billingSelectState);
          selectState.selectByVisibleText(state);}
        }catch (ElementNotInteractableException e){
            System.out.println("we have your info");
        }
        functionLibrary.waitForElementPresent(continueButtonInBilling);
        continueButtonInBilling.click();
        provideShippingAndPaymentInfo(shippingMethod,paymentMethod,purchaseOrderNumber);
    }





}







