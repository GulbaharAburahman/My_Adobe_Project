package com.unitedcoder.backend;

import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.commonuse.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToAdminPage {
    Logger logger= LogManager.getLogger();
WebDriver driver;
FunctionLibrary functionLibrary;
final String configFile="config.properties";
String customerManagerUsername=UtilityClass.readFromConfig(configFile,"customerManager_username");
String catalogManagerUsername=UtilityClass.readFromConfig(configFile,"catalogManager_username");
String storeManagerUsername=UtilityClass.readFromConfig(configFile,"storeManager_username");
String marketingManagerUsername=UtilityClass.readFromConfig(configFile,"marketingManager_username");
String salesManagerUsername=UtilityClass.readFromConfig(configFile,"salesManager_username");
String reportingManagerUsername=UtilityClass.readFromConfig(configFile,"reportingManager_username");
String password=UtilityClass.readFromConfig(configFile,"backend_password");

@FindBy(css = "div[class='login-form'] h2")
WebElement headerLoginToAdminPanelPage;
    @FindBy(id="username")
    WebElement usernameField;
    @FindBy(id="login")
    WebElement passwordField;

    @FindBy(css = "input.form-button")
    WebElement loginButton;

    public LoginToAdminPage(WebDriver driver) {
        this.driver = driver;
        functionLibrary=new FunctionLibrary(driver);
        PageFactory.initElements(driver,this);
    }


    public void  loginToAdminPanelWithCredentials(String role){
        logger.info("login to Admin Panel as : "+role );
        functionLibrary.waitForElementPresent(usernameField);
        switch (role.toLowerCase()){
            case "customermanager"  ->usernameField.sendKeys(customerManagerUsername);
            case "catalogmanager"   ->usernameField.sendKeys(catalogManagerUsername);
            case "salesmanager"     ->usernameField.sendKeys(salesManagerUsername);
            case "storemanager"     ->usernameField.sendKeys(storeManagerUsername);
            case "marketingmanager" ->usernameField.sendKeys(marketingManagerUsername);
            case "reportingmanager" ->usernameField.sendKeys(reportingManagerUsername);
            default -> System.out.println("Invalid role, please try again");
            }
            functionLibrary.waitForElementPresent(passwordField);
            passwordField.sendKeys(password);
            functionLibrary.waitForElementPresent(loginButton);
            loginButton.click();
        }

        public boolean isLoginToAdminPanelPage(){
        functionLibrary.waitForElementPresent(headerLoginToAdminPanelPage);
        boolean a = headerLoginToAdminPanelPage.isDisplayed();
        logger.info("Is Login To Admin Panel Page ? "+a);
        return a;
        }


    }



