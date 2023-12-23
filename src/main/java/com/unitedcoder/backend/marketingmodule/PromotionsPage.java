package com.unitedcoder.backend.marketingmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PromotionsPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    public Logger logger= LogManager.getLogger();


    public PromotionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);

    }

    // ************************ Promotions  ************************

    @FindAll(@FindBy(xpath = "//div[@class=\"nav-bar\"]/ul/li/a"))
    List<WebElement> homePageAllRootTab;

    @FindBy(xpath ="//span[contains(text(),'Promotions')]")
    WebElement promotionsLink;

    @FindBy(xpath = "//span[contains(text(),'Catalog Price Rules')]")
    WebElement catalogPriceRulesLink;
    @FindBy(xpath = "//td[@class='pager']//select[@name='limit']")
    WebElement viewLimitSelectField;
    @FindBy(xpath = "//tr//img[@alt='Go to Next page']")
    WebElement nextPageArrow;
    @FindBy(xpath ="//input[@name='rule_id']" )
    WebElement ruleIdSearchField;
    @FindBy(xpath = "//input[@id='promo_catalog_grid_filter_name']")
    WebElement ruleNameSearchField;
    @FindBy(xpath = "//button[@class='scalable task']")
    WebElement searchButton;

    @FindBy(xpath = "//td[@class='pager']")
    WebElement pageTextElement;
    @FindBy(xpath = "//tbody//tr//td[@class='a-right ']")
    WebElement ruleId;

    @FindBy(xpath ="(//button[@class='scalable delete'])[1]" )
    WebElement deleteButton;

    @FindBy(xpath = "//input[@id='rule_from_date']")
    WebElement fromDateField;
    @FindBy(xpath = "//input[@id='rule_to_date']")
    WebElement toDateField;

    @FindBy(xpath = "(//button[@class='scalable save']//span[contains(text(),'Save and Apply')])[1]")
    WebElement saveAndApplyButton;
    @FindBy(xpath = "//ul//li//a/span[text()='Shopping Cart Price Rules']")
    WebElement shoppingCartPriceRules;

    @FindBy(xpath = "(//div//td//button//span[text()=\"Add New Rule\"]) [1]")
    WebElement addNewRuleButton;

    @FindBy(xpath = "//input[@id='rule_name']")
    WebElement ruleNameField;

    @FindBy(xpath = "//textarea[@id=\"rule_description\"]")
    WebElement descriptionField;

    @FindBy(xpath = "//select[@id='rule_is_active']")
    WebElement statusSelectBox;
    @FindBy(xpath = "//select[@id='rule_website_ids']")
    WebElement websitesSelectBox;
    @FindBy(xpath = "//select[@id='rule_customer_group_ids']")
    WebElement customerGroupsSelectBox;

    @FindBy(xpath = "//select[@id=\"rule_coupon_type\"]")
    WebElement coupon;
    @FindBy(xpath = "//input[@id=\"rule_uses_per_customer\"]")
    WebElement usesPerCustomer;

    @FindBy(xpath = "(//img[@title=\"Select Date\"]) [1]")
    WebElement fromDateCalendar;
    @FindBy(xpath = "(//img[@title=\"Select Date\"]) [2]")
    WebElement toDateCalendar;

    @FindBy(xpath = "//input[@id=\"rule_sort_order\"]")
    WebElement priority;
    @FindBy(xpath = "//select[@id=\"rule_is_rss\"]")
    WebElement publicInRSSFeed;

    @FindBy(xpath = "(//img[@title=\"Add\"]) [1]")
    WebElement addCondition;
    @FindBy(xpath = "//select[@id=\"conditions__1__new_child\"]")
    WebElement selectCondition;

    @FindBy(xpath = "//a[@title=\"Actions\"]")
    WebElement action;

    @FindBy(xpath = "//select[@id='rule_simple_action']")
    WebElement applyOptionsSelectBox;
    @FindBy(xpath = "//input[@id='rule_discount_amount']")
    WebElement discountAmount;
    @FindBy(xpath = "//input[@id=\"rule_discount_qty\"]")
    WebElement maximumQty;

    @FindBy(xpath = "//input[@id=\"rule_discount_step\"]")
    WebElement discountQty;

    @FindBy(xpath = "//select[@id=\"rule_apply_to_shipping\"]")
    WebElement applyToShippingAmount;

    @FindBy(xpath = "//select[@id=\"rule_simple_free_shipping\"]")
    WebElement freeShipping;

    @FindBy(xpath = "id=\"rule_stop_rules_processing\"")
    WebElement stopFurtherRulesProcessing;

    @FindBy (xpath = "(//span[@class=\"rule-param rule-param-new-child\"]) [3]")
    WebElement applyAddButton;

    @FindBy(xpath = "//select[@id=\"actions__1__new_child\"]")
    WebElement applyConditions;
    @FindBy(xpath = "//a[@title=\"Labels\"]")
    WebElement labels;

    @FindBy(xpath = "//input[@id=\"rule_store_default_label\"]")
    WebElement defaultLabels;
    @FindBy(xpath = "(//button[@title=\"Save\"]) [1]")
    WebElement saveButton;

    @FindBy(xpath = "//li[@class='success-msg']")
    WebElement successMessage;






    public void navegateToAddNewRulePage() {
        logger.info("Start Add Shopping Cart Price Rule");
        for (WebElement each : homePageAllRootTab) {
            if (each.getText().equals("Promotions")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(each).build().perform();
                break;
            }
        }
        functionLibrary.waitForElementPresent(shoppingCartPriceRules);
        shoppingCartPriceRules.click();
        functionLibrary.waitForElementPresent(addNewRuleButton);
        addNewRuleButton.click();

    }

    public void fillRuleInformation(String name, String des, String statu, String website, String group, String coupo
            , String priorit, String publicInRss) {
        logger.info("Fill Rule Information Page");
        functionLibrary.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(name);
        functionLibrary.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(des);
        functionLibrary.waitForElementPresent(statusSelectBox);
        Select select = new Select(statusSelectBox);
        select.selectByVisibleText(statu);
        functionLibrary.waitForElementPresent(websitesSelectBox);
        Select select1 = new Select(websitesSelectBox);
        select1.selectByVisibleText(website);
        functionLibrary.waitForElementPresent(customerGroupsSelectBox);
        Select select2 = new Select(customerGroupsSelectBox);
        select2.selectByVisibleText(group);
        functionLibrary.waitForElementPresent(coupon);
        Select select3 = new Select(coupon);
        select3.selectByVisibleText(coupo);
        functionLibrary.waitForElementPresent(priority);
        priority.sendKeys(priorit);
        functionLibrary.waitForElementPresent(publicInRSSFeed);
        Select select4 = new Select(publicInRSSFeed);
        select4.selectByVisibleText(publicInRss);
    }

    String tab_Name = "//div//a[@title=\"?\"]";

    public void selectPriceRuleTab(String tabName) {
        WebElement tabElement = driver.findElement(By.xpath(tab_Name.replace("?", tabName)));
        functionLibrary.waitForElementPresent(tabElement);
        Actions actions = new Actions(driver);
        actions.click(tabElement).build().perform();
    }

    public void conditions(String tabName, String conditions) {
        logger.info("Fill Conditions Page");
        selectPriceRuleTab(tabName);
        functionLibrary.waitForElementPresent(addCondition);
        addCondition.click();
        functionLibrary.waitForElementPresent(selectCondition);
        Select select = new Select(selectCondition);
        select.selectByVisibleText(conditions);

    }

    public void actions(String applye, String discountA , String maximumQ , String discountQ
            , String applyAmount , String freeship,  String addApply) {
        logger.info("Fill Actions Page");
        functionLibrary.waitForElementPresent(action);
        action.click();
        functionLibrary.waitForElementPresent(applyOptionsSelectBox);
        Select select=new Select(applyOptionsSelectBox);
        select.selectByVisibleText(applye);
        functionLibrary.waitForElementPresent(discountAmount);
        discountAmount.sendKeys(discountA);
        functionLibrary.waitForElementPresent(maximumQty);
        maximumQty.sendKeys(maximumQ);
        functionLibrary.waitForElementPresent(discountQty);
        discountQty.sendKeys(discountQ);
        functionLibrary.waitForElementPresent(applyToShippingAmount);
        Select select1=new Select(applyToShippingAmount);
        select1.selectByVisibleText(applyAmount);
        functionLibrary.waitForElementPresent(freeShipping);
        Select select2=new Select(freeShipping);
        select2.selectByVisibleText(freeship);
//        functionLibrary.waitForElementPresent(stopFurtherRulesProcessing);
//        Select select3=new Select(stopFurtherRulesProcessing);
//        select3.selectByValue(stopFurther);
        functionLibrary.waitForElementPresent(applyAddButton);
        applyAddButton.click();
        functionLibrary.waitForElementPresent(applyConditions);
        Select select4=new Select(applyConditions);
        select4.selectByVisibleText(addApply);


    }
    public void labels(String label){
        logger.info("Fill Labels Page");
        functionLibrary.waitForElementPresent(labels);
        labels.click();
        functionLibrary.waitForElementPresent(defaultLabels);
        defaultLabels.sendKeys(label);
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }
    public boolean verifyNewProductAdded() {
        logger.info("Verify New Product Added ");
        functionLibrary.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("The rule has been saved.")) {
            return true;
        } else {
            System.out.println(successMessage.getText());
        }
        return false;
    }

    public void clickOnCatalogPriceRules(){
        logger.info("Click on Catalog Price Rules sub link tab");
        Actions actions=new Actions(driver);
        functionLibrary.waitForElementPresent(promotionsLink);
        actions.moveToElement(promotionsLink).build().perform();
        functionLibrary.waitForElementPresent(catalogPriceRulesLink);
        actions.moveToElement(catalogPriceRulesLink).click().build().perform();
    }

    public void fillCatalogPriceRuleInformation(String nameOfRule, String descriptionText, String activeOrInactive, String websiteName, String groupName, String fromDate, String toDate ){
        logger.info("click on add new rule button ");
        functionLibrary.waitForElementPresent(addNewRuleButton);
        logger.info("fill a new catalog price rule form");
        addNewRuleButton.click();
        functionLibrary.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(nameOfRule);
        functionLibrary.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(descriptionText);
        functionLibrary.waitForElementPresent(statusSelectBox);
        Select select1=new Select(statusSelectBox);
        switch (activeOrInactive.toLowerCase()){
            case "active"->select1.selectByVisibleText("Active");
            case "inactive"->select1.selectByVisibleText("Inactive");
            default -> logger.info(activeOrInactive +" is Not valid status. Enter true for active , false for inactive ");
        }
        functionLibrary.waitForElementPresent(websitesSelectBox);
        Select select2=new Select(websitesSelectBox);
        select2.selectByVisibleText(websiteName);
        functionLibrary.waitForElementPresent(customerGroupsSelectBox);
        Select select3=new Select(customerGroupsSelectBox);
        select3.selectByVisibleText(groupName);
        functionLibrary.waitForElementPresent(fromDateField);
        fromDateField.sendKeys(fromDate);
        functionLibrary.waitForElementPresent(toDateField);
        toDateField.sendKeys(toDate);
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public void fillCatalogPriceRuleActions(String priceApplyOption,String amount){
        logger.info("fill Price Rule Actions ");
        functionLibrary.waitForElementPresent(applyOptionsSelectBox);
        Select selectApplyOption=new Select(applyOptionsSelectBox);
        switch (priceApplyOption.toLowerCase()){
            case "by percentage"->selectApplyOption.selectByVisibleText("By Percentage of the Original Price");
            case "by fixed amount"->selectApplyOption.selectByVisibleText("By Fixed Amount");
            case "to percentage"->selectApplyOption.selectByVisibleText("To Percentage of the Original Price");
            case "to fixed"->selectApplyOption.selectByVisibleText("To Fixed Amount");
            default -> logger.info("Invalid Price Apply Option, the option should be  : by percentage  or by fixed amount or to percentage or to fixed ");
        }
        functionLibrary.waitForElementPresent(discountAmount);
        discountAmount.sendKeys(amount);
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }


    public void addNewCatalogPriceRule(String catalogPriceRuleName,String description,String activeOrInactive,String websiteName,String groupName,
                                       String fromDate,String toDate,String priceApplyOption,String amount){
        clickOnCatalogPriceRules();
        fillCatalogPriceRuleInformation(catalogPriceRuleName, description,activeOrInactive,websiteName,groupName,fromDate,toDate);
        fillCatalogPriceRuleActions(priceApplyOption,amount);
    }

    public boolean isNewCategoryPriceRuleCreated(){
        functionLibrary.waitForElementPresent(successMessage);
        logger.info(successMessage.getText());
        return successMessage.isDisplayed();
    }


    public String getIdOfCatalogPriceRule(String  categoryPriceRuleName){
        logger.info(" get Catalog Price Rule id ");
        clickOnCatalogPriceRules();
        functionLibrary.waitForElementPresent(viewLimitSelectField);
        viewLimitSelectField.sendKeys("200");
        String myId="";
        while (true) {
            try {
                String myIdXpath=String.format("//td[contains(text(),'%s')]//parent::tr//td[@class='a-right ']",categoryPriceRuleName);
                WebElement myRuleId =driver.findElement(By.xpath(myIdXpath));
                functionLibrary.waitForElementPresent(myRuleId);
                myId= myRuleId.getText().trim();
                logger.info("Category Pricing Rule Id is : "+myId);
                break;
            } catch (NoSuchElementException e) {
                logger.info("Could not find in this page");
            }
            try {
                functionLibrary.waitForElementPresent(nextPageArrow);
                nextPageArrow.click();
            } catch (NoSuchElementException e) {
                logger.info("all pages been checked , could not find the rule: " + categoryPriceRuleName);
                break;
            }
        }
        return myId;
    }

    public void searchCatalogPricingRuleByIdAndRuleName(String ruleName, String ruleId){
        clickOnCatalogPriceRules();
        logger.info("Search Rule By Id and Rule Name: "+ruleId +"  "+ruleName);
        functionLibrary.waitForElementPresent(ruleIdSearchField);
        ruleIdSearchField.sendKeys(ruleId);
        functionLibrary.waitForElementPresent(ruleNameSearchField);
        ruleNameSearchField.sendKeys(ruleName);
        functionLibrary.waitForElementPresent(searchButton);
        searchButton.click();

    }

    public boolean isSearchCategoryPricingRuleSuccessful(){
        functionLibrary.waitForElementPresent(pageTextElement);
        String pageText = pageTextElement.getText();
        logger.info("is search successful "+pageText.contains("Total 1 records found"));
        return pageText.contains("Total 1 records found");
    }

    public void deleteMyCategoryPricingRule(String catalogPricingName, String id){
        logger.info("Delete Category Pricing Rule" );
        searchCatalogPricingRuleByIdAndRuleName(catalogPricingName,id);
        functionLibrary.waitForElementPresent(ruleId);
        ruleId.click();
        logger.info("click on Delete Button");
        functionLibrary.waitForElementPresent(deleteButton);
        deleteButton.click();
        logger.info("Accept Alert");
        functionLibrary.waitForAlertAndAccept();
    }

    public boolean isCatalogPricingRuleDeleted(){
        functionLibrary.waitForElementPresent(successMessage);
        logger.info(successMessage.getText());
        return successMessage.isDisplayed();
    }


}


