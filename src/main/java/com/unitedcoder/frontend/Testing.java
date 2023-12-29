package com.unitedcoder.frontend;

import com.unitedcoder.backend.LoginToAdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Testing {
    public static void main(String[] args) throws InterruptedException, AWTException {

//        SafariOptions options = new SafariOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        SafariDriver driver = new SafariDriver(options);
//        driver.manage().window().maximize();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            driver.get("https://ecommerce.unitedcoderapp.com/index.php/admin");
            LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
            loginToAdminPage.loginToAdminPanelWithCredentials("storemanager");
//        WebElement usernameField = driver.findElement(By.id("username"));
//        usernameField.sendKeys("storemanager");
//        driver.findElement(By.id("login")).sendKeys("automationadmin!123");
//        driver.findElement(By.cssSelector("input.form-button")).click();
            Actions actions = new Actions(driver);
            WebElement catalog =driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a/span"));
            actions.moveToElement(catalog).build().perform();
            driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[1]/a/span")).click();
            driver.findElement(By.xpath("//td/button[@class=\"scalable add\"][1]")).click();
            driver.findElement(By.xpath("//div//td[@class=\"value\"]/span[@id=\"continue_button\"]")).click();
            driver.findElement(By.xpath("//div[@id=\"page:left\"]/ul/li/a/span[contains(text(),'Images')]")).click();
           driver.findElement(By.xpath(" //span[contains(text(),'Upload Files')]")).sendKeys("testdata/team4.jpg");

    /*        StringSelection ss = new StringSelection("/Users/alimadil/IdeaProjects/SDET2023Magento_Team4/testdata/team4.jpg");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            Thread.sleep(2000);



       Robot robot = new Robot();

            // Cmd + Tab is needed since it launches a Java app and the browser looses focus
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(500);

            //Open Goto window
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);
            robot.delay(5000);
            //Paste the clipboard value
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_V);

            //Press Enter key to close the Goto window and Upload window
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3);
            driver.findElement(By.xpath("//*[@title=\"Upload Files\"]")).click();  */

        }
    }

