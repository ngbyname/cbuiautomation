package com.code.bull.pagerepository.pagemethods.common;

import com.code.bull.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Driver {

    public static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        super();
    }


    /**
     * This method will be used to click anywhere
     *
     * @param elementLocation the webelement location
     */
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    /**
     * This method is used to enter text
     *
     * @param elementLocation the webelement
     * @param text            the text
     */
    public void enterText(By elementLocation, String text) throws InterruptedException {
        if (isDisplayed(elementLocation)) {
            driver.findElement(elementLocation).sendKeys(text);
        } else {
            System.out.println("Element is not visible");
        }
    }

    /**
     * This method is used to get element is displayed or not
     *
     * @param elementLocation the webelement
     * @return is visible or not?
     */
    public Boolean isDisplayed(By elementLocation) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementLocation)));
        return driver.findElement(elementLocation).isDisplayed();
    }

    public void hardWait(int time) throws InterruptedException {
        time = time * 1000;
        Thread.sleep(time);
    }
}
