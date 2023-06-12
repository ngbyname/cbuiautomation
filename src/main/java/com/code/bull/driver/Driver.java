package com.code.bull.driver;


import com.code.bull.commonutils.applicationutils.contants.ApplicationConstant;
import com.code.bull.commonutils.applicationutils.contants.ConstantUtils;
import com.code.bull.pagerepository.pagemethods.common.PageCollection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    public static String env = System.getProperty("env");
    public static String browser = null;
    public static ConstantUtils constants = ConstantUtils.getInstance();
    public static PageCollection pages;
    public static WebDriver driver ;

   /* private void driver(WebDriver driver){
        this.driver = driver;
    }*/


    @BeforeSuite(alwaysRun = true)
    public static void setup() {
        envLevelSetup();
        startBrowser(browser);
    }

    @BeforeClass(alwaysRun = true)
    public static void pageSetup() {
        initializePage();
    }

    @BeforeMethod(alwaysRun = true)
    public static void methodSetup() {

    }

    @AfterMethod(alwaysRun = true)
    public static void endTest() {

    }

    @AfterClass(alwaysRun = true)
    public static void cleanup() {

    }

    @AfterSuite(alwaysRun = true)
    public void closeReport() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }


    /**
     * This method is used to set the env value in capital
     */
    private static void envLevelSetup() {

        browser = constants.getValue(ApplicationConstant.WEB_BROWSER);

        if (env.equalsIgnoreCase("sit")) {
            env = "SIT";
        } else if (env.equalsIgnoreCase("uat")) {
            env = "UAT";
        } else if (env.equalsIgnoreCase("prod")) {
            env = "PROD";
        }

    }

    /**
     * @param browser
     */
    private static void startBrowser(String browser) {

        try {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                default:
                    break;
            }


        } catch (Exception e) {
            e.getMessage();

        }

    }

    private static void initializePage() {
        try {
            pages = new PageCollection(driver);
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
