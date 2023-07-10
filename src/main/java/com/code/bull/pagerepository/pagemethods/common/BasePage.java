package com.code.bull.pagerepository.pagemethods.common;

import com.code.bull.commonutils.applicationutils.contants.ApplicationConstant;
import com.code.bull.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage extends Driver {

    public static Wait<WebDriver> wait = null;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        Driver.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(constants.getValue(ApplicationConstant.GENERAL_WAIT_IN_SEC))));
    }


    /**
     * This method will be used to click anywhere
     *
     * @param elementLocation the webelement location
     */
    public void click(By elementLocation) {
        commonLib.info("Going to click on webelement");
        driver.findElement(elementLocation).click();
    }

    /**
     * This method is used to enter text
     *
     * @param elementLocation the webelement
     * @param text            the text
     */
    public void enterText(By elementLocation, String text) {
        if (isDisplayed(elementLocation)) {
            commonLib.info("Going to enter text ");
            driver.findElement(elementLocation).clear();
            driver.findElement(elementLocation).sendKeys(text);
        } else {
            commonLib.error("Element is not visible");
        }
    }

    /**
     * This method is used to get element is displayed or not
     *
     * @param elementLocation the webelement
     * @return is visible or not?
     */
    public Boolean isDisplayed(By elementLocation) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
        return driver.findElement(elementLocation).isDisplayed();
    }

    /**
     * This method is used for hard wait
     *
     * @param time the time for wait
     * @throws InterruptedException the exception
     */
    public void hardWait(int time) throws InterruptedException {
        time = time * 1000;
        Thread.sleep(time);
    }

    /**
     * This method is used to get the text
     *
     * @param elementLocation the weblement location
     * @return the text
     */
    public String getText(By elementLocation) {
        return driver.findElements(elementLocation).get(0).getText();
    }

    /**
     * This method is used to get the attribute
     *
     * @param elementLocation the webelement
     * @param attributeName   the attribute name
     * @return the attribute
     */
    public String getAttribute(By elementLocation, String attributeName) {
        return driver.findElements(elementLocation).get(0).getAttribute(attributeName);
    }
}
