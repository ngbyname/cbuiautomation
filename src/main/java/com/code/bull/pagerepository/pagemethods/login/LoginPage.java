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
    public void enterUserName(String userName) throws InterruptedException {
        enterText(LoginPageElements.userName, userName);
    }

    /**
     * This method is used to enter text in userPass filed
     *
     * @param userPass userPass
     */
    public void enterUserPass(String userPass) throws InterruptedException {
        enterText(LoginPageElements.userPass, userPass);
    }
}
