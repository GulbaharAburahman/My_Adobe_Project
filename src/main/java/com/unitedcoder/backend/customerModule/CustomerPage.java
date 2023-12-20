package com.unitedcoder.backend.customerModule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class CustomerPage {
 public  Logger logger= LogManager.getLogger("customerModule");
   WebDriver driver;
    FunctionLibrary functionLibrary;

    public CustomerPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    //*****************Customer Manager Home Page  ***********************

    @FindBy(linkText = "Customers")
    WebElement customersLinkTab;
    @FindBy(linkText = "Manage Customers")
    WebElement manageCustomers;

    @FindBy(linkText = "Customer Groups")
    WebElement customerGroups;
    @FindBy(css = "td.form-buttons>button>span")
    WebElement addNewCustomerButton;


//    ******************Add new customer section  ****************
    @FindBy(id = "_accountwebsite_id")
    WebElement selectAssociateToWebsiteDropDown;
    @FindBy(id = "_accountgroup_id")
    WebElement selectGroupField;
    @FindBy(id = "_accountfirstname")
    WebElement firstnameField;
    @FindBy(id = "_accountmiddlename")
    WebElement middleNameField;

    @FindBy(id = "_accountlastname")
    WebElement lastnameField;
    @FindBy(id = "_accountemail")
    WebElement emailField;
    @FindBy(id="_accountdob")
    WebElement dateOfBirthField;
    @FindBy(css = "img#_accountdob_trig")
    WebElement calendar;
    @FindBy(id = "_accountgender")
    WebElement selectGenderField;
    @FindBy(id = "_accountsendemail")
    WebElement sendWelcomeEmailCheckBox;
    @FindBy(id = "_accountpassword")
    WebElement passwordInputField;
    @FindBy(id = "account-send-pass")
    WebElement sendAutoGeneratedPasswordCheckBox;
    @FindBy(xpath = "//span[text()='Save Customer']")
    WebElement saveCustomerButton;
    @FindBy(css = "li.success-msg")
    WebElement successMessage;
    @FindBy(xpath ="//td[@class='title']")
     WebElement currentYearMonthElement;
    @FindBy(xpath = "//div[text()='«']")
    WebElement previousYearButton;
    @FindBy(xpath ="//div[text()='‹']")
    WebElement previousMonthButton;

    @FindAll(@FindBy(xpath ="//tr[@class='daysrow']//td[@class='day']" ))
    List<WebElement> weekDatesElements;
    @FindAll(@FindBy(xpath ="//tr[@class='daysrow']//td[@class='day weekend']"))
    List<WebElement> weekendDatesElements;

   @FindBy(id="_accountdob_trig")
   WebElement calender;


 //  *********************  edit  customers section *******************
@FindBy(xpath = "//tr//a/img[@alt='Go to Next page']")
 WebElement nextPage;

@FindBy(css="button.scalable.delete" )
 WebElement deleteCustomerTab;

@FindBy(id = "customer_info_tabs_addresses")
WebElement customersInfoAddressesTab;

@FindBy(css = "li>a#customer_info_tabs_account")
WebElement customerAccountInfoTab;

   // ******************** manage customers section methods *****************
public void  addCustomer(String website,String groupName,String firstname,String middleName,String lastname, String email,boolean doYouUseCalender, String DOB, String gender,boolean doYouWantWelcomeMail, String password ) {
logger.info("Add customer");
 functionLibrary.waitForElementPresent(customersLinkTab);
 customersLinkTab.click();
 logger.info("click on customers link");
 functionLibrary.waitForElementPresent(manageCustomers);
 manageCustomers.click();
 logger.info("click on manage customers ");
 functionLibrary.waitForElementPresent(addNewCustomerButton);
 addNewCustomerButton.click();
 logger.info("click on add customers tab and fill the form");
 functionLibrary.waitForElementPresent(selectAssociateToWebsiteDropDown);
 Select selectWebSite = new Select(selectAssociateToWebsiteDropDown);
 selectWebSite.selectByVisibleText(website);
 functionLibrary.waitForElementPresent(selectGroupField);
 Select selectGroup = new Select(selectGroupField);
 selectGroup.selectByVisibleText(groupName);
 functionLibrary.waitForElementPresent(firstnameField);
 firstnameField.sendKeys(firstname);
 functionLibrary.waitForElementPresent(middleNameField);
 middleNameField.sendKeys(middleName);
 functionLibrary.waitForElementPresent(lastnameField);
 lastnameField.sendKeys(lastname);
 functionLibrary.waitForElementPresent(emailField);
 emailField.sendKeys(email);
 dateOfBirthField.clear();
 functionLibrary.waitForElementPresent(dateOfBirthField);
 logger.info("have filled some , now need to enter DOB");
 if (!doYouUseCalender) {
  logger.info(" Enter the DOB without Calender");
  dateOfBirthField.sendKeys(DOB);
 }else { logger.info("Enter the DAB with Date picker");
  useDatePicker(DOB);}
  functionLibrary.waitForElementPresent(selectGenderField);
  Select selectGender = new Select(selectGenderField);
  selectGender.selectByVisibleText(gender);
  functionLibrary.waitForElementPresent(sendWelcomeEmailCheckBox);
  sendWelcomeEmailCheckBox.click();
  functionLibrary.waitForElementPresent(passwordInputField);
  passwordInputField.sendKeys(password);
  functionLibrary.waitForElementPresent(saveCustomerButton);
  saveCustomerButton.click();
  logger.info("clicked on SaveCustomerButton ");
}


public void pickYear(String year) {
  String[] currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
  logger.info("read current year and month from the calender : " + Arrays.toString(currentYearAndMonth));
 if (Integer.parseInt(year) < Integer.parseInt("2024") && Integer.parseInt(year) > 1900) {
  for (int i = 0; ; i++) {
   String currentYear = currentYearAndMonth[1].trim();
   if (!currentYear.equals(year)) {
    previousYearButton.click();
    currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
   } else {
   logger.info("The Year picked : " + currentYear);
    break;
   }
  }
 }else logger.info("DOB year is invalid");
}
public void pickMonth(String monthInLetters) {
 String[] currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
 String currentMonth = currentYearAndMonth[0].trim();
 logger.info("read current month from the calender: "+currentMonth);
 if (monthInLetters.length() != 0) {
  for (int i = 0; ; i++) {
   if (!currentMonth.equals(monthInLetters)) {
    previousMonthButton.click();
    currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
    currentMonth = currentYearAndMonth[0].trim();
   } else {
    logger.info("The month picked : " + currentMonth);
    break;
   }
  }
 }else logger.info("DOB month is invalid , picked current month: "+currentMonth);
}

public void pickDate(String expectedDate) {
 logger.info("Pick date");
  int expectedDateInNumber = Integer.parseInt(expectedDate);
  boolean isDatePicked = false;
  for (WebElement each : weekDatesElements) {
   int weekDate = Integer.parseInt(each.getText().trim());
   if (weekDate == expectedDateInNumber) {
   logger.info("The date picked : " + weekDate);
    each.click();
    isDatePicked = true;
    break;
   }
  }
  if (!isDatePicked) {
   for (WebElement each : weekendDatesElements) {
    int weekendDate = Integer.parseInt(each.getText().trim());
    if (weekendDate == expectedDateInNumber) {
     logger.info("clicked date is : " + weekendDate);
     each.click();
     isDatePicked = true;
     break;
    }
   }
  }

  if (!isDatePicked) {
   logger.info("please check the date : " +expectedDate+ ",it is not valid date in this month . current date is entered for you ");
  }
}

public String convertMonthInNumberToLetters(String month) {
 int monthInNumber = Integer.parseInt(month);
 String monthInLetters ="";
  switch (monthInNumber) {
   case 1-> monthInLetters = "January";
   case 2 -> monthInLetters = "February";
   case 3-> monthInLetters = "March";
   case 4 -> monthInLetters = "April";
   case 5 -> monthInLetters = "May";
   case 6-> monthInLetters = "June";
   case 7 -> monthInLetters = "July";
   case 8 -> monthInLetters = "August";
   case 9 -> monthInLetters = "September";
   case 10 -> monthInLetters = "October";
   case 11 -> monthInLetters = "November";
   case 12 -> monthInLetters = "December";
   default -> logger.error("Invalid month , the month should be two digits and between  01 to 12 ");
   }
  logger.info("The month in number "+ monthInNumber +" is converted to :"+monthInLetters);
  return monthInLetters;
 }


public void useDatePicker(String DOB){
 logger.info("Expected DOB :"+DOB);
 functionLibrary.waitForElementPresent(calender);
 calender.click();
 String[] expectedDOBData=DOB.trim().split("/");
 String year=expectedDOBData[2].trim();
 String monthInNumber=expectedDOBData[0].trim();
 String date =expectedDOBData[1].trim();
 pickYear(year);
 String monthInLetters= convertMonthInNumberToLetters(monthInNumber);
 pickMonth(monthInLetters);
 pickDate(date);

}


public boolean isCustomerAdded(){
 functionLibrary.waitForElementPresent(successMessage);
 logger.info("Add new customer validation: "+successMessage.getText());
 return successMessage.isDisplayed();
}

public void displayCustomersList(){
    logger.info("display customers List");
    functionLibrary.waitForElementPresent(customersLinkTab);
    customersLinkTab.click();
    functionLibrary.waitForElementPresent(manageCustomers);
    manageCustomers.click();
}


public void findMyEditIconAndClick(String email){
    displayCustomersList();
    logger.info("looking for target edit icon");
    String xpath = String.format("//td[contains(text(),'%s')]//parent::tr//td[@class=' last']/a", email);
    while (true) {
        try {
            WebElement edit = driver.findElement(By.xpath(xpath));
            functionLibrary.waitForElementPresent(edit);
            logger.info("found target edit ");
            edit.click();
            logger.info(" clicked on target edit");
            break;
        } catch (NoSuchElementException e) {
            logger.info("can't locate target edit icon in this page, try next page ");
        }
        try {
            functionLibrary.waitForElementPresent(nextPage);
            nextPage.click();
            FunctionLibrary.sleep(2);
        } catch (NoSuchElementException e) {
            logger.info("all pages been checked");
            break;
        }
    }
}

public void deleteCustomer(String email) throws InterruptedException {
    findMyEditIconAndClick(email);
 FunctionLibrary.sleep(2);
 deleteCustomerTab.click();
 logger.info("deleteCustomerTab is clicked");
 functionLibrary.waitForAlertAndAccept();
 logger.info("Alert Accepted");
}


public boolean  isCustomerDeleted(){
    logger.info("Finally, "+successMessage.getText());
  return successMessage.isDisplayed();
}


public void updateCustomer(String email,String newName, String newDOB){
    logger.info("find target icon and click to bring up customer information ");
   findMyEditIconAndClick(email);
   logger.info("customer information displayed");
   functionLibrary.waitForElementPresent(customerAccountInfoTab);
   customerAccountInfoTab.click();
   logger.info("Clicked on account information tab");
   functionLibrary.waitForElementPresent(middleNameField);
   logger.info("clear the middle name field and enter new name");
   middleNameField.clear();
   middleNameField.sendKeys(newName);
   functionLibrary.waitForElementPresent(dateOfBirthField);
   logger.info("Clear the DOB field and use calender to enter new DOB ");
   dateOfBirthField.clear();
   useDatePicker(newDOB);
   functionLibrary.waitForElementPresent(saveCustomerButton);
   saveCustomerButton.click();
   logger.info("finally clicked on the save button ");
}

 public  boolean isCustomerInfoUpDated(){
    functionLibrary.waitForElementPresent(successMessage);
    logger.info("Confirmation message displayed as:" +successMessage.getText());
    return successMessage.isDisplayed();
 }





}
