package com.unitedcoder.backend.customerModule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
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



public void  addCustomer(String website,String groupName,String firstname,String middleName,String lastname, String email, String DOB, String gender,boolean doYouWantWelcomeMail, String password ) {
 functionLibrary.waitForElementPresent(customersLinkTab);
 customersLinkTab.click();
 functionLibrary.waitForElementPresent(manageCustomers);
 manageCustomers.click();
 functionLibrary.waitForElementPresent(addNewCustomerButton);
 addNewCustomerButton.click();
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
 dateOfBirthField.sendKeys(DOB);
 functionLibrary.waitForElementPresent(selectGenderField);
 Select selectGender = new Select(selectGenderField);
 selectGender.selectByVisibleText(gender);
 functionLibrary.waitForElementPresent(sendWelcomeEmailCheckBox);
 sendWelcomeEmailCheckBox.click();
 functionLibrary.waitForElementPresent(passwordInputField);
 passwordInputField.sendKeys(password);
 functionLibrary.waitForElementPresent(saveCustomerButton);
 saveCustomerButton.click();
}

public boolean isCustomerAdded(){
 functionLibrary.waitForElementPresent(successMessage);
 return successMessage.isDisplayed();
}



}
