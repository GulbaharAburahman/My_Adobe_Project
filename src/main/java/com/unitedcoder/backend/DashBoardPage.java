package com.unitedcoder.backend;


import com.unitedcoder.commonuse.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    @FindBy(xpath ="//p[@class='super'][contains(text(),'Logged')]")
    WebElement loginHeaderText;

    @FindBy(xpath ="//a[text()='Log Out']")
    WebElement logoutButton;


    public boolean isLoginSuccessful(String role){
        functionLibrary.waitForElementPresent(loginHeaderText);
        String loginText=loginHeaderText.getText();
        return loginText.toLowerCase().contains(role.toLowerCase());

    }

    public void  logout(){
        functionLibrary.waitForElementPresent(logoutButton);
        logoutButton.click();
    }


}
