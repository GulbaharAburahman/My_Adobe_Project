package com.unitedcoder.backend.storemodule;

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

import java.util.List;

public class StorePage {
    public Logger logger= LogManager.getLogger();
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    @FindBy(xpath = "//ul[@id='nav']/li/a/span[text()='Sales']")
    WebElement salesLinkTab;
    @FindBy(xpath = "//li/a/span[text()='Orders']")
    WebElement ordersLink;

    @FindBy(xpath = "//button[@title='Create New Order']/span")
    WebElement createNewOrderTab;

    @FindBy(xpath = "//input[@id='sales_order_grid_filter_real_order_id']")
    WebElement orderField;

    @FindBy(css = "#sales_order_create_customer_grid_filter_email")
    WebElement searchByEmailFieldInCreateOrder;
    @FindBy(xpath = "(//span[contains(text(),'Search')])[1]")
    WebElement searchButtonInCreateOrder;

    @FindAll(@FindBy(xpath ="//div[@id='order-store-selector']//input[@class='radio']//parent::span/label"))
    List<WebElement> stores;

    @FindBy(xpath ="//div[@id='customer_account_fieds']//select[@id='group_id']")
            WebElement selectCustomerGroupInCreateOrder;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailFieldInCreateOrder;
    @FindBy(css=".form-buttons > .add > span" )
    WebElement addProductsButtonInCreateOrder;

    @FindBy(xpath ="//input[@id='sales_order_create_search_grid_filter_entity_id']" )
    WebElement idSearchFiledInCreateOrder;
    @FindAll(@FindBy(xpath = "//tbody//tr[@class='pointer']//input"))
    List<WebElement> productCheckBoxes;

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





   public void clickOnCreateOrder() {
       logger.info("find create order tab");
       functionLibrary.waitForElementPresent(salesLinkTab);
       salesLinkTab.click();
       functionLibrary.waitForElementPresent(ordersLink);
       ordersLink.click();
       functionLibrary.waitForElementPresent(createNewOrderTab);
       createNewOrderTab.click();
       logger.info("create new order Tab is clicked ");
   }

   public void  selectCustomerToCreateOrder(String email){
       logger.info("Select A customer to create an order");
       functionLibrary.waitForElementPresent(searchByEmailFieldInCreateOrder);
       searchByEmailFieldInCreateOrder.sendKeys(email);
       functionLibrary.waitForElementPresent(searchButtonInCreateOrder);
       searchButtonInCreateOrder.click();
       FunctionLibrary.sleep(2);
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

     FunctionLibrary.sleep(3);

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
       addProductsButtonInCreateOrder.click();
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
       FunctionLibrary.sleep(5);

       Actions actions=new Actions(driver);
       functionLibrary.waitForElementPresent(addSelectedProductsToOrder);
       actions.moveToElement(addSelectedProductsToOrder).click().build().perform();
       FunctionLibrary.sleep(3);

   }

   public void clickOnPaymentMethod(String paymentMethod) {
       logger.info("payment method");
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

   public void submitOrder(){
       FunctionLibrary.sleep(3);
       functionLibrary.waitForElementPresent(submitOrderButtonInCreateOrder);
       submitOrderButtonInCreateOrder.click();
   }

   public void createANewOrder(String customerEmail,String storeName,String groupName, String productId,
                               String customPrice,String quantity, String paymentOption){
       clickOnCreateOrder();
       selectCustomerToCreateOrder(customerEmail);
       chooseTheStore(storeName);
       fillAccountInformation(groupName);
       addProductsFromStore(productId,customPrice,quantity);
       clickOnPaymentMethod(paymentOption);
       submitOrder();
   }

   public String getOrderNumber(){
       functionLibrary.waitForElementPresent(headerOrderNumber);
       String[] orderDetails=headerOrderNumber.getText().trim().split(" ");
       logger.info("order number is : "+ orderDetails[2]);
       return orderDetails[2];
   }


   public boolean isOrderCreated(){
      logger.info(successMessage.getText());
      return successMessage.isDisplayed();
   }



   public void findMyOrderEndView(String orderNumber){
       functionLibrary.waitForElementPresent(salesLinkTab);
    salesLinkTab.click();
       logger.info("clicked on sales link");
    functionLibrary.waitForElementPresent(ordersLink);
    ordersLink.click();
       logger.info("clicked on orders link");
    functionLibrary.waitForElementPresent(filterByOrderInputFiled);
    filterByOrderInputFiled.sendKeys(orderNumber);
       logger.info("filter my order by order number");
    functionLibrary.waitForElementPresent(searchButtonInCreateOrder);
    searchButtonInCreateOrder.click();
    FunctionLibrary.sleep(3);
    functionLibrary.waitForElementPresent(viewInEditOrder);
    viewInEditOrder.click();
    FunctionLibrary.sleep(5);
   }
   public void editViewingOrder(String quantity){
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
       inputQuantityInCreateOrder.sendKeys(quantity+Keys.ENTER);
       logger.info("new quantity is entered");
       functionLibrary.waitForElementPresent(submitOrderButtonInCreateOrder);
       submitOrderButtonInCreateOrder.click();
       logger.info("Submit Order Button is clicked");
   }


   public void editMyOrder(String orderNumber,String quantity){
       logger.info("Edit an Existing order Starts now");
       findMyOrderEndView(orderNumber);
       editViewingOrder(quantity);
   }
   public boolean isOrderUpdated(){
       functionLibrary.waitForElementPresent(successMessage);
       logger.info("Confirmation message after editing displayed as : "+successMessage.getText());
       return successMessage.isDisplayed();
   }


   public void cancelOrder(String orderNumber){
       logger.info("cancel an existing order ");
       logger.info("find my order by order number and click on view ");
       findMyOrderEndView(orderNumber);
       FunctionLibrary.sleep(3);
       functionLibrary.waitForElementPresent(cancelButtonInViewOrder);
       cancelButtonInViewOrder.click();
       logger.info("Cancel button is clicked");
       functionLibrary.waitForAlertAndAccept();
       logger.info("Alert accepted");
   }

   public boolean isOrderCancelled(){
       functionLibrary.waitForElementPresent(successMessage);
       logger.info("confirmation message displayed as: "+successMessage.getText());
       return successMessage.isDisplayed();
   }











}