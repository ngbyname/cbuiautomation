package com.code.bull.pagerepository.pagemethods.common;

import com.code.bull.pagerepository.pagemethods.dashboard.DashboardPage;
import com.code.bull.pagerepository.pagemethods.login.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageCollection {

    private final WebDriver driver;

    public PageCollection(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public DashboardPage getDashboardPage() {
        return new DashboardPage(driver);
    }
}
