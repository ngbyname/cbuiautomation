package com.code.bull.pagerepository.pagemethods.dashboard;

import com.code.bull.pagerepository.pagelocators.DashboardPageElements;
import com.code.bull.pagerepository.pagemethods.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    DashboardPageElements dashboardPage;

    public DashboardPage(WebDriver driver) {
        super(driver);
        dashboardPage = PageFactory.initElements(driver, DashboardPageElements.class);
    }


    /**
     * This method is used to get the header text of dashboard page
     *
     * @return the text
     */
    public String getHeaderText() {
        return getText(DashboardPageElements.headerText);
    }

    public Boolean isLeftPanelCollapsed() {
        boolean isCollapsed = false;
        String aClass = getAttribute(DashboardPageElements.leftPanel, "class");
        if (aClass.contains("toggled")) {
            isCollapsed = true;
        }
        return isCollapsed;
    }
}
