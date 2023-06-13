package com.code.bull.driver;


import com.code.bull.commonutils.applicationutils.contants.ApplicationConstant;
import com.code.bull.commonutils.applicationutils.contants.ConstantUtils;
import com.code.bull.pagerepository.pagemethods.common.PageCollection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    public static String env = System.getProperty("env");
    public static String browser = null;
    public static String baseUrl;
    public static ConstantUtils constants = ConstantUtils.getInstance();
    public static PageCollection pages;
    public static WebDriver driver;

    /**
     * This method will return the instance of WebDriver
     *
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }


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
        baseUrl = constants.getValue(ApplicationConstant.BASE_URL);

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
                    browserCapabilities();
                    openBaseUrl(baseUrl);
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

    /**
     * This method is used to initialize all the pages
     */
    private static void initializePage() {
        try {
            pages = new PageCollection(driver);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method is used to set or customize the Chrome browser
     */
    private static void browserCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * This method is used to open your browser
     *
     * @param baseUrl the url
     */
    private static void openBaseUrl(String baseUrl) {
        driver.get(baseUrl);
    }
}
