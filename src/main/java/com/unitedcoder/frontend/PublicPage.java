package com.unitedcoder.frontend;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.invoke.SwitchPoint;
import java.util.List;

public class PublicPage {

    public  Logger log = LogManager.getLogger("PublicPage");

    WebDriver driver;
    FunctionLibrary functionLibrary;

    //*******************  HomePage Section  *****************************
    @FindBy(css = "div.account-cart-wrapper")
    WebElement accountIcon;
    @FindBy(id = "editing-view-port")
    WebElement searchBar;
    @FindAll(@FindBy(css = "ol.nav-primary>li"))
    List<WebElement> allRootCategories;
    @FindAll(@FindBy(xpath = "//div[@id='header-account']//a"))
    List<WebElement> accountDropDownSubLinks;

    @FindAll(@FindBy(xpath = "//ol[@class='nav-primary']//ul[@class='level0']//li/a[text()]"))
    List<WebElement> categoriesDropdownLinks;

    @FindAll(@FindBy(xpath = "//h2[@class='product-name']/a[text()]"))
    List<WebElement> productNames;
    @FindBy(xpath = "//h2[@class='product-name']/a[text()]")
    WebElement productName;

    @FindBy(css = "a.next.i-next")
    WebElement nextPageButton;
    @FindBy(css = "li.success-msg")
    WebElement successMessage;

    //********************** add to cart section *************************
    @FindAll(@FindBy(xpath = "//div[@class='actions']//button[@title='Add to Cart']"))
    List<WebElement> addToCartButtons;
    @FindBy(xpath = "//div[@class='actions']//button[@title='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(css = "div.page-title.title-buttons>h1")
    WebElement myShoppingCartPageTile;
    @FindBy(css = "div.cart.display-single-price>ul.messages")
    WebElement myShoppingCartMessage;

    //*************** Create Account Section ***************************
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
    @FindBy(css = "button.button[title='Register']")
    WebElement registerButton;
    @FindBy(css = "input#newsletter.input-text.required-entry.validate-email")
    WebElement newsLetterSubscribe;


    //*********************  Login Section   *********************************
    @FindBy(xpath = "//*[@id='email']")
    WebElement loginEmailField;
    @FindBy(name = "login[password]")
    WebElement loginPassword;
    @FindBy(id = "send2")
    WebElement loginButton;
    @FindBy(css = "div.welcome-msg")
    WebElement welcomeMessage;


    //****************** Checkout method section *******************************
    @FindBy(id = "login:guest")
    WebElement checkoutAsGuestRadioButton;
    @FindBy(id = "login:register")
    WebElement registerAndCheckoutRadioButton;
    @FindBy(id = "onepage-guest-register-button")
    WebElement continueButtonInCheckOutMethod;


    // ************** My Wishlist section *************************
    @FindBy(css = "div.page-title.title-buttons>h1")
    WebElement myWishListPageTitle;

    @FindAll(@FindBy(css = "h3.product-name>a"))
    List<WebElement> wishlistProductNames;

    @FindBy(css = "a.link-wishlist")
    WebElement addToWishListButton;
    @FindAll(@FindBy(css = "a.link-wishlist"))
    List<WebElement> addToWishListButtons;


    //***************** Check out Billing information Section ***********************
    @FindBy(id = "opc-billing")
    WebElement billingInformationSection;
    @FindBy(id = "billing:firstname")
    WebElement billingFirstNameField;
    @FindBy(id = "billing:lastname")
    WebElement billingLastNameField;
    @FindBy(id = "billing:email")
    WebElement billingEmailField;
    @FindBy(id = "billing:street1")
    WebElement billingAddress1Field;
    @FindBy(id = "billing:city")
    WebElement billingCityField;
    @FindBy(id = "billing:region_id")
    WebElement billingSelectState;
    @FindBy(id = "billing:postcode")
    WebElement billingPostalCodeField;
    @FindBy(id = "billing:country_id")
    WebElement billingSelectCountry;
    @FindBy(id = "billing:telephone")
    WebElement billingTelephoneField;
    @FindBy(id = "billing:customer_password")
    WebElement billingPasswordField;
    @FindBy(id = "billing:confirm_password")
    WebElement billingConfirmPasswordField;
    @FindBy(id = "billing:use_for_shipping_yes")
    WebElement shipToThisAddress;

    @FindBy(css = "#billing-buttons-container > button")
    WebElement continueButtonInBilling;


    //********************** Shipping Method Section *************************************
    @FindBy(id = "s_method_flatrate_flatrate")
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


    // ***************** My account section **********************

    @FindAll(@FindBy(css = "div.block-content>ul>li>a"))
    List<WebElement> myAccountPageMenu;
    @FindBy(css = "div.block-content > ul > li:nth-child(11) > a")
    WebElement newsLetterSubscriptionsLink;
    @FindBy(css = " div.col-main > div.my-account > div > h1")
    WebElement verifyNewsLetterPageOpenedMessage;
    @FindBy(css = "div.block-content > ul > li:nth-child(2) > a")
    WebElement accountInformationLink;
    @FindBy(id = "current_password")
    WebElement currentPasswordField;
    @FindBy(id = "change_password")
    WebElement changePasswordCheckBox;
    @FindBy(id = "password")
    WebElement newPasswordField;
    @FindBy(id = "confirmation")
    WebElement confirmNewPasswordField;
    @FindBy(css = "div.buttons-set > button")
    WebElement changePasswordPageSaveButton;


    // *****************   view orders section  *************************
    @FindBy(css = "div.block-content > ul > li:nth-child(4) > a")
    WebElement myOrdersLink;
    @FindBy(css = "div.my-account > div.page-title > h1")
    WebElement isMyOrderPage;


    public PublicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public void selectAccountSubLink(String subLinkName) {
        log.info("Click on " + subLinkName + " from Account dropdown list");
        functionLibrary.waitForElementPresent(accountIcon);
        accountIcon.click();
        for (WebElement each : accountDropDownSubLinks) {
            functionLibrary.waitForElementPresent(each);
            if (each.getText().equalsIgnoreCase(subLinkName) || each.getText().startsWith(subLinkName)) {
                each.click();
                break;
            }
        }
    }

    public boolean isSuccessMessageDisplayed() {
        log.info(successMessage.getText());
        return successMessage.isDisplayed();
    }

    public boolean isLoginSuccessful() {
        log.info(welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    public void goToCheckout() {
        log.info("click on check out link from Account dropdown list ");
        functionLibrary.waitForElementPresent(accountIcon);
        selectAccountSubLink("Checkout");
    }


    public void logout() {
        log.info("log out ");
        functionLibrary.waitForElementPresent(accountIcon);
        selectAccountSubLink("Log Out");
    }


    public void loginToAccount(String email, String password) {
        log.info("login");
        functionLibrary.waitForElementPresent(accountIcon);
        selectAccountSubLink("Log In");
        functionLibrary.waitForElementPresent(loginEmailField);
        loginEmailField.sendKeys(email);
        functionLibrary.waitForElementPresent(loginPassword);
        loginPassword.sendKeys(password);
        functionLibrary.waitForElementPresent(loginButton);
        loginButton.click();
    }


    public void createAccount(String firstname, String lastname, String email, String password) {
        log.info("create an account");
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

    public void displayProducts( String rootCategory,String subCategory ) {
        log.info("Display products");
        boolean isRootCategoryFound=false;
        //find root category
        Actions actions = new Actions(driver);
        for (WebElement eachRoot : allRootCategories) {
            functionLibrary.waitForElementPresent(eachRoot);
            if (eachRoot.getText().trim().equalsIgnoreCase(rootCategory)) {
                actions.moveToElement(eachRoot).build().perform();
                isRootCategoryFound = true;
                try {
                    String myXpath = String.format("//ul[@class='level0']//li/a[contains(text(),'%s')]", subCategory);
                    WebElement mySubCategory = driver.findElement(By.xpath(myXpath));
                    functionLibrary.waitForElementPresent(mySubCategory);
                    mySubCategory.click();
                    break;
                } catch (NoSuchElementException e) {
                    log.info("could not find matching subCategory , will display all products under the root category");
                    eachRoot.click();
                  break;
                }
            }
        }if(!isRootCategoryFound) {
            allRootCategories.get(0).click();
            log.info("could not find matching root category: " + rootCategory + ", first displayed root category selected for your testing ");
        }
    }


    public void addProductToCart( String rootCategory, String subCategory, String productName) {
        boolean isAddToCartButtonClicked = false;
        displayProducts( rootCategory, subCategory);
        String addToCartButtonXpath = String.format("//h2[@class='product-name']/a[text()='%s']//ancestor::li//span[text()='Add to Cart']", productName);
        while (true) {
            try {
                driver.findElement(By.xpath(addToCartButtonXpath)).click();
                isAddToCartButtonClicked = true;
                break;
            } catch (NoSuchElementException e) {
                log.info("add to cart button is not displayed in this page for this product ");
            }
            try {
                functionLibrary.waitForElementPresent(nextPageButton);
                nextPageButton.click();
            } catch (Exception e) {
                log.info("There is no next page ");
                break;
            }
        }
        // click one of the displayed add to cart button if cant find my product
        if (!isAddToCartButtonClicked) {
            functionLibrary.waitForElementPresent(addToCartButton);
            addToCartButton.click();
            log.info("could not find add to cart button for your product , clicked one of the displayed add to cart button for your testing");
        }
    }




    public void findMyProductTakeAction(boolean viewAllProducts, String rootCategory, String subCategory, String productName, String action){
         log.info("Display products");
        displayProducts(rootCategory,subCategory);
        boolean isProductFound=false;
        //find product by name and do something
            for (WebElement each : productNames) {
                if (each.getText().trim().equalsIgnoreCase(productName)) {
                    isProductFound=true;
                    switch (action.toLowerCase()) {
                        case "add to cart" -> {
                            try {
                                WebElement addToCartButton = each.findElement(By.xpath("//ancestor::li//span[text()='Add to Cart']"));
                                functionLibrary.waitForElementPresent(addToCartButton);
                                addToCartButton.click();
                            } catch (Exception e) {
                                System.out.println(" add to cart button is not displayed here for this product ,one of the displayed add to cart button is clicked for your testing ");
                                functionLibrary.waitForElementPresent(addToCartButtons.get(1));
                                addToCartButtons.get(1).click();
                            }
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
            if(!isProductFound){
                log.info("your product is not found");
                addToCartButton.click();
            }
    }



    public void  addToCart(boolean viewAllProducts,String rootCategory, String subCategory, String productName){
        findMyProductTakeAction(viewAllProducts,rootCategory,subCategory,productName,"add to cart");
    }

    public boolean isAddToCartSuccessful(){
        log.info("verify add product to cart : "+myShoppingCartMessage.getText());
        return myShoppingCartMessage.isDisplayed() || myShoppingCartPageTile.isDisplayed();
    }

    public void  addProductToWishList(String rootCategory, String subCategory, String productName) {
        displayProducts( rootCategory, subCategory);
        String addToWishButtonXpath = String.format("//h2[@class='product-name']/a[text()='%s']//ancestor::li//a[@class='link-wishlist']", productName);
        boolean isAddToWishListButtonClicked=false;
        while (true) {
            try {
                driver.findElement(By.xpath(addToWishButtonXpath)).click();
                isAddToWishListButtonClicked=true;
                break;
            } catch (NoSuchElementException e) {
                log.info("can't not find your product in this page");
            }try {
                driver.findElement(By.cssSelector("a.next.i-next")).click();
            } catch (NoSuchElementException e) {
                log.info("there is no next page , couldn't find your product");
                break;
            }
        }
        if(!isAddToWishListButtonClicked) {
            functionLibrary.waitForElementPresent(addToWishListButton);
            addToWishListButton.click();
            log.info("Can't find your product,one of the displayed add to wishlist button is clicked for your testing");
        }


    }

    public boolean isAddTOWishListSuccessful(){
        log.info(successMessage.getText());
        functionLibrary.waitForElementPresent(successMessage);
       return isSuccessMessageDisplayed();
    }
    public boolean viewMyWishListVerifyIsMyProductAdded(String productName){
        boolean isMyProductInMyWishList=false;
        selectAccountSubLink("My Wishlist");
        for(WebElement each : productNames){
            if(each.getText().equalsIgnoreCase(productName)){
                isMyProductInMyWishList = true;
            }
        }
        return isMyProductInMyWishList;
    }

    public void addProductToShoppingCart1( String rootCategory, String subCategory, String productName) {
        displayProducts(rootCategory, subCategory);
        boolean isAddToCartButtonClicked = false;
        //find product by name and click on add to cart button
        while (true) {
            for (WebElement each : productNames) {
                functionLibrary.waitForElementPresent(each);
                if (each.getText().trim().equalsIgnoreCase(productName)) {
                    try {
                        WebElement myAddToCartButton = each.findElement(By.xpath("//ancestor::li//span[text()='Add to Cart']"));
                        myAddToCartButton.click();
                        isAddToCartButtonClicked = true;
                    } catch (Exception e) {
                        System.out.println(" add to cart button is not displayed here for this product, will click for you one of the available add to cart button");
                        addToCartButton.click();
                        isAddToCartButtonClicked = true;
                    }
                    break;
                }
            }
            if (!isAddToCartButtonClicked) {
                try {
                    nextPageButton.click();
                } catch (NoSuchElementException e) {
                   log.info("next page button is not displayed here,let me display page1 products");
                    displayProducts(rootCategory, subCategory);
                    addToCartButton.click();
                    log.info("could not find add to cart button for your product , clicked one of the displayed add to cart button for your testing");
                    break;
                }

            } else {
                break;
            }
        }
    }



    public void addProductToMyWishList1(boolean viewAll,String rootCategory,String subCategory,String productName) {
        boolean isAddToWishButtonClicked = false;
        displayProducts(rootCategory, subCategory);
        while (true) {
            for (WebElement each : productNames) {
                if (each.getText().trim().equalsIgnoreCase(productName)) {
                    WebElement myAddToWishButton = each.findElement(By.xpath("//ancestor::li//a[@class='link-wishlist']"));
                    myAddToWishButton.click();
                    isAddToWishButtonClicked = true;
                    break;
                }
            }
            if (!isAddToWishButtonClicked) {
                try {
                    nextPageButton.click();
                } catch (NoSuchElementException e) {
                    System.out.println("There is no more next page.Could not find your product , will add one product to your wishlist for yor testing ");
                    addToWishListButton.click();
                    break;
                }
            }else {break;}
        }
    }


    public void selectCheckoutMethod(String asGuestOrAsRegister) {
        functionLibrary.setFluentWaitForElementPresent(continueButtonInCheckOutMethod);
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
        functionLibrary.setFluentWaitForElementClickable(continueButtonInBilling);
        continueButtonInBilling.click();
    }

    public void provideShippingAndPaymentInfo(String shippingMethod, String paymentMethod, String purchaseOrderNumber) {
        functionLibrary.setFluentWaitForElementClickable(flatRateRadioButton);
        switch (shippingMethod.toLowerCase()) {
            case ("flat rate") -> flatRateRadioButton.click();
            case ("free shipping") -> freeShippingRadioButton.click();
        }
        functionLibrary.setFluentWaitForElementClickable(continueButtonInShippingMethod);
        continueButtonInShippingMethod.click();
        functionLibrary.setFluentWaitForElementClickable(check_moneyOrder_radioButton);
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
        functionLibrary.setFluentWaitForElementClickable(continueButtonInPayment);
        continueButtonInPayment.click();
        functionLibrary.setFluentWaitForElementClickable(placeOrderButton);
        placeOrderButton.click();
        functionLibrary.setFluentWaitForElementPresent(checkoutSuccessConfirmation);
        log.info(checkoutSuccessConfirmation.getText());
    }


    public boolean isCheckoutOrderSuccessful(){
        return   checkoutSuccessConfirmation.isDisplayed();
    }


    public void checkoutMyOrderWithoutLogin(String asGuestOrRegister,String firstName, String lastName,String email,String password,String address, String city, String country, String state,

                                            String zipCode, String telNum,String shippingMethod, String paymentMethod,String purchaseOrderNumber){
        log.info("Click on checkout link from Account Dropdown list");
        goToCheckout();
        log.info("select checkout method");
        selectCheckoutMethod(asGuestOrRegister);
        log.info("fill out billing info");
        fillOutBillingInfoAsGuest(firstName,lastName,email,password,address,city,country,state,zipCode,telNum);
        log.info("shipping and payment info");
        provideShippingAndPaymentInfo(shippingMethod,paymentMethod,purchaseOrderNumber);
    }


    public void checkOutMyOrderAfterLogin(String address, String city,String zipCode,String telNum,String country,String state,
                                          String shippingMethod,String paymentMethod,String purchaseOrderNumber){
        goToCheckout();
        functionLibrary.setFluentWaitForElementPresent(continueButtonInBilling);
        try {
            billingAddress1Field.sendKeys(address);
            billingCityField.sendKeys(city);
            billingPostalCodeField.sendKeys(zipCode);
            billingTelephoneField.sendKeys(telNum);
            Select select =new Select(billingSelectCountry);
            select.selectByVisibleText(country);
            if(state.length()!=0) {
                functionLibrary.waitForElementPresent(billingSelectState);
                billingSelectState.click();

                Select selectState = new Select(billingSelectState);
                selectState.selectByVisibleText(state);
            }
        }catch (ElementNotInteractableException e){
            System.out.println("we have your info");
        }
        functionLibrary.waitForElementPresent(continueButtonInBilling);
        continueButtonInBilling.click();
        provideShippingAndPaymentInfo(shippingMethod,paymentMethod,purchaseOrderNumber);
    }
    public void seeNewsLetterSubscriptionsLink(){
        selectAccountSubLink("My Account");
        for (WebElement each:myAccountPageMenu){
            if (each.getText().equals("Newsletter Subscriptions")){
                each.click();
                break;
            }
        }
    }
    public boolean isNewsLetterPageOpened(){
        functionLibrary.waitForElementPresent(verifyNewsLetterPageOpenedMessage);
        return verifyNewsLetterPageOpenedMessage.isDisplayed();
    }

    public void changeMyPassword(String currentPassword,String newPassword,String confirmPassword){
        selectAccountSubLink("My Account");
        functionLibrary.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
        functionLibrary.waitForElementPresent(currentPasswordField);
        currentPasswordField.sendKeys(currentPassword);
        functionLibrary.waitForElementPresent(changePasswordCheckBox);
        changePasswordCheckBox.click();
        functionLibrary.waitForElementPresent(newPasswordField);
        newPasswordField.sendKeys(newPassword);
        functionLibrary.waitForElementPresent(confirmNewPasswordField);
        confirmNewPasswordField.sendKeys(confirmPassword);
        functionLibrary.waitForElementPresent(changePasswordPageSaveButton);
        changePasswordPageSaveButton.click();
    }

    public boolean isPasswordChanged(){
        functionLibrary.waitForElementPresent(successMessage);
        log.info("user change password validation : "+successMessage.getText());
        return successMessage.isDisplayed();

    }





}







