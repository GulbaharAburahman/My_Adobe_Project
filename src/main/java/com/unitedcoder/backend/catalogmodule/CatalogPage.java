package com.unitedcoder.backend.catalogmodule;

import com.unitedcoder.commonuse.FunctionLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static com.unitedcoder.commonuse.FunctionLibrary.*;

public class CatalogPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    Logger logger = LogManager.getLogger("CatalogModule");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }
    //**************  Catalog Manager can add products  ***************************

    @FindBy(xpath = "//div//a[@id=\"product_info_tabs_group_22\"]")
    WebElement ImageTab;
    @FindAll
            (@FindBy(xpath = "//div[@class=\"nav-bar\"]/ul/li/a"))
    List<WebElement> megentoAllTabList;
    @FindBy(xpath = "//div//span[text()=\"Manage Products\"]")
    WebElement manageProductLink;

    @FindBy(xpath = "(//td/button[@class=\"scalable add\"]) [1]")
    WebElement addProductLink;

    @FindAll(@FindBy(xpath = "//div//td[@class=\"value\"]/select/option"))
    java.util.List<WebElement> createProductSettingsSelectList;
    @FindBy(xpath = "//div//select[@id=\"attribute_set_id\"]")
    WebElement newProductAttributeSet;
    //id="product_type"
    @FindBy(xpath = "//div//select[@id=\"product_type\"]")
    WebElement newProductProductType;
    @FindBy(xpath = "//div//td[@class=\"value\"]/span[@id=\"continue_button\"]")
    WebElement createProductContinueButton;
    @FindAll(@FindBy(xpath = "//div//ul[@id=\"product_info_tabs\"]//li"))
    java.util.List<WebElement> product_info_tabs;
    @FindBy(xpath = "//div//a[@id=\"product_info_tabs_group_22\"]")
    WebElement imageTab;
    @FindBy(xpath = "//div//button[@title=\"Save\"]")
    WebElement newProductSaveButton;

    //verify
    //The product has been saved.
    @FindBy(xpath = "//div//li[@class=\"success-msg\"]")
    WebElement newProductSuccess_msg;


    //newProductGeneral
    @FindBy(xpath = "//div//input[@id=\"name\"]")
    WebElement newProductName;
    @FindBy(xpath = "//div//textarea[@id=\"description\"]")
    WebElement newProductDescription;
    @FindBy(xpath = "//div//textarea[@id=\"short_description\"]")
    WebElement newProductShortDescription;

    @FindBy(xpath = "(//div//span[text()=\"WYSIWYG Editor\"]) [1]")
    WebElement wysiwygEditorForDescription;
    @FindBy(xpath = "(//div//span[text()=\"WYSIWYG Editor\"]) [2]")
    WebElement wysiwygEditorForShortDescription;
    @FindBy(xpath = "//div//input[@id=\"sku\"]")
    WebElement newProductSKU;
    @FindBy(xpath = "//div//input[@id=\"weight\"]")
    WebElement newProductWeight;
    @FindBy(xpath = "//div//input[@id=\"news_from_date\"]")
    WebElement setProductAsNewFromData;
    @FindBy(xpath = "//div//td//img[@id=\"news_from_date_trig\"]")
    WebElement newProductDate;
    @FindBy(xpath = "//div//input[@id=\"news_to_date\"]")
    WebElement setProductAsNewToData;
    @FindBy(xpath = "//div//td//img[@id=\"news_to_date_trig\"]")
    WebElement setProductNewToDate;
    @FindBy(xpath = "//div//select[@id=\"status\"]")
    WebElement newProductStatus;
    @FindBy(xpath = "//div//input[@id=\"url_key\"]")
    WebElement newProductURLKey;
    @FindBy(xpath = "//div//select[@id=\"visibility\"]")
    WebElement newProductVisibility;
    @FindBy(xpath = "//div//select[@id=\"country_of_manufacture\"]")
    WebElement newProductCountryManufacture;

    //newProductCreteNewAttribute
    @FindBy(xpath = "//div//button[@id=\"create_attribute_33\"]")
    WebElement creteNewAttribute;
    @FindBy(xpath = "//div//input[@id=\"attribute_code\"]")
    WebElement newProductAttributeCode;
    //For internal use. Must be unique with no spaces.
    // Maximum length of attribute code must be less then 30 symbols.
    // Do not use "event" for an attribute code, it is a reserved keyword.
    @FindBy(xpath = "(//div//button[@id=\"id_afd22a59e6d161bc9082d2559b4c2e92\"]) [1]")
    WebElement newProductSaveAttribute;
    @FindBy(xpath = "(//div//button[@id=\"id_9cebe0103fe560982250b3535fe938e8\"]) [1]")
    WebElement getNewProductAttributeCloseWindow;

    @FindBy(xpath = "//div//button[@id=\"id_a19e1a2258c4b24f33939931c42325d0\"]")
    WebElement newProductSave;


    //newProductPrice
    @FindBy(xpath = "//div//input[@id=\"price\"]")
    WebElement newProductPrice;
    @FindBy(xpath = "//div//input[@id=\"price\"]")
    WebElement newProductGroupPrice;
    @FindBy(xpath = "//div//button[@id=\"id_35e913dca4b115eb57aeed42e8ef504c\"]")
    WebElement newProductAddGroupPrice;
    @FindBy(xpath = "//div//input[@id=\"special_price\"]")
    WebElement newProductSpecialPrice;
    @FindBy(xpath = "//div//img[@id=\"special_from_date_trig\"]")
    WebElement newProductSpacialPriceDate;
    @FindBy(xpath = "//div//img[@id=\"special_to_date_trig\"]")
    WebElement newProductSpecialPriceToDate;
    @FindBy(xpath = "//div//button[@id=\"id_09e5fa189e1a5f7fad7354d3dfd54798\"]")
    WebElement newProductTierPriceAddTier;
    @FindBy(xpath = "//div//select[@id=\"msrp_enabled\"]")
    WebElement newProductApplyMAP;
    @FindBy(xpath = "//div//select[@id=\"msrp_display_actual_price_type\"]")
    WebElement newProductDisplayActualPrice;
    @FindBy(xpath = "//div//input[@id=\"msrp\"]")
    WebElement newProductManufacturersSuggestedRetail;
    @FindBy(xpath = "//div//select[@id=\"tax_class_id\"]")
    WebElement newProductTaxClass;

    //Meta Information;
    @FindBy(xpath = "//div//input[@id=\"meta_title\"]")
    WebElement newProductMetaTitle;
    @FindBy(xpath = "//div//textarea[@id=\"meta_keyword\"]")
    WebElement newProductMetaKeyword;
    @FindBy(xpath = "//div//textarea[@id=\"meta_description\"]")
    WebElement newProductMetaDescription;

    //Image
    @FindBy(xpath = "//div//button[contains(@id, \"Uploader-browse_button\")]")
    WebElement newProductImageBrowseFiles;
    @FindBy(xpath = "//button[@title=\"Upload Files\"]")
    WebElement uploadFile;
    @FindBy(xpath = "//div//button[@id=\"id_a7979f7f93c238ef24e14d6847567e65_Uploader-upload\"]")
    WebElement newProductImageUpload;
    @FindBy(xpath = "(//div//input[@class=\"input-text\"]) [2]")
    WebElement newProductImageLabel;
    @FindBy(xpath = "(//input[@name=\"product[small_image]\"])[3]")
    WebElement newProductImageSmallImage;

    //Recurring ProfileCreate
    @FindBy(xpath = "//div//select[@id=\"is_recurring\"]")
    WebElement newProductEnableRecurringProfile;
    @FindBy(xpath = "//div//select[@id=\"custom_design\"]")
    WebElement newProductCustomerDesign;

    //Design
    @FindBy(xpath = "//div//img[@id=\"custom_design_from_trig\"]")
    WebElement newProductActiveFrom;

    @FindBy(xpath = "//div//img[@id=\"custom_design_to_trig\"]")
    WebElement newProductActiveTo;

    @FindBy(xpath = "//div//textarea[@id=\"custom_layout_update\"]")
    WebElement newProductCustomLayoutUpdate;
    @FindBy(xpath = "//div//select[@id=\"page_layout\"]")
    WebElement newProductPageLayout;

    @FindBy(xpath = "//div//select[@id=\"options_container\"]")
    WebElement newProductDisplayProductOptionsIn;

    //Gift Options

    @FindBy(xpath = "//div//input[@id=\"use_config_gift_message_available\"]")
    WebElement newProductUseConfigSettingsCheckBox;

    @FindBy(xpath = "//div//select[@id=\"gift_message_available\"]")
    WebElement newProductAllowGiftMessage;

    @FindBy(xpath = "//div//select[@id=\"gift_wrapping_available\"]")
    WebElement newProductAllowGiftWrapping;
    @FindBy(xpath = "//div//input[@id=\"gift_wrapping_price\"]")
    WebElement newProductPriceForGiftWrapping;

    //Accessories
    @FindAll(@FindBy(xpath = "//div[@id=\"product_info_tabs_group_34_content\"]//select"))
    java.util.List<WebElement> newProductAccessoriesSelectBoxes;

    @FindBy(xpath = "//div//textarea[@id=\"accessories_type\"]")
    WebElement newProductAccessoriesType;

    @FindBy(xpath = "//div//textarea[@id=\"luggage_style\"]")
    WebElement newProductLuggageStyle;

    //Inventory

    @FindAll(@FindBy(xpath = "//div//table[@id=\"table_cataloginventory\"]//select"))
    java.util.List<WebElement> newProductInventorySelect;
    @FindBy(xpath = "//input[@id=\"inventory_qty\"]")
    WebElement newProductQty;
    @FindBy(xpath = "//select[@id=\"inventory_stock_availability\"]")
    WebElement newProductStockAvailability;
    @FindBy(xpath = "//div//table//input[@id=\"inventory_use_config_manage_stock\"]")
    WebElement newProductManageStockCheckBox;
    @FindBy(xpath = "//div//table//input[@id=\"inventory_use_config_min_qty\"]")
    WebElement newProductQtyForItemsStatusToBecomeOutOfStockCheckBoc;
    @FindBy(xpath = "//div//table//input[@id=\"inventory_use_config_min_sale_qty\"]")
    WebElement newProductMinimumQtyAllowedInShoppingCartCheckBox;
    @FindBy(xpath = "id=\"inventory_use_config_max_sale_qty\"")
    WebElement newProductMaximumQtyAllowedInShoppingCartCheckBox;
    @FindBy(xpath = "//div//table//input[@id=\"inventory_use_config_backorders\"]")
    WebElement newProductBackordersCheckBox;
    @FindBy(xpath = "//div//table//input[@id=\"inventory_use_config_notify_stock_qty\"]")
    WebElement newProductNotifyForQuantityBelowCheckBox;
    @FindBy(xpath = "//div//table//input[@id=\"inventory_use_config_enable_qty_increments\"]")
    WebElement newProductEnableQtyIncrementsCheckBox;

    //Product In Websites

    @FindAll(@FindBy(xpath = "//div[@class=\"website-name\"]//input"))
    java.util.List<WebElement> newProductProductInWebsitesCheckBox;
    ////div[@class="website-name"]//input

    //Product Categories
    @FindAll(@FindBy(xpath = "//div[@class=\"x-tree-root-node\"]//input"))
    java.util.List<WebElement> newProductCategories;

    //RelatedProducts
    //Up_Sells
    //Cross_Sells

    @FindAll(@FindBy(xpath = "//div[@class=\"grid\"]//tr//input[@class=\"checkbox\"]"))
    List<WebElement> newProductRelatedProducts;


    //Custom Options

    @FindBy(xpath = "//div//button[@id=\"add_new_defined_option\"]")
    WebElement newProductCustomOptions;
    @FindBy(xpath = "//div[@class=\"option-box\"]//tr//input[@id=\"product_option_1_title\"]")
    WebElement newProductCustomOptionsTitle;
    @FindBy(xpath = "//div//select[@id=\"product_option_1_type\"]")
    WebElement newProductCustomOptionsInputType;
    @FindBy(xpath = "//div//select[@id=\"product_option_1_is_require\"]")
    WebElement newProductCustomOptionIsRequired;
    @FindBy(xpath = "//div//input[@name=\"product[options][1][sort_order]\"]")
    WebElement newProductCustomOptionsSortOrder;


    //*************************** Catalog *************************
    @FindBy(xpath = "//a//span[text()='Catalog']")
    WebElement catalogLinkTab;
    @FindBy(xpath = "//*[@id='nav']/li/ul/li/a/*[contains(text(),'Manage Categories')]")
    WebElement manageCategoriesLink;

    //*************************** add edit and delete sub category ****************

    @FindBy(css = "button#add_root_category_button")
    WebElement addRootCategoryButton;
    @FindBy(css = "a#category_info_tabs_group_4")
    WebElement generalInfoTabInRootCat;
    @FindBy(css = "a#category_info_tabs_group_5")
    WebElement displaySettingsTabInRootCat;
    @FindBy(xpath = "//a//span[text()='Custom Design']")
    WebElement customDesignTabInRootCat;
    @FindBy(css = "a#category_info_tabs_products")
    WebElement categoryProductsTabInRootCat;
    @FindBy(id = "group_4name")
    WebElement nameFieldInRootCat;
    @FindBy(id = "group_4include_in_menu")
    WebElement includeInNavigationSelectField;
    @FindBy(id = "use_config_group_5available_sort_by")
    WebElement productListingSortByCheckBoxInRootCat;
    @FindBy(css = "select[name='general[available_sort_by][]'")
    WebElement selectListingSortByInRootCat;
    @FindBy(css = "#group_5default_sort_by")
    WebElement defaultProductListingSortByFieldInRootCat;
    @FindBy(css = "input#use_config_group_5default_sort_by")
    WebElement defaultSortByCheckBoxInRootCat;
    @FindBy(css = "select#group_6custom_use_parent_settings")
    WebElement useParentCatSettingDSelectFiled;
    @FindBy(xpath = "//td[@class='title']")
    WebElement currentYearMonthElement;
    @FindAll(@FindBy(xpath = "//tr[@class='daysrow']//td[@class='day']"))
    List<WebElement> weekDatesElements;
    @FindAll(@FindBy(xpath = "//tr[@class='daysrow']//td[@class='day weekend']"))
    List<WebElement> weekendDatesElements;

    @FindBy(xpath ="//img[@id='group_6custom_design_from_trig']" )
    WebElement calenderActiveFrom;
    @FindBy(xpath ="//img[@id='group_6custom_design_to_trig']" )
    WebElement calenderActiveTo;
    @FindBy(xpath = "//div[text()='»']")
    WebElement calenderNextYearButton;

    @FindBy(xpath="//div[text()='›']")
    WebElement calenderNextMonthButton;


    //  *********************  edit  categories section *******************

    @FindAll(@FindBy(xpath = "//tr//td[@class=' ']"))
    List<WebElement> IDNameSkuCellsInCategoryProducts;

    @FindBy(css = "li.success-msg")
    WebElement successMessage;

    @FindBy(xpath = "(//h3[@class='icon-head head-categories'])[2]")
    WebElement iconHeaderCategories;

   @FindBy(xpath ="//button//span[text()='Reset']")
    WebElement resetButton;
    @FindBy(css = "#add_subcategory_button")
    WebElement addSubCategoryButton;
    @FindBy(name = "general[name]")
    WebElement subNameFiled;
    @FindBy(id = "group_4is_active")
    WebElement isActiveSelectField;

    @FindBy(xpath = "//*[@id='category_info_tabs_products']/span")
    WebElement categoryProductsLink;
    @FindBy(xpath = "//button[@title='Save Category']")
    WebElement saveCategoryButton;

    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement categorySuccessMessage;
    @FindBy(name = "general[description]")
    WebElement subCategoryDescriptionField;
    @FindAll(@FindBy(xpath = "//*[@id='ext-gen5']/div/li/div/a/span"))
    List<WebElement> categories;
    @FindBy(css = "#category_info_tabs_group_4 > span")
    WebElement generalInformationLink;
    @FindBy(css = "a[title='Next page']")
    WebElement nextPageButton;
 //   @FindBy(css = "#id_88d125f90d1ffc6ace36639ce17190ce > span")
  //  WebElement deleteCategoryButton;
    @FindBy(xpath = "//*[@class='scalable delete']/span/span/span")
    WebElement deleteCategoryButton;


    //**************  Catalog Manager can add products  ***************************
    @FindBy(xpath = "//table[@id=\"productGrid_table\"]//tr//td[contains(text(),\"1101\")]")
    WebElement productId;

    @FindBy(xpath = "//a[@title=\"Next page\"]")
    WebElement addProductNextPageButton;

    @FindBy(xpath = "(//td[@class=\"cell-remove a-center last\"]//input[@type=\"checkbox\"]) [2]")
    WebElement imageRemoveCheckBox;


    //**************  Catalog Manager can add products  ***************************

    //Create Product Settings
    public void createAddProductSettings(String attributeSet, String productType) {
        for (WebElement each : megentoAllTabList) {
            if (each.getText().equals("Catalog")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(each).build().perform();
                break;
            }
        }
        functionLibrary.waitForElementPresent(manageProductLink);
        manageProductLink.click();
        functionLibrary.waitForElementPresent(addProductLink);
        addProductLink.click();
        functionLibrary.waitForElementPresent(newProductAttributeSet);
        Select select = new Select(newProductAttributeSet);
        select.selectByVisibleText(attributeSet);
        functionLibrary.waitForElementPresent(newProductProductType);
        Select select1 = new Select(newProductProductType);
        select1.selectByVisibleText(productType);
        functionLibrary.waitForElementPresent(createProductContinueButton);
        createProductContinueButton.click();

    }

    public void addProductGeneral(String name, String productDescription, String shortDescription, String SKU,
                                  String productWeight, String status, String visibility) {
        functionLibrary.waitForElementPresent(newProductName);
        newProductName.sendKeys(name);
        functionLibrary.waitForElementPresent(newProductDescription);
        newProductDescription.sendKeys(productDescription);
        functionLibrary.waitForElementPresent(newProductShortDescription);
        newProductShortDescription.sendKeys(shortDescription);
        functionLibrary.waitForElementPresent(newProductSKU);
        newProductSKU.sendKeys(SKU);
        functionLibrary.waitForElementPresent(newProductStatus);
        Select select = new Select(newProductStatus);
        select.selectByVisibleText(status);
        functionLibrary.waitForElementPresent(newProductVisibility);
        Select select1 = new Select(newProductVisibility);
        select1.selectByVisibleText(visibility);
    }

    String tab_Name = "//div//ul[@id=\"product_info_tabs\"]//li//a[@title = \"?\"]";

    public void selectProductInfoTab(String tabName) {
        WebElement tabElement = driver.findElement(By.xpath(tab_Name.replace("?", tabName)));
        functionLibrary.waitForElementPresent(tabElement);
        Actions actions = new Actions(driver);
        actions.click(tabElement).build().perform();
    }

    public void addNewProductPrices(String price, String taxClass) throws InterruptedException {
        sleep(3);
        functionLibrary.waitForElementPresent(newProductPrice);
        newProductPrice.sendKeys(price);
        functionLibrary.waitForElementPresent(newProductTaxClass);
        Select select = new Select(newProductTaxClass);
        select.selectByVisibleText(taxClass);

    }

    public void addNewProductImage() throws AWTException, InterruptedException {
        sleep(2);
        functionLibrary.waitForElementPresent(newProductImageBrowseFiles);
        newProductImageBrowseFiles.click();
        sleep(2);
        Robot robot = new Robot();
        StringSelection filePath = new StringSelection("C:\\Users\\ELMA\\IdeaProjects\\SDET2023Magento_Team4-Zikrullah_\\testdata\\9781589255517.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        functionLibrary.waitForElementPresent(uploadFile);
        sleep(2);
        uploadFile.click();
    }

    public void addInventoryForNewProduct(String qty, String stockAvailability) {
        functionLibrary.waitForElementPresent(newProductQty);
        newProductQty.sendKeys(qty);
        functionLibrary.waitForElementPresent(newProductStockAvailability);
        Select select = new Select(newProductStockAvailability);
        select.selectByVisibleText(stockAvailability);
    }

    String webSites = "//label[contains(text(),\"?\")]";

    public void addWebsitesForNewProduct(String productInWebsites) {
        selectProductInfoTab("Websites");
        WebElement webSitesElement = driver.findElement(By.xpath(webSites.replace("?", productInWebsites)));
        functionLibrary.waitForElementPresent(webSitesElement);
        Actions actions = new Actions(driver);
        actions.click(webSitesElement).build().perform();
    }

    //    String categoriesXpath="//span[contains(text(),\"?\")]/preceding::input[@id=\"!\"]";
    String categoriesXpath = "//span[contains(text(),\"?\")]/parent::a/preceding-sibling::input";

    public void addCategoriesForNewProduct(String cat_NameText, String cat_NameText2) throws InterruptedException {
        selectProductInfoTab("Categories");
        sleep(2);
        WebElement categoriesElement = driver.findElement(By.xpath(categoriesXpath.replace("?", cat_NameText)));
        functionLibrary.waitForElementPresent(categoriesElement);
        Actions actions = new Actions(driver);
        actions.click(categoriesElement).build().perform();
        sleep(2);
        WebElement categoriesElement1 = driver.findElement(By.xpath(categoriesXpath.replace("?", cat_NameText2)));
        functionLibrary.waitForElementPresent(categoriesElement1);
        actions.click(categoriesElement1).build().perform();
    }

    public void saveNewAddedProduct() {
        functionLibrary.waitForElementPresent(newProductSaveButton);
        newProductSaveButton.click();
    }

    public boolean verifyNewProductAdded() {
        functionLibrary.waitForElementPresent(newProductSuccess_msg);
        if (newProductSuccess_msg.getText().contains("The product has been saved.")) {
            return true;
        } else {
            System.out.println(newProductSuccess_msg.getText());
        }
        return false;
    }

    public void addProduct(String attributeSet, String productType, String name, String productDescription,
                           String shortDescription, String SKU, String productWeight, String status, String visibility
            , String tabName, String price, String taxClass) throws FileNotFoundException, InterruptedException {
        createAddProductSettings(attributeSet, productType);
        addProductGeneral(name, productDescription, shortDescription, SKU, productWeight, status, visibility);
//        selectProductInfoTab(tabName);
        addNewProductPrices(price, taxClass);

    }


    //**************  Catalog Manager can add products  ***************************
    String productID = "//td[contains(text(),\"?\")]//following-sibling::td[@class=' last']/a";

    public void manageProductPage(String productByID) {
        for (WebElement each : megentoAllTabList) {
            if (each.getText().equals("Catalog")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(each).build().perform();
                break;
            }

        }

        functionLibrary.waitForElementPresent(manageProductLink);
        manageProductLink.click();
//    WebElement productI = driver.findElement(By.xpath(productID.replace("?", productByID)));
//    functionLibrary.waitForElementPresent(productI);
//    productI.click();
        findMyEditIconAndClick(productByID);

    }

    public void findMyEditIconAndClick(String ID) {
        String idNumber = String.format("//td[contains(text(),\"%s\")]//following-sibling::td[@class=' last']/a", ID);
        while (true) {
            try {
                WebElement edit = driver.findElement(By.xpath(idNumber));
                functionLibrary.waitForElementPresent(edit);
                System.out.println("found target edit");
                edit.click();
                System.out.println("clicked on target edit");
                break;
            } catch (NoSuchElementException e) {
                System.out.println("can`t locate target edit icon in this page, try next page");
            }
            try {
                functionLibrary.waitForElementPresent(addProductNextPageButton);
                addProductNextPageButton.click();
                sleep(3);
            } catch (NoSuchElementException e) {
                System.out.println("all pages been checked");
                break;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void upDateProductGeneral(String name, String productDescription, String shortDescription, String SKU,
                                     String status, String visibility) {
        functionLibrary.waitForElementPresent(newProductName);
        newProductName.clear();
        newProductName.sendKeys(name);
        functionLibrary.waitForElementPresent(newProductDescription);
        newProductDescription.clear();
        newProductDescription.sendKeys(productDescription);
        functionLibrary.waitForElementPresent(newProductShortDescription);
        newProductShortDescription.clear();
        newProductShortDescription.sendKeys(shortDescription);
        functionLibrary.waitForElementPresent(newProductSKU);
        newProductSKU.clear();
        newProductSKU.sendKeys(SKU);
        functionLibrary.waitForElementPresent(newProductStatus);
        Select select = new Select(newProductStatus);
        select.selectByVisibleText(status);
        functionLibrary.waitForElementPresent(newProductVisibility);
        Select select1 = new Select(newProductVisibility);
        select1.selectByVisibleText(visibility);
    }

    public void removeImage() {
        functionLibrary.waitForElementPresent(imageRemoveCheckBox);
        imageRemoveCheckBox.click();
        functionLibrary.waitForElementPresent(newProductSaveButton);
        newProductSaveButton.click();
    }

    public boolean verifyUpdateProduct() {
        functionLibrary.waitForElementPresent(newProductSuccess_msg);
        if (newProductSuccess_msg.getText().contains("The product has been saved.")) {
            return true;
        } else {
            System.out.println(newProductSuccess_msg.getText());
        }
        return false;
    }

    //**************  Catalog Manager can delete products  ***************************
    @FindBy(xpath = "//button[@title=\"Delete\"]")
    WebElement deleteProductButton;

    //**************  Catalog Manager can delete products  ***************************

    public void deleteProduct(String productById) throws InterruptedException {
        for (WebElement each : megentoAllTabList) {
            if (each.getText().equals("Catalog")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(each).build().perform();
                break;
            }
        }
        functionLibrary.waitForElementPresent(manageProductLink);
        manageProductLink.click();
        WebElement productI = driver.findElement(By.xpath(productID.replace("?", productById)));
        functionLibrary.waitForElementPresent(productI);
        productI.click();
        functionLibrary.waitForElementPresent(deleteProductButton);
        deleteProductButton.click();
        sleep(2);
        driver.switchTo().alert().accept();
    }

    public boolean verifyDeleteProduct() {
        functionLibrary.waitForElementPresent(newProductSuccess_msg);
        if (newProductSuccess_msg.getText().contains("The product has been deleted.")) {
            return true;
        } else {
            System.out.println(newProductSuccess_msg.getText());
        }
        return false;
    }


    //********************* catalog manager can add new sub categories *********************\\
    public void addSubCategories(String subCategoriesName, String active, String productNames) throws InterruptedException {
        logger.info("add sub category start now");
        Actions actions = new Actions(driver);
        for (WebElement each : megentoAllTabList) {
            if (each.getText().equals("Catalog")) {
                actions.moveToElement(each).build().perform();
                logger.info(each + "clicked");
                break;
            }
        }
        functionLibrary.waitForElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        functionLibrary.waitForElementPresent(addSubCategoryButton);
        addSubCategoryButton.click();
        Thread.sleep(3000);
        functionLibrary.setFluentWaitForElementPresent(subNameFiled);
        subNameFiled.sendKeys(subCategoriesName);
        Select selectActive = new Select(isActiveSelectField);
        selectActive.selectByVisibleText(active);
        functionLibrary.waitForElementPresent(categoryProductsLink);
        categoryProductsLink.click();
        boolean isAddToCategoryButtonClick = false;
        String productNameXpath = String.format("//*[@id=\"catalog_category_products_table\"]/tbody/tr/td[3][contains(text(),\"%s\")]", productNames);
        while (true) {
            try {
                WebElement productName = driver.findElement(By.xpath(productNameXpath));
                functionLibrary.waitForElementPresent(productName);
                productName.click();
                isAddToCategoryButtonClick = true;
                break;

            } catch (NoSuchElementException e) {
            }
            try {
                functionLibrary.waitForElementPresent(nextPageButton);

            } catch (NoSuchElementException e) {
            }
            try {
                functionLibrary.waitForElementPresent(addProductNextPageButton);

                logger.info("not this page will check next page");
            } catch (Exception e) {
            }
        }

        functionLibrary.waitForElementPresent(saveCategoryButton);
        saveCategoryButton.click();
    }

    public boolean isAddSubCategories() {
        functionLibrary.waitForElementPresent(categorySuccessMessage);
        return categorySuccessMessage.isDisplayed();
    }

    public void editSubCategories(String subCategoryNames, String description) throws InterruptedException {
        logger.info("edit start now");
        for (WebElement each : categories) {
            if (each.getText().equals(subCategoryNames)) {
                each.click();
                break;
            }
        }
        Thread.sleep(3000);
        functionLibrary.waitForElementPresent(generalInformationLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-2000)");
        Thread.sleep(3000);
        generalInformationLink.click();
        Thread.sleep(2000);
        functionLibrary.waitForElementPresent(subCategoryDescriptionField);
        subCategoryDescriptionField.sendKeys(description);
        Thread.sleep(2000);
        functionLibrary.waitForElementPresent(saveCategoryButton);
        saveCategoryButton.click();
    }

    public boolean isEditSubCategories() {
        functionLibrary.waitForElementPresent(categorySuccessMessage);
        return categorySuccessMessage.isDisplayed();
    }

    public void deleteSubCategories(String subCategoryNames) throws InterruptedException {
        logger.info("delete sub category now");
        for (WebElement each : categories) {
            if (each.getText().equals(subCategoryNames)) {
                each.click();
                break;
            }
        }
        Thread.sleep(3000);
        functionLibrary.waitForElementPresent(deleteCategoryButton);
        Thread.sleep(3000);
        deleteCategoryButton.click();
        driver.switchTo().alert().accept();
    }

    public boolean isCategoryDeleted() {
        logger.info(categorySuccessMessage.getText());
        return categorySuccessMessage.isDisplayed();
    }


    public void goToManageCategories() {
        Actions action = new Actions(driver);
        functionLibrary.waitForElementPresent(catalogLinkTab);
        action.moveToElement(catalogLinkTab).build().perform();
        logger.info("Mouseover on Catalog Link Tab ");
        functionLibrary.waitForElementPresent(manageCategoriesLink);
        action.moveToElement(manageCategoriesLink).click().build().perform();
        logger.info("Clicked on Manage Categories");
    }


    public void fillNewRootCategoryForm(String rootCategoryName, String isActive, String includeInNavigation, String productName) throws InterruptedException {
        logger.info("fill out add a new root  category form");
        functionLibrary.waitForElementPresent(addRootCategoryButton);
        addRootCategoryButton.click();
        logger.info("addCategory button clicked");
        sleep(2);
        functionLibrary.waitForElementPresent(generalInfoTabInRootCat);
        generalInfoTabInRootCat.click();
        logger.info("General info Tab clicked");
        functionLibrary.waitForElementPresent(nameFieldInRootCat);
        nameFieldInRootCat.sendKeys(rootCategoryName);
        logger.info("send name");
        functionLibrary.waitForElementPresent(isActiveSelectField);
        logger.info("select isActive ");
        Select select = new Select(isActiveSelectField);
        select.selectByVisibleText(isActive);
        functionLibrary.waitForElementPresent(includeInNavigationSelectField);
        logger.info("select include in navigation  ");
        Select select1 = new Select(includeInNavigationSelectField);
        select1.selectByVisibleText(includeInNavigation);
        functionLibrary.waitForElementPresent(displaySettingsTabInRootCat);
        displaySettingsTabInRootCat.click();
        logger.info("display Settings clicked");
        functionLibrary.waitForElementPresent(categoryProductsTabInRootCat);
        categoryProductsTabInRootCat.click();
        logger.info("CategoryProductTab clicked");
        sleep(2);
        while (true) {
            boolean isTargetCheckBoxClicked = false;
            for (WebElement each : IDNameSkuCellsInCategoryProducts) {
                functionLibrary.waitForElementPresent(each);
                if (each.getText().trim().contains(productName)) {
                    WebElement targetProductCheckBox = each.findElement(By.xpath("//parent::tr/td[@class='a-center ']"));
                    functionLibrary.waitForElementPresent(targetProductCheckBox);
                    targetProductCheckBox.click();
                    logger.info("check box clicked for product: " + productName);
                    functionLibrary.waitForElementPresent(saveCategoryButton);
                    saveCategoryButton.click();
                    logger.info("Clicked on Save button");
                    isTargetCheckBoxClicked = true;
                    sleep(2);
                    break;
                }
            }
            if (!isTargetCheckBoxClicked) {
                try {
                    functionLibrary.waitForElementPresent(nextPageButton);
                    nextPageButton.click();
                    sleep(2);
                } catch (NoSuchElementException e) {
                    logger.info("All pages been checked");
                    break;
                }
            } else break;
        }
    }

    public boolean isRootCategoryAdded(String rootCategoryName) {
        functionLibrary.waitForElementPresent(iconHeaderCategories);
        logger.info("Validation: " + iconHeaderCategories.getText());
        return iconHeaderCategories.getText().contains(rootCategoryName);
    }

    public void addRootCategory(String rootCategoryName, String isActive, String includeInNavigation, String productName) throws InterruptedException {
        goToManageCategories();
        fillNewRootCategoryForm(rootCategoryName, isActive, includeInNavigation, productName);
    }

    public void updateRootCategory(String categoryName, String activeFromDate, String activeToDate) throws InterruptedException {
        logger.info("update a root category");
        goToManageCategories();
        for (WebElement each : categories) {
            functionLibrary.waitForElementPresent(each);
            if (each.getText().contains(categoryName)) {
                each.click();
                logger.info("My category clicked");
                FunctionLibrary.sleep(3);
                break;
            }
        }
            functionLibrary.waitForElementPresent(resetButton);
            resetButton.click();
            FunctionLibrary.sleep(3);
            logger.info("reset button clicked");
            functionLibrary.waitForElementPresent(customDesignTabInRootCat);
             functionLibrary.javaScriptClick(customDesignTabInRootCat);
            logger.info("customDesign button clicked");
            logger.info("use calender to update active from field");
            functionLibrary.waitForElementPresent(calenderActiveFrom);
            calenderActiveFrom.click();
            fillDateFieldWithCalender(activeFromDate);
            FunctionLibrary.sleep(2);
            functionLibrary.waitForElementPresent(saveCategoryButton);
            saveCategoryButton.click();
            logger.info("save category button clicked");
        }


    public void pickYear(String year) throws InterruptedException {
        functionLibrary.waitForElementPresent(currentYearMonthElement);
        String[] currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
        int currentYear = Integer.parseInt(currentYearAndMonth[1].trim());
        logger.info("read current year and month from the calender : " + Arrays.toString(currentYearAndMonth));
        int expectedYear = Integer.parseInt(year);
        while (expectedYear > currentYear) {
            functionLibrary.waitForElementPresent(calenderNextYearButton);
            calenderNextYearButton.click();
            currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
            currentYear = Integer.parseInt(currentYearAndMonth[1].trim());
        }
    }

    public void pickMonth(String monthInLetters) {
        functionLibrary.waitForElementPresent(currentYearMonthElement);
        String[] currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
        String currentMonth = currentYearAndMonth[0].trim();
        logger.info("read current month from the calender: " + currentMonth);

        if (monthInLetters.length() != 0) {
            while (!currentMonth.equalsIgnoreCase(monthInLetters)) {
                functionLibrary.waitForElementPresent(calenderNextMonthButton);
                calenderNextMonthButton.click();
                functionLibrary.waitForElementPresent(currentYearMonthElement);
                currentYearAndMonth = currentYearMonthElement.getText().trim().split(",");
                currentMonth = currentYearAndMonth[0].trim();
            }
           logger.info("picked month : "+currentMonth);
        } else logger.info("invalid month ");
    }

    public void pickDate(String expectedDate) {
        logger.info("Pick date");
        int expectedDateInNumber = Integer.parseInt(expectedDate);
        boolean isDatePicked = false;
        for (WebElement each : weekDatesElements) {
            functionLibrary.waitForElementPresent(each);
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
                functionLibrary.waitForElementPresent(each);
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
            logger.info("please check the date : " + expectedDate + ",it is not valid date in this month . current date is entered for you ");
        }
    }

    public String convertMonthInNumberToLetters(String month) {
        int monthInNumber = Integer.parseInt(month);
        String monthInLetters = "";
        switch (monthInNumber) {
            case 1 -> monthInLetters = "January";
            case 2 -> monthInLetters = "February";
            case 3 -> monthInLetters = "March";
            case 4 -> monthInLetters = "April";
            case 5 -> monthInLetters = "May";
            case 6 -> monthInLetters = "June";
            case 7 -> monthInLetters = "July";
            case 8 -> monthInLetters = "August";
            case 9 -> monthInLetters = "September";
            case 10 -> monthInLetters = "October";
            case 11 -> monthInLetters = "November";
            case 12 -> monthInLetters = "December";
            default -> logger.error("Invalid month , the month should be two digits and between  01 to 12 ");
        }
        logger.info("The month in number " + monthInNumber + " is converted to :" + monthInLetters);
        return monthInLetters;
    }


    public void fillDateFieldWithCalender(String expectedDate) throws InterruptedException {
        logger.info("picking the date starts now : " + expectedDate);
        String[] expectedDOBData = expectedDate.trim().split("/");
        String year = expectedDOBData[2].trim();
        String monthInNumber = expectedDOBData[0].trim();
        String date = expectedDOBData[1].trim();
        pickYear(year);
        String monthInLetters = convertMonthInNumberToLetters(monthInNumber);
        pickMonth(monthInLetters);
        pickDate(date);
    }


    public void deleteRootCategory(String categoryName) throws InterruptedException {
        logger.info("Delete a root category starts now");
        goToManageCategories();
        boolean isCategoryFoundAndClicked = false;
        for (WebElement each : categories) {
            functionLibrary.waitForElementPresent(each);
            if (each.getText().contains(categoryName)) {
                each.click();
                isCategoryFoundAndClicked = true;
                FunctionLibrary.sleep(3);
                break;
            }
        }
        if (isCategoryFoundAndClicked) {
            functionLibrary.waitForElementPresent(deleteCategoryButton);
            deleteCategoryButton.click();
            logger.info("delete category button clicked");
            functionLibrary.waitForAlertAndAccept();
            logger.info("Alert accepted");
            FunctionLibrary.sleep(3);
        } else logger.info("sorry cant find your category");
    }


    public boolean isCategoryUpdated(){
      functionLibrary.waitForElementPresent(successMessage);
      logger.info("Confirmation message displayed as: " + successMessage.getText());
      return successMessage.isDisplayed();
    }



}





