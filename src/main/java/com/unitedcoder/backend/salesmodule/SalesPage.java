package com.unitedcoder.backend.salesmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SalesPage {
    public Logger logger= LogManager.getLogger();
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public SalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }



    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logout;


    @FindBy(xpath = "//ul[@id='nav']/li/a/span[text()='Sales']")
    WebElement salesLinkTab;
    @FindBy(xpath = "//li/a/span[text()='Orders']")
    WebElement ordersLink;

    @FindBy(xpath = "//button[@title='Create New Order']/span")
    WebElement createNewOrderTab;

    @FindBy(css = "#sales_order_create_customer_grid_filter_email")
    WebElement searchByEmailFieldInCreateOrder;
    @FindBy(xpath = "(//span[contains(text(),'Search')])[1]")
    WebElement searchButtonInCreateOrder;
    @FindBy(xpath = "(//h4[contains(text(),'Please Select a Store')])[1]")
    WebElement selectStorePageHeader;
    @FindAll(@FindBy(xpath ="//div[@id='order-store-selector']//input[@class='radio']//parent::span/label"))
    List<WebElement> stores;

    @FindBy(xpath ="//div[@id='customer_account_fieds']//select[@id='group_id']")
    WebElement selectCustomerGroupInCreateOrder;
    @FindBy(xpath = "//div[@class='form-buttons']//button[@class='scalable add']//span[contains(text(),'Add Products')]")
    WebElement addProductsButtonInCreateOrder;
    @FindBy(xpath ="//input[@name='links[]']")
    WebElement checkboxProductDownloadableLink;
    @FindBy(xpath ="//input[@id='product_composite_configure_input_qty']" )
    WebElement inputQuantityInCreateOrder;
    @FindBy(xpath = "//input[@id='options_7_text']")
    WebElement priceFieldInCreateOrder;
    @FindBy(xpath = "(//div[@class='buttons-set a-right']//span[text()='OK'])[1]")
    WebElement oKButton;

    @FindBy(xpath ="//span[contains(text(),'Add Selected Product(s) to Order')]" )
    WebElement addSelectedProductsToOrder;

    @FindBy(xpath = "//dl[@class='payment-methods']//input[@title='Check / Money order']")
    WebElement radioButtonOfCheckOrMoney;
    @FindBy(xpath = "//dl[@class='payment-methods']//input[@title='Purchase Order']")
    WebElement radioButtonOfPurchaseOrder;
    @FindBy(xpath ="//dl[@class='payment-methods']//input[@title='Cash On Delivery']")
    WebElement radioButtonOfCashOnDelivery;
    @FindBy(xpath ="(//button[@onclick='order.submit()'])[2]")
    WebElement submitOrderButtonInCreateOrder;

    @FindBy(xpath ="//div[@id='messages']//li[@class='success-msg']" )
    WebElement successMessage;
    @FindBy(xpath = "//div[@class='box-left']//h4[contains(text(),'Order')]")
    WebElement headerOrderNumber;

    @FindBy(xpath = "//thead//tr[@class='filter']//input[@name='real_order_id']")
    WebElement filterByOrderInputFiled;

    @FindBy(xpath = "//div[@class='main-col']//button[@class='scalable ']//span[text()='Edit']")
    WebElement editButtonInEditOrders;
    @FindBy(xpath = "(//button[@class='scalable ']//span[text()='Configure'])[1]")
    WebElement configureButtonInEditOrder;
    @FindBy(css = "#sales_order_grid_table > tbody > tr > td.last > a")
    WebElement viewInEditOrder;
    @FindBy(xpath ="(//button[@class='scalable ']//span[contains(text(),'Cancel')])[1]")
    WebElement cancelButtonInViewOrder;

    //*************************** Sales Manager should be able to delete orders with in store pickup *****************

    @FindAll(@FindBy(xpath = "//div[@class=\"nav-bar\"]/ul/li/a"))
    List<WebElement> homePageAllRootTab;

    @FindBy(xpath = "//ul//li[@class=\"  level1\"]/a/span[text()=\"Orders\"]")
    WebElement ordersTab;

    @FindAll(@FindBy(xpath = "//table[@id=\"sales_order_grid_table\"]//tbody//tr"))
    List<WebElement> ordersList;
    @FindBy(xpath = "(//div//button[@title=\"Cancel\"]) [1]")
    WebElement cancelButton;

    //****************Sales Manager should be able to manage (add and update) tax rules (see Tax link under Store);
    @FindBy(xpath = "(//a//span[text()=\"Tax\"]) [1]")
    WebElement taxLink;
    @FindBy(xpath = "//li[@class=\"  level2\"]//span[text()=\"Manage Tax Rules\"]")
    WebElement manageTaxRules;
    @FindBy(xpath = "(//button[@title=\"Add New Tax Rule\"]) [1]")
    WebElement addNewTaxRuleButton;
    @FindBy(xpath = "//input[@id=\"code\"]")
    WebElement taxName;
    @FindBy(xpath = "//select[@id=\"tax_customer_class\"]")
    WebElement customerTaxClass;

    @FindBy(xpath = "//select[@id=\"tax_product_class\"]")
    WebElement productTaxClass;

    @FindBy(xpath = "//select[@id=\"tax_rate\"]")
    WebElement taxRate;

    @FindBy(xpath = "//input[@id=\"priority\"]")
    WebElement priority;

    @FindBy(xpath = "//input[@id=\"calculate_subtotal\"]")
    WebElement calculateoffsubtotalonlyCheckBox;

    @FindBy(xpath = "//input[@id=\"position\"]")
    WebElement sortOrder;

    @FindBy(xpath = "(//button[@title=\"Save Rule\"]) [1]")
    WebElement saveRule;



    //*************************** Sales Manager should be able to delete orders with in store pickup *****************
    public void navigateToOrdersListPage() {
        logger.info("Start delete orders with in store pickup");
        for (WebElement each : homePageAllRootTab) {
            if (each.getText().equals("Sales")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(each).build().perform();
                break;
            }
        }
        functionLibrary.waitForElementPresent(ordersTab);
        ordersTab.click();

    }

    public void deleteOrder(String orderValue) {
        for (WebElement each : ordersList) {
            if (each.getText().trim().contains(orderValue)) {
                each.click();
                break;
            }
        }
        if (cancelButton.isDisplayed()) {
            functionLibrary.waitForElementPresent(cancelButton);
            cancelButton.click();
            driver.switchTo().alert().accept();
            logger.info("order deleted");
        } else {
            System.out.println("this order can not display cancel button !!!");
            logger.info("this order can not display cancel button !!!");

        }
    }

    public boolean verifyNewProductAdded() {
        logger.info("Verify Delete Order ");
        functionLibrary.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("The order has been cancelled.")) {
            return true;
        } else {
            System.out.println(successMessage.getText());
        }
        return false;
    }

    public void navigateToManageTaxRulesPage() {
        logger.info("Start delete orders with in store pickup");
        for (WebElement each : homePageAllRootTab) {
            if (each.getText().equals("Sales")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(each).build().perform();
                break;
            }
        }
        functionLibrary.waitForElementPresent(taxLink);
        Actions actions=new Actions(driver);
        actions.moveToElement(taxLink).build().perform();
        functionLibrary.waitForElementPresent(manageTaxRules);
        manageTaxRules.click();
    }
    public void addNewTaxRule(String name,String customerTaxValue,String productTaxValue,String rate,
                              String priorityNumber,String sortOrderNumber){
        functionLibrary.waitForElementPresent(addNewTaxRuleButton);
        addNewTaxRuleButton.click();
        functionLibrary.waitForElementPresent(taxName);
        taxName.sendKeys(name);
        functionLibrary.waitForElementPresent(customerTaxClass);
        Select select=new Select(customerTaxClass);
        select.selectByVisibleText(customerTaxValue);
        functionLibrary.waitForElementPresent(productTaxClass);
        Select select1=new Select(productTaxClass);
        select1.selectByVisibleText(productTaxValue);
        functionLibrary.waitForElementPresent(taxRate);
        Select select2=new Select(taxRate);
        select2.selectByVisibleText(rate);
        functionLibrary.waitForElementPresent(priority);
        priority.sendKeys(priorityNumber);
        functionLibrary.waitForElementPresent(calculateoffsubtotalonlyCheckBox);
        calculateoffsubtotalonlyCheckBox.click();
        functionLibrary.waitForElementPresent(sortOrder);
        sortOrder.sendKeys(sortOrderNumber);
        functionLibrary.waitForElementPresent(saveRule);
        saveRule.click();

    }
    public void clickOnCreateOrder() {
        clickOnOrdersLink();
        logger.info("click on create order tab");
        functionLibrary.waitForElementPresent(createNewOrderTab);
        createNewOrderTab.click();
    }

    public void  selectCustomerToCreateOrder(String email){
        logger.info("Select A customer to create an order");
        functionLibrary.waitForElementPresent(searchByEmailFieldInCreateOrder);
        searchByEmailFieldInCreateOrder.sendKeys(email);
        functionLibrary.waitForElementPresent(searchButtonInCreateOrder);
        searchButtonInCreateOrder.click();
        FunctionLibrary.sleep(3);
        String myCustomerXpath ="//td[normalize-space()='?']";
        WebElement targetCustomer= driver.findElement(By.xpath(myCustomerXpath.replace("?",email)));
        functionLibrary.waitForElementPresent(targetCustomer);
        functionLibrary.javaScriptClick(targetCustomer);
    }


    public void chooseTheStore( String storeName){
        logger.info("choose the store");
        boolean isStoreClicked =false;
        for(WebElement eachStore: stores){
            functionLibrary.waitForElementPresent(eachStore);
            if(eachStore.getText().trim().equalsIgnoreCase(storeName)){
                functionLibrary.javaScriptClick(eachStore);
                isStoreClicked=true;
                logger.info("store clicked: " + storeName);
                break;
            }
        } if(!isStoreClicked) logger.info(" this store is not found : "+storeName);
        functionLibrary.sleep(5);

    }

    public boolean isCreateOrderFromStorePageDisplayed(){
        return  addProductsButtonInCreateOrder.isDisplayed();
    }


    public void  fillAccountInformation(String groupName){
        logger.info("Select GroupName for the Customer: "+groupName);
        functionLibrary.waitForElementPresent(selectCustomerGroupInCreateOrder);
        Select select=new Select(selectCustomerGroupInCreateOrder);
        select.selectByVisibleText("Team4 - Sweden");
        FunctionLibrary.sleep(5);

    }

    public void addProductsFromStore(String  productId, String customPrice, String quantity){
        logger.info("add Product from store");
        functionLibrary.waitForElementPresent(addProductsButtonInCreateOrder);
        functionLibrary.javaScriptClick(addProductsButtonInCreateOrder);
        logger.info("find my product checkbox");
        String checkBox="//input[@value='?'][@class='checkbox']";
        try {
            WebElement myCheckBox = driver.findElement(By.xpath(checkBox.replace("?", productId)));
            functionLibrary.waitForElementPresent(myCheckBox);
            myCheckBox.click();
        }catch (Exception e){
            logger.info("cant find this product id :"+productId);
        }
        try {
            functionLibrary.waitForElementPresent(checkboxProductDownloadableLink);
            checkboxProductDownloadableLink.click();
        }catch (Exception e){
            logger.info("checkbox ProductDownloadable Link is not available here" );
        }
        try {
            functionLibrary.waitForElementPresent(priceFieldInCreateOrder);
            priceFieldInCreateOrder.sendKeys(customPrice);
        }catch (Exception e){
            logger.info("Custom Options not available");
        }

        functionLibrary.waitForElementPresent(inputQuantityInCreateOrder);
        inputQuantityInCreateOrder.sendKeys(quantity);

        functionLibrary.waitForElementPresent(oKButton);
        oKButton.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        Actions actions=new Actions(driver);
        functionLibrary.waitForElementPresent(addSelectedProductsToOrder);
        actions.moveToElement(addSelectedProductsToOrder).click().build().perform();
        FunctionLibrary.sleep(3);
    }

    public void clickOnPaymentMethod(String paymentMethod) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        logger.info("click on payment method : " +paymentMethod);
        switch (paymentMethod.toLowerCase()){
            case "cash on delivery"->{functionLibrary.waitForElementPresent(radioButtonOfCashOnDelivery);
                radioButtonOfCashOnDelivery.click();}
            case "purchase order" -> {functionLibrary.waitForElementPresent(radioButtonOfPurchaseOrder);
                radioButtonOfPurchaseOrder.click();}
            case "check / money order"-> {
                functionLibrary.waitForElementPresent(radioButtonOfCheckOrMoney);
                radioButtonOfCheckOrMoney.click();}
            default -> logger.info("invalid payment method");
        }

    }

    public String submitOrder(){
        logger.info("Click on Submit order Button");
        functionLibrary.waitForElementPresent(submitOrderButtonInCreateOrder);
        submitOrderButtonInCreateOrder.click();
        logger.info("Submit order Button is clicked");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        functionLibrary.waitForElementPresent(headerOrderNumber);
        String[] orderDetails=headerOrderNumber.getText().trim().split(" ");
        logger.info("order number is : "+ orderDetails[2]);
        return orderDetails[2];
    }



    public boolean isOrderCreated(){
        logger.info(successMessage.getText());
        return successMessage.isDisplayed();
    }

    public void clickOnOrdersLink(){
        logger.info("click on orders link");
        functionLibrary.waitForElementPresent(salesLinkTab);
        functionLibrary.waitForElementPresent(salesLinkTab);
        salesLinkTab.click();
        functionLibrary.waitForElementPresent(ordersLink);
        ordersLink.click();
    }



    public void findMyOrderEndView(String orderNumber){
        functionLibrary.waitForElementPresent(salesLinkTab);
        salesLinkTab.click();
        logger.info("clicked on sales link");
        functionLibrary.waitForElementPresent(ordersLink);
        ordersLink.click();
        logger.info("clicked on orders link");
        functionLibrary.waitForElementPresent(filterByOrderInputFiled);
        filterByOrderInputFiled.clear();
        filterByOrderInputFiled.sendKeys(orderNumber);
        logger.info("filter my order by order number");
        functionLibrary.waitForElementPresent(searchButtonInCreateOrder);
        searchButtonInCreateOrder.click();
        functionLibrary.waitForElementPresent(viewInEditOrder);
        functionLibrary.javaScriptClick(viewInEditOrder);
    }
    public void editViewingOrder(String quantity){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        functionLibrary.waitForElementPresent(editButtonInEditOrders);
        editButtonInEditOrders.click();
        logger.info("Edit Button is clicked ");
        functionLibrary.waitForAlertAndAccept();
        logger.info("Alert accepted");
        functionLibrary.waitForElementPresent(configureButtonInEditOrder);
        configureButtonInEditOrder.click();
        logger.info("configure button clicked");
        functionLibrary.waitForElementPresent(inputQuantityInCreateOrder);
        inputQuantityInCreateOrder.clear();
        logger.info("quantity field is cleared");
        inputQuantityInCreateOrder.sendKeys(quantity+ Keys.ENTER);
        logger.info("new quantity is entered");
        functionLibrary.waitForElementPresent(submitOrderButtonInCreateOrder);
        submitOrderButtonInCreateOrder.click();
        logger.info("Submit Order Button is clicked");
    }


    public void editMyOrder(String orderNumber,String quantity){
        logger.info("Edit an Existing order Starts now, order number: "+orderNumber);
        findMyOrderEndView(orderNumber);
        editViewingOrder(quantity);
    }
    public boolean isOrderUpdated(){
        functionLibrary.waitForElementPresent(successMessage);
        logger.info("Confirmation message after editing displayed as : "+successMessage.getText());
        return successMessage.isDisplayed();
    }



}
