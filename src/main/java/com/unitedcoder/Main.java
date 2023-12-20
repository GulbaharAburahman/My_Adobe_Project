package com.unitedcoder;
import com.unitedcoder.backend.LoginToAdminPage;
import com.unitedcoder.backend.customerModule.CustomerPage;
import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;


public class Main {

public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws InterruptedException {
       BaseClass baseClass = new BaseClass();
        baseClass.launchBrowser(BrowserType.CHROME);
        WebDriver driver = baseClass.driver;
        baseClass.navigateToBackEnd();
        LoginToAdminPage loginPage = new LoginToAdminPage(baseClass.driver);
        loginPage.loginToAdminPanelWithCredentials("StoreManager");
        FunctionLibrary functionLibrary = new FunctionLibrary(driver);

      WebElement sales =  driver.findElement(By.xpath("//ul[@id='nav']/li/a/span[text()='Sales']"));
      functionLibrary.waitForElementPresent(sales);
      sales.click();
      WebElement order=driver.findElement(By.xpath("//li/a/span[text()='Orders']"));
      functionLibrary.waitForElementPresent(order);
      order.click();
       WebElement createNewOrder= driver.findElement(By.xpath("//button[@title='Create New Order']/span"));
       functionLibrary.waitForElementPresent(createNewOrder);
       createNewOrder.click();
   //     Thread.sleep(3000);

WebElement emaIL= driver.findElement(By.cssSelector("#sales_order_create_customer_grid_filter_email"));
functionLibrary.waitForElementPresent(emaIL);
emaIL.sendKeys("timthomas@gmail.com");
WebElement search= driver.findElement(By.xpath(" (//span[contains(text(),'Search')])[1]"));
  search.click();
  FunctionLibrary.sleep(3);

  WebElement myCustomer= driver.findElement(By.xpath("//td[normalize-space()='timthomas@gmail.com']"));
 functionLibrary.waitForElementPresent(myCustomer);
  functionLibrary.javaScriptClick(myCustomer);;

 WebElement myRadioButton= driver.findElement(By.xpath("(//div[@id='order-store-selector']//label[text()='Treat']//parent::span/input)[1]"));
 functionLibrary.waitForElementPresent(myRadioButton);
 functionLibrary.javaScriptClick(myRadioButton);
 Thread.sleep(3000);



WebElement selectDropDown=driver.findElement(By.xpath("//div[@id='customer_account_fieds']//select[@id='group_id']"));
    Select select=new Select(selectDropDown);
 select.selectByVisibleText("Team4 - Sweden");

 WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
   functionLibrary.waitForElementPresent(emailField);
   emailField.sendKeys("timthomas@gmail.com");

        Thread.sleep(5000);

        WebElement addProductsButton=driver.findElement(By.cssSelector(".form-buttons > .add > span"));

        functionLibrary.waitForElementPresent(addProductsButton);
    functionLibrary.javaScriptClick(addProductsButton);

WebElement idField=driver.findElement(By.xpath("//input[@id='sales_order_create_search_grid_filter_entity_id']"));
functionLibrary.waitForElementPresent(idField);
idField.sendKeys("1188"+Keys.RETURN);
Thread.sleep(3000);

WebElement myCheckBox=driver.findElement(By.xpath("//input[@value='1188'][@class='checkbox']"));
functionLibrary.waitForElementPresent(myCheckBox);
myCheckBox.click();
Thread.sleep(2000);
WebElement checkBox= driver.findElement(By.xpath("//input[@name='links[]']"));
functionLibrary.waitForElementPresent(checkBox);
checkBox.click();
WebElement priceTextBox=driver.findElement(By.xpath("//input[@id='options_7_text']"));
priceTextBox.sendKeys("88");
WebElement quantityInput=driver.findElement(By.xpath("//input[@id='product_composite_configure_input_qty']"));
functionLibrary.waitForElementPresent(quantityInput);
quantityInput.sendKeys("2");
WebElement ok=driver.findElement(By.xpath("(//div[@class='buttons-set a-right']//span[text()='OK'])[1]"));
functionLibrary.waitForElementPresent(ok);
ok.click();
Thread.sleep(5000);


WebElement addToOrder=driver.findElement(By.xpath("//span[contains(text(),'Add Selected Product(s) to Order')]"));
Actions actions=new Actions(driver);
actions.moveToElement(addToOrder).click().build().perform();
        Thread.sleep(3000);



WebElement shipping=driver.findElement(By.id("p_method_cashondelivery"));
functionLibrary.waitForElementPresent(shipping);
shipping.click();

WebElement checkout = driver.findElement(By.xpath("(//button[@onclick='order.submit()'])[2]"));
functionLibrary.waitForElementPresent(checkout);
checkout.click();

Thread.sleep(5000);
WebElement successMessage=driver.findElement(By.xpath("//div[@id='messages']//li[@class='success-msg']"));
functionLibrary.waitForElementPresent(successMessage);
        System.out.println(successMessage.getText());





        WebElement headerOrderNumber=driver.findElement(By.xpath( "//div[@class='box-left']//h4[contains(text(),'Order')]"));

        functionLibrary.waitForElementPresent(headerOrderNumber);
        String[] orderDetails=headerOrderNumber.getText().trim().split(" ");
        System.out.println(orderDetails[2] );


        }
    }



