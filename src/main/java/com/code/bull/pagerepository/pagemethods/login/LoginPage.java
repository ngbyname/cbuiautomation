package com.code.bull.pagerepository.pagemethods.login;

import com.code.bull.pagerepository.pagelocators.LoginPageElements;
import com.code.bull.pagerepository.pagemethods.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    LoginPageElements loginPage;

    public LoginPage(WebDriver driver) {
        super(driver);
        loginPage = PageFactory.initElements(driver, LoginPageElements.class);
    }

    /**
     * This method is used to enter text in username field
     *
     * @param userName userName
     */
    public void enterUserName(String userName) {
        commonLib.info("Going to enter username");
        enterText(LoginPageElements.userName, userName);
    }

    /**
     * This method is used to enter text in userPass filed
     *
     * @param userPass userPass
     */
    public void enterUserPass(String userPass) {
        commonLib.info("Going to enter password");
        enterText(LoginPageElements.userPass, userPass);
    }

    /**
     * This method will return you the current url
     *
     * @return the url
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * This method is used to click on Login Btn
     */
    public void clickLoginBtn() {
        click(LoginPageElements.loginBtn);
    }

    /**
     * This method is used to check if invalid msg is present or not
     */
    public Boolean isInvalidMsgVisible() throws InterruptedException {
        hardWait(2);
        return isDisplayed(LoginPageElements.invalidMsg);
    }

    /**
     * This method is used to get invalid msg text
     *
     * @return the text
     */
    public String getInvalidMsg() {
        return getText(LoginPageElements.invalidMsg);
    }
}
